
// ----------------------- Class Main ---------------------------

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		Fibonacci fib = new Fibonacci();
		Splitter split = new Splitter();
		Manager manager = new Manager();
		
		List<Integer> fibonacci = fib.filFibonacci(1000000);
		List<Integer> even = split.getEven(fibonacci);
		List<Integer> odd = split.getOdds(fibonacci);
		
		manager.saveArray(odd, "Odd_Fibonacci.dat");
		manager.saveArray(even, "Even_Fibonacci.dat");
		manager.saveArray(fibonacci, "Fibonacci.dat");
	}
}


// ---------------------- Class Fibonacci -----------------------

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Fibonacci {
	
	public List<Integer> filFibonacci(int upperLimit) {
		
		List<Integer> fibonacci = new ArrayList<Integer>();
		
		int i = 1;
		fibonacci.addAll(Arrays.asList(1,1));
		
		while (fibonacci.get(i) < upperLimit) {
			fibonacci.add(fibonacci.get(i-1)+fibonacci.get(i));
			i ++;
		}
		fibonacci.remove(i);
		
		return fibonacci;
	}
}


// --------------------- Class Manager -------------------------

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Manager {
	
	
	public void saveArray(List<Integer> list, String fileName) throws IOException {

		File file = new File(fileName);
		
		FileWriter fileWriter 	= new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		int i;
		for (i=0; i<list.size();i++) {
			printWriter.println(list.get(i));	    			
		}
		printWriter.close();
	}

}

// ---------------------- Class Splitter ---------------------------

import java.util.ArrayList;
import java.util.List;

public class Splitter {
	
	public List<Integer> getOdds(List<Integer> list){ // Impares
		
		int i;
		List<Integer> odds = new ArrayList<Integer>();
				
		for (i=0; i<list.size(); i++) {
			if (list.get(i)%2 != 0) {
				odds.add(list.get(i));
			}
		}
		
		return odds;
	}
	
	public List<Integer> getEven(List<Integer> list){ // Pares
			
		int i;
		List<Integer> even = new ArrayList<Integer>();
				
		for (i=0; i<list.size(); i++) {
			if (list.get(i)%2 == 0) {
				even.add(list.get(i));
			}
		}
		
		return even;
	}
	
}
