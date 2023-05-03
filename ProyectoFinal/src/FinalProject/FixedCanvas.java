package FinalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class FixedCanvas extends JPanel{
	
	private static final long serialVersionUID = 1L;
	BufferedImage img;
	Graphics gfx;	
	int width, height;
	
	public FixedCanvas(int width, int height, Color color) {	
		img = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB);
		gfx = img.createGraphics();
		this.width = width;
		this.height = height;
		fillColor(color);
	}
	 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}

	public void setImage(BufferedImage image) {
		img = image;
	}

	public Graphics getGraphic() {
		return gfx;
	}
	
	public void fillColor(Color color) {
		for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                gfx.setColor(color);
                gfx.fillRect(i * width, j * width, width, width);                
            }
		}
		repaint();
	}

}
