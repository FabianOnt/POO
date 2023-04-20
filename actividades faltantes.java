// *********************** ACTIVIDAD 2:CÍRUCLO-CUADRADO *********************************

public class Cuadrado {
	
	public double longitud;
	public double diagonal;
	public double area;
	public double perimetro;
	
	public Cuadrado() {
		this.longitud = 173428;
		this.calculaArea();
		this.calculaDiagonal();
		this.calculaPerimetro();
	}	
	
	public void modificaLongitud(int nuevaLongitud) {
		this.longitud = nuevaLongitud;
	}
	
	public void calculaArea() {
		this.area = this.longitud * this.longitud;
	}
	
	public void calculaPerimetro() {
		this.perimetro = 4*this.longitud;
	}
	
	public void calculaDiagonal() {
		this.diagonal = this.longitud*Math.sqrt(2);
	}
}


public class Circulo {
	
	public double radio;
	public double area;
	public double circunferencia;
	
	public Circulo() {
		this.radio = 173428;
		this.calculaArea();
		this.calculaCircunferencia();		
	}

	public void calculaArea() {
		this.area = Math.PI*this.radio*this.radio;
	}
	
	public void calculaCircunferencia() {
		this.circunferencia = 2*Math.PI*this.radio;
	}
	}
}


// *********************** ACTIVIDAD 3:THIS *********************************


public class Cuadrado {
	
	public double longitud;
	public double diagonal;
	public double area;
	public double perimetro;
	
	public Cuadrado(double longitud) {
		this.longitud = longitud;
		this.calculaArea();
		this.calculaDiagonal();
		this.calculaPerimetro();
	}	
	
	public Cuadrado() {
		this(173428);
	}
	
	public void modificaLongitud(int nuevaLongitud) {
		this.longitud = nuevaLongitud;
	}
	
	public void calculaArea() {
		this.area = this.longitud * this.longitud;
	}
	
	public void calculaPerimetro() {
		this.perimetro = 4*this.longitud;
	}
	
	public void calculaDiagonal() {
		this.diagonal = this.longitud*Math.sqrt(2);
	}
}


public class Circulo {
	
	public double radio;
	public double area;
	public double circunferencia;
	
	public Circulo(double radio) {
		this.radio = radio;
		this.calculaArea();
		this.calculaCircunferencia();		
	}
	
	public Circulo() {
		this(173428);
	}
	
	public void calculaArea() {
		this.area = Math.PI*this.radio*this.radio;
	}
	
	public void calculaCircunferencia() {
		this.circunferencia = 2*Math.PI*this.radio;
	}
}

// *********************** ACTIVIDAD 5:FLOW CONTROL *********************************

public class Actividad {
	
