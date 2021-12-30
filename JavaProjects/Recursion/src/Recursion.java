
public class Recursion {
	public static void main(String[] args) {
	int i,fact=1;  
		  int number=9;    
		  for(i=1;i<=number;i++){    
		      fact=fact*i;
		  }
		  System.out.println("Factorial of " +number+" is " +fact);
		System.out.println(factorial(5));
		System.out.println(factRec(5));
	}
	
	public static int factorial(int n) {
		int product = 1;
		for (int i=2; i<=n; i++) {
			product=product * i;
					
				}
				return product;
	}
	
	public static int factRec(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factRec(n - 1);
		
	}
	
	public static int sumRec(int n) {
		if (n==1) return 1;
		return n + sumRec(n-1);
	}
	
	public static int fib(int n) {
		if (n<= 1) return n;
		int first = 1;
		int second = 1;
		for (int i =2; i < n; i++) {
			int temp = second;
			second = second + first;
			first = temp;
		}
		return second; 
	}
	
	public static int fibRec(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibRec(n - 1) + fibRec(n - 2);
		}
	}
	//fib(5) -> 3
	//fib (7) -> 8
	
}
