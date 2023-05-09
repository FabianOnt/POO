package estructurasDeDatos;

public class Ejercicio {
	public static void main(String[] ars) {
		
		int i;
		int max = 3;
		MyStack stack1 = new MyStack(max);
		MyQueue queue1 = new MyQueue(max);
		
		System.out.println("1),2) Llenado del stack y el queue");
		for (i=0; i<max+1; i++) {
			System.out.println(i);
			stack1.push(Character.forDigit(i,10));
			queue1.push(Character.forDigit(i, 10));
		}
		
		System.out.println("\n1) Vaciado del queue");
		for (i=0; i<queue1.MAX+1; i++) {
			System.out.println( i + ": " + queue1.delete());
		}
		
		System.out.println("\n2) Vaciado del stack");
		for (i=0; i<stack1.MAX+1; i++) {
			System.out.println( i + ": " + stack1.pop());
		}
		
		System.out.println("\n4) Palíndromo: profesor -> " + isPalindrome("profesor"));
		System.out.println("\n4) Palíndromo:  reconocer-> " + isPalindrome("reconocer"));
		
	}
	
	public static String invert(String string) {
		MyStack stack = new MyStack(string.length());
		String inverted_string = "";
		int i;
		for (i=0; i<stack.MAX; i++) {
			stack.push(string.charAt(i));
		}
		for (i=0; i<stack.MAX; i++) {
			inverted_string += stack.pop() ;
		}
		return inverted_string;
	}
	
	public static boolean isPalindrome(String string) {
		String inverted_string = invert(string);
		int i;
		for (i=0; i<string.length(); i++) {
			if (string.charAt(i) != inverted_string.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
