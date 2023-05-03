package FinalProject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel  implements MouseListener, MouseMotionListener{
	
	int PIXEL_SIZE = 40;
	static BufferedImage img;
	static Graphics gfx;
	
	public Canvas(int width, int height) {	
		addMouseListener(this);
		addMouseMotionListener(this);
		setBackground(Color.black);
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		gfx = img.createGraphics();
		
		PIXEL_SIZE = (int)(width/20);
		
		drawBackground(PIXEL_SIZE, Color.white);
		drawSquareGrid(PIXEL_SIZE, Color.black);
	}
	 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}

	public void setImage(BufferedImage image) {
		img = image;
		repaint();
	}
	
	public void makeEditable() {
		gfx = img.createGraphics();
		drawSquareGrid(PIXEL_SIZE, Color.black);
		repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		int dx = PIXEL_SIZE;
		gfx.setColor(MyWindow.selectedColor);
		gfx.fillRect(dx*(int)Math.floor(e.getX()/dx),dx*(int)Math.floor(e.getY()/dx),dx, dx);
		drawSquareGrid(PIXEL_SIZE, Color.black);
		repaint();
	}
	
	public void mouseClicked(MouseEvent e) {
		int dx = PIXEL_SIZE;
		gfx.setColor(MyWindow.selectedColor);
		gfx.fillRect(dx*(int)Math.floor(e.getX()/dx),dx*(int)Math.floor(e.getY()/dx),dx, dx);
		drawSquareGrid(PIXEL_SIZE, Color.black);
		repaint();
	}

	public Graphics getGraphic() {
		return gfx;
	}
	
	public void drawSquareGrid(int size, Color c) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {                
                gfx.setColor(c);
                gfx.drawRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
            }
        }
        repaint();
    }
	
	public void drawBackground(int size, Color c) {
    	for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gfx.setColor(c);
                gfx.fillRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);                
            }
        }
    	repaint();
    }
	
	public void saveCanvas(String name) {
		try {       
            ImageIO.write(img, "jpg", new File(name+".jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void mouseMoved(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
	
}