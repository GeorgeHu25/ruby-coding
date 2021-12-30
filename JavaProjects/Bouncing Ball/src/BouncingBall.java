import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class BouncingBall {
	private final static int FRAME_SIZE = 500;
	
	private JFrame frame;
	private DisplayPanel displayPanel;
	private JButton button;
	public static void main(String[] args){
		BouncingBall ball = new BouncingBall();
		ball.start();
	}
	
	public void start() {
		frame = new JFrame("Bouncing Ball");
		frame.setSize(FRAME_SIZE,FRAME_SIZE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		displayPanel = new DisplayPanel();
		frame.add(displayPanel, BorderLayout.CENTER);
		button = new JButton("Pause");
		button.setPreferredSize(new Dimension(80, 25));
		button.addActionListener(displayPanel);
		JPanel controlPanel = new JPanel();
		controlPanel.setBackground(Color.black);
		controlPanel.add(button);
		
		frame.add(controlPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
		//frame.setVisible(true);
	}
	class DisplayPanel extends JPanel implements ActionListener, Runnable {
		private static final int SPEED = 4;
		private static final int DIAMETER = 20;
		
		private int x, y, deltaX, deltaY;
		private boolean running = true;
		
		public DisplayPanel() {
			deltaY = deltaX = SPEED;
			x = new Random().nextInt(FRAME_SIZE - DIAMETER);
			y = new Random().nextInt(FRAME_SIZE - DIAMETER);
			startThread();
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillOval(x, y, DIAMETER, DIAMETER);
		}
		
		private void startThread() {
			Thread runner = new Thread(this);
			running = true;
			runner.start();
		}
		private void stopThread() {
			running = false;
		}
		
		
		@Override
		public void run() {
			int width, height;
			while (running)  {
				width = getWidth();
				height = getHeight();
				
				x = x + deltaX;
				y = y + deltaY;
				
				if (x < 0 || x > width - DIAMETER) {
					x =x - deltaX;
					deltaX = -deltaX;
				}
				if (y < 0 || y > height - DIAMETER) {
					y = y - deltaY;
					deltaY = -deltaY;
							
					
				}
				repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
		@Override
		public void actionPerformed(ActionEvent event) {
			JButton btn = (JButton)event.getSource();
			String btnText = event.getActionCommand();
			if (btnText.contentEquals("Pause")) {
				btn.setText("GO");
				stopThread();
			} else {
				btn.setText("Pause");
				startThread();
			}
		}
	}
	//public interface ActionListener {
		//public void ActionPerformed();
	}
//}





//class DisplayPanel extends JPanel {
//}