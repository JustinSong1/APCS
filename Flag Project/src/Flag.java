import java.awt.*;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Flag extends JPanel {
	double startingHeight;
	double startingWidth;
	double stripeWidth;
	double stripeHeight;
	double rectangleWidth;
	double rectangleHeight;
	private final Color red = new Color(191, 10, 48);
	private final Color blue = new Color(0, 40, 104);
	
	/**
	 * @param size - size of the desired flag
	 */
	public Flag(Dimension size) {
		//Checks is 1.9*height is greater than the width, if it is then the width is maxed out and the height is scaled approporiately.
		if(size.getHeight()*1.9 > size.getWidth()) {
			this.startingHeight = size.getHeight();
			this.startingWidth = size.getWidth();
			this.stripeWidth = size.getWidth();
			this.stripeHeight = (1.0/13.0)*stripeWidth/1.9;
			this.rectangleWidth = 10*stripeHeight;
			this.rectangleHeight = 7*stripeHeight;
			
		} else { //Checks is 1.9*height is greater than the width, if it is not then the height is maxed out and the width is scaled approporiately.
			this.startingHeight = size.getHeight();
			this.startingWidth = size.getWidth();
			this.stripeHeight = startingHeight/13;
			this.stripeWidth = 13*1.9*stripeHeight;
			this.rectangleWidth = 10*stripeHeight;
			this.rectangleHeight = 7*stripeHeight;
		}
		init();
	}

	public void init() {
		setSize((int)startingWidth, (int)startingHeight);
		repaint();
	}
	
	public void paint(Graphics g) {
		//Creates the 7 red stripes spaced at equal intervals
		g.setColor(red);
		for(int x = 0; x < 7; x++) {
			g.fillRect(0, (int)(2*x*stripeHeight), (int)stripeWidth, (int)stripeHeight);
		}
		//Cretaes the blue rectangle at the top left corner of the screen
		g.setColor(blue);
		g.fillRect(0, 0, (int)rectangleWidth, (int)rectangleHeight);
		g.setColor(Color.WHITE);
		double currY = (0.054)*stripeHeight*13;
		//Creates the desired 50 stars
		for(int y = 0; y < 5; y++) {
			double currX = (0.063)*stripeHeight*13;
			for(int x = 0; x < 6; x++) {
				g.fillPolygon(new Star((int)currX, (int)currY, (int)(.0616*stripeHeight*13/2), (int)(.4*.0616*stripeHeight*13/2)));
				currX += 2*0.063*stripeHeight*13;
			}
			currY += 2*0.054 *stripeHeight*13;
		}
		currY = 2*.054*stripeHeight*13;
		for(int y = 0; y < 4; y++) {
			double currX = 2*(0.063)*stripeHeight*13;
			for(int x = 0; x < 5; x++) {
				g.fillPolygon(new Star((int)currX, (int)currY, (int)(.0616*stripeHeight*13/2), (int)(.4*.0616*stripeHeight*13/2)));
				currX += 2*0.063*stripeHeight*13;
			}
			currY += 2*0.054 *stripeHeight*13;
		}
	}
	
	
}