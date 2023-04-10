//************************************************************ Actividad del día (un solo PixelArt) ******************************************************************

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




// ************************************************************** Actividad Vacaciones PixelArtX *********************************************************************

public class Main {
	public static void main(String[] args) {
		Pictures pixelArt = new Pictures();
		pixelArt.pic1();
		pixelArt.pic2();
		pixelArt.pic3();
		pixelArt.pic4();
		pixelArt.pic5();
		pixelArt.pic6();
		pixelArt.pic7();
		pixelArt.pic8();
		pixelArt.pic9();
		pixelArt.pic10();
	}
}

/*
Enlaces de las imágenes usadas como referencia por orden:

1. https://images.app.goo.gl/WeRFWDeVVNYn7YkRA
2. https://images.app.goo.gl/u9u2rmY4qQpA4rnm8
3. https://images.app.goo.gl/9qwtG71DFjySWJvS8
4. https://images.app.goo.gl/xwHE42MMtLNU1Whh9
5. https://www.google.com/imgres?imgurl=https%3A%2F%2Fi.pinimg.com%2Foriginals%2Fb3%2F04%2F3f%2Fb3043fb6486360dc1c82b229b31df6d4.jpg&tbnid=INxxTGrqQQh7cM&vet=1&imgrefurl=https%3A%2F%2Fco.pinterest.com%2Famp%2Fpin%2F834432637182856869%2F&docid=3hUCnCyD_J0NlM&w=480&h=854&hl=es&source=sh%2Fx%2Fim
6. https://images.app.goo.gl/9poowqW6L7wHd57o6
7. https://images.app.goo.gl/WAPwpVXejbU8C3mv7
8. https://images.app.goo.gl/d2VBi8wH3FTM5w9m6
9. https://www.google.com/imgres?imgurl=https%3A%2F%2Fjuegosinfantiles.bosquedefantasias.com%2Fwp-content%2Fuploads%2F2020%2F12%2Fpixel-art-sandia.jpg&tbnid=9ThBxcNZzN66eM&vet=1&imgrefurl=https%3A%2F%2Fjuegosinfantiles.bosquedefantasias.com%2Fpixel-art-para-ninos&docid=Lnm9mMsUQRkY7M&w=1200&h=818&hl=es&source=sh%2Fx%2Fim
10. https://i.pinimg.com/originals/b0/66/a8/b066a8a3fc8326fcb2ce39a0240b3c4b.png

*/




import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import java.awt.Color;

public class Pictures {
	
    static int width;
    static int height;
	
	static Graphics2D g;
    static BufferedImage image;

