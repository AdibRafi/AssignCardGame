package GUI;

import Function.Card;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class stage3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void display(String[] name,String[] cards1,String[] cards2,String[] cards3, int round) throws FileNotFoundException {
        Stage stage = new Stage();
        stage.setTitle("Round x");

        StackPane stackPane = new StackPane();
        stackPane.setPrefHeight(30);
        Text roundText = new Text("Round 1");

        stackPane.getChildren().add(roundText);
        stackPane.setStyle("-fx-background-color: #87CEFA;");

        //Player
        Text p1 = new Text(name[0]);
        Text p2 = new Text(name[1]);
        Text p3 = new Text(name[2]);
        p1.setFont(Font.font("Helvetica", FontWeight.NORMAL, 30));
        p2.setFont(Font.font("Helvetica", FontWeight.NORMAL, 30));
        p3.setFont(Font.font("Helvetica", FontWeight.NORMAL, 30));

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

        //Cards
        VBox cardsBox = new VBox();
        if (cards1.length<=16)
            cardsBox.setSpacing(120);
        cardsBox.getChildren().addAll(flowCard1,flowCard2,flowCard3);
        cardsBox.setFillWidth(true);
        cardsBox.setStyle("-fx-background-color: #be57a3;");

        //Button
        HBox btnBox = new HBox(30);
        btnBox.setAlignment(Pos.CENTER);
        Button btn = new Button("Score");
        btn.setMinHeight(35);
        btn.setMinWidth(50);
        btn.setOnAction(e->stage.close());

        Text winRound = new Text("Adib win");
        winRound.setTextAlignment(Pos.BOTTOM_RIGHT);

        btnBox.getChildren().addAll(btn,winRound);


        StackPane btnPane = new StackPane();
        btnPane.setPrefHeight(50);
        btnPane.getChildren().add(btnBox);
        btnPane.setStyle("-fx-background-color: #b81e5e;");

        //Points
        VBox points = new VBox();
        Card.getValueFromCard(cards1);
        int x = Card.getValueFromCard(cards1);
        Text point1 = new Text(Integer.toString(x));
        point1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        points.getChildren().add(point1);

        Text point2 = new Text(Integer.toString(Card.getValueFromCard(cards2)));
        point2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        points.getChildren().add(point2);

        Text point3 = new Text(Integer.toString(Card.getValueFromCard(cards3)));
        point3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        points.getChildren().add(point3);

        points.setSpacing(155);
        points.setStyle("-fx-background-color: #aff8cd;");


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(stackPane);
        borderPane.setBottom(btnPane);
        borderPane.setLeft(playerPane);
        borderPane.setCenter(cardsBox);
        borderPane.setRight(points);

        Scene scene = new Scene(borderPane, 1000, 650);
        stage.setScene(scene);
        stage.showAndWait();

    }
    public void display2Player(String[] name,String[] cards1,String[] cards2) throws FileNotFoundException {
        Stage stage = new Stage();
        stage.setTitle("Group 7 Card Game");

        StackPane stackPane = new StackPane();
        stackPane.setPrefHeight(30);
        Text roundText = new Text("Round 1");

        stackPane.getChildren().add(roundText);
        stackPane.setStyle("-fx-background-color: #87CEFA;");

        //Player
        Text p1 = new Text(name[0]);
        Text p2 = new Text(name[1]);
        p1.setFont(Font.font("Helvetica", FontWeight.NORMAL, 30));
        p2.setFont(Font.font("Helvetica", FontWeight.NORMAL, 30));

        //Player Pane
        GridPane playerPane = new GridPane();
        playerPane.setVgap(200);

        playerPane.add(p1,0,0);
        playerPane.add(p2,0,1);
        playerPane.setStyle("-fx-background-color: #9ab16f;");

        //display Cards
        FlowPane flowCard1 = imageToFlow(cards1);
        FlowPane flowCard2 = imageToFlow(cards2);

        //Cards
        VBox cardsBox = new VBox();
        if (cards1.length<=16)
            cardsBox.setSpacing(120);
        cardsBox.getChildren().addAll(flowCard1,flowCard2);
        cardsBox.setFillWidth(true);
        cardsBox.setStyle("-fx-background-color: #be57a3;");

        //Button
        HBox btnBox = new HBox(30);
        btnBox.setAlignment(Pos.CENTER);
        Button btn = new Button("Score");
        btn.setMinHeight(35);
        btn.setMinWidth(50);
        btn.setOnAction(e->stage.close());

        Text winRounds = new Text("adib win");
        winRounds.setTextAlignment(Pos.BOTTOM_RIGHT);

        btnBox.getChildren().addAll(btn,winRounds);

        StackPane btnPane = new StackPane();
        btnPane.setPrefHeight(50);
        btnPane.getChildren().add(btnBox);
        btnPane.setStyle("-fx-background-color: #b81e5e;");

        //Points
        VBox points = new VBox();
        Card.getValueFromCard(cards1);
        int x = Card.getValueFromCard(cards1);
        Text point1 = new Text(Integer.toString(x));
        point1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        points.getChildren().add(point1);

        Text point2 = new Text(Integer.toString(Card.getValueFromCard(cards2)));
        point2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        points.getChildren().add(point2);

        points.setSpacing(155);
        points.setStyle("-fx-background-color: #aff8cd;");


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(stackPane);
        borderPane.setBottom(btnPane);
        borderPane.setLeft(playerPane);
        borderPane.setCenter(cardsBox);
        borderPane.setRight(points);

        Scene scene = new Scene(borderPane, 1000, 650);
        stage.setScene(scene);
        stage.showAndWait();


    }

    private static FlowPane imageToFlow(String[] cards) throws FileNotFoundException {
        ImageView[] imageViews = new ImageView[cards.length];
        for (int i = 0; i < cards.length; i++) {
            String nameFile = "C:\\Users\\User\\IdeaProjects\\Assignment2OOPDS\\src\\deckOfCards\\"+cards[i]+".png";

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

    @Override
    public void start(Stage stage) throws Exception {
        String[] name = {"Adib", "Adam", "Darwisy"};
        String[] cards = {"c5","s6","sK","dA","cK","h5","h3","dJ","d8","s7","cX","c2","h4"};
//                ,"hA","d2","hJ","hX","s2"};
        String[] cards2 = {"d4","h7","c4","cQ","sA","d5","s3","d3","h2","h8","c9","hK"};
//                ,"d6","sJ","sX","s8","d7"};
        String[] cards3 = {"cA","dX","h6","dQ","d9","c8","h9","hQ","sQ","cJ","dK","c6"};
//                "s9","s4","c7","s5","c3"};

//        display(name,cards,cards2,cards3);

        display2Player(name,cards,cards2);

    }
}
