package Menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxQ1 implements ItemListener{
	
	@Override
	public void itemStateChanged(ItemEvent e) {

		Window.clearTextFields();
		Window.label1.setVisible(false);
		Window.text1.setVisible(false);

		switch(Window.box1.getSelectedIndex()) {
			case 0 -> {
				Window.headline.setText("Room Search Menu");
				Window.description.setText("<html>In this section, you can access to the data related to ROOMS. <br/> "
						+ "Select an option from the box above to permform an action.</html>");
			}
			case 1 -> {
				Window.headline.setText("Search All Rooms");
				Window.description.setText("Execute to search all rooms in the DB.");
				
				Window.saveQ1.setVisible(true);

				Querry1.querrymode = 1;
			}
			case 2 -> {
				Window.headline.setText("Search by Minimum Capacity");
				Window.description.setText("Enter the minimum capacity required and execute.");
				Window.label1.setText("Minimum Capacity");
				
				Window.label1.setVisible(true);
				Window.text1.setVisible(true);
				Window.saveQ1.setVisible(true);

				Querry1.querrymode = 2;
			}
			case 3 -> {
				Window.headline.setText("Search by Room Type");
				Window.description.setText("Enter the room type and execute.");
				Window.label1.setText("Room Type");
				
				Window.label1.setVisible(true);
				Window.text1.setVisible(true);
				Window.saveQ1.setVisible(true);

				Querry1.querrymode = 3;
			}
			case 4 -> {
				Window.headline.setText("Search by RoomID");
				Window.description.setText("Enter the roomID and execute.");
				Window.label1.setText("RoomID");
				
				Window.label1.setVisible(true);
				Window.text1.setVisible(true);
				Window.saveQ1.setVisible(true);

				Querry1.querrymode = 4;
			}
		}
		
	}

}
