package GUI;

import Function.Card;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.Flow;

public class stage2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public static void display3Player(String[] name,String[] cards1,String[] cards2,String[] cards3,int round) throws FileNotFoundException {
        Stage stage = new Stage();
        stage.setTitle("Group 7 Card Game");

        // letak 'ROUND x'
        StackPane stackPane = new StackPane();
        stackPane.setPrefHeight(30);
        String textRound = "Round " + round;
        Text roundText = new Text(textRound);
        roundText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        stackPane.getChildren().add(roundText);
        stackPane.setStyle("-fx-background-color: #87CEFA;");

        //Player
        Text p1 = new Text(name[0]);
        p1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Text p2 = new Text(name[1]);
        p2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Text p3 = new Text(name[2]);
        p3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        GridPane playerPane = new GridPane();
        playerPane.setVgap(200);

        playerPane.add(p1,0,0);
        playerPane.add(p2,0,1);
        playerPane.add(p3,0,2);
        playerPane.setStyle("-fx-background-color: #9ab16f;");


        //display Cards
        FlowPane flowCard1 = imageToFlow(cards1);
        FlowPane flowCard2 = imageToFlow(cards2);
        FlowPane flowCard3 = imageToFlow(cards3);



        // letak flowpane dlm grid
        VBox cardsBox = new VBox();
        if (cards1.length<=16)
            cardsBox.setSpacing(120);
        cardsBox.getChildren().addAll(flowCard1,flowCard2,flowCard3);
        cardsBox.setFillWidth(true);
        cardsBox.setStyle("-fx-background-color: #be57a3;");

        //Button
        HBox btnBox = new HBox(30);
        btnBox.setAlignment(Pos.CENTER);

        Button btn = new Button("Start");
        btn.setMinHeight(35);
        btn.setMinWidth(50);
        Button btn2 = new Button("Shuffle");
        btn2.setMinHeight(35);
        btn2.setMinWidth(50);

        // Shuffling cards first before press Button
        cards1 = Card.shuffleCards(cards1);
        cards2 = Card.shuffleCards(cards2);
        cards3 = Card.shuffleCards(cards3);

