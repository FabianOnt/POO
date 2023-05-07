package Menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Notification extends JLabel{
	
	public Notification(int x, int y, int width, int height) {
		setBounds(x, y, width, height);
	}
	
	public void print(String text, Color color) {
		setText(text);
		setForeground(color);
		setFont(new Font("Gotham", Font.PLAIN, 20));
	}
	
	public void reset() {
		setText("");
	}

}
