// --------------------------  User class ----------------------------

public class User{
	
	private String name;
	private int games, wins;
	
	public User() {
	}
	
	public User(String name){
		this.name = name;
		games = 0;
		wins = 0;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGames(int value) {
		games = value;
	}
	
	public int getGames() {
		return games;
	}
	
	public void setWins(int value) {
		wins = value;
	}
	
	public int getWins() {
		return wins;
	}
}

// --------------------------- Personaje class ---------------------------------

public class Personaje {
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}


// ---------------------------- Persona class -------------------------------


public class Persona extends Personaje{
	
	private boolean isMale, isMexican, hasPets, isStudent;
	
	// ***** Setters for private attributes *****	
	public void setIsMale(boolean isMale) {
		this.isMale = isMale;
	}
	
	public void setIsMexican(boolean isMexican) {
		this.isMexican = isMexican;
	}
	
	public void sethasPets(boolean hasPets) {
		this.hasPets = hasPets;
	}
	
	public void setIsStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}
	
	// ***** Getters for private attributes *****
	public boolean getIsMale() {
		return isMale;
	}
	
	public boolean getIsMexican() {
		return isMexican;
	}
	
	public boolean getHasPets() {
		return hasPets;
	}
	
	public boolean getIsStudent() {
		return isStudent;
	}
}


// --------------------------------- AdivinaQuien class ------------------------------------

import java.util.Random;
import java.util.Scanner;

public class AdivinaQuien{

	public static boolean win;
	
	public AdivinaQuien(){
		win = false;
	}

	public void newGame() {
		
		Scanner scan1 = new Scanner(System.in);
		String names[] = {"Juan","Pedro","Amanda","Jimena","Fernando","Ana","Antonio","Grecia","María","Homero"};
		Persona people[] = new Persona[10];
		boolean combinations[][] = new boolean[16][4]; // number of combinations
		fillCombinations(combinations);
		fillData(people, names, combinations);
		
		// Test for unique and randomized values
		test(people);
		
		// Selection of one element
		Random random = new Random();
		int selected = random.nextInt(people.length);
		
		// Menu
		int question, iter=0;
		boolean[] possibles = new boolean[people.length];
		fillConstant(possibles);
		
		System.out.println("---------------------------------------------------------------\n"
				+ "Este es un juego de adivina quién con la computadora :)."
				+ "Ingrese el índice de la pregunta que desea hacer.\nLas preguntas posibles son las sigueintes:\n"
				+ "1.¿Es hombre?\n"
				+ "2.¿Tiene mascotas?\n"
				+ "3.¿Es mexicano?\n"
				+ "4.¿Es estudiante?\n\n");
		
		do {
			int i;
			System.out.println("Haga su pregnta "+(iter+1)+":");
			question = scan1.nextInt();
			scan1.nextLine();
			
			for (i=0; i<people.length; i++) {
				if (possibles[i]) {
					switch (question) {
					case 1:{
						if (people[i].getIsMale() != people[selected].getIsMale()) {
							possibles[i] = false;
						} break;
					}
					case 2:{
						if (people[i].getHasPets() != people[selected].getHasPets()) {
							possibles[i] = false;
						} break;
					}
					case 3:{
						if (people[i].getIsMexican() != people[selected].getIsMexican()) {
							possibles[i] = false;
						} break;
					}
					case 4:{
						if (people[i].getIsStudent() != people[selected].getIsStudent()) {
							possibles[i] = false;
						} break;
					}
					default: {
						iter -= 1;
					}
					
					}
				}
			}
			iter++;
			
			System.out.println("Personajes posibles:");
			for (i=0; i<possibles.length; i++) {
				if (possibles[i]) {
					System.out.println(i+": "+people[i].getName()+"\n");
				}
			}
			
		} while(iter<3);
		
		System.out.println("Ingrese el índice asociado a la persona que usted cree que es la seleccionada: ");
		int ans = scan1.nextInt();
		
		if (ans == selected) {
			System.out.println("¡Felicidades! Has adivinado el personaje.");
			win = true;
		} else{
			System.out.println("Mala suerte, el personaje correcto es "+people[selected].getName());
			win = false;
		}

	}
	
