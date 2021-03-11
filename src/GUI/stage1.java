package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class stage1 extends Application {
    Button Button;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Group 7 Card Game");
        primaryStage.show();

        //GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);


        //Controls
        Text scenetitle = new Text("Welcome Players");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName1 = new Label("P1:");
        grid.add(userName1, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label userName2 = new Label("P2:");
        grid.add(userName2, 0, 2);

        TextField userTextField2 = new TextField();
        grid.add(userTextField2, 1, 2);

        Label userName3 = new Label("P3:");
        grid.add(userName3,0,3);

        TextField userTextField3 = new TextField();
        grid.add(userTextField3,1,3);

        //Button
        Button btn = new Button("Next");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

      /*  //Button Event
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                java.awt.Label actiontarget = null;
                Object color = null;
                actiontarget.show(color.);
                actiontarget.setText("Next button pressed");
            }
        });*/



    }

    public static void main(String[] args){
        launch(args);
    }
}