        String[] finalCards1 = cards1;
        String[] finalCards2 = cards2;
        String[] finalCards3 = cards3;
        btn2.setOnAction(e->{
            try {
                display3Player(name, finalCards1, finalCards2, finalCards3,round);
                stage.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        //start btn
        btn.setOnAction(e->stage.close());

        btnBox.getChildren().addAll(btn,btn2);

        StackPane btnPane = new StackPane();
        btnPane.setPrefHeight(50);
        btnPane.getChildren().add(btnBox);
        btnPane.setStyle("-fx-background-color: #b81e5e;");


        // Final design
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(stackPane);
        borderPane.setBottom(btnPane);
        borderPane.setLeft(playerPane);
        borderPane.setCenter(cardsBox);

        Scene scene = new Scene(borderPane, 1000, 650);
        stage.setScene(scene);
        stage.showAndWait();
    }
    public static void display2Player(String[] name,String[] cards1,String[] cards2,int round)throws FileNotFoundException{
        Stage stage = new Stage();
        stage.setTitle("Group 7 Card Game");

        //GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // letak 'ROUND x'
        StackPane stackPane = new StackPane();
        stackPane.setPrefHeight(30);
        String textRound = "Round " + round;
        Text roundText = new Text(textRound);
        roundText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        stackPane.getChildren().add(roundText);
        stackPane.setStyle("-fx-background-color: #87CEFA;");

        //Player
        Text p1 = new Text(name[0]);
        p1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Text p2 = new Text(name[1]);
        p2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        GridPane playerPane = new GridPane();
        playerPane.setVgap(200);

        playerPane.add(p1,0,0);
        playerPane.add(p2,0,1);
        playerPane.setStyle("-fx-background-color: #9ab16f;");


        //display Cards
        FlowPane flowCard1 = imageToFlow(cards1);
        FlowPane flowCard2 = imageToFlow(cards2);



        // letak flowpane dlm grid
        VBox cardsBox = new VBox();
        if (cards1.length<16)
            cardsBox.setSpacing(120);
        cardsBox.getChildren().addAll(flowCard1,flowCard2);
        cardsBox.setFillWidth(true);
        cardsBox.setStyle("-fx-background-color: #be57a3;");

        //Button
        HBox btnBox = new HBox(30);
        btnBox.setAlignment(Pos.CENTER);

        Button btn = new Button("Start");
        btn.setMinHeight(35);
        btn.setMinWidth(50);
        Button btn2 = new Button("Shuffle");
        btn2.setMinHeight(35);
        btn2.setMinWidth(50);

        // Shuffling cards first before press Button
        cards1 = Card.shuffleCards(cards1);
        cards2 = Card.shuffleCards(cards2);

        String[] finalCards1 = cards1;
        String[] finalCards2 = cards2;
        btn2.setOnAction(e->{
            try {
                display2Player(name, finalCards1, finalCards2,round);
                stage.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        //start btn
        btn.setOnAction(e->stage.close());

        btnBox.getChildren().addAll(btn,btn2);

        StackPane btnPane = new StackPane();
        btnPane.setPrefHeight(50);
        btnPane.getChildren().add(btnBox);
        btnPane.setStyle("-fx-background-color: #b81e5e;");


        // Final design
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(stackPane);
        borderPane.setBottom(btnPane);
        borderPane.setLeft(playerPane);
        borderPane.setCenter(cardsBox);

        Scene scene = new Scene(borderPane, 1000, 500);
        stage.setScene(scene);
        stage.showAndWait();
    }
    @Override
    public void start(Stage stage) throws Exception {
        String[] name = {"Adib", "Adam", "Darwisy"};
        String[] cards1 = {"c5","s6","sK","dA","cK","h5","h3","dJ","d8","s7","cX","c2","h4"};
//                ,"hA","d2","hJ","hX","s2"};
        String[] cards2 = {"d4","h7","c4","cQ","sA","d5","s3","d3","h2","h8","c9","hK"};
//                ,"d6","sJ","sX","s8","d7"};
        String[] cards3 = {"cA","dX","h6","dQ","d9","c8","h9","hQ","sQ","cJ","dK","c6"};
//                "s9","s4","c7","s5","c3"};
        String[] cards4 ={"hQ","dX","h7","c2","cX","h4","d6","c5","s5","h9","cA","c7","d7"};
//                ,"d8","d9","cK","c3","dA","c6","d4","c4","s3","hA","hX","dK","dQ"};
        String[] cards5 = {"h6","hJ","c8","sJ","hK","s4","h5","dJ","s7","sA","h3","d5","d3","sQ","c9","d2"};
//                ,"s8","h8","s9","cQ","cJ","h2","s2","s6","sX","sK"};
        display3Player(name,cards1,cards2,cards3,2);
    }
    private static FlowPane imageToFlow(String[] cards) throws FileNotFoundException {
        ImageView[] imageViews = new ImageView[cards.length];
        for (int i = 0; i < cards.length; i++) {
            String nameFile = "/Users/adibrafi/Desktop/Group 7/Main Program/src/deckOfCards/"+cards[i]+".png";

            InputStream stream = new FileInputStream(nameFile);
            Image image = new Image(stream);
            imageViews[i] = new ImageView();
            imageViews[i].setImage(image);
            imageViews[i].setX(10);
            imageViews[i].setY(10);
            imageViews[i].setFitWidth(60);
            imageViews[i].setPreserveRatio(true);
        }
        FlowPane flowResult = new FlowPane();
        for (int i = 0; i < cards.length; i++) {
            flowResult.getChildren().add(imageViews[i]);
        }
        return flowResult;
    }
}


