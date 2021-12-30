import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.canvas.*;
import javafx.scene.Group;

public class Plot extends Application {
	private GraphicsContext gc;
	private int x,y;
	
	@Override
	public void start(Stage primaryStage) {
		Group group = new Group();
		Canvas canvas = new Canvas(800, 600);
		group.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		Scene scene = new Scene(group);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Plotter");
		primaryStage.show();
		
		readFile("commands.txt");
	}
	
	
	public void readFile(String fileName) {
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while (true) {
				line = br.readLine();
				if (line == null) break;
				processCommand(line);
			}
			br.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void processCommand(String command) {
		//String line = "up, down";
		//String[] values = line.split(",");
		String [] cmds = command.split(" ");
		String dir = cmds[0];
		int val = Integer.parseInt(cmds[1]);
		
			switch (dir) {
			case "right":
				gc.strokeLine(x, y, x + val, y);
				x += val;
			break;
			
			case "left":
				gc.strokeLine(x, y, x - val, y);
				x -= val;
			break;
		
			case "up":
				gc.strokeLine(x, y, x, y-val);
				y -= val;
			break;
			
			case "down":
				gc.strokeLine(x, y, x, y + val);
				y += val;
			break;
			
			case "x":
			  x = val;
			break;
			
			case "y":
				y = val;
			break;
			
			default:
				System.err.println("Unknown command:" + dir);
		}
		
		
	}
	
	public static void main(String[] args) {
		launch();
	}
}



//gc.strokeLine(startX, startY, endX, endY);





















