import java.util.ArrayList;

public class ArraysListExample {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("John");
		names.add("Will");
		for (String name : names) {
			System.out.println(name);
		}
	}
}