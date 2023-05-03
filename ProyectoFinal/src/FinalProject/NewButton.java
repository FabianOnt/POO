package FinalProject;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class NewButton extends Buttons{

	Canvas canvas;
	BufferedImage img;
	String name;
	
	public NewButton(String name, Canvas canvas) {
		super(name);
		this.canvas = canvas;
	}
	
	public void mouseClicked(MouseEvent e){
		MyWindow.projectName = Components.textField.getText();
		canvas.saveCanvas(MyWindow.projectName);
		if (MyWindow.projectName.equals("Project" + Integer.toString(MyWindow.workCounter))) {
			MyWindow.workCounter ++;
		}
		Components.textField.setText("Project"+Integer.toString(MyWindow.workCounter));;
	
		canvas.drawBackground(canvas.PIXEL_SIZE, Color.white);
		canvas.drawSquareGrid(canvas.PIXEL_SIZE, Color.black);
	}
}
