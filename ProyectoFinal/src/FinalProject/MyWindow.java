package FinalProject;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MyWindow extends JFrame implements ActionListener, MouseListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	int width;
	int height;
	int x;
	int y;
	static int workCounter=0;
	Components components; 
	static Color selectedColor;
	static String projectName = "Project" + Integer.toString(workCounter);
	
	Color[] colors= {Color.WHITE, Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.BLUE, Color.BLACK, Color.RED, Color.PINK, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.CYAN};
	
	public MyWindow(int width, int height) {
		this.width = width;
		this.height = height;
		
		components = new Components(width, height);
		insert();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(width,height);							
		setLocationRelativeTo(null);					
		setLayout(null);								
		setResizable(false);							
		setVisible(true);								
	}
	
	public void insert() {

		int x0 = 4*(width-width*8/15)/5;
		int y0 = (height-height*17/20)/2;
		
		components.addCanvas(x0, y0,(int)(width*8/15),(int)(width*64/150));	
		
		components.addNewButton(x0, 0, 150, (int)(y0*0.4));
		components.addOpenButton(x0+(int)width*8/(4*15), 0, 150, (int)(y0*0.4));
		components.addClearButton(x0+(int)width*8*2/(4*15), 0, 150, (int)(y0*0.4));
		components.addSaveButton(x0+(int)width*8*3/(4*15), 0, 150, (int)(y0*0.4));
		
		components.addCurrentColor((int)(width*0.2*0.35), (int)(height*0.15), (int)(width*0.2*0.4), (int)(width*0.2*0.4), Color.black);
		
		components.addTextField((int)(width*0.05),0,(int)(width*0.15),30);
		
		int c=0;
		for(int a = 60; a < 270; a = a + 60) {
			for(int b = 300; b < 450; b = b + 60) {
				components.addColorButton((int)(width*a/1500), (int)(height*b/800), 30, 30, colors[c], "");
				c++;
			}
		}
		
		components.addRed(10, (int)(height*0.7), (int)(width*0.2), 35, 0, 255);
		components.addGreen(10, (int)(height*0.75), (int)(width*0.2), 35, 0, 255);
		components.addBlue(10, (int)(height*0.8), (int)(width*0.2), 35, 0, 255);
		
		components.BeginColors();
		
		components.addRectangle(0, 0, (int)(width*0.25), height, Components.barColor);
		components.addRectangle(0, 0, width, (int)(y0*0.65), Components.barColor);

		add(components.mainPanel);
	}
	
	
	public void mouseClicked(MouseEvent e) {}
	
	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void stateChanged(ChangeEvent e) {}

	public void actionPerformed(ActionEvent e) {}
}