	public static void main(String[] args) {
		
		int ans = 0;
		int mode;
		
		do {
			System.out.println("Menú principal:\nIngrese el número de la opción que desea ejecutar\n\n"
					+ "1. Si desea crear un cuadrado\n"
					+ "2. Si desea crear un círculo\n"
					+ "3. Si desea cerrar el programa\n\n"
					+ "Opción: ");
			
			mode = readInt();
			
			switch(mode) {
			
			case 1: // Cuadrado
				System.out.println("\nSe creará un cuadrado con la longitud de lado que usted ingrese\n"
						+ "Longitud de lado: ");
				
				double lado = readDou();
				Cuadrado cuadrado = new Cuadrado(lado);
				
				do {
					System.out.println("\nIngrese el número de la opción que desea ejecutar\n\n"
							+ "1. Calcular perímetro\n"
							+ "2. Calcular área\n"
							+ "3. Calcular diagonal\n"
							+ "4. Salir\n\n"
							+ "Opción: ");
					
					ans = readInt();
					
					switch (ans) {
					case 1: // Calcular perímetro
						cuadrado.calculaPerimetro();
						System.out.println("El perímetro del cuadrado es " + cuadrado.perimetro);						
						break;
					case 2: // Calcular área
						cuadrado.calculaArea();
						System.out.println("El área del cuadrado es " + cuadrado.area);
						break;
					case 3: // Calcular diagonal
						cuadrado.calculaDiagonal();
						System.out.println("La diagonal del cuadrado es " + cuadrado.diagonal);
						break;
					case 4: // Salir
						System.out.println("Volviendo a menú principal...\n");
						break;
					default: // Default
						System.out.println("Opción Invalida. Ingrese una opción vaálida.\n");
				}
					} while (ans != 4);					
				break;
					
			case 2: // Círculo
				System.out.println("\nSe creará un cículo con elradio que usted ingrese\n"
									+ "Radio: ");
					
				double radio = readDou();
				Circulo circulo = new Circulo(radio);
				
				do {
					System.out.println("\nIngrese el número de la opción que desea ejecutar\n\n"
							+ "1. Calcular circunferencia\n"
							+ "2. Calcular área\n"
							+ "3. Salir\n\n"
							+ "Opción: ");
					
					ans = readInt();
					
					switch (ans){
					
					case 1: // Calcular perímetro
						circulo.calculaCircunferencia();
						System.out.println("La circunferencia del círuclo es " + circulo.circunferencia);							
						break;
					case 2: // Calcular área
						circulo.calculaArea();
						System.out.println("El área del cuadrado es " + circulo.area);
						break;
					case 3: // Salir
						System.out.println("Volviendo a menú principal...\n");
						break;
					default: // Default
						System.out.println("Opción Invalida. Ingrese una opción vaálida.\n");
					}	
				} while (ans != 3);
				break;
					
				case 3:
					System.out.println("Cerrando programa...");
					break;
					
				default:
					System.out.println("Opción inválida. Ingrese una opción válida.");
					break;
			}	
		} while (mode != 3);
	}
	
	public static int readInt() {
		Scanner scan = new Scanner(System.in);
		int input;
		input = Integer.parseInt(scan.nextLine());
		scan.close();
		return input;
	}
	
	public static double readDou() {
		Scanner scan = new Scanner(System.in);
		double input;
		input = Double.parseDouble(scan.nextLine());
		scan.close();	
		return input;
	}
	
	public static String readString() {
		Scanner scan = new Scanner(System.in);
		String input;
		input = scan.nextLine();
		scan.close();
		return input;
	}
}

// *********************** ACTIVIDAD 8: QUEUE *********************************

	public char delete() {
		int i;
		char value;
		if (tail != 0) {
			value = queue[0];
			for (i=0; i<tail-1; i++) {
				queue[i] = queue[i+1];
			}
			tail --;
			return value;
		} else {
			System.out.println("Queue is empty");
			return '#';
		}
			
	}

// *********************** ACTIVIDAD 9: STACK & QUEUE *********************************

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


public class MyQueue {

	int MAX;
	int tail = 0;
	char queue[];
	
	MyQueue(int max){
		MAX = max;
		queue = new char[MAX];
	}
	
	public void push(char value){
		if (tail == MAX) {
			System.out.println("Queue is full");
		} else {
			queue[tail] = value;
			tail ++;			
		}
	}
	
	public char delete() {
		int i;
		char value;
		if (tail != 0) {
			value = queue[0];
			for (i=0; i<tail-1; i++) {
				queue[i] = queue[i+1];
			}
			tail --;
			return value;
		} else {
			System.out.println("Queue is empty");
			return '#';
		}
			
	}
	
}


public class MyStack {

	int MAX;
	char stack[];
	int top = 0;
	
	MyStack(int MAX){
		this.MAX = MAX;
		this.stack = new char[MAX];
	}
	
	public char pop() {
		if (top == 0) {
			System.out.println("Stack is empty");
			return '#';
		} else {
			top --;
			return stack[top];
		}
	}
	
	void push(char value) {
		if (top == MAX) {
			System.out.println("Stack is full");
		} else {
			stack[top] = value;
			top ++;			
		}
	}	
}


