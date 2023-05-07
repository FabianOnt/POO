package Menu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SaveQ3 implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		String sql = "";
		
		if (true) { // validation condition
			Window.hideContent();
			
			Window.notification.print("Querry "+Window.querryCounter+" executed.", Color.green);
			Window.querryCounter++;
			
			Window.headline.setText("Result");
			Window.description.setText(sql); // Execute Querry
			
		} else {
			Window.notification.print("Enter valid parameters.", Color.red);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
