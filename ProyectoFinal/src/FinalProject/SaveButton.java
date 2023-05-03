package FinalProject;

import java.awt.event.MouseEvent;

public class SaveButton extends Buttons{
	
	Canvas canvas;
	
	public SaveButton(String name, Canvas canvas) {
		super(name);
		this.canvas = canvas;
	}
	
	public void mouseClicked(MouseEvent e){
		MyWindow.projectName = Components.textField.getText();
		canvas.saveCanvas(MyWindow.projectName);
		if (MyWindow.projectName.equals("Project" + Integer.toString(MyWindow.workCounter))) {
			MyWindow.workCounter ++;
		}
		Components.textField.setText("Project"+Integer.toString(MyWindow.workCounter));
	}
}

