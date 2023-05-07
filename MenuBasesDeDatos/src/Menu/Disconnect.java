package Menu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Disconnect implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (Window.online) {
			//try to disconnect from DBMS
				Window.notification.print("Connection terminated.", Color.green);
				Window.online = false;
					
			//Catch connection error
			//	Window.notification.setTet("An error has occurred.", Color.red);
		} else {
			Window.notification.print("The system is not connected yet.", Color.red);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		Window.disconnect.setBackground(Color.DARK_GRAY);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Window.disconnect.setBackground(Color.black);
	}

}