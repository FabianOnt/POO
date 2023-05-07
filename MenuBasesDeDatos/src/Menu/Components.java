package Menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Components {

	public static JButton addPanelButton(int x, int y, int width, int height, String title) {
		JButton button = new JButton(title);
		button.setBounds(x, y, width, height);
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setFont(new Font("Gotham", Font.BOLD, 20));
		button.setBorderPainted(false);
		
		return button;
	}
	
	public static JButton addContentButton(int x, int y, int width, int height, String title) {
		JButton button = new JButton(title);
		button.setBounds(x, y, width, height);
		button.setBackground(Color.white);
		button.setForeground(Color.black);
		button.setFont(new Font("Gotham", Font.BOLD, 20));
		button.setBorderPainted(false);
		
		return button;
	}
	
	public static JLabel addTitle(int x, int y, int width, int height, String title) {
		JLabel label = new JLabel(title);
		label.setBounds(x, y, width, height);
		label.setForeground(Color.white);
		label.setFont(new Font("Gotham", Font.BOLD, 50));
		
		return label;
	}
	
	public static JLabel addText(int x, int y, int width, int height, String text) {
		JLabel label= new JLabel(text);
		label.setBounds(x, y, width, height);
		label.setForeground(Color.white);
		label.setFont(new Font("Gotham", Font.PLAIN, 20));
		
		return label;
	}
	
	public static SolidRectangle addRectangle(int x, int y, int width, int height, Color color) {
		SolidRectangle rect = new SolidRectangle(width,height,color);
		rect.setBounds(x,y,width,height);
		
		return rect;
	}
	
	public static JComboBox<String> addBox(int x, int y, int width, int height, String[] items) {
		JComboBox<String> box = new JComboBox<String>();
		for (int i=0; i<items.length; i++) {
			box.addItem(items[i]);
		}
		box.setBounds(x, y, width, height);
		box.setForeground(Color.black);
		box.setBackground(Color.white);

		return box;
	}
	
	public static JTextField addTextField(int x, int y, int width, int height) {
		JTextField txt = new JTextField();
		txt.setBounds(x, y, width, height);
		txt.setBackground(Color.white);
		txt.setForeground(Color.black);
		return txt;
	}
	

}
