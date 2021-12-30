
public class Bits {
	public static void main(String[] args) {
		byte five = 0b101;
		byte seven = 0b111;
		byte num = 0b101010;
		
		int val = five & seven;
		
		System.out.println(Integer.toBinaryString(~num));
		//System.out.println(num << 1);
		
	}
}
