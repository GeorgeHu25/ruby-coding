import javafx.application.Application;
import javafx.stage.Stage;

public class BasicFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("BasicFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}




//--module-path="C:\Program Files\Java\javafx-sdk-12.0.1\lib" --add-modules=javafx.controls
//