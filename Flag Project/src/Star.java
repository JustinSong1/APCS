import java.awt.Polygon;

public class Star extends Polygon{
	public Star(int x, int y, int r, int innerR) {
		super(getXCoordinates(x, y, r, innerR), getYCoordinates(x, y, r, innerR), 10);
	}
	/**
	 * @param x - the starting x pos
	 * @param y - the starting y pos
	 * @param r - outer radius
	 * @param innerR - innerRadius
	 * @return xCoordinates - the array of x coords
	 */
	public static int[] getXCoordinates(int x, int y, int r, int innerR) {
		int[] xCoordinates = new int[10];
		double addAngle = 2*Math.PI/5;
		double angle = 2*Math.PI/3+.1;
        double innerAngle=angle+Math.PI/5;
		for(int z = 0; z < 5; z++) {
			xCoordinates[z*2]=(int)(r*Math.cos(angle))+x;
			angle+=addAngle;
			xCoordinates[z*2+1]=(int)(innerR*Math.cos(innerAngle))+x;
			innerAngle+=addAngle;
		}
		return xCoordinates;
	}
	/**
	 * @param x - the starting x pos
	 * @param y - the starting y pos
	 * @param r - outer radius
	 * @param innerR - innerRadius
	 * @return xCoordinates - the array of x coords
	 */
	public static int[] getYCoordinates(int x, int y, int r, int innerR){
		int[] yCoordinates = new int[10];
		double addAngle = 2*Math.PI/5;
		double angle = 2*Math.PI/3+.1;
        double innerAngle=angle+Math.PI/5;
		for(int z = 0; z < 5; z++) {
			yCoordinates[z*2]=(int)(r*Math.sin(angle))+y;
			angle+=addAngle;
			yCoordinates[z*2+1]=(int)(innerR*Math.sin(innerAngle))+y;
			innerAngle+=addAngle;
		}
		return yCoordinates;	
	}
}
