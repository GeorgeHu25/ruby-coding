import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.util.EventListener;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
public class MouseExample2 extends Application {
	
	private int letterIndex = 0;
	private int sentenceIndex = 0;
	private String[] sentences = {"Hello World"};
	private String curSentence = sentences[0];
	@Override
	public void start(Stage primaryStage) {
		String sentence = "Greetings";
		Group group = new Group();
		Text text = new Text(curSentence);
		text.setFont(Font.font("Moonspace"));
		Text caret = new Text("^");
		caret.setFont(Font.font("Moonspace"));
		HBox textBox = new HBox(text);
		HBox caretBox = new HBox(caret);
		caretBox.setTranslateY(20);
		group.getChildren().add(textBox);
		group.getChildren().add(caretBox);
		
		Scene scene = new Scene(group, 1100, 400);
		
		//lambda expression
		scene.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			System.out.println(event.getX() + ", " + event.getY());
		});
		
		scene.addEventHandler(KeyEvent.KEY_PRESSED,  event -> {
			System.out.println(event.getCharacter());
			if (event.getText(). equals (sentence.substring(letterIndex, letterIndex + 1))) {
				caret.setAccessibleText(" " + caret.getText());
				letterIndex++;
				if (letterIndex == sentence.length()) {
					sentenceIndex++;
					text.setAccessibleText(sentences [sentenceIndex]);
					caret.setAccessibleText("^");
					letterIndex = 0;
				}
				System.out.println("Works");
			}

			//text.setText("Hi");
		});
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Lambda");
		primaryStage.show();	
}		
	public static void main(String[] args) {
		launch(args);
	}
}
