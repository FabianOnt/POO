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
		
		Window.label1.setBounds(400, 360, 180, 30);
		Window.label2.setBounds(600, 360, 180, 30);
		Window.label3.setBounds(800, 360, 180, 30);
		Window.label4.setBounds(1000, 360, 180, 30);
		Window.label5.setBounds(1200, 360, 180, 30);
		
		Window.label6.setBounds(400, 460, 180, 30);
		Window.label7.setBounds(600, 460, 180, 30);

		
		Window.text1.setBounds(400, 400, 180, 30);
		Window.text2.setBounds(600, 400, 180, 30);
		Window.text3.setBounds(800, 400, 180, 30);
		Window.text4.setBounds(1000, 400, 180, 30);
		Window.text5.setBounds(1200, 400, 180, 30);
		
		Window.text6.setBounds(400, 500, 180, 30);
		Window.text7.setBounds(600, 500, 180, 30);

		Window.box2.setBounds(400, 300, 300, 30);
		Window.box2A.setBounds(710, 300, 300, 30);
		Window.box2B.setBounds(710, 300, 300, 30);
		
		Window.headline.setVisible(true);
		Window.description.setVisible(true);
		Window.box2.setVisible(true);		
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
