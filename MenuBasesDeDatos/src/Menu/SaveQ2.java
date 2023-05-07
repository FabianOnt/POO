package Menu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SaveQ2 implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		String sql ="";
		
		switch(Querry2.querrymode) {
			case 0 -> {
			}
			case 1 -> {
				sql = "SELECT * FROM RESERVATION";				
			}
			case 2 -> {
				sql = "SELECT * FROM ROOMS WHERE ROOM_ID NOT IN (SELECT ROOM_ID FROM RESERVATION WHERE RES_DATE = '" + Window.text1.getText() + ":00')";
			}
			case 3 -> {
				String res_name = Window.text2.getText();
				String room_id = Window.text3.getText();
				int duration = Integer.parseInt(Window.text4.getText());
				String date = Window.text5.getText() + ":00";
				
				// handleOneTimeReservation(connection, room_id, res_name, duration, date);
			}
			case 4 -> {
				String res_name = Window.text2.getText();
				String room_id = Window.text3.getText();
				int duration = Integer.parseInt(Window.text4.getText());
				String period = Window.text5.getText();
				int weekday = Integer.parseInt(Window.text6.getText());
				int hour = Integer.parseInt(Window.text7.getText());
				int minute = Integer.parseInt(Window.text8.getText());
				
				// handleRecurrentReservation(connection, room_id, res_name, duration, period, weekday, hour, minute, false);
			}
			case 5 -> {
				// Room_id, name, date
				String room_id_cancelation = Window.text2.getText();
				String res_name_cancelation = Window.text3.getText();
				String date = Window.text3.getText() + ":00";
				
				sql = "DELETE FROM RESERVATION WHERE RES_DATE = ? AND RES_NAME = ? AND ROOM_ID = ?";
                
                /*
                PreparedStatement prep = connection.prepareStatement(sql);

                // set the values for the placeholders
                prep.setString(1, date);
                prep.setString(2, res_name_cancelation);
                prep.setString(3, room_id_cancelation);

                // execute the query
                prep.executeUpdate();
                
                */

			}
			case 6 -> {
				// Room_id, name, date
				String room_id_cancelation = Window.text2.getText();
				String res_name_cancelation = Window.text3.getText();
				String date1 = Window.text3.getText() + ":00";
				String date2 = Window.text4.getText() + ":00";
				
                sql = "DELETE FROM RESERVATION WHERE (RES_DATE BETWEEN ? AND ?) AND RES_NAME = ? AND ROOM_ID = ?";
                /*
                PreparedStatement prep = connection.prepareStatement(sql);

                // set the values for the placeholders
                prep.setString(1, date_1);
                prep.setString(2, date_2);
                prep.setString(3, res_name_cancelation);
                prep.setString(4, room_id_cancelation);

                // execute the query
                prep.executeUpdate();
                */
			}
			
			
		}
		
		if (true) { // add validation condition
			Window.hideContent();
			
			Window.notification.print("Querry "+Window.querryCounter+" executed.", Color.green);
			Window.querryCounter++;
			
			Window.headline.setText("Result");
			Window.description.setText(sql); // Execute Querry
			
			Window.headline.setVisible(true);
			Window.description.setVisible(true);
		} else {
			Window.notification.print("Enter valid parameters.", Color.red);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
