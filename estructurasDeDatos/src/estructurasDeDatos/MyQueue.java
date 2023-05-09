package estructurasDeDatos;

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
