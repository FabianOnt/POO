package Menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxQ3A implements ItemListener{
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Window.description.setText("Select a searching criteria.");
		
		Window.clearTextFields();
		Window.hideLabels();
		
		switch(Window.box3A.getSelectedIndex()) {
			case 0 -> {
				Window.description.setText("Select a searching criteria.");
			}
			case 1 -> {
				Window.description.setText("Enter the number of weekday you want to filter for (e.g. 1=Monday, 7=Sunday, etc.) and execute.");
				Window.label1.setText("Weekday");
				
				Window.label1.setVisible(true);
				Window.text1.setVisible(true);
				Querry3.querrymode = 2;
			}
			case 2 -> {
				Window.description.setText("Enter the period you want to filter for (e.g. SPRING-22, AUTUMN-23, etc.) and execute.");
				Window.label1.setText("Period");
				
				Window.label1.setVisible(true);
				Window.text1.setVisible(true);
				Querry3.querrymode = 3;
			}
			case 3 -> {
				Window.description.setText("Enter the semester you want to filter for (1 - 10) and execute.");
				Window.label1.setText("Semester");
				
				Window.label1.setVisible(true);
				Window.text1.setVisible(true);
				Querry3.querrymode = 4;
			}
			case 4 -> {
				Window.description.setText("Choose the RoomID you want to filter for (e.g. IA-203) and execute.");
				Window.label1.setText("RoomID");
				
				Window.label1.setVisible(true);
				Window.text1.setVisible(true);
				Querry3.querrymode = 5;
			}
		}
	}

}
