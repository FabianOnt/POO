package Menu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Querry2 implements MouseListener{

	static int querrymode = 0;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		Window.hideContent();
		
		Window.headline.setText("Querry 2");
		Window.description.setText("Instructions for Querry 2...");
		
		Window.label1.setText("Select an option");
				
		Window.label1.setBounds(400, 350, 800, 30);
		Window.label2.setBounds(400, 500, 800, 30);
		
		Window.text1.setBounds(650, 400, 180, 30);
		Window.text2.setBounds(850, 400, 180, 30);
		Window.text3.setBounds(1050, 400, 180, 30);
		Window.text4.setBounds(1250, 400, 180, 30);
		
		Window.text5.setBounds(400, 600, 180, 30);
		Window.text6.setBounds(600, 600, 180, 30);
		Window.text7.setBounds(800, 600, 180, 30);
		
		Window.headline.setVisible(true);
		Window.description.setVisible(true);
		Window.box2.setVisible(true);
		Window.saveQ2.setVisible(true);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		Window.querry2.setBackground(Color.DARK_GRAY);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Window.querry2.setBackground(Color.black);
	}

}
