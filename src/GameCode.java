import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class GameCode extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        int a = 0;

        primaryStage.setTitle("Button Clicker");
        Label label = new Label("Clicked " + a + " times");
        Button button = new Button("Click Me!");

        button.setOnAction(value -> a++, value -> label.setText("Clicked " + a + " times"));

        button.setMaxSize(100, 100);
        HBox hbox = new HBox(button, label);
        Scene scene = new Scene(hbox, 200, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void labelChange(Label c, int b)
    {
        b++;
        c.setText("Clicked " + b + " times");
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
