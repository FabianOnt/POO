package Menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxQ3 implements ItemListener{
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		Window.description.setText("Select an option.");
		
		Window.clearTextFields();
		Window.hideTextFields();
		Window.hideLabels();
		Window.box3A.setVisible(false);

		switch(Window.box3.getSelectedIndex()) {
			case 0 -> {
				Window.description.setText("Select an option.");
				
				Window.saveQ3.setVisible(false);
			}
			case 1 -> {
				Window.description.setText("Execute to check the full schedule.");
				
				Window.saveQ3.setVisible(true);
				Querry3.querrymode = 1;
			}
			case 2 -> {
				Window.description.setText("Select a searching criteria.");
				
				Window.box3A.setVisible(true);
				Window.saveQ3.setVisible(true);
			}
			case 3 -> {
				Window.description.setText("Fill the next form to ADD a new entry to the schedule and execute.");
				
				Window.label1.setText("Course Key");
				Window.label2.setText("Section");
				Window.label3.setText("Weekday");
				Window.label4.setText("Hour");
				Window.label5.setText("Minute");
				Window.label6.setText("Duration (min)");
				Window.label7.setText("Period");
				Window.label8.setText("Semester");
				Window.label9.setText("RoomID");		
				Window.label10.setText("Professor");
				
				Window.text1.setVisible(true);
				Window.text2.setVisible(true);
				Window.text3.setVisible(true);
				Window.text4.setVisible(true);
				Window.text5.setVisible(true);
				
				Window.text6.setVisible(true);
				Window.text7.setVisible(true);
				Window.text8.setVisible(true);
				Window.text9.setVisible(true);
				Window.text10.setVisible(true);
				
				Window.label1.setVisible(true);
				Window.label2.setVisible(true);
				Window.label3.setVisible(true);
				Window.label4.setVisible(true);
				Window.label5.setVisible(true);
				
				Window.label6.setVisible(true);
				Window.label7.setVisible(true);
				Window.label8.setVisible(true);
				Window.label9.setVisible(true);
				Window.label10.setVisible(true);
				
				Window.saveQ3.setVisible(true);
				// complete jsdjdjsidjk
				
				Querry3.querrymode = 6;
			}
			case 4 -> {
				
				Window.description.setText("Fill the next form to MODIFY a programmed schedule and execute.");
				
				Window.label1.setText("Course Key");
				Window.label2.setText("Section");
				Window.label3.setText("Weekday");
				Window.label4.setText("Hour");
				Window.label5.setText("Minute");
				
				Window.label6.setText("Duration (min)");
				Window.label7.setText("Period");
				Window.label8.setText("Semester");
				Window.label9.setText("RoomID");		
				Window.label10.setText("Professor");
				
				Window.text1.setVisible(true);
				Window.text2.setVisible(true);
				Window.text3.setVisible(true);
				Window.text4.setVisible(true);
				Window.text5.setVisible(true);
				
				Window.text6.setVisible(true);
				Window.text7.setVisible(true);
				Window.text8.setVisible(true);
				Window.text9.setVisible(true);
				Window.text10.setVisible(true);
				
				Window.label1.setVisible(true);
				Window.label2.setVisible(true);
				Window.label3.setVisible(true);
				Window.label4.setVisible(true);
				Window.label5.setVisible(true);
				
				Window.label6.setVisible(true);
				Window.label7.setVisible(true);
				Window.label8.setVisible(true);
				Window.label9.setVisible(true);
				Window.label10.setVisible(true);
				
				Window.saveQ3.setVisible(true);
				// complete jsdjdjsidjk
				
				Querry3.querrymode = 7;
				
				
			}
			case 5 -> {
				Window.description.setText("Fill the next form to DELETE a programmed schedule and execute.");

				Window.label1.setText("Course Key");
				Window.label2.setText("Section");
				Window.label3.setText("Weekday");
				Window.label4.setText("Professor");
												
				Window.text1.setVisible(true);
				Window.text2.setVisible(true);
				Window.text3.setVisible(true);
				Window.text4.setVisible(true);
				
				Window.label1.setVisible(true);
				Window.label2.setVisible(true);
				Window.label3.setVisible(true);
				Window.label4.setVisible(true);
				
				// if all correct...
												
				Window.saveQ3.setVisible(true);
				
				Querry3.querrymode = 8;
			}
		}
		
	}
}
