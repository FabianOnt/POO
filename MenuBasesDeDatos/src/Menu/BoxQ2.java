package Menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxQ2 implements ItemListener{
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Window.label1.setText("Select an option");
		Window.label1.setVisible(true);
		Window.label2.setVisible(false);
		
		Window.text1.setVisible(false);
		Window.text2.setVisible(false);
		Window.text3.setVisible(false);
		Window.text4.setVisible(false);
		
		Window.text5.setVisible(false);
		Window.text6.setVisible(false);
		Window.text7.setVisible(false);
		Window.text8.setVisible(false);
		
		Window.box2A.setVisible(false);
		Window.box2B.setVisible(false);
		
		switch(Window.box2.getSelectedIndex()) {
			case 0 -> {
				Window.label1.setText("Select an option");
			}
			case 1 -> {
				Window.label1.setText("Execute to check all rooms.");
				Querry2.querrymode = 1;
			}
			case 2 -> {
				Window.label1.setText("Enter the date in the format (YYYY-MM-DD HH:MM) and execute.");
				Window.text1.setVisible(true);
				Querry2.querrymode = 2;
			}
			case 3 -> {
				Window.label1.setText("Choose between made a one time reservation or a recurrent one ");
				Window.box2A.setVisible(true);
				System.out.println(Window.box1.getSelectedIndex());
			}
			case 4 -> {
				Window.label1.setText("Choose between CANCEL a particular reservation or all the reservations between two dates ");
				Window.box2B.setVisible(true);
			}
		}
	}

}
