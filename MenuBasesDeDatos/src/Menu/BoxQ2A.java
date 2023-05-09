package Menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxQ2A implements ItemListener{
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Window.description.setText("Choose between creating a one time reservation or a recurrent one. ");		
		
		Window.hideLabels();
		Window.clearTextFields();
		Window.hideTextFields();
		
		switch(Window.box2A.getSelectedIndex()) {
			case 0 -> {}
			case 1 -> {
				Window.description.setText("<html>Enter a Professor's Name, the RoomID and Duration for the reservation.<br/>"
											+ "Enter the date of the reservation in the format (YYYY-MM-DD HH:MM) and execute.<html>");	
				
				Window.label1.setText("Name");
				Window.label2.setText("RommID");
				Window.label3.setText("Duration (min)");
				Window.label4.setText("Date");
				
				Window.text1.setVisible(true);
				Window.text2.setVisible(true);
				Window.text3.setVisible(true);
				Window.text4.setVisible(true);
				
				Window.label1.setVisible(true);
				Window.label2.setVisible(true);
				Window.label3.setVisible(true);
				Window.label4.setVisible(true);
				
				Querry2.querrymode = 3;
			}
			case 2 -> {
				Window.description.setText("<html>Enter a Professor's Name, the RoomID and Duration (in munutes) for the reservation.<br/>"
										+ "Enter the Period (e.g SPRING-22, AUTUMN-23), Weekday (integer), Hour and Minute of the reservation and execute.<html>");
				
				Window.label1.setText("Name");
				Window.label2.setText("RommID");
				Window.label3.setText("Duration (min)");
				Window.label4.setText("Period");
				Window.label5.setText("Weekday");
				
				Window.label6.setText("Hour");
				Window.label7.setText("Minute");
				
				Window.text1.setVisible(true);
				Window.text2.setVisible(true);
				Window.text3.setVisible(true);
				Window.text4.setVisible(true);
				Window.text5.setVisible(true);
				
				Window.text6.setVisible(true);
				Window.text7.setVisible(true);
				
				Window.label1.setVisible(true);
				Window.label2.setVisible(true);
				Window.label3.setVisible(true);
				Window.label4.setVisible(true);
				Window.label5.setVisible(true);
				
				Window.label6.setVisible(true);
				Window.label7.setVisible(true);
				
				Querry2.querrymode = 4;
			}
		}
	}

}
