package Menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxQ2B implements ItemListener{
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Window.label1.setText("Add the RoomID and Name for the reservation.");		
		Window.label2.setVisible(false);
		
		Window.text2.setVisible(true);
		Window.text3.setVisible(true);
		
		Window.text5.setVisible(false);
		Window.text6.setVisible(false);
		
		switch(Window.box2B.getSelectedIndex()) {
			case 0 ->{
				Window.label1.setText("Add the RoomID and Name for the reservation.");
				Window.label2.setVisible(false);
				Window.text5.setVisible(false);
				Window.text6.setVisible(false);
			}
			case 1 ->{
				Window.label2.setText("Enter the date in the format (YYYY-MM-DD HH:MM) and execute.");
				Window.label2.setVisible(true);
				Window.text5.setVisible(true);
				Querry2.querrymode = 5;
			}
			case 2 ->{
				Window.label2.setText("Enter the INITIAL and FINAL date in the format (YYYY-MM-DD HH:MM) and execute.");
				Window.label2.setVisible(true);
				Window.text5.setVisible(true);
				Window.text6.setVisible(true);
				Querry2.querrymode = 6;
			}
		
		}
	}
}
