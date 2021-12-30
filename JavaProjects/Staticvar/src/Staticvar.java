
public final class Staticvar {
	private static int count = 0;
	public int x = 3;
	private static final double PI = 3.1415926;
	
	public final void FinalMethod() { 
	
	}
	public void nonStaticMethod() {
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		count++;
		PI = 2.14;
		System.out.println(count);
		System.out.println(Staticvar.count);
		
		Staticvar sv = new Staticvar();
		System.out.println(sv.count);
		
		//nonStaticMethod();
	}
}