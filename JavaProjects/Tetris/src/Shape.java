import java.util.Random;
public class Shape {
	private final static String[] tetrisShapes = {
		"    " + 
		" XX " + 
		" XX " +
		"    "
	,
		"    " +
		"XXXX" +
		"    " +
		"    "
	,
		"    " +
		"XXX " +
		"X   " +
		"    "
		,
		"    " +
		"XXX " +
		"  X " +
		"    "
		,
		"    " +
		" XX " +
		"XX  " +
		"    "
		,
		"    " +
		" XX " +
		"  XX" +
		"    "
		,
		"    " +
		"XXX " +
		" X  " +
		"    "
		
		
	};
	 private static Random rnd = new Random();
	private int x, y;
	private int type;
	private String shapeStr;
	
	
	public Shape(int type) {
		this.type = type;
		shapeStr = tetrisShapes[type];
	}
	
	public static Shape getRandomShape() {
		int type = rnd.nextInt(tetrisShapes.length);
		return new Shape(type);
	}
	public static int getNumberOfShapes() {
		return tetrisShapes.length;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.type = y;
	}
	
	public int incY() {
		return ++y;
		
		
	}
	
	public int getType() {
		return type;
	}
	public String[] getShape() {
		String[] shape = new String[4];// {null,null,null,null}
		String temp = "";
		int idx = 0;
		for ( int i = 0; i < shapeStr.length(); i++) {
			temp += shapeStr.charAt(i);
			if (temp.length() == 4) {
				shape[idx] = temp;
				temp = "";
				idx ++;
				
			}
		}
		return shape;
	}
	
	
	public void rotateRight() {
		StringBuilder str = new StringBuilder(shapeStr);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				str.setCharAt(3 - i + 4 * j, shapeStr.charAt(i * 4 + j));
				
			}
		}
		shapeStr = str.toString();
	}
	
	public void rotateLeft() {
		StringBuilder str = new StringBuilder(shapeStr);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				str.setCharAt(i * 4 + j, shapeStr.charAt(3 - i + 4 * j));
				
			}
		}
		shapeStr = str.toString();
	}
}

















