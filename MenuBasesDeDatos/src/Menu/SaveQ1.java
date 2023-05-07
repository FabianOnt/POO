package Menu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SaveQ1 implements MouseListener{

	static int querrymode = 0;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		String sql="";
		
		switch(Querry1.querrymode) {
			case 0 ->{
				sql = "";
			}
			case 1 ->{
				sql = "SELECT * FROM ROOMS";
			}
			case 2 -> {
				sql = "SELECT * FROM ROOMS WHERE CAPACITY ='" + Window.text1.getText() + "'";
			}
			case 3 -> {
				sql = "SELECT * FROM ROOMS WHERE R_TYPE = '" + Window.text1.getText() + "'";
			}
			case 4 -> {
				sql = "SELECT * FROM ROOMS WHERE ROOM_ID = '" + Window.text1.getText() + "'";
			}
		}
		
		if (Window.text1.getText() != null || Window.box1.getSelectedIndex() == 0) {
			Window.hideContent();
			
			Window.notification.print("Querry "+Window.querryCounter+" executed.", Color.green);
			Window.querryCounter++;
			
			Window.headline.setText("Result");
			Window.description.setText(sql); // Execute Querry	
			
			Window.headline.setVisible(true);
			Window.description.setVisible(true);
			
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
