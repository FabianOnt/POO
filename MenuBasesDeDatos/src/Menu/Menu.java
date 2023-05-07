package Menu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		Window.hideContent();
		Window.setMenuDefault();

		Window.headline.setVisible(true);
		Window.description.setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		Window.menu.setBackground(Color.DARK_GRAY);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Window.menu.setBackground(Color.black);
	}

}