
public class Corporation {
	protected int BasePay; 
	protected String Name;
	protected int OvertimePay;


	public int getBasePay() {
		return BasePay;
	}
	
	public String getName() {
		return Name;
	}
	
	public int getOvertimePay() {
		return OvertimePay;
	}
	
	public void setBasePay(int BasePay) {
		this.BasePay = BasePay;
	}
	
	public void setOvertimePay(int OvertimePay) {
		this.OvertimePay = OvertimePay;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	
	
	public int Calculate(int HoursWorked) {
		
		int Salary;
		if(HoursWorked > 40) {
			Salary = (HoursWorked - 40) * OvertimePay + BasePay * 40;
		}else{
			Salary = HoursWorked * BasePay;
		}
		return Salary;
		
	}
	
	

	
	
	
	
	
	
}