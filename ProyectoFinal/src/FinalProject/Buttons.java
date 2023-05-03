package FinalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

public class Buttons extends JButton  implements MouseListener, MouseMotionListener{
	
	Color color = null;
	
	public Buttons(Color color) {
		addMouseListener(this);
		addMouseMotionListener(this);
		this.color = color;
	}
	
	public Buttons(String name) {
		this.setText(name);
		this.setForeground(Color.black);
		this.setFont(new Font("Arial", Font.BOLD, 13));
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
	
}