    private final static int PIXEL_SIZE = 40;
    private final static Color[][] PIXELS = {
        {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
        {Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE},
        {Color.WHITE, Color.BLUE, Color.RED, Color.BLUE, Color.WHITE},
        {Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE, Color.WHITE},
        {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE}
    };
	
	public void pic1() {
		width = 15;
		height = 18;
		image = new BufferedImage(PIXEL_SIZE*width, PIXEL_SIZE*height, BufferedImage.TYPE_INT_RGB);
		g = image.createGraphics();		
		
		Color green1 = new Color(113,163,152,255);
		Color green2 = new Color(207,252,215,255);
		Color yellow1 = new Color(229,204,78,255);
		Color gray1 = new Color(38,55,59,255);
		
		drawBackground(PIXEL_SIZE, Color.white);
		
		fillRect(1,1,13,16,Color.black);
		fillRect(2,2,11,14,green1);
		fillRect(3,3,9,6,green2);
		putPixel(4,5,Color.black);
		putPixel(10,5,Color.black);
		drawHorizontalLine(6,6,3,Color.black);
		
		drawHorizontalLine(3,10,5,gray1);
		putPixel(10,10,Color.blue);
		drawHorizontalLine(3,13,3,yellow1);
		drawVerticalLine(4,12,3,yellow1);
		
		putPixel(9,14,Color.red);
		putPixel(10,13,Color.green);
		putPixel(8,13,Color.cyan);
		
		putPixel(1,1,Color.white);
		putPixel(13,1,Color.white);
		putPixel(1,16,Color.white);
		putPixel(13,16,Color.white);
		
		drawSquareGrid(PIXEL_SIZE, Color.black);
		
		save(image, "imagen1.jpg");
	}
	
	
	public void pic2() {
		width = 16;
		height = 16;
		image = new BufferedImage(PIXEL_SIZE*width, PIXEL_SIZE*height, BufferedImage.TYPE_INT_RGB);
		g = image.createGraphics();	
		
		Color brown1 = new Color(170,115,24,255);
		Color brown2 = new Color(118,78,9,255);
		Color brown3 = new Color(74,54,19,255);
		
		drawBackground(PIXEL_SIZE, Color.white);		
		
		int i;
		for (i=9;i<=16;i++) {
			drawDiagonalLine(1,i,i,1,brown1);			
		}

		fillRect(1,12,2,4,Color.white);
		fillRect(11,1,5,2,Color.white);
		putPixel(14,3,Color.white);
		
		drawDiagonalLine(2,7,7,2,brown2);
		putPixel(8,2,brown2);

		drawDiagonalLine(5,13,13,5,brown2);
		drawDiagonalLine(6,13,13,6,brown2);
		drawDiagonalLine(6,14,14,6,brown3);
		
		drawVerticalLine(14,4,3,brown3);
		drawHorizontalLine(4,14,3,brown3);
		
		putPixel(13,4,brown2);
		drawVerticalLine(1,9,3,brown2);
		drawHorizontalLine(3,13,4,brown2);
		
		putPixel(13,3,brown3);
		drawDiagonalLine(10,1,13,4,brown2);
		putPixel(12,2,brown2);
		putPixel(2,8,brown2);
		
		drawHorizontalLine(4,7,2,brown3);
		putPixel(6,8,brown3);
		drawHorizontalLine(7,4,2,brown3);
		putPixel(9,5,brown3);
		
		putPixel(2,11,brown1);
		putPixel(3,12,brown1);
		putPixel(2,12,brown2);
		
		drawDiagonalLine(3,14,5,12,brown2);
		drawDiagonalLine(7,10,8,9,brown2);
		
		drawDiagonalLine(10,1,12,3,brown2);
		putPixel(9,1,brown2);
		
		
		drawSquareGrid(PIXEL_SIZE, Color.black);
		
		save(image, "imagen2.jpg");
	}
	
	
	public void pic3() {
		
		width = 14;
		height = 19;
		image = new BufferedImage(PIXEL_SIZE*width, PIXEL_SIZE*height, BufferedImage.TYPE_INT_RGB);
		g = image.createGraphics();	
		
		Color perry = new Color(43,210,180,255);
		Color brown = new Color(123,53,2,255);
		Color orange = new Color(255,106,0);
		
		drawBackground(PIXEL_SIZE, Color.white);
		
		drawDiagonalLine(1,10,5,14,orange);
		drawDiagonalLine(1,9,5,13,orange);
		drawDiagonalLine(2,8,5,12,orange);
		drawDiagonalLine(3,8,5,11,orange);
		drawDiagonalLine(2,9,5,10,orange);
		
		fillRect(6,5,5,11,perry);
		putPixel(11,5,perry);
		putPixel(11,7,perry);
		
		putPixel(5,10,perry);
		drawVerticalLine(4,11,2,perry);
		putPixel(5,13,perry);
		
		drawVerticalLine(11,11,2,perry);
		drawVerticalLine(12,12,2,perry);
		
		putPixel(7,6,Color.white);
		putPixel(8,6,Color.black);
		putPixel(9,6,orange);
		putPixel(10,6,Color.white);
		putPixel(11,6,Color.black);
		
		fillRect(8,7,3,3,orange);
		putPixel(7,9,orange);
		drawVerticalLine(11,8,2,orange);
		putPixel(12,8,orange);
		
		drawHorizontalLine(4,4,9,brown);
		putPixel(5,5,brown);
		drawHorizontalLine(6,2,5,brown);
		putPixel(6,3,brown);
		drawHorizontalLine(7,1,3,brown);
		drawHorizontalLine(7,3,4,Color.black);
		
		fillRect(5,15,2,2,perry);
		fillRect(10,15,2,2,perry);
		drawHorizontalLine(4,17,3,orange);
		drawHorizontalLine(10,17,3,orange);
		
		drawSquareGrid(PIXEL_SIZE, Color.black);
		
		save(image, "imagen3.jpg");
	}
	
	
	public void pic4() {
		
		width = 16;
		height = 15;
		image = new BufferedImage(PIXEL_SIZE*width, PIXEL_SIZE*height, BufferedImage.TYPE_INT_RGB);
		g = image.createGraphics();
		
		Color blue1 = new Color(127,254,239,255);
		Color blue2 = new Color(0,153,201,255);
		
		drawBackground(PIXEL_SIZE, Color.white);
		
		fillRect(3,4,10,7,blue1);
		fillRect(5,11,6,2,blue2);
		fillRect(10,9,2,2,blue2);
		fillRect(11,6,2,2,blue2);
		
		drawHorizontalLine(2,3,3,blue1);
		drawVerticalLine(4,2,2,blue1);
		drawVerticalLine(5,2,2,blue2);
		putPixel(2,5,blue2);
		putPixel(3,7,blue2);
		putPixel(2,4,blue1);
		
		fillRect(10,2,2,2,blue1);
		putPixel(12,3,blue1);
		drawVerticalLine(13,3,3,blue2);
		putPixel(11,8,blue2);
		
		putPixel(12,5,blue2);
		putPixel(11,11,blue2);
		drawVerticalLine(4,10,2,blue2);
		
		
		drawVerticalLine(3,8,4,Color.black);
		drawVerticalLine(12,8,4,Color.black);
		
		drawVerticalLine(1,3,3,Color.black);
		drawVerticalLine(14,3,3,Color.black);
		
		drawVerticalLine(2,6,2,Color.black);
		drawVerticalLine(13,6,2,Color.black);
		
		drawHorizontalLine(5,13,6,Color.black);
		
		putPixel(4,12,Color.black);
		putPixel(11,12,Color.black);
		
		drawHorizontalLine(2,2,2,Color.black);
		drawHorizontalLine(12,2,2,Color.black);
		
		drawVerticalLine(6,2,2,Color.black);
		drawVerticalLine(9,2,2,Color.black);
		
		drawHorizontalLine(7,4,2,Color.black);
		drawHorizontalLine(4,1,2,Color.black);
		drawHorizontalLine(10,1,2,Color.black);
		
		drawHorizontalLine(4,5,2,Color.white);
		putPixel(4,6,Color.white);
		
		drawSquareGrid(PIXEL_SIZE, Color.black);
		
		save(image, "imagen4.jpg");
	}
	
	
	public void pic5() {
		
		width = 14;
		height = 21;
		image = new BufferedImage(PIXEL_SIZE*width, PIXEL_SIZE*height, BufferedImage.TYPE_INT_RGB);
		g = image.createGraphics();
		
		Color yellow = new Color(255,217,0,255);
		
		drawBackground(PIXEL_SIZE, Color.white);
		
		fillRect(2,3,10,13,yellow);
		fillRect(4,1,6,2,yellow);
		putPixel(3,2,yellow);
		putPixel(10,2,yellow);
		
		fillRect(2,4,10,2,Color.black);
		drawVerticalLine(4,4,2,Color.gray);
		drawVerticalLine(9,4,2,Color.gray);
		drawHorizontalLine(6,2,2,Color.gray);
		drawHorizontalLine(6,7,2,Color.gray);
		putPixel(5,3,Color.gray);
		putPixel(8,3,Color.gray);
		putPixel(5,6,Color.gray);
		putPixel(8,6,Color.gray);
		drawVerticalLine(5,4,2,Color.white);
		drawVerticalLine(8,4,2,Color.white);
		drawHorizontalLine(6,3,2,Color.white);
		drawHorizontalLine(6,6,2,Color.white);
		
		drawHorizontalLine(5,9,4,Color.black);
		putPixel(4,8,Color.black);
		putPixel(9,8,Color.black);
		
		putPixel(2,11,Color.blue);
		putPixel(11,11,Color.blue);
		drawHorizontalLine(3,12,8,Color.blue);
		fillRect(4,13,6,2,Color.blue);
		fillRect(3,15,8,3,Color.blue);
		
		drawHorizontalLine(1,16,2,Color.black);
		putPixel(2,17,Color.black);
		
		drawHorizontalLine(11,16,2,Color.black);
		putPixel(11,17,Color.black);
		
		fillRect(4,18,2,2,Color.black);
		putPixel(3,19,Color.black);
		
		fillRect(8,18,2,2,Color.black);
		putPixel(10,19,Color.black);
		
		drawSquareGrid(PIXEL_SIZE, Color.black);
		
		save(image, "imagen5.jpg");
		
	}
	
	public void pic6() {
		
		width = 17;
		height = 18;
		image = new BufferedImage(PIXEL_SIZE*width, PIXEL_SIZE*height, BufferedImage.TYPE_INT_RGB);
		g = image.createGraphics();
		
		Color o = new Color(234,200,170,255);
		Color green = new Color(91,189,56,255);

		drawBackground(PIXEL_SIZE, Color.white);
		
		fillRect(3,14,11,2,Color.blue);
		fillRect(3,10,12,4,Color.cyan);
		
		drawVerticalLine(3,9,3,green);
		putPixel(2,9,green);
		drawVerticalLine(13,9,3,green);
		putPixel(14,9,green);
		
		drawVerticalLine(2,10,3,o);
		drawVerticalLine(14,10,3,o);
		
		fillRect(4,4,9,5,o);
		
		putPixel(5,6,Color.black);
		putPixel(11,6,Color.black);
		drawHorizontalLine(7,7,3,Color.black);
		
		putPixel(4,4,Color.white);
		putPixel(4,8,Color.white);
		putPixel(12,4,Color.white);
		putPixel(12,8,Color.white);
		
		drawHorizontalLine(3,1,2,Color.black);
		drawHorizontalLine(12,1,2,Color.black);
		drawHorizontalLine(5,2,7,Color.black);
		
		drawHorizontalLine(3,16,3,Color.black);
		drawHorizontalLine(11,16,3,Color.black);
		drawHorizontalLine(6,15,5,Color.black);
		
		drawVerticalLine(2,2,7,Color.black);
		drawVerticalLine(14,2,7,Color.black);
		
		drawVerticalLine(1,9,4,Color.black);
		drawVerticalLine(15,9,4,Color.black);
		
		drawVerticalLine(2,13,3,Color.black);
		drawVerticalLine(14,13,3,Color.black);
		
		
		drawSquareGrid(PIXEL_SIZE, Color.black);
		
		save(image, "imagen6.jpg");
	}
	
	public void pic7() {
			
		width = 17;
		height = 17;
		image = new BufferedImage(PIXEL_SIZE*width, PIXEL_SIZE*height, BufferedImage.TYPE_INT_RGB);
		g = image.createGraphics();

		drawBackground(PIXEL_SIZE, Color.white);
		
		fillRect(3,3,11,11,Color.yellow);
		drawHorizontalLine(6,2,5,Color.yellow);
		drawHorizontalLine(6,14,5,Color.yellow);
		drawVerticalLine(2,7,4,Color.yellow);
		drawVerticalLine(14,7,4,Color.yellow);
		
		drawHorizontalLine(6,1,5,Color.black);
		drawHorizontalLine(6,15,5,Color.black);
		drawVerticalLine(1,6,5,Color.black);
		drawVerticalLine(15,6,5,Color.black);
		
		drawHorizontalLine(4,2,2,Color.black);
		drawHorizontalLine(11,2,2,Color.black);
		drawHorizontalLine(4,14,2,Color.black);
		drawHorizontalLine(11,14,2,Color.black);
		
		drawVerticalLine(2,4,2,Color.black);
		drawVerticalLine(14,4,2,Color.black);
		drawVerticalLine(2,11,2,Color.black);
		drawVerticalLine(14,11,2,Color.black);
		
		putPixel(3,3,Color.black);
		putPixel(13,3,Color.black);
		putPixel(3,13,Color.black);
		putPixel(13,13,Color.black);
		
		drawHorizontalLine(7,12,4,Color.black);
		putPixel(11,11,Color.black);
		
		drawHorizontalLine(2,6,13,Color.black);
		fillRect(3,6,5,4,Color.black);
		fillRect(9,6,5,4,Color.black);
		
		drawHorizontalLine(4,7,2,Color.white);
		drawHorizontalLine(10,7,2,Color.white);
		putPixel(4,8,Color.white);
		putPixel(10,8,Color.white);
		
		putPixel(3,9,Color.yellow);
		putPixel(7,9,Color.yellow);
		putPixel(9,9,Color.yellow);
		putPixel(13,9,Color.yellow);
		
		
		
		
		drawSquareGrid(PIXEL_SIZE, Color.black);
		
		save(image, "imagen7.jpg");
	}
	
	
	public void pic8() {
		
		width = 15;
		height = 18;
		image = new BufferedImage(PIXEL_SIZE*width, PIXEL_SIZE*height, BufferedImage.TYPE_INT_RGB);
		g = image.createGraphics();
		
		Color o = new Color(251,193,145,255);
		Color brown = new Color(154,71,1,255);
		Color blue = new Color(8,112,191,255);
		
		drawBackground(PIXEL_SIZE, Color.white);
		
		drawHorizontalLine(4,1,6,Color.red);
		drawHorizontalLine(3,2,10,Color.red);
		fillRect(4,3,7,5,o);
		fillRect(11,4,2,2,o);
		putPixel(13,5,o);
		putPixel(11,7,o);
		
		drawHorizontalLine(9,6,4,Color.black);
		putPixel(10,5,Color.black);
		drawVerticalLine(9,3,2,Color.black);
		
		fillRect(2,3,4,4,brown);
		drawVerticalLine(3,4,2,o);
		putPixel(2,3,Color.white);
		drawHorizontalLine(4,6,2,o);
		putPixel(5,4,o);
		
		fillRect(1,8,12,3,Color.red);
		drawHorizontalLine(1,8,2,Color.white);
		drawHorizontalLine(10,8,3,Color.white);
		putPixel(1,9,Color.white);
		putPixel(12,9,Color.white);
		
		fillRect(4,10,6,4,blue);
		drawVerticalLine(5,8,3,blue);
		putPixel(8,9,blue);
		putPixel(4,10,Color.red);
		putPixel(9,10,Color.red);
		putPixel(5,11,Color.yellow);
		putPixel(8,11,Color.yellow);
		
		fillRect(3,13,3,2,blue);
		fillRect(8,13,3,2,blue);
		
		fillRect(2,15,3,2,brown);
		fillRect(9,15,3,2,brown);
		putPixel(1,16,brown);
		putPixel(12,16,brown);
		
		fillRect(1,11,2,3,o);
		fillRect(11,11,2,3,o);
		putPixel(3,12,o);
		putPixel(10,12,o);
		
		putPixel(3,11,Color.red);
		putPixel(10,11,Color.red);
		
		
		
		drawSquareGrid(PIXEL_SIZE, Color.black);
		
		save(image, "imagen8.jpg");
	}
	
	public void pic9() {
		
		width = 13;
		height = 15;
		image = new BufferedImage(PIXEL_SIZE*width, PIXEL_SIZE*height, BufferedImage.TYPE_INT_RGB);
		g = image.createGraphics();
		
		Color green1 = new Color(138,197,55,255);
		Color green2 = new Color(4,100,63,255);
		Color red = new Color(244,25,41,255);
		
		drawBackground(PIXEL_SIZE, Color.white);

		fillRect(1,9,11,2,red);
		fillRect(2,6,9,3,red);
		fillRect(4,3,5,3,red);
		putPixel(3,5,red);
		putPixel(9,5,red);
		drawHorizontalLine(5,2,3,red);
		putPixel(6,1,red);
		
		fillRect(2,10,9,3,green1);
		putPixel(1,10,green1);
		putPixel(11,10,green1);
		
		drawHorizontalLine(4,13,5,green2);
		drawHorizontalLine(2,12,2,green2);
		drawHorizontalLine(9,12,2,green2);
		putPixel(1,11,green2);
		putPixel(11,11,green2);
		
		drawHorizontalLine(4,10,5,red);
		putPixel(5,6,Color.black);
		putPixel(7,6,Color.black);
		putPixel(4,8,Color.black);
		putPixel(8,8,Color.black);
		putPixel(6,9,Color.black);
		
		
		
		drawSquareGrid(PIXEL_SIZE, Color.black);
		
		save(image, "imagen9.jpg");
	}
	
	
	public void pic10() {
		
		width = 29;
		height = 20;
		image = new BufferedImage(PIXEL_SIZE*width, PIXEL_SIZE*height, BufferedImage.TYPE_INT_RGB);
		g = image.createGraphics();
		
		Color green1 = new Color(149,185,11,255);
		Color green2 = new Color(0,153,0,255);
		Color red = new Color(255,0,0,255);
		Color brown = new Color(102,51,0,255);
		Color yellow = new Color(255,147,28,255);
		
		drawBackground(PIXEL_SIZE, Color.white);
		
		fillRect(1,1,9,18,green2);
		fillRect(19,1,9,18,red);
		
		fillRect(13,7,4,5,brown);
		putPixel(14,7,Color.white);
		putPixel(13,9,Color.white);
		putPixel(17,8,brown);
		putPixel(17,9,brown);
		
		putPixel(15,6,brown);
		putPixel(14,5,brown);
		putPixel(12,7,brown);
		putPixel(11,7,green1);
		putPixel(12,8,green1);
		putPixel(12,9,green1);
		
		putPixel(12,11,red);
		putPixel(16,11,red);
		putPixel(14,12,red);
		putPixel(13,12,green2);
		putPixel(15,12,green2);
		putPixel(13,13,Color.blue);
		putPixel(15,13,Color.blue);
		putPixel(14,13,yellow);
		
		putPixel(12,13,green1);
		putPixel(16,13,green1);
		
		drawHorizontalLine(13,14,3,green1);
		drawVerticalLine(11,11,2,green1);
		drawVerticalLine(17,11,2,green1);
		
		
		drawSquareGrid(PIXEL_SIZE, Color.black);
		
		save(image, "imagen10.jpg");
	}
	
	private static void drawDiagonalLine(int x1, int y1, int x2, int y2, Color c) {
        
		int sgn1,sgn2, dist, i, j, k=0;
		
		if (x1<x2) {
			sgn1 = 1;
			dist = x2-x1;
		}else {
			sgn1 = -1;
			dist = x1-x2;
		}
		
		if (y1<y2) {
			sgn2 = 1;
		}else {
			sgn2 = -1;
		}
		
		i = x1; j = y1;
		
    	while (k != dist+1) {
    		putPixel(i,j,c);
    		i += sgn1;
    		j += sgn2;
    		k++;
    		
    	}
    }
    
    private static void drawVerticalLine(int x, int y, int heigth, Color c){
    	for(int i=y;i<y+heigth;i++){
     	   g.setColor(c);
           g.fillRect(x * PIXEL_SIZE, i * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        }
    }
    
    private static void drawHorizontalLine(int x, int y, int width, Color c){
        for(int i=x;i<x+width;i++){
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
    
    
	public static void save(BufferedImage image, String name) {
		try {       
            ImageIO.write(image, "jpg", new File(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
