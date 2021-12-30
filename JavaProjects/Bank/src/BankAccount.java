import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BankAccount {
	protected double Balance=100;
	protected String Name;
	protected static DecimalFormat da = new DecimalFormat("0.00");
	
	public BankAccount(String accountName) {
		this.Name = accountName;
	}
	
	public BankAccount(String accountName, double initialBalance) {
		Name = accountName;
		
		Balance = initialBalance;	
		
		
	}
	
	
	//password is the current hour and minute.  if the time is currently 1:15pm, the password is "0115"
//	public boolean Login(String username, String password) {
//		String pattern = "HHmm";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		String date = simpleDateFormat.format(new Date());
//		
//		if(password.equals(date))
//			return true; 
//		else
//			return false; //if password is incorrect.
//	}
	
	public boolean Login(String username, String password) {
		if (username.toUpperCase().equals(password)) {
		return true;
		} else {
		return false;
	}
		}
	

	public double Deposit(double newMoney) {
		Balance += newMoney;

		return Balance;
	}
	
	public double Withdraw(double newMoney) throws Exception {
		if(newMoney < 0) {
			throw new Exception("Money value cannot be negative.");
		}
		if (newMoney > 300) {
			throw new Exception("Money value cannot excede 300.");
		}
		if (newMoney > Balance) {
			throw new Exception("Money value cannot excede bank account value");
		}
		Balance -= newMoney;
		

		return Balance;
	}
	
	public double CurrentBalance() {
		return Balance;
	}

	
}