	public static boolean getResult() {
		return win;
	}
	
	public static void fillData(Persona[] people, String[] names, boolean[][] combinations) {
		int i;
		int[] index1 = new int[people.length];
		int[] index2 = new int[16];
		arange(index1); shuffleArray(index1); // names index
		arange(index2); shuffleArray(index2); // combinations index
		
		for (i=0; i<people.length; i++) {
			people[i] = new Persona();
			people[i].setName(names[index1[i]]);
			people[i].setIsMale(combinations[index2[i]][0]);
			people[i].setIsMexican(combinations[index2[i]][1]);
			people[i].sethasPets(combinations[index2[i]][2]);
			people[i].setIsStudent(combinations[index2[i]][3]);			
		}
	}
	
	public static boolean intToBool(int number) {
		if (number == 0) {
			return false;
		} else {
			return true;		
		}
	}
	
	public static int boolToInt(boolean value) {
		if (value) {
			return 1;
		} else {
			return 0;		
		}
	}
	
	public static void fillCombinations(boolean[][] comb) {
		int i=0,p1,p2,p3,p4;
 		//number of unique combinations
		while (i<comb.length) {
			for (p1=0; p1<=1; p1++) {
				for (p2=0; p2<=1; p2++) {
					for (p3=0; p3<=1; p3++) {
						for (p4=0; p4<=1; p4++) {
							comb[i][0] = intToBool(1-p1);
							comb[i][1] = intToBool(1-p2);
							comb[i][2] = intToBool(1-p3);
							comb[i][3] = intToBool(1-p4);
							i++;
						}
					}
				}
			}
				
		}
	}
	
	public static void shuffleArray(int[] array) {
		int i, idx, value;
		Random random = new Random();
		for (i=0; i<array.length; i++) {
			idx = random.nextInt(array.length);
			value = array[idx];
			array[idx] = array[i];
			array[i] = value;
		}
	}
	
	public static void arange(int[] array) {
		int i;
		for (i=0; i<array.length; i++) {
			array[i] = i;
		}
	}
	
	public static void fillConstant(boolean[] array) {
		int i;
		for (i=0; i<array.length; i++) {
			array[i] = true;
		}
	}
	
	public static void test(Persona[] people) {
		int i, totalMale=0, totalPets=0, totalMexican=0, totalStudent=0;
		System.out.println("Nombre|Es hombre|Tiene mascotas|Es mexicano|Es estudainte\n");
		for (i=0; i<people.length; i++) {
			System.out.println(people[i].getName() + ": " + people[i].getIsMale() +", "+ people[i].getHasPets() +", "+ people[i].getIsMexican() +", "+ people[i].getIsStudent()+"\n");
			totalMale += boolToInt(people[i].getIsMale());
			totalPets += boolToInt(people[i].getHasPets());
			totalMexican += boolToInt(people[i].getIsMexican());
			totalStudent += boolToInt(people[i].getIsStudent());
		}
		System.out.println("Suma de valores de atrubutos: " + totalMale + ", " + totalPets +", "+ totalMexican +", "+totalStudent);
	}
	
}


// ------------------------------------ MainMenu class ------------------------------------------


