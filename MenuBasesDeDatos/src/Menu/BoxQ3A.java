package Menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxQ3A implements ItemListener{
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Window.label1.setText("Select a searching criteria.");
		Window.text1.setVisible(false);
		
		switch(Window.box3A.getSelectedIndex()) {
			case 0 -> {
				Window.label1.setText("Select a searching criteria.");
				Window.text1.setVisible(false);
			}
			case 1 -> {
				Window.label1.setText("Enter the weekday you want to filter for (1=Monday, 7=Sunday) and execute ");
				Window.text2.setVisible(true);
				Querry3.querrymode = 2;
			}
			case 2 -> {
				Window.label1.setText("Enter the period you want to filter for (SPRING-22, AUTUMN-23, etc.) and execute ");
				Window.text2.setVisible(true);
				Querry3.querrymode = 3;
			}
			case 3 -> {
				Window.label1.setText("Enter the semester you want to filter for (1 - 10) and execute ");
				Window.text2.setVisible(true);
				Querry3.querrymode = 4;
			}
			case 4 -> {
				Window.label1.setText("Choose the RoomID you want to filter for (IA-203) and execute ");
				Window.text2.setVisible(true);
				Querry3.querrymode = 5;
			}
		}
	}

}
