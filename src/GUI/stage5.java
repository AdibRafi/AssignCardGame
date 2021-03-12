package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class stage5 extends Application {

    public static void displayProceed(String Name1, String Name2){
        Stage stage5 = new Stage();
        stage5.setTitle("Players Advance");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setMinSize(300,300);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-background-color: #87faa4;");

        Text scene5title = new Text("Proceed to 2 Phase-Player");
        scene5title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scene5title, 0, 0);

        Text message = new Text("Congrats both of you :)");
        message.setFont(Font.font("Helvetica",FontWeight.NORMAL,15));
        grid.add(message,0,1);

        Text names = new Text(Name1);
        grid.add(names,0,2);
        Text names2 = new Text(Name2);
        grid.add(names2,0,3);

        Button btn = new Button("Next Round");
        btn.setOnAction(e->stage5.close());
        grid.add(btn,0,4);


        Scene scene = new Scene(grid, 300, 175);
        stage5.setScene(scene);
        stage5.showAndWait();

    }

    public static void displayWinner(String name3){
        Stage stage5 = new Stage();
        stage5.setTitle("Players Won");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setMinSize(300,300);
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setStyle("-fx-background-color: #87faa4;");

        Text scene5title = new Text("Winner OF The Game");
        scene5title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scene5title, 0, 0);

        Text message = new Text("Congrats!! You are the winner");
        message.setFont(Font.font("Helvetica",FontWeight.NORMAL,15));
        grid.add(message,0,1);

        Text names = new Text(name3);
        grid.add(names,0,2);

        Scene scene = new Scene(grid, 300, 175);
        stage5.setScene(scene);
        stage5.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //String[] names = {"adibgelebah", "markAdams"};
        //displayProceed(names[0],names[1]);

        String[] names = {"adib","darwisy"};
        displayProceed(names[0], names[1]);

    }
}
