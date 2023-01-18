package com.example;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {
  public void start(Stage stage){
    Pane layout = new HBox(10);
    layout.setPadding(new Insets(5,5,5,5));
    ImageView image = new ImageView();
    Image[] images = new Image[4];
    images[0] = new Image("Arg.png");
    images[1] = new Image("Indea.png");
    images[2] = new Image("Japan.png");
    images[3] = new Image("UK.png");
    image.setFitWidth(230);
    image.setPreserveRatio(true);
    image.setImage(images[first]);

    Button next = new Button("Next");
    next.setOnAction(e ->{
      first = (first + 1) % images.length;
      image.setImage(images[first]);
    });

    Button back = new Button("Back");
    back.setOnAction(e -> {
      first --;
      if (first < 0)
        first = images.length - 1;
      image.setImage(images[first]);
    });

    Scene scene = new Scene(layout,500,500);
    layout.getChildren().addAll(next, image, back);
    stage.setTitle("Lab project");
    stage.setScene(scene);
    stage.show();
  }
  int first = 0;
  public static void main(String[] args){
    launch();
  }
}
