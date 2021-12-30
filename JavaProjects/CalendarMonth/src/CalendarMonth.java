import java.util.Scanner;
import java.util.Calendar;
import java.util.InputMismatchException;
public class CalendarMonth {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while(true) {
		try {
		System.out.println("Enter month 1-12: ");
		int month = scn.nextInt();
		break;
		}catch (InputMismatchException e) {
			System.out.println("Please enter a value between 1-12");
			scn.hasNextLine();

			}
		}
		
		int year = 0;
		do {
			try {
				System.out.println("Enter year (e.g 2017):");
				year  = scn.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(" Please enter a 4-digit year");
				scn.nextLine();
			}
		}while (year <= 0);
		Calendar cal = Calendar.getInstance();
		int month = 0;
		cal.set(year, month, 1);
		
		
	}
	

}
