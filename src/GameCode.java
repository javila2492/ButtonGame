import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class GameCode extends Application
{
    private boolean game = true;
    @FXML
    private Label label;

    @FXML
    private Button button1;
    private int score;

    @FXML
    private Label scoreList;

    private String[] textArr = {"GO GO GO!", "Faster now!", "Speed up!", "Hurry!", "Keep clicking!", "Yeah!"};
    private String[] colorArr = {"blue", "green", "pink", "red", "purple", "white", "orange"};

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
        root.setStyle("-fx-background-color: black");
        primaryStage.setTitle("Button Clicker");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }

    public void click()
    {
        if(!game)
            return;
        button1.setText(textArr[(int)(Math.random() * textArr.length)]);
        button1.setStyle("-fx-background-color:" + colorArr[(int)(Math.random() * colorArr.length)] + "; -fx-font-family: cursive;");
        score++;
        label.setText("Score: " + score);
        label.setStyle("-fx-background-color: white");

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10000), ae -> endGame()));
        timeline.play();
    }

    public void endGame()
    {
        String a = "Previous Scores: ";
        button1.setText("Game over!");
        button1.setStyle("-fx-background-color: white; -fx-font-family: cursive; -fx-font-weight: bold;");
        BackEnd.updateScore(score);
        for(int i = 0; i < BackEnd.readScore().size() - 1; i++)
        {
            a += BackEnd.readScore().get(i) + ", ";
        }
        scoreList.setText(a);
        scoreList.setStyle("-fx-background-color: white");
        game = false;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
