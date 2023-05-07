package Menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxQ3 implements ItemListener{
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		Window.label1.setText("Select an option.");
		Window.label1.setVisible(true);
		
		Window.text1.setVisible(false);
		Window.text2.setVisible(false);
		Window.text3.setVisible(false);
		Window.text4.setVisible(false);
		Window.text5.setVisible(false);
		Window.text6.setVisible(false);
		Window.text7.setVisible(false);
		Window.text8.setVisible(false);
		Window.text9.setVisible(false);
		

		switch(Window.box3.getSelectedIndex()) {
			case 0 -> {
				Window.label1.setText("Select an option.");
				Window.label1.setVisible(true);
			}
			case 1 -> {
				Window.label1.setText("Select an option.");
				Querry3.querrymode = 1;
				Window.label1.setVisible(true);
			}
			case 2 -> {
				Window.label1.setText("Select an option.");
				Window.label1.setVisible(true);
				Window.box3A.setVisible(true);
			}
			case 3 -> {
				Window.label1.setText("Fill the next form.");
				
				Window.text1.setVisible(true);
				Window.text2.setVisible(true);
				Window.text3.setVisible(true);
				Window.text4.setVisible(true);
				Window.text5.setVisible(true);
				Window.text6.setVisible(true);
				Window.text7.setVisible(true);
				Window.text8.setVisible(true);
				Window.text9.setVisible(true);
				
				// complete jsdjdjsidjk
				
				Window.label1.setVisible(true);
				Querry3.querrymode = 6;
			}
			case 4 -> {
				// not completed
				
			}
			case 5 -> {
				Window.label1.setText("Enter the COURSE KEY, SECTION and WEEKDAY of the element to modify.");
								
				Window.text1.setVisible(true);
				Window.text2.setVisible(true);
				Window.text3.setVisible(true);
				Window.text4.setVisible(true);
				
				// if all correct...
								
				Window.label2.setText("Enter the name of the professor how is in charge of the course and execute.");
				
				Window.label1.setVisible(true);
				Window.label2.setVisible(true);
				Window.text5.setVisible(true);
			}
		}
		
	}
}
