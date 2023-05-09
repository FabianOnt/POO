package Menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxQ2 implements ItemListener{
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Window.description.setText("Select an option");
		
		Window.hideLabels();
		Window.clearTextFields();
		Window.hideTextFields();
		
		Window.saveQ2.setVisible(true);
				
		Window.box2A.setVisible(false);
		Window.box2B.setVisible(false);
		
		switch(Window.box2.getSelectedIndex()) {
			case 0 -> {
				Window.description.setText("Select an option");
			}
			case 1 -> {
				Window.description.setText("Execute to check all rooms.");
				
				Querry2.querrymode = 1;
			}
			case 2 -> {
				Window.description.setText("Enter the date in the format (YYYY-MM-DD HH:MM) and execute.");
				Window.label1.setText("Date");
				
				Window.label1.setVisible(true);
				Window.text1.setVisible(true);
				Querry2.querrymode = 2;
			}
			case 3 -> {
				Window.description.setText("Choose between creating a one time reservation or a recurrent one. ");
				
				Window.box2A.setVisible(true);
			}
			case 4 -> {
				Window.description.setText("Choose between cancelling a particular reservation or all the reservations between two dates. ");
				
				Window.box2B.setVisible(true);
			}
		}
	}

}
