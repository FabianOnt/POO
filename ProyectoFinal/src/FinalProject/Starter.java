package FinalProject;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Starter {

	public static void main(String[] args) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		MyWindow myWindow = new MyWindow((int)(width*0.8), (int)(height*0.8));
	}
}
