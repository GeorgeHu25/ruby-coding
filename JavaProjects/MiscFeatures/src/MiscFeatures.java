import java.util.Random;
import static java.lang.Math.PI;
public class MiscFeatures {
	int num = 5;
	public static void main(String[] args) {
	//int sum = add(-9, -10, 20);
	int [] numbers = {34,52,54,3};
	int sum = add (numbers);
	int sum2 = add2(43,53,53,66,23,23,646);
	//print("apple", "hello", "laptop", "Box", "blue");
	//System.out.println(sum2);
	
	
	Random rnd = new Random();
	int flip = rnd.nextInt(2);
	String result = flip == 0 ? "heads" : "tails";
	
//	if (flip == 0) {
//		result = "heads";
//	} else {
//		result = "tails";
//	}
	
	System.out.println(result);
	
//	var fruit = "apple";
//	var x = 12;
	System.out.println(PI);
	boolean found = false;
	
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j< 10; j++) {
			System.out.println(j + " ");
			int random = rnd.nextInt(11);
			if (random > 5) {
				found =true;
				break;
			}
		}
		System.out.println();
		if (found) break;
	}
}
	private static int add(int[] nums) {
		int sum = 0;
//		for (int i = 0; i < nums.length; i++) {
//			sum = sum +nums[i];
			
			for (int num : nums) {
				sum += num;
			}
		
		return sum;
	}
	
	public static int add2(int ... nums) { 
		int sum = 0;
		for (int num : nums) {
			sum += num;
			
		}
		return sum;
	}
	
	//public static void print(String... words) {
	//	for (String word : words) {
	//		System.out.println(word);
	//	}
	}
	

//}
