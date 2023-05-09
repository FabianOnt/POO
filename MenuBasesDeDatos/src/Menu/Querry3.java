package Menu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Querry3 implements MouseListener{

	static int querrymode = 0;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Window.hideContent();
		
		Window.headline.setText("Schedules menu");
		Window.description.setText("<html>In this section, you can access and modify to the data related to shcedules. <br/> Select an option from the box above to permform an action.</html>");
		
		Window.label1.setBounds(400, 360, 180, 30);
		Window.label2.setBounds(600, 360, 180, 30);
		Window.label3.setBounds(800, 360, 180, 30);
		Window.label4.setBounds(1000, 360, 180, 30);
		Window.label5.setBounds(1200, 360, 180, 30);
		
		Window.label6.setBounds(400, 460, 180, 30);
		Window.label7.setBounds(600, 460, 180, 30);
		Window.label8.setBounds(800, 460, 180, 30);
		Window.label9.setBounds(1000, 460, 180, 30);
		Window.label10.setBounds(1200, 460, 180, 30);
		
		Window.text1.setBounds(400, 400, 180, 30);
		Window.text2.setBounds(600, 400, 180, 30);
		Window.text3.setBounds(800, 400, 180, 30);
		Window.text4.setBounds(1000, 400, 180, 30);
		Window.text5.setBounds(1200, 400, 180, 30);
		
		Window.text6.setBounds(400, 500, 180, 30);
		Window.text7.setBounds(600, 500, 180, 30);
		Window.text8.setBounds(800, 500, 180, 30);
		Window.text9.setBounds(1000, 500, 180, 30);
		Window.text10.setBounds(1200,500,180,30);
		
		Window.box3.setBounds(400, 300, 300, 30);
		Window.box3A.setBounds(710, 300, 300, 30);

		Window.box3.setVisible(true);
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