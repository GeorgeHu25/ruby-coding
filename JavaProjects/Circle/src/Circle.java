
public class Circle {
	protected static  double radius = 10;

	
	public Circle (double CircleRadius) {
		radius = CircleRadius;
	}
	

	public Circle() {
		// TODO Auto-generated constructor stub
	}






	public static double Circumference() {
		double Circumference = 2 * radius * 3.14;
		// TODO Auto-generated method stub
		return Circumference;
	}


	public static double Area() {
		double Area = radius * radius * 3.14;
		// TODO Auto-generated method stub
		return Area;
	}
	
}
