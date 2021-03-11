package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class testJap {
    public static void start(String[] name){
        Stage window = new Stage();
        window.setTitle("Title of the Window");

        Button button = new Button();
        button.setText("Click me");

        //This class will handle the button events
        button.setOnAction(e -> {
            System.out.println(name[0]);
            System.out.println(name[1]);
            System.out.println(name[2]);
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }
}
