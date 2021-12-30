
public class CorporationMain {
	public static void main(String[] args) {
		Corporation Apple = new Corporation();
			Apple.setName("Apple");
			Apple.setBasePay(70);
			Apple.setOvertimePay(120);
		Corporation FaceBook = new Corporation();
			FaceBook.setName("FaceBook");
			FaceBook.setBasePay(100);
			FaceBook.setOvertimePay(120);
		Corporation Google = new Corporation();
			Google.setName("Google");
			Google.setBasePay(150);
			Google.setOvertimePay(160);
		Amazon Amazon = new Amazon();
			Amazon.setName("Amazon");
			Amazon.setBasePay(15);
			System.out.println("Hours Worked" + "\t" + "Apple" + "\t" + "\t" + "FaceBook" + "\t" + "Google" + "\t" + "\t" + "Amazon");
			for (int HoursWorked = 35; HoursWorked <= 50; HoursWorked = HoursWorked + 1) {
				int PayApple = Apple.Calculate(HoursWorked);
				int PayFaceBook = FaceBook.Calculate(HoursWorked);
				int PayGoogle = Google.Calculate(HoursWorked);
				int PayAmazon = Amazon.Calculate(HoursWorked);
				Apple.Calculate(HoursWorked);
				FaceBook.Calculate(HoursWorked);
				Google.Calculate(HoursWorked);
				Amazon.Calculate(HoursWorked);

				System.out.println(HoursWorked + "\t" + "\t" +  PayApple + "\t" + "\t" + PayFaceBook + "\t" + "\t" + PayGoogle + "\t" + "\t" + PayAmazon);
				
			}
			
			System.out.println("Done");
			
			
			
	}
}
