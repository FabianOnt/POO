package FinalProject;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OpenButton extends Buttons{

	BufferedImage img;
	String name;
	Canvas canvas;
	
	
	public OpenButton(String name, Canvas canvas) {
		super(name);
		this.canvas = canvas;
	}
	
	public void mouseClicked(MouseEvent e){
		name = Components.textField.getText();
		try {
		    img = ImageIO.read(new File(name+".jpg"));
		    canvas.setImage(img);
		    canvas.makeEditable();
		} catch (IOException e1) {
		}
	}
}
