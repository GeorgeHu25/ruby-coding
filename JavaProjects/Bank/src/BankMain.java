import java.util.Scanner;

public class BankMain extends BankAccount{
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.print("Enter Name ");
		String Name = scanner.nextLine();
		
		System.out.print("Enter your password ");
		String Password = scanner.nextLine();
		
		BankAccount myAccount = new BankAccount(Name, 100);
		
		if(myAccount.Login(Name, Password)==false)
		{
			System.out.println("Wrong password. Try again.");
			continue;
		}
		
		System.out.println("Welcome, " + Name);
	
		
		while(true) {
			System.out.println("(A)Deposit" + "\r" + "(B)Withdraw" + "\r" + "(C)Check Current Balance" + "\r" + "(D)Logoff");
			String letter = scanner.nextLine();
			
			
			if (letter.toUpperCase().equals("A")) {
				System.out.println("How much money do you want to deposit?");
				
				String stringValue = scanner.nextLine();
				
				double Value = Double.parseDouble(stringValue);
				
				// double Total = Value + 100;
				double Total = myAccount.Deposit(Value);
				
				System.out.println("Depositing $" + da.format(Value));
				System.out.println("Account value is now $" + da.format(Total));
				
			} 
			
			if (letter.toUpperCase().equals("B")) {
				System.out.println("How much do you want to withdraw?");
				String stringValue = scanner.nextLine();
				
				double Value = Double.parseDouble(stringValue);
				double Total = 100; 
				
				try
				{
					Total = myAccount.Withdraw(Value);
				} catch(Exception exp) {
					System.out.println(exp.getMessage());
					continue;
				}
		
				
//				if (Value < 0) {
//					System.out.println("Error, cannot withdraw negative numbers.");
//				} else {
//					if (Value > 300) {
//						System.out.println("Error, cannot withdraw more than $300.");
//					} else {
//						if (Total < Value) {
//							System.out.println("Error, bank account cannot have negative values.");
//						} else {
//				double Total = 100 - Value;
				System.out.println("Withdrawing $" + da.format(Value));
				System.out.println("Account value is now $" + da.format(Total));
			}

			if (letter.toUpperCase().equals("C")) {
				System.out.println("Checking Current Balance...");
				//String stringValue = scanner.nextLine();
				
				double Total = myAccount.CurrentBalance();
//				double Total = 100;
				System.out.println("Balance is $" + da.format(Total));
				
			} 
			
			if (letter.toUpperCase().equals("D")) {
				System.out.println("Logoff");
					break;
				}
			} 
		}
	}
}

