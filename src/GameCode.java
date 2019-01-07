import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.util.Duration;


public class GameCode extends Application
{
    public int a = 0;

    @FXML
    public static Label scores;
    public Label label;
    public Button button;
    public HBox box;

    public boolean on = true;
    long timer;
    boolean loss = false;
    boolean over = false;

    @Override
    public void start(Stage primaryStage)
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Button Clicker");
        Label label = new Label("Score: " + a);

        Button button  = new Button("Click Me!");
        button.setOnAction(value ->
        {
            if(loss)
            {
                a--;
                label.setText("Score: " + a);
            }
            if(on)
            {
                a++;
                label.setText("Score: " + a);
            }
        });

        button.setMaxSize(150, 120);
        box = new HBox(button, label);
        Scene scene = new Scene(box, 400, 150);
        primaryStage.setScene(new Scene(root, scene, 300, 150));

        timer = System.nanoTime() + 1000000000L;
        new AnimationTimer() {
            public void handle(long now)
            {
                if(over)
                    return;
                if (now > timer)
                {
                    timer = now + 1000000000L;
                    on = !on;
                }
                if (!on)
                {
                    button.setText("Don't Click");
                    loss = true;
                }
                else
                {
                    button.setText("Click Me!");
                    loss = false;
                }
                label.setText("Score:" + Integer.toString(a));
            }}.start();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10000), actionEvent -> end()));
        timeline.play();
        primaryStage.show();
    }

    public void end()
    {
        button.setText("Game Over!");
        over = true;
        button.setStyle("-fx-background-color: white; -fx-font-family: cursive; -fx-font-weight: bold;");
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
