package Menu;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SaveQ3 implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		String sql = "";
		
		switch(Querry3.querrymode) {
			case 0 ->{}
			case 1 -> {
				sql = "SELECT * FROM SCHEDULES";
			}
			case 2 -> {
				String weekday = Window.text1.getText();
				sql = "SELECT * FROM SCHEDULES WHERE WEEK_DAY ="+weekday;
			}
			case 3 ->{
				String period = Window.text1.getText();
				sql = "SELECT * FROM SCHEDULES WHERE PERIOD ="+period;
			}
			case 4 ->{
				String semester = Window.text1.getText();
				sql = "SELECT * FROM SCHEDULES WHERE SEMESTER ="+ semester;
			}
			case 5 ->{
				String room_id = Window.text1.getText();
				sql = "SELECT * FROM SCHEDULES WHERE ROOM_ID ="+room_id;
			}
			case 6->{
				String courseKey = Window.text1.getText();
				String section = Window.text2.getText();
				int weekday = Integer.parseInt(Window.text3.getText());
				int hour = Integer.parseInt(Window.text4.getText());
				int minute = Integer.parseInt(Window.text5.getText());
				int duration = Integer.parseInt(Window.text6.getText());
				String period= Window.text7.getText();
				String semester= Window.text8.getText();
				String roomID= Window.text9.getText();
				
				// falta profesor
				
			}
			case 7->{
				String course_key = Window.text1.getText();
				String section = Window.text2.getText();
				int weekday = Integer.parseInt(Window.text3.getText());
				
				int sch_hour = Integer.parseInt(Window.text4.getText());
				int sch_minute = Integer.parseInt(Window.text5.getText());
				int duration = Integer.parseInt(Window.text6.getText());
				String period = Window.text7.getText();
				String semester = Window.text8.getText();
				String room_id = Window.text9.getText();
				
				// falta profesor
			}
			case 8->{
				String course_key = Window.text1.getText();
				String section = Window.text2.getText();
				int weekday = Integer.parseInt(Window.text3.getText());
				
				String professor = Window.text5.getText();
			}
			
		
		}
		
		if (true) { // validation condition
			Window.hideContent();
			
			Window.notification.print("Querry "+Window.querryCounter+" executed.", Color.green);
			Window.querryCounter++;
			
			Window.headline.setText("Result");
			Window.description.setText(sql); // Execute Querry
			
		} else {
			Window.notification.print("Enter valid parameters.", Color.red);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
