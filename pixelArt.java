import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class PixelArt {
    static int width = 720;
    static int height = 720;
    
    static Color darkBlue = new Color(20,79,92,255);
    static Color softBlue = new Color(93,195,196,255);
    static Color lightBlue = new Color(115,241,243,255);
    static Color strangeBlue = new Color(22,99,115,255);
    
    static Color softBrown = new Color(180,95,6,255);
    static Color darkBrown  = new Color(66,51,35,255);
    static Color strangeBrown = new Color(151,118,81,255);
    
    static Graphics2D g;

    static BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    // Definimos el tamaÃ±o del pixel y la matriz de colores
    private final static int PIXEL_SIZE = 40;
    private final static Color[][] PIXELS = {
        {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
        {Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE},
        {Color.WHITE, Color.BLUE, Color.RED, Color.BLUE, Color.WHITE},
        {Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE},
        {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE}
    };
    
    public static void paint() {
    	drawBackground(PIXEL_SIZE, Color.white); 
    	
    	drawHorizontalLine(2, 3, 1, darkBlue);
    	drawVerticalLine(1,3,1,darkBlue);

    	drawDiagonalLine(8,14,14,8,darkBlue);
    	drawDiagonalLine(9,15,15,9,darkBlue);
    	drawDiagonalLine(11,14,14,11,darkBlue);
    	drawDiagonalLine(8,15,15,8,darkBlue);
    	drawDiagonalLine(9,10,14,13,strangeBlue);
    	drawDiagonalLine(11,13,13,11,softBlue);
    	putPixel(12,9,softBlue);
    	putPixel(13,8,strangeBlue);
    	
    	drawDiagonalLine(5,11,3,9,darkBlue);
    	drawDiagonalLine(3,9,5,11,darkBlue);
    	drawDiagonalLine(4,11,3,10,lightBlue);
    	drawDiagonalLine(3,10,4,11,lightBlue);
    	drawDiagonalLine(3,11,3,11,softBlue);
    	
    	fillRect(14,14,3,3,darkBlue);
    	putPixel(15,15,softBlue);
    	putPixel(14,14,strangeBrown);
    	
    	
    	drawDiagonalLine(13,14,14,15,darkBrown);
    	drawDiagonalLine(13,14,13,14,softBrown);
    	drawDiagonalLine(14,15,13,14,strangeBrown);
    	
        
        drawSquareGrid(PIXEL_SIZE, Color.black);
        // Guardamos la imagen en formato JPG
        try {       
            ImageIO.write(image, "jpg", new File("pixel_art.jpg"));
            System.out.println("EXITO !!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void drawDiagonalLine(int a, int b, int x1, int x2, Color c) {
    	int sgn;
    	if (x1<x2) {
    		sgn = 1;
    	}else {
    		sgn = -1;
    	}
    	
    	int j = x1;
    	for(int i=a; i<=b; i++) {
    		putPixel(i-1,j-1,c);
    		j += sgn*1;
    	}
    }
    
    private static void drawVerticalLine(int a, int b, int x, Color c){
    	for(int i=a;i<=b;i++){
     	   g.setColor(c);
           g.fillRect(x * PIXEL_SIZE, i * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        }
    }
    
    private static void drawHorizontalLine(int a, int b, int y, Color c){
        for(int i=a;i<=b;i++){
     	   g.setColor(c);
           g.fillRect(i * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        }
    }
    
    private static void putPixel(int x, int y, Color c){       
	   g.setColor(c);
	   g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);    
    }
    
    private static void fillRect(int x, int y, int width, int height, Color c){
    	g.setColor(c);
    	g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, width*PIXEL_SIZE, height*PIXEL_SIZE);
    }
    
    private static void drawSquareGrid(int size, Color c) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {                
                g.setColor(c);
                g.drawRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
            }
        }
    }
    private static void drawBackground(int size, Color c) {
    	for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                g.setColor(c);
                g.fillRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);                
            }
        }
    }
    
    
    public static void main(String[] args) {
        g = image.createGraphics();        
        paint();
    }
}
