package FinalProject;

import java.awt.Color;
import java.awt.event.MouseEvent;

public class ClearButton extends Buttons{

	Canvas canvas; 
	
	public ClearButton(String name, Canvas canvas) {
		super(name);
		this.canvas = canvas;
	}
	
	public void mouseClicked(MouseEvent e){
		canvas.drawBackground(canvas.PIXEL_SIZE, Color.white);
		canvas.drawSquareGrid(canvas.PIXEL_SIZE, Color.black);
	}
}
