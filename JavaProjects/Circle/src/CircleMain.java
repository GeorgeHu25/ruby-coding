import java.util.Scanner;


public class CircleMain extends Circle{
	
	public static void main(String args[]) {
		
		System.out.println("Enter Circle Radius:");
		
		Scanner scanner = new Scanner(System.in);
		double radius = scanner.nextDouble();
		Circle circle= new Circle(radius);
		double CircleArea = Circle.Area();
		double CircleCircumference = Circle.Circumference();
		System.out.println("Circle Radius is " + radius);
		System.out.println("Circle Area is " + CircleArea);
		System.out.println("Circle Circumference " + CircleCircumference);
	}
}
