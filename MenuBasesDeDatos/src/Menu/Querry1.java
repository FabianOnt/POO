package Menu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Querry1 implements MouseListener{

	static int querrymode = 0;
	
	@Override
	public void mouseClicked(MouseEvent e) {
				
		Window.clearTextFields();
		Window.hideContent();
		
		Window.headline.setText("Room Search Menu");
		Window.description.setText("<html>In this section, you can access to the data related to ROOMS. <br/> "
									+ "Select an option from the box above to permform an action.</html>");
		
		Window.label1.setBounds(400, 360, 180, 30);
		Window.text1.setBounds(400, 400, 180, 30);
		
		Window.box1.setBounds(400, 300, 300, 30);
		
		Window.box1.setVisible(true);
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
