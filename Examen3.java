import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Lector miLectorExamen = new Lector();
		miLectorExamen.ejecutar(173428);
		
	}
}


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lector {
	
	public void ejecutar(int id) throws IOException {
	
		File file = new File("emails.csv");
		File file2 = new File("173428.txt");

		int idStart = getLast3(173428);
		int[][] data = loadData(file,idStart);
		int[] sum = sumCols(data);
		String[] headers = loadHeaders(file);

		saveCols(sum,headers,file2);

	}
	
	private static int[] sumCols(int[][] data) {
		int[] newArray = new int[data[0].length];
		int i,j,value;
		for (j=0; j<data[0].length; j++) {
			value=0;
			for (i=0; i<data.length; i++) {
				value += data[i][j];
			}
			newArray[j] = value;
		}
		return newArray;
	}
	
	private static int getLast3(int number) {
		int val = number - 1000*(int) Math.floor(number/1000);
		return val;
	}
	
	private static String read(File file)  throws IOException { 
		Path fileName = Path.of(file.getPath());
		String str = Files.readString(fileName);
        return str;
    }	

	private static String[] loadHeaders(File file) throws IOException {
		String rawData = read(file);
		String[] rows = rawData.split("\n");
		String[] row = rows[0].split(",");
		String[] headers = new String[row.length-2];
		int i;
		for (i=0;i<row.length-2;i++) {
			headers[i] = row[i+1];
		}
		return headers;		
	}
	
	private static int[][] loadData(File file, int start) throws IOException {
		String rawData = read(file);
		String[] rows = rawData.split("\n");
		
		int[][] data = new int[50][3000]; 

		int i,j;
		for (i=0; i<data.length; i++) {
			String[] newRow = rows[start+i].split(",");			
			for (j=0; j<data[0].length; j++) {
				data[i][j] = Integer.parseInt(newRow[j+1]);
			}
		}
		return data;
	}
	
	public static void write(File file, String msg) throws IOException {
		
	    FileWriter fileWriter 	= new FileWriter(file);
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.print(msg);
	    printWriter.close();
	}
	
	
	private static void saveCols(int[] data, String[] keys, File file) throws IOException{
		String text = "";
		int i;
		for (i=0; i<data.length;i++) {
			text += keys[i] + "," + data[i] + "\n";
		}
		write(file, text);
	}
	
}
