package Menu;

import javax.sql.rowset.RowSetWarning;
import java.sql. *;
import java.util.Objects;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// JF23afds0AsdfF03JAFfa

public class Transaction_Principal {
    private static Connection connection;

    private static void connect() {
        // Conexión a la base de datos.
        String url = "jdbc:mysql://localhost:3306/SchoolManagementDB";
        String username = "root";
        String password = "JF23afds0AsdfF03JAFfa";

        // Prueba de conexión
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Failed to connect to MySQL database: " + e.getMessage());
        }
    }

    private static void disconnect() {
        try {
            connection.close();
            System.out.println("Disconnected from database");
        } catch (SQLException e) {
            System.err.println("Failed to close connection: " + e.getMessage());
        }
    }

    private static boolean confirmTransaction(Scanner scanner) {
        System.out.println("Do you want to commit the transaction? (y/n)");
        String choice = scanner.next();
        return choice.equalsIgnoreCase("y");
    }

    ////////////////////////////////  ///////////////////////////////////////////////////////////
    public static int getWeekday(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        return dayOfWeek.getValue();
    }

    public static int getHour(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        return dateTime.getHour();
    }

    public static int getMinute(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        return dateTime.getMinute();
    }

    public static List<String> getDatesForWeekday(int weekday_1, int weekday_2, String initialDate, String finalDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDate = LocalDateTime.parse(initialDate, formatter);
        LocalDateTime endDate = LocalDateTime.parse(finalDate, formatter);
        List<String> datesForWeekday = new ArrayList<>();

        // Iterate through all the dates between the initial and final dates
        while (!startDate.isAfter(endDate)) {
            // Check if the weekday of the current date matches the specified weekday integer
            if ((startDate.getDayOfWeek().getValue() == weekday_1) || (startDate.getDayOfWeek().getValue() == weekday_2)) {
                String dateString = startDate.format(formatter);
                datesForWeekday.add(dateString);
            }
            startDate = startDate.plusDays(1); // Move to the next day
        }

        return datesForWeekday;
    }

    public static boolean checkOverlap(Connection conn, String roomId, String newDate, int duration, String tableName) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean overlap = false;

        try {
            pstmt = conn.prepareStatement("SELECT COUNT(*) FROM " + tableName + " WHERE ROOM_ID = ? AND DATE < DATE_ADD(?, INTERVAL ? MINUTE) AND DATE_ADD(DATE, INTERVAL DURATION MINUTE) > ?");
            pstmt.setString(1, roomId);
            pstmt.setTimestamp(2, Timestamp.valueOf(newDate));
            pstmt.setInt(3, duration);
            pstmt.setTimestamp(4, Timestamp.valueOf(newDate));
            rs = pstmt.executeQuery();

            if (rs.next()) {
                overlap = rs.getInt(1) > 0;
            }
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
        }

        return overlap;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void handleOneTimeReservation(Connection connection, String room_id, String res_name, int duration, String date) throws SQLException {

        boolean overlap = checkOverlap(connection, room_id, date, duration, "RESERVATION");

        if (overlap) {
            throw new IllegalArgumentException("The reservation will overlap with an existing reservation. Try another input values.");
        } else {
            String sql = "INSERT INTO RESERVATION(ROOM_ID, RES_NAME, RES_DATE, DURATION) VALUES (?, ?, ?, ?)";
            PreparedStatement prep = connection.prepareStatement(sql);
            // set the values for the placeholders
            prep.setString(1, room_id);
            prep.setString(2, res_name);
            prep.setString(3, date);
            prep.setInt(3, duration);

            prep.executeUpdate();
        }
    }

    private static void handleRecurrentReservation(Connection connection, String room_id, String res_name, int duration,
                                                   String period, int weekday, int hour, int minute, boolean delete) throws SQLException {
        List<String> all_dates;

        int nextWeekday = (weekday == 5) ? weekday + 1 : weekday + 2;

        // Query the PERIODS table to get the start and end dates for the given period
        String query = "SELECT START_DATE, END_DATE FROM PERIODS WHERE TITLE = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, period);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String start = rs.getString("START_DATE") + " " + hour + ":" + minute + ":00";
                    String end = rs.getString("END_DATE") + " " + hour + ":" + minute + ":00";
                    all_dates = getDatesForWeekday(weekday, nextWeekday, start, end);
                } else {
                    all_dates = List.of("INVALID PERIOD");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            all_dates = List.of("ERROR OCCURRED");
        }


        if (delete) {
            // Finally we delete all the rows which match the given parameters for the recurrent reservation.
            for (String date : all_dates) {
                String sql = "DELETE FROM RESERVATION WHERE ROOM_ID = ? AND RES_NAME = ? AND RES_DATE = ? AND DURATION = ?";
                PreparedStatement prep = connection.prepareStatement(sql);
                // set the values for the placeholders
                prep.setString(1, room_id);
                prep.setString(2, res_name);
                prep.setString(3, date);
                prep.setInt(4, duration);

                prep.executeUpdate();
            }
        } else {
            // Check if the Period-Weekday-Hour-Minute for room_id is a possible reservation.
            for (String allDate : all_dates) {
                boolean overlap = checkOverlap(connection, room_id, allDate, duration, "RESERVATION");
                if (overlap) {
                    throw new IllegalArgumentException("The reservation will overlap with an existing reservation. Try another input values.");
                }
            }
            // Finally we insert all the rows necessary for the recurrent reservation.
            for (String date : all_dates) {
                String sql = "INSERT INTO RESERVATION(ROOM_ID, RES_NAME, RES_DATE, DURATION) VALUES (?, ?, ?, ?)";
                PreparedStatement prep = connection.prepareStatement(sql);
                // set the values for the placeholders
                prep.setString(1, room_id);
                prep.setString(2, res_name);
                prep.setString(3, date);
                prep.setInt(4, duration);

                prep.executeUpdate();
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////APPLICATION FEATURES////////////////////////////////////////////////////////
    private static void check_room(int criteria, Scanner scanner) throws SQLException {

        String sql;

        switch (criteria) {
            case 1 -> {
                System.out.println("All Rooms: ");
                sql = "SELECT * FROM ROOMS";
            }
            case 2 -> {
                System.out.println("Enter the capacity minimum capacity required: ");
                int capacity_value = scanner.nextInt();
                sql = "SELECT * FROM ROOMS WHERE CAPACITY ='" + capacity_value + "'";
            }
            case 3 -> {
                System.out.println("Enter the room type: ");
                scanner.nextLine();
                String type_value = scanner.nextLine();
                sql = "SELECT * FROM ROOMS WHERE R_TYPE = '" + type_value + "'";
            }
            case 4 -> {
                System.out.println("Enter the room id: ");
                String room_id_value = scanner.nextLine();
                sql = "SELECT * FROM ROOMS WHERE ROOM_ID = '" + room_id_value + "'";
            }
            default ->
                // ERROR:
                    throw new IllegalArgumentException("Invalid criteria value: " + criteria);
        }
        // Realizar operaciones dentro de la transacción

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String roomId = resultSet.getString("ROOM_ID");
            String roomType = resultSet.getString("R_TYPE");
            String capacity = resultSet.getString("CAPACITY");

            System.out.println("Room ID: " + roomId + ", Room Type: " + roomType + ", Capacity: " + capacity);
        }
    }

    private static void room_reservation(int option, Scanner scanner) throws SQLException {

        String sql;
        String date;

        Statement statement = connection.createStatement();

        switch (option) {
            case 1 -> {
                sql = "SELECT * FROM RESERVATION";
                statement.executeQuery(sql);
            }
            case 2 -> {
                System.out.println("Please enter the date in the format (YYYY-MM-DD HH:MM).");
                date = scanner.nextLine();
                date += ":00";
                sql = "SELECT * FROM ROOMS WHERE ROOM_ID NOT IN (SELECT ROOM_ID FROM RESERVATION WHERE RES_DATE = '" + date + "')";
                statement.executeQuery(sql);
            }
            case 3 -> {
                System.out.println("Choose between made a one time reservation or a recurrent one. (o/r)");
                System.out.print("Note that a recurrent reservation will imply reserve a room for the entire period: ");
                scanner.nextLine(); // consume the newline character left in the buffer
                String reservation_type = scanner.nextLine();
                System.out.print("Enter your name to create the reservation: ");
                String res_name = scanner.nextLine();
                System.out.print("ROOM_ID: ");
                String room_id = scanner.nextLine();
                System.out.print("Enter the duration of your reservation (in minutes): ");
                int duration = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                switch (reservation_type) {
                    case "o" -> {
                        // RoomID, Date, Duration, Name
                        System.out.print("Please enter the date in the format (YYYY-MM-DD HH:MM):");
                        date = scanner.nextLine();
                        date += ":00";

                        handleOneTimeReservation(connection, room_id, res_name, duration, date);
                        }
                    case "r" -> {
                        // RoomID, Name, Period, Weekday, Hour, Minute, Duration
                        System.out.print("Period (e.g SPRING-22, AUTUMN-23): ");
                        String period = scanner.nextLine(); // Aquí podríamos hacer un menú de selección del periodo
                        System.out.print("Weekday: ");
                        int weekday = scanner.nextInt();
                        System.out.print("Hour: ");
                        int hour = scanner.nextInt();
                        System.out.print("Minute: ");
                        int minute = scanner.nextInt();
                        scanner.nextLine();

                        handleRecurrentReservation(connection, room_id, res_name, duration, period, weekday, hour, minute, false);
                    }
                    default -> throw new IllegalArgumentException("Invalid value");
                }
            }
            case 4 -> {
                System.out.print("Choose between CANCEL particular reservation or all the reservations between 'date_1' and 'date_2'. (p/a): ");
                scanner.nextLine(); // consume the newline character left in the buffer
                String cancelation_type = scanner.nextLine();
                System.out.print("ROOM_ID: ");
                String room_id_cancelation = scanner.nextLine();
                System.out.print("Your Name: ");
                String res_name_cancelation = scanner.nextLine();
                switch (cancelation_type) {
                    case "p" -> {
                        System.out.print("Please enter the date in the format (YYYY-MM-DD HH:MM):");
                        date = scanner.nextLine();
                        date += ":00";

                        // Room_id, name, date
                        sql = "DELETE FROM RESERVATION WHERE RES_DATE = ? AND RES_NAME = ? AND ROOM_ID = ?";
                        PreparedStatement prep = connection.prepareStatement(sql);

                        // set the values for the placeholders
                        prep.setString(1, date);
                        prep.setString(2, res_name_cancelation);
                        prep.setString(3, room_id_cancelation);

                        // execute the query
                        prep.executeUpdate();
                        break;
                    }
                    case "a" -> {
                        // Room_id, name, date_1, date_2
                        System.out.print("Please enter the INITIAL date in the format (YYYY-MM-DD HH:MM):");
                        String date_1 = scanner.nextLine();
                        System.out.println("Please enter the END date in the format (YYYY-MM-DD HH:MM):");
                        String date_2 = scanner.nextLine();

                        date_1 += ":00";
                        date_2 += ":00";

                        // Room_id, name, date
                        sql = "DELETE FROM RESERVATION WHERE (RES_DATE BETWEEN ? AND ?) AND RES_NAME = ? AND ROOM_ID = ?";
                        PreparedStatement prep = connection.prepareStatement(sql);

                        // set the values for the placeholders
                        prep.setString(1, date_1);
                        prep.setString(2, date_2);
                        prep.setString(3, res_name_cancelation);
                        prep.setString(4, room_id_cancelation);

                        // execute the query
                        prep.executeUpdate();
                        break;
                    }
                    default -> throw new IllegalArgumentException("Invalid value");
                }
            }
            default ->
                // ERROR:
                    throw new IllegalArgumentException("Invalid value");
        }

        // Just the option 3 and 4 imply commit actions.
        if (option == 3 || option == 4) {
        // Confirm or rollback the transaction.
        boolean commit = confirmTransaction(scanner);
        if (commit) {
            connection.commit();
            System.out.println("Transaction committed");
        } else {
            connection.rollback();
            System.out.println("Transaction rolled back");
        }}
    }

    private static void schedule_manager(int option, Scanner scanner) throws Exception {

        String sql;

        Statement statement = connection.createStatement();

        switch (option) {
            case 1 -> {
                sql = "SELECT * FROM SCHEDULES";
                statement.executeQuery(sql);
            }
            case 2 -> {

                System.out.println("Please choose the searching criteria.");
                System.out.println("1. Weekday (1-7): ");
                System.out.println("2. Period: ");
                System.out.println("3. Semester");
                System.out.println("4. RoomID");
                System.out.print("OPTION");

                int criteria = scanner.nextInt();

                switch (criteria){
                    case 1 -> {
                        System.out.print("Choose the weekday you want to filter for (1=Monday, 7=Sunday): ");
                        int weekday = scanner.nextInt();
                        sql = "SELECT * FROM SCHEDULES WHERE WEEK_DAY ="+weekday;
                        statement.executeQuery(sql);
                    }
                    case 2 -> {
                        System.out.print("Choose the period you want to filter for (SPRING-22, AUTUMN-23, etc.): ");
                        String period = scanner.nextLine();
                        sql = "SELECT * FROM SCHEDULES WHERE PERIOD ="+period;
                        statement.executeQuery(sql);
                    }
                    case 3 -> {
                        System.out.print("Choose the semester you want to filter for (1 - 10): ");
                        int semester = scanner.nextInt();
                        sql = "SELECT * FROM SCHEDULES WHERE SEMESTER ="+semester;
                        statement.executeQuery(sql);
                    }
                    case 4 -> {
                        System.out.print("Choose the RoomID you want to filter for (IA-203): ");
                        int room_id = scanner.nextInt();
                        sql = "SELECT * FROM SCHEDULES WHERE ROOM_ID ="+room_id;
                        statement.executeQuery(sql);

                    }
                    default -> throw new IllegalArgumentException("Invalid value");
                }
            }
            case 3 -> {

                HashMap<String, Object> entry = new HashMap<String, Object>();

                System.out.println("To add an entry please fill the next form: ");

                System.out.print("Course Key: ");
                String courseKey = scanner.nextLine();
                entry.put("Course Key", courseKey);

                System.out.print("Section: ");
                String section = scanner.nextLine();
                entry.put("Section", section);

                System.out.print("Weekday: ");
                int weekday = scanner.nextInt();
                entry.put("Weekday", weekday);

                System.out.print("Hour: ");
                int hour = scanner.nextInt();
                entry.put("Hour", hour);

                System.out.print("Minute: ");
                int minute = scanner.nextInt();
                entry.put("Minute", minute);

                System.out.print("Duration: ");
                int duration = scanner.nextInt();
                entry.put("Duration", duration);

                System.out.print("Period: ");
                String period = scanner.nextLine();
                entry.put("Period", period);

                System.out.print("Semester: ");
                String semester = scanner.nextLine();
                entry.put("Semester", semester);

                System.out.print("RoomID: ");
                String roomID = scanner.nextLine();
                entry.put("RoomID", roomID);

                // We check if the row already exist:
                sql = "SELECT COUNT(*) FROM SCHEDULES WHERE COURSE_KEY = ? AND SECC = ? AND WEEK_DAY = ?";
                PreparedStatement check_statement = connection.prepareStatement(sql);
                check_statement.setString(1, courseKey);
                check_statement.setString(2, section);
                check_statement.setInt(3, weekday);
                ResultSet resultSet = check_statement.executeQuery();

                resultSet.next(); // We get the first row
                int rowCount = resultSet.getInt(1); // We get the count of the rows with the course_key, secc, weekday combination
                if (rowCount > 0) {
                    // Row already exists, print error message and return
                    throw new RowSetWarning("The row you are trying to insert already exists.");
                }

                // If the row does not exist then:
                sql = "INSERT INTO SCHEDULES (COURSE_KEY, SECC, WEEK_DAY, SCH_HOUR, SCH_MIN, DURATION, PERIOD, SEMESTER, ROOM_ID) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

                PreparedStatement prep_statement = connection.prepareStatement(sql);
                prep_statement.setString(1, (String) entry.get("Course Key"));
                prep_statement.setString(2, (String) entry.get("Section"));
                // Weekday is considered later
                prep_statement.setInt(4, (int) entry.get("Hour"));
                prep_statement.setInt(5, (int) entry.get("Minute"));
                prep_statement.setInt(6, (int) entry.get("Duration"));
                prep_statement.setString(7, (String) entry.get("Period"));
                prep_statement.setString(8, (String) entry.get("Semester"));
                prep_statement.setString(9, (String) entry.get("RoomID"));

                // We insert two rows because of weekday. For example, weekday = 1 implies a row in weekday = 3.

                String weekDay = (String) entry.get("Weekday");
                if (weekDay.equals("1") || weekDay.equals("3")) {
                    // Insert row with weekday 1
                    prep_statement.setInt(3, 1);
                    prep_statement.executeUpdate();

                    prep_statement.setInt(3, 3);
                    prep_statement.executeUpdate();
                }
                if (weekDay.equals("2") || weekDay.equals("4")) {
                    // Insert row with weekday 1
                    prep_statement.setInt(3, 2);
                    prep_statement.executeUpdate();

                    prep_statement.setInt(3, 4);
                    prep_statement.executeUpdate();
                }
                if (weekDay.equals("5") || weekDay.equals("6")) {
                    // Insert row with weekday 1
                    prep_statement.setInt(3, 5);
                    prep_statement.executeUpdate();

                    prep_statement.setInt(3, 6);
                    prep_statement.executeUpdate();
                }

                System.out.print("To finish the process enter the name of the professor that will use the room "+roomID+": ");
                String professor = scanner.nextLine();

                // Trigger function
                handleRecurrentReservation(connection, roomID, professor, duration, period, weekday, hour, minute, false);

            }
            case 4 -> {
                System.out.println("To modify a programmed schedule you need to provide its COURSE KEY, SECTION and WEEKDAY.");
                System.out.print("Course Key: ");
                String course_key = scanner.nextLine();
                System.out.print("Section: ");
                String section = scanner.nextLine();
                System.out.print("Weekday (Monday=1, Sunday=7): ");
                int weekday = scanner.nextInt();

                // We check that the schedule exist in the db:
                sql = "SELECT * FROM SCHEDULES WHERE COURSE_KEY ="+ course_key + " AND SECC =" + section + " AND WEEK_DAY ="+ weekday ;

                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    // get the values from the columns of the result set
                    String courseKey = resultSet.getString("COURSE_KEY");  // TODO: PRUEBA
                    String secc = resultSet.getString("SECC");  // TODO: PRUEBA
                    int weekDay = resultSet.getInt("WEEK_DAY");  // TODO: PRUEBA

                    String result = "";  // TODO: PRUEBA
                    result += "Course Key: " + courseKey + ", Section: " + secc + ", Weekday: " + weekDay; // TODO: PRUEBA
                    System.out.print(result);
                } else {
                    throw new RowSetWarning("The row you try to update does not exist in the DB.");
                }

                // If the schedule exist then we can update it.
                // All the following entries are mandatory.
                System.out.println("Please fill the following form: ");
                System.out.print("Hour: (Current = "+resultSet.getInt("SCH_HOUR")+")");
                int sch_hour = scanner.hasNextInt() ? scanner.nextInt() : resultSet.getInt("SCH_HOUR");
                System.out.print("Minute: (Current = "+resultSet.getInt("SCH_MINUTE")+")");
                int sch_min = scanner.hasNextInt() ? scanner.nextInt() : resultSet.getInt("SCH_MINUTE");
                System.out.print("Duration: (Current = "+resultSet.getInt("DURATION")+")");
                int duration = scanner.hasNextInt() ? scanner.nextInt() : resultSet.getInt("DURATION");
                scanner.nextLine(); // consume the remaining new line character
                System.out.print("Period: (Current = "+resultSet.getString("PERIOD")+")");
                String period = scanner.hasNextLine() ? scanner.nextLine() : resultSet.getString("PERIOD");
                System.out.print("Semester: (Current = "+resultSet.getString("SEMESTER")+")");
                String semester = scanner.hasNextLine() ? scanner.nextLine() : resultSet.getString("SEMESTER");
                System.out.print("RoomID: (Current = "+resultSet.getString("ROOM_ID")+")");
                String room_id = scanner.hasNextLine() ? scanner.nextLine() : resultSet.getString("ROOM_ID");

                sql = "UPDATE SCHEDULES SET SCH_HOUR=?, SCH_MIN=?, DURATION=?, PERIOD=?, SEMESTER=?, ROOM_ID=? " +
                        "WHERE COURSE_KEY=? AND SECC=? AND WEEK_DAY=?";

                PreparedStatement prep_statement = connection.prepareStatement(sql);
                prep_statement.setInt(1, sch_hour);
                prep_statement.setInt(2, sch_min);
                prep_statement.setInt(3, duration);
                prep_statement.setString(4, period);
                prep_statement.setString(5, semester);
                prep_statement.setString(6, room_id);
                prep_statement.setString(7, course_key);
                prep_statement.setString(8, section);
                prep_statement.setInt(9, weekday);

                prep_statement.executeUpdate();

                // Delete and generate the necessary reservations to the schedule

                System.out.print("In order to delete and create the needed reservations provide the name of the professor how is in charge of the course: ");
                String professor = scanner.nextLine();

                // DELETE from reservations

                String original_roomID = resultSet.getString("ROOM_ID");
                int original_hour = resultSet.getInt("HOUR");
                int original_minute = resultSet.getInt("MINUTE");
                int original_weekday = resultSet.getInt("WEEK_DAY");
                int original_duration = resultSet.getInt("DURATION");
                String original_period = resultSet.getString("PERIOD");

                handleRecurrentReservation(connection, original_roomID, professor, original_duration, original_period, original_weekday, original_hour, original_minute, true);

                // GENERATE reservations
                handleRecurrentReservation(connection, room_id, professor, duration, period, weekday, sch_hour, sch_min, false);

            }
            case 5 -> {

                System.out.println("In order to delete a course from the schedule you need to fill the following form. ");
                System.out.print("Course Key: ");
                String course_key = scanner.nextLine();
                System.out.print("Section: ");
                String section = scanner.nextLine();
                System.out.print("Weekday (Monday=1, Sunday=7): ");
                int weekday = scanner.nextInt();

                // We check if the row already exist:
                sql = "SELECT * FROM SCHEDULES WHERE COURSE_KEY = ? AND SECC = ? AND WEEK_DAY = ?";
                PreparedStatement check_statement = connection.prepareStatement(sql);
                check_statement.setString(1, course_key);
                check_statement.setString(2, section);
                check_statement.setInt(3, weekday);
                ResultSet resultSet = check_statement.executeQuery();

                if (resultSet.next()) {
                    // Row already exists, print error message and return
                    throw new Exception("There is no courses with that key-section-weekday combination.");
                }

                sql = "DELETE FROM SCHEDULES WHERE COURSE_KEY = ? AND SECC = ? AND WEEK_DAY = ?";
                PreparedStatement prep_statement = connection.prepareStatement(sql);
                prep_statement.setString(1, course_key);
                prep_statement.setString(2, section);
                prep_statement.setInt(3, weekday);
                prep_statement.executeQuery();

                // Delete the needed reservations.
                String roomID = resultSet.getString("ROOM_ID");
                int duration = resultSet.getInt("DURATION");
                String period = resultSet.getString("PERIOD");
                int sch_hour = resultSet.getInt("SCH_HOUR");
                int sch_min = resultSet.getInt("SCH_MIN");

                System.out.print("In order to delete the needed reservations provide the name of the professor how is in charge of the course: ");
                String professor = scanner.nextLine();

                handleRecurrentReservation(connection, roomID, professor, duration, period, weekday, sch_hour, sch_min, true);

            }
            default -> throw new IllegalArgumentException("Invalid value");
        }

        // Just the option 3 and 4 imply commit actions.
        if (option == 3 || option == 4  || option == 5) {
            // Confirm or rollback the transaction.
            boolean commit = confirmTransaction(scanner);
            if (commit) {
                connection.commit();
                System.out.println("Transaction committed");
            } else {
                connection.rollback();
                System.out.println("Transaction rolled back");
            }}

    }

}
