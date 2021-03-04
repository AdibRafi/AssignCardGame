package GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI extends Application{
    Button button;


    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Title of the Window");

        button = new Button();
        button.setText("Click me");

        //This class will handle the button events
        button.setOnAction(e -> {
            System.out.println("Hey now brown cow");
            System.out.println("I am a meatball");
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout,300,250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}