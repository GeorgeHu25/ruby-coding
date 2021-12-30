
public class ThreadTest {
	public static void main(String[] args) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				String threadName = Thread.currentThread().getName();
				System.out.println("Current thread: " + threadName);
			}
		};
		
		
		task.run();
		
		Thread thread = new Thread(task);
		thread.start();
		
		Runnable task2 = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Current thread: " + threadName);
		};
		
		Thread thread2 = new Thread(task2);
		thread2.start();
	}
}
