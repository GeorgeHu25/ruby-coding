import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class MouseExample extends Application implements EventHandler<MouseEvent>{
	public static void main(String[] args) {
		//System.out.println("hi");
		launch(args);
	}
	@Override
		public void handle(MouseEvent event) {
		System.out.println(event.getX() + "," + event.getY());
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		//System.out.println("hello");
		Group group = new Group();
		Scene scene = new Scene(group, 400, 400);		
		scene.addEventHandler(MouseEvent.MOUSE_PRESSED, this);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Mouse Example");
		primaryStage.show();
		//System.out.println("hi");
	}
}
