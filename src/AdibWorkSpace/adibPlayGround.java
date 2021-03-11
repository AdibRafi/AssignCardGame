package AdibWorkSpace;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class adibPlayGround extends Application{
    public static void display(Queue<String> cards) throws FileNotFoundException {
        Stage window = new Stage();
        window.setTitle("Title of the Window");

        ImageView[] imageView = new ImageView[cards.size()];
        int loop = cards.size();

        for (int i = 0; i < loop; i++) {
            String name = "/Users/adibrafi/IdeaProjects/Year_1_Tri_2/Assignment2OOPDS/src/deckOfCards/"+cards.remove()+".png";
            InputStream stream = new FileInputStream(name);
            Image image = new Image(stream);
            imageView[i] = new ImageView();
            imageView[i].setImage(image);
            imageView[i].setX(10);
            imageView[i].setY(10);
            imageView[i].setFitWidth(50);
            imageView[i].setPreserveRatio(true);
        }

        FlowPane flowPane = new FlowPane();

        for (int i = 0; i < loop; i++) {
            flowPane.getChildren().add(imageView[i]);
        }

//        flowPane.getChildren().add(imageView[0]);
//        flowPane.getChildren().add(imageView[1]);
//        flowPane.getChildren().add(imageView[2]);

        Scene scene = new Scene(flowPane,300,250);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String[] t = {"c2","c4","c5"};
        Queue<String> e = new LinkedList<>(Arrays.asList(t));
        display(e);
    }
}
