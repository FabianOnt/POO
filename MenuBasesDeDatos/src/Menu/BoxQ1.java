package Menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxQ1 implements ItemListener{
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Window.label1.setVisible(true);

		switch(Window.box1.getSelectedIndex()) {
			case 0 -> {
				Window.label1.setText("Select an option.");
				Window.text1.setVisible(false);
			}
			case 1 -> {
				Window.label1.setText("Execute to search all rooms.");
				Window.text1.setVisible(false);
				Querry1.querrymode = 1;
			}
			case 2 -> {
				Window.label1.setText("Enter the capacity minimum capacity required and execute.");
				Window.text1.setVisible(true);
				Querry1.querrymode = 2;
			}
			case 3 -> {
				Window.label1.setText("Enter the room type and execute.");
				Window.text1.setVisible(true);
				Querry1.querrymode = 3;
			}
			case 4 -> {
				Window.label1.setText("Enter the room id and execute.");
				Window.text1.setVisible(true);
				Querry1.querrymode = 4;
			}
		}
		
	}

}