import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class MainMenu {
	
	private static int totalUsers;  // total number of used spaces in the data set by an existing user.
	private static int newSize = 100; // ( >1 ) default value for new data set length if it is filled during execution (if not enough, defaults to twice the data set current length).
	private static String defaultName = "Dn9Tx01c#sd&"; // default name that will indicate a free user space in the data set.
	
	static File file = new File("GameData.dat");
	static String line;
	
	public static void main(String[] args) {
		try {
			file.createNewFile();
			 User[] data = loadData(file,10);
			 totalUsers = getTotalUsers(data);
			 mainMenu(data);
			 saveData(data, file);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	
	public static void mainMenu(User[]data) {
			
		Scanner scan = new Scanner(System.in);		
		
		boolean activeProcess = true;
		
		do {
			
			String[] usernames = getUsernames(data);
			System.out.println("\n------------ MENU PRINCIPAL ------------\n\n"
					+ "Opciones:\n"
						+ "1)\tIniciar Sesión\n"
						+ "2)\tCrear nuevo usuario\n"
						+ "3)\tSalir del juego");
			
			int option = scan.nextInt();
			
			
			switch (option) {
			
			case 1:
			{
				System.out.println("\nIngrese su nombre de usuario");
				String username = scan.next();
				
				
				if (isInStrArray(usernames, username, totalUsers)) {
					int idx = getUserIndex(data, username);
					
					do {
						
						System.out.println("\nBienvenido " + data[idx].getName() + "\n"
								+ "Opciones:\n"
								+ "1)\tNuevo juego\n"
								+ "2)\tVer estadisticas\n"
								+ "3)\tReiniciar estadisticas\n"
								+ "4)\tModificar nombre de usuario\n"
								+ "5)\t Salir");
						option = scan.nextInt();
						
						
						switch (option) {
						case 1:{
							AdivinaQuien game = new AdivinaQuien();
							int nextGame = 1;
							do {
								game.newGame();
								data[idx].setGames(data[idx].getGames()+1);
								if (AdivinaQuien.getResult()) {
									data[idx].setWins(data[idx].getWins()+1);
								}
								System.out.println("\n¿Quieres jugar otra partida?\n"
										+ "1)\tSi\n"
										+ "2)\tNo");
								nextGame = scan.nextInt();
								
								
							} while (nextGame == 1);
							break;
						}
						
						case 2:{
							
							double percentageWin = 0, percentageLoss = 0;
							
							if (data[idx].getGames() != 0) {
								percentageWin = 100*data[idx].getWins()/data[idx].getGames();
								percentageLoss = 100*(data[idx].getGames() - data[idx].getWins())/data[idx].getGames();
							}
							
							System.out.println("\n***** Estadisticas *****\n"
									+ "Partidas ganadas: " + data[idx].getWins() + "(" + (percentageWin) + "%)\n"
									+ "Partidas perdidas: " + (data[idx].getGames()-data[idx].getWins()) + "(" + percentageLoss + "%)\n"
									+ "Partidas jugadas: " + data[idx].getGames() +"\n\n"
									
											+ "Ingrese cualquier tecla para volver.");
							scan.next();
							
							break;
						}
						case 3:{
							System.out.println("¿Esta seguro de querer reinicar sus estadisticas? El proceso es irreversible.\n"
									+ "1)\tSi\n"
									+ "2)\tNo");
							int ans = scan.nextInt();
							
							
							if (ans == 1) {
								data[idx].setGames(0);
								data[idx].setWins(0);
								System.out.println("Estadisticas reiniciadas.");
							} else {
								System.out.println("Tranquilo, no se han modificado sus estadisticas.");							
							}
							break;
						}
						case 4:{
							String newName;
							do {
								System.out.println("\nIngrese un nuevo nombre de usuario:");
								newName = scan.next();
								
								if (newName != data[idx].getName()) {
									if (isInStrArray(usernames, newName,totalUsers)) { // checks if the username is free. 
										System.out.println("El usuario "+ newName +" ya existe. Ingrese un nuevo nombre.");
									} else{
										break;
									}
								} else {
									break;
								}
							} while (true); // repeated while the username is already in use
							data[idx].setName(newName);
							System.out.println("Perfecto, su nuevo nombre de usuario sera " + data[idx].getName());
							usernames = getUsernames(data);
							break;
						}
						default:{
							break;
						}
						
						}
					} while (option != 5);
					

				} else {
					System.out.println("El usuario no exisite. Volviendo al menu principal...");
				}
				break;
			}
		
			
			case 2:
			{
				if (totalUsers == data.length) {
					data = broadcastToNewArray(data, newSize);
				}
				System.out.println("\nIngrese su nombre de usuario.");
				while (true){
					String username = scan.next();
					if (!isInStrArray(usernames, username,totalUsers)) { // determines if the name is unique (name is the Key for each user)
						User newUser = new User(username);
						if (totalUsers != 0) {
							data[totalUsers-1] = newUser;						
						} else {
							data[0] = newUser;
						}
						totalUsers ++;
						System.out.println("El usuario ha sido creado.");
						break;
					} else {
						System.out.println("El usuario "+ username +" ya existe. Ingrese un nuevo nombre.");
					}
				}
				System.out.println("Volviendo al menú pricipal...");
				break;
			}
			
			
			case 3:{
				activeProcess = false;
			}
			default: break;
			}
			
		} while (activeProcess);
		scan.close();
	}
	
	
	public static void saveData(User[] data, File file) throws IOException {
		
		String stringData = "";
		int i;
		for (i=0; i<totalUsers; i++) {
			stringData += data[i].getName() + ",";
			stringData += Integer.toString(data[i].getGames()) + ",";
			stringData += Integer.toString(data[i].getWins()) + ";";
			//if (i<totalUsers -1) {
			//	stringData += ";";
			//}
		}
		
		write(file, stringData);
	}
	
	
	public static int getUserIndex(User[] data, String name) {
		int i;
		for (i=0; i<totalUsers; i++) {
			if (data[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public static User[] broadcastToNewArray(User[] array, int newSize){
		if (newSize < array.length) {
			newSize = 2*array.length;
		}
		User[] newArray = new User[newSize];
		int i;
		for (i=0; i<array.length; i++) {
			newArray[i] = array[i];
		}
		for (i=array.length; i<newSize; i++) {  // fills the rest of the array with users that will be overwritten.
			User user = new User(defaultName);
			newArray[i] = user;
		}
		return newArray;
	}
	
	public static int getTotalUsers(User[] data) {
		int i;
		for(i=0; i<data.length; i++) {
			if (data[i].getName().equals(defaultName)) {
				return i;
			}
		}
		return data.length;
	}
	
	public static boolean isInStrArray(String[] array, String value, int validUsers) {
		int i;
		for (i=0; i<validUsers; i++) {
			if (value.equals(array[i])) {
				return true;
			}
		}
		return false;
	}
	
	
	public static String toString(String id, int[] data) {
		String myString = "";
		myString += id;
		int i;
		for (i=0; i<data.length; i++) {
			myString += "," + Integer.toString(data[i]) + ";";
		}
		//myString += ";";
		return myString;
	}
	
	public static User[] loadData(File file, int maxUsers) throws IOException {
		String rawData = read(file);
		String[] rows = rawData.split(";");
		
		
		
		int length = 0;
		
		User[] data = new User[maxUsers]; 
		
		if (rows[0] != "") {
			length = rows.length;
		}
		
		int i;
		for (i=0; i<length; i++) {
			String[] newRow = rows[i].split(",");			
			User user = new User();
			user.setName(newRow[0]);
			user.setGames(Integer.parseInt(newRow[1]));
			user.setWins(Integer.parseInt(newRow[2]));
			data[i] = user;
		}
		for (i=length; i<maxUsers; i++) {  // fills the rest of the array with users that will be overwritten.
			User user = new User(defaultName);
			data[i] = user;
		}
		return data;
	}
	
	public static String[] getUsernames(User[] data) {
		String[] names = new String[totalUsers];
		int i;
		for (i=0; i< totalUsers; i++) {
			names[i] = data[i].getName();
		}
		return names;
	}
	
	
	public static void write(File file, String msg) throws IOException {
			
	    FileWriter fileWriter 	= new FileWriter(file);
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.print(msg);
	    printWriter.close();
	}
	
	public static String read(File file)  throws IOException
    { 
        Path fileName = Path.of(file.getPath());
        String str = Files.readString(fileName);
        return str;
    }	

}



