
public class ThreadRace {
	private static String winner;
	public static void main(String[] args) throws Exception{

		Runnable runnable = () -> {
			String name = Thread.currentThread().getName();
			for (int i = 1; i <= 26; i++) {
				System.out.println(i);
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					//System.out.println("Error when trying to sleep the thread: /n" + e);
					e.printStackTrace();
				}
				
				if (winner == null) {
					winner = name;
					System.out.println("Winner: " + name);
				}
				
			}
		};
		
		Runnable alphabet = () -> {
			String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			for (int i = 0; i< abc.length(); i++) {
				System.out.println(abc.charAt(i));
			}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				//System.out.println("Error when trying to sleep the thread: /n" + e);
				e.printStackTrace();
			}
			
//			if (winner == null) {
//				winner = name;
//				System.out.println("Winner: " + );
//			}
		};
		Thread thread = new Thread(runnable, "Number printer 1");
		Thread thread2 = new Thread(runnable, "Number Printer 2");
		thread.start();
		thread2.start();
	}
}
	
	
