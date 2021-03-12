package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class stage4 extends Application {
    public static void display3Player(String[]Name,int[]Score){

        Stage stage4 = new Stage();
        stage4.setTitle("Score");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setMinSize(300,300);
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setStyle("-fx-background-color: #87faa4;");

        Text scene4title = new Text("Players Score");
        scene4title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scene4title, 0, 0);


        Text player1Name = new Text(Name[0] +": ");
        grid.add(player1Name,0,1);
        Text player2Name = new Text(Name[1] +": ");
        grid.add(player2Name,0,2);
        Text player3Name = new Text(Name[2] +": ");
        grid.add(player3Name,0,3);

        Text ScoreP1 = new Text(Integer.toString(Score[0]));
        grid.add(ScoreP1,1,1);
        Text ScoreP2 = new Text(Integer.toString(Score[1]));
        grid.add(ScoreP2,1,2);
        Text ScoreP3 = new Text(Integer.toString(Score[2]));
        grid.add(ScoreP3,1,3);


        Button btn = new Button("Next Round");
        grid.add(btn, 0, 4);
        btn.setOnAction(e->stage4.close());

        Scene scene = new Scene(grid, 200, 175);
        stage4.setScene(scene);
        stage4.showAndWait();

    }
    public static void display2Player(String[] name, int[] score){
        Stage stage4 = new Stage();
        stage4.setTitle("Score");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setMinSize(300,300);
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setStyle("-fx-background-color: #87faa4;");

        Text scene4title = new Text("Players Score");
        scene4title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scene4title, 0, 0);


        Text player1Name = new Text(name[0] +": ");
        grid.add(player1Name,0,1);
        Text player2Name = new Text(name[1] +": ");
        grid.add(player2Name,0,2);


        Text ScoreP1 = new Text(Integer.toString(score[0]));
        grid.add(ScoreP1,1,1);
        Text ScoreP2 = new Text(Integer.toString(score[1]));
        grid.add(ScoreP2,1,2);



        Button btn = new Button("Next Round");
        grid.add(btn, 0, 4);
        btn.setOnAction(e->stage4.close());

        Scene scene = new Scene(grid, 200, 175);
        stage4.setScene(scene);
        stage4.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        String[] names = {"adibgelebah", "markAdams", "rjd"};
        int[] scores = {19,0,29};

        display3Player(names,scores);
    }
}
