//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Image;
//import java.awt.Insets;
//import java.awt.Label;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import javafx.animation.Timeline;
//import javafx.scene.Scene;
//import javafx.geometry.*;
//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
//import javafx.scene.*;
//import javafx.stage.*;
//import javafx.animation.*;
//
//public class TetrisFX extends Application{
//	public static final int Width = 650;
//	public static final int Height = 650;
//	public static final int Board_Width = 325;
//	public static final int Board_Height = Height;
//	public static final int BLOCK_SIZE = 30;
//	private Image[] blockImages = new Image[Shape.getNumberOfShapes()];
//	private String[] imageNames = {
//			"yellow.png",
//			"cyan.png",
//			"green.png",
//			"orange.png",
//			"red.png",
//			"purple.png",
//			"blue.png",
//	};
//	
//	private GraphicsContext gc;
//	private Tetris game;
//	private VBox vbox;
//	private Text scoreValue;
//	private Label gameOverLabel, startLabel;
//	private boolean gameOver = true;
//	
//	@Override
//	public void start1(Stage primaryStage) throws FileNotFoundException {
//		BorderPane pane = new BorderPane();
//		Canvas canvas = new Canvas(325, Height);
//		gc = canvas.getGraphicsContext2D();
//		pane.setCenter(canvas);
//		
//		
//	}
//
//	
//
//	@Override
//	public void start(Stage primaryStage) {
//		game = new Tetris();
//		
//		BorderPane pane = new BorderPane();
//		Canvas canvas = new Canvas(Board_Height, Board_Width);
//		pane.setCenter(canvas);
//		
//		vbox = new VBox();
//		vbox.setAlignment(Pos.BASELINE_CENTER);
//		pane.setRight(vbox);
//		
//		ImageView titleImgView = new ImageView(new Image(new FileInputStream("images/tetris_title.jpg")));
//		vbox.getChildren().add(titleImgView);
//		
//		Label scoreLabel = new Label("Score");
//		scoreLabel.setFont(Font.font("Verdona", 32));
//		scoreLabel.setText(Color.RED);
//		scoreLabel.setPadding(new Insets(20,0,0,0));
//		vbox.getChildren().add(scoreLabel());
//		
//		Scene scene = new Scene(pane, Width, Height);
//		primaryStage.setScene(scene);
//		primaryStage.setTitle("TetrisFX");
//		primaryStage.show();
//		
//		scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
//			System.out.println(event.getCode());
//		});
//	}
//	private Node scoreLabel() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//	
//	
//	
//	
//}
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TetrisFX extends Application {
    public static final int WIDTH = 650;
    public static final int HEIGHT = 650;

    public static final int BLOCK_SIZE = 30;

    private Image[] blockImages = new Image[Shape.getNumberOfShapes()];
    private String[] blockFn = { // should match # of shape types in Shape.java
        "yellow.png",
        "cyan.png",
        "orange.png",
        "blue.png",
        "green.png",
        "red.png",
        "purple.png",
    };

    private GraphicsContext gc;
    private Tetris game;

    private VBox vbox;
    private Text scoreValue; // the JavaFX widget for the score
    private Label gameOverLabel, startLabel;
    private boolean gameOver = true;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        BorderPane pane = new BorderPane();

        // Add canvas for the Tetris playing field
        Canvas canvas = new Canvas(325, HEIGHT);
        gc = canvas.getGraphicsContext2D();
        pane.setCenter(canvas);

        // Vertical box on right-hand side
        vbox = new VBox();
        vbox.setAlignment(Pos.BASELINE_CENTER); // center horizontally only
        pane.setRight(vbox);

        // Add Tetris title
        ImageView titleImgView = new ImageView(new Image(
              new FileInputStream("tetris_title.jpg")));
        vbox.getChildren().add(titleImgView);

        // The Label string cannot change.  You can use a Text here.
        Label scoreLabel = new Label("Score");
        scoreLabel.setFont(Font.font("Verdana", 32));
        scoreLabel.setTextFill(Color.RED);
        scoreLabel.setPadding(new Insets(20, 0, 0, 0)); // top/right/bottom/left
        vbox.getChildren().add(scoreLabel);

        // The Text string can change.  Use this for the score.
        scoreValue = new Text("0");
        scoreValue.setFont(Font.font("Verdana", 32));
        scoreValue.setFill(Color.ORANGE);
        vbox.getChildren().add(scoreValue);

        gameOverLabel = new Label("Game Over");
        gameOverLabel.setFont(Font.font("Cambria", 32));
        gameOverLabel.setTextFill(Color.BLUE);
        gameOverLabel.setPadding(new Insets(100, 0, 10, 0));

        startLabel = new Label("Press Enter to restart");
        startLabel.setFont(Font.font("Times New Roman", 20));


        // Load in Tetris shapes (tetrimino).
        for (int i = 0; i < blockFn.length; i++) {
            blockImages[i] = new Image( blockFn[i]);
        }

        Group group = new Group();
        group.getChildren().add(pane);

        Scene scene = new Scene(group, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TetrisFX");
        primaryStage.show();


        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            handleKey(event.getCode());
        });

        // This is the game loop.
        KeyFrame kf = new KeyFrame(Duration.millis(500), event -> {
            if (!gameOver) {
                // Drop the shape.  If it can't be dropped, it handles
                // clearing of the rows and updating the score.
                if (game.dropShape() == false) {
                    // Update the score in the GUI.
                    scoreValue.setText(String.valueOf(game.getScore()));

                    // Get the next playing shape.  If it can't be
                    // placed on the board, the game is over!
                    if (game.playNextShape() == false) {
                        gameOver = true;
                        vbox.getChildren().addAll(gameOverLabel, startLabel);
                        return; // return so it won't draw board
                    }
                }

                // After dropping the shape or getting a new shape,
                // update the board in the UI.
                drawBoard(game.getBoard());
            }
        });

        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        startGame();
    }

    /**
     * Starts or restarts a new game.
     */
    private void startGame() {
        game = new Tetris(); // Tetris game engine
        drawBoard(game.getBoard());
        gameOver = false;
    }

    private void handleKey(KeyCode code) {
        if (!gameOver) {
            if (code == KeyCode.LEFT) {
                game.moveShapeLeft();
            } else if (code == KeyCode.RIGHT) {
                game.moveShapeRight();
            } else if (code == KeyCode.UP) {
                game.rotateShape();
            } else if (code == KeyCode.DOWN || code == KeyCode.SPACE) {
                game.placeShape();
            }
            drawBoard(game.getBoard()); // update board now so it feels smoother
        } else {
            if (code == KeyCode.ENTER) {
                vbox.getChildren().removeAll(gameOverLabel, startLabel);
                startGame();
            }
        }
    }

    private void drawBoard(int[][] board) {
        for (int row = 0; row < Tetris.ROWS; row++) {
            for (int col = 0; col < Tetris.COLS; col++) {
                int shapeIndex = board[row][col];
                if (shapeIndex >= 0) {
                    gc.drawImage(blockImages[shapeIndex], col * BLOCK_SIZE, row * BLOCK_SIZE);
                } else {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(col * BLOCK_SIZE, row * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


