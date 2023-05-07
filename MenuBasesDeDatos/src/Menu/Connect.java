package Menu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Connect implements MouseListener{
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (!Window.online) {
			// try to connect to DBMS
				Window.notification.print("Connection stablished.", Color.green);
				Window.online = true;
					
			//Catch connection error
			//	Window.notification.print("An error has occurred.", Color.red);
		} else {
			Window.notification.print("The system is already connected.", Color.red);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		Window.connect.setBackground(Color.DARK_GRAY);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Window.connect.setBackground(Color.black);
		
	}

}
