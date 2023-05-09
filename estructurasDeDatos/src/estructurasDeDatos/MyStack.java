package estructurasDeDatos;

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
