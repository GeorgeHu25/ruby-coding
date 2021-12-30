import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class ImageFX  extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Group group = new Group();
		Canvas canvas = new Canvas(200, 200);
		group.getChildren().add(canvas);
		
//		Image img = new Image("https://www.championtutor.com/blog/wp-content/uploads/2017/11/When-to-Get-a-Maths-Tutor-for-Your-Child.jpg");
//		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		primaryStage.setTitle("hi");
		primaryStage.show();
//		gc.drawImage(img,  200,  200);
		
		
		Scene scene = new Scene(group);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Image");
		primaryStage.show();
	}
}