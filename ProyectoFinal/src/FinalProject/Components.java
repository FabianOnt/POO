package FinalProject;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Components implements ActionListener , MouseListener , ChangeListener {
	
	JPanel mainPanel;
	Canvas canvas;
	Color actionButtonColor = Color.lightGray;
	Color backgroundColor = new Color(84, 83, 85);
	FixedCanvas currentColor;
	static JTextField textField;
	static Color barColor = new Color(46, 43, 41);
	static JLabel red, green, blue;
	static ColorSlider Red, Green, Blue;
	
	public Components(int width, int height) {
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(backgroundColor);
		mainPanel.setBounds(0, 0, width, height);
	}
	
	public void addCanvas(int x, int y, int width, int height) {
		canvas = new Canvas(width, height);
		canvas.setBounds(x, y, width, height);
		mainPanel.add(canvas);
	}
	
	public void addRectangle(int x, int y, int width, int height, Color color) {
		FixedCanvas rect = new FixedCanvas(width, height, color);
		rect.setBounds(x, y, width, height);
		rect.setBackground(color);
		mainPanel.add(rect);
	}
	
	public void addCurrentColor(int x, int y, int width, int height, Color color) {
		currentColor = new FixedCanvas(width, height, color);
		currentColor.setBounds(x, y, width, height);
		currentColor.setBackground(color);
		mainPanel.add(currentColor);
	}
	
	public void addColorButton(int x, int y, int width, int height, Color color, String name) {
		ColorButton b = new ColorButton(color, currentColor);
		b.setName(name);
		b.setBounds(x, y, width, height);
		b.setBackground(color);
		b.setBorderPainted(false);
		mainPanel.add(b);
	}
	
	public void addSaveButton(int x, int y, int width, int height) {
		SaveButton b = new SaveButton("Guardar imagen", canvas);
		b.setBounds(x, y, width, height);
		b.setBackground(actionButtonColor);
		b.setBorderPainted(false);
		b.addActionListener(this);
		mainPanel.add(b);
	}
	
	public void addOpenButton(int x, int y, int width, int height) {
		OpenButton b = new OpenButton("Abrir imagen", canvas);
		b.setBounds(x, y, width, height);
		b.setBackground(actionButtonColor);
		b.setBorderPainted(false);
		b.addActionListener(this);
		mainPanel.add(b);
	}
	
	public void addNewButton(int x, int y, int width, int height) {
		NewButton b = new NewButton("Nuevo Dibujo", canvas);
		b.setBounds(x, y, width, height);
		b.setBackground(actionButtonColor);
		b.setBorderPainted(false);
		b.addActionListener(this);
		mainPanel.add(b);
	}
	
	public void addClearButton(int x, int y, int width, int height) {
		ClearButton b = new ClearButton("Borrar dibujo", canvas);
		b.setBounds(x, y, width, height);
		b.setBackground(actionButtonColor);
		b.setBorderPainted(false);
		b.addActionListener(this);
		mainPanel.add(b);
	}
	
	public void addTextField(int x, int y, int width, int height) {
		textField = new JTextField(MyWindow.projectName);
		textField.setBounds(x, y, width, height);
		textField.setBackground(actionButtonColor);
		textField.addActionListener(this);
		textField.setFont(new Font("Gotham", Font.BOLD, 20));
		mainPanel.add(textField);
		
	}
	
	public void addRed(int x, int y, int width, int height, int min, int max) {
		Red = new ColorSlider(min, max);
		Red.setBounds(x, y, width, height);
		Red.setBackground(barColor);
		Red.addChangeListener(this);
		mainPanel.add(Red);
		red = new JLabel();
		red.setBounds(x+(int)(width*1.05),y,width,height);
		red.setForeground(Color.red);
		red.setFont(new Font("Gotham", Font.BOLD, 20));
		mainPanel.add(red);		
	}
	
	public void addGreen(int x, int y, int width, int height, int min, int max) {
		Green = new ColorSlider(min, max);
		Green.setBounds(x, y, width, height);
		Green.setBackground(barColor);
		Green.addChangeListener(this);
		mainPanel.add(Green);
		green = new JLabel();
		green.setBounds(x+(int)(width*1.05),y,width,height);
		green.setForeground(Color.green);
		green.setFont(new Font("Gotham", Font.BOLD, 20));
		mainPanel.add(green);
	
	}
	
	public void addBlue(int x, int y, int width, int height, int min, int max) {
		Blue = new ColorSlider(min, max);
		Blue.setBounds(x, y, width, height);
		Blue.setBackground(barColor);
		Blue.addChangeListener(this);
		mainPanel.add(Blue);
		blue = new JLabel();
		blue.setBounds(x+(int)(width*1.05),y,width,height);
		blue.setForeground(Color.blue);
		blue.setFont(new Font("Gotham", Font.BOLD, 20));
		mainPanel.add(blue);
				
	}
	
	 public void BeginColors() {
		Red.setValue(0);
		Green.setValue(0);
		Blue.setValue(0);
	}
	

	public void stateChanged(ChangeEvent e) {
		red.setText(""+Red.getValue());
		green.setText(""+Green.getValue());
		blue.setText(""+Blue.getValue());
		MyWindow.selectedColor = new Color(Red.getValue(), Green.getValue(), Blue.getValue());
		currentColor.fillColor(MyWindow.selectedColor);
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
