import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class GameCode extends Application
{
    public int a = 0;
    public static Label scores;
    public Label label;
    public Button button;
    public HBox box;
    public boolean on = true;
    long timer;

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Button Clicker");
        label.setText("Clicked " + a + " times");
        button.setText("Click Me!");

        button.setOnAction(value ->
        {
            if(on)
            {
                a++;
                label.setText("Clicked " + a + " times");
            }
        });

        button.setMaxSize(100, 100);
        box = new HBox(button, label);
        Scene scene = new Scene(box, 200, 150);
        primaryStage.setScene(scene);
        primaryStage.show();

        timer = System.nanoTime() + 1000000000L;
        new AnimationTimer() {
            public void handle(long now)
            {
                if (now > timer)
                {
                    timer = now + 1000000000L;
                    on = !on;
                }
                if (!on)
                {
                    button.setText("Don't Click");
                }
                else
                {
                    button.setText("Click Me!");
                }
                label.setText("Score:" + Integer.toString(a));
            }}.start();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
