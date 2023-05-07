package Menu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Querry3 implements MouseListener{

	static int querrymode = 0;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Window.hideContent();
		
		Window.headline.setText("Querry3");
		Window.description.setText("Add description for querry 3");
		
		Window.text1.setBounds(710, 400, 180, 30);
		Window.text2.setBounds(910, 400, 180, 30);
		Window.text3.setBounds(1110, 400, 180, 30);
		Window.text4.setBounds(1310, 400, 180, 30);
		
		Window.text5.setBounds(400, 600, 180, 30);
		Window.text6.setBounds(600, 600, 180, 30);
		Window.text7.setBounds(800, 600, 180, 30);
		Window.text8.setBounds(1000, 600, 180, 30);
		Window.text9.setBounds(1200, 600, 180, 30);
		
		Window.box3.setVisible(true);
		Window.saveQ3.setVisible(true);
		Window.headline.setVisible(true);
		Window.description.setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		Window.querry3.setBackground(Color.DARK_GRAY);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Window.querry3.setBackground(Color.black);
	}

}