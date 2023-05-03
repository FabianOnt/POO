package FinalProject;

import java.awt.Color;
import java.awt.event.MouseEvent;

public class ColorButton extends Buttons{
	
	FixedCanvas canvas;
	
	public ColorButton(Color color, FixedCanvas canvas) {
		super(color);
		this.canvas = canvas;
	}

	public void mouseClicked(MouseEvent e) {
		MyWindow.selectedColor = color;
		Components.Red.setValue(color.getRed());
		Components.Green.setValue(color.getGreen());
		Components.Blue.setValue(color.getBlue());
		canvas.fillColor(color);
	}
}
