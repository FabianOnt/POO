package Menu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Querry1 implements MouseListener{

	static int querrymode = 0;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		Window.hideContent();
		
		Window.headline.setText("Querry 1");
		Window.description.setText("Instructions for Querry 1...");
		Window.label1.setText("Select an option");
		
		Window.label1.setBounds(400, 350, 800, 30);
		Window.text1.setBounds(620, 400, 200, 30);
		
		Window.headline.setVisible(true);
		Window.description.setVisible(true);
		Window.box1.setVisible(true);
		Window.saveQ1.setVisible(true);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		Window.querry1.setBackground(Color.DARK_GRAY);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Window.querry1.setBackground(Color.black);
	}

}
