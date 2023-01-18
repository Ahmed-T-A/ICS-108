package com.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

import java.io.IOException;


public class App2 extends Application {
  int index = (int)(Math.random() * (4));
  public void start (Stage stage){
    Image[] images = new Image[4];
    images[0] = new Image("Arg.png");
    images[1] = new Image("Indea.png");
    images[2] = new Image("Japan.png");
    images[3] = new Image("UK.png");
    ImageView myImage = new ImageView(images[index]);

    HBox buttons = new HBox();
    buttons.setSpacing(10);
    buttons.setPadding(new Insets(5,5,5,5));
    buttons.setAlignment(Pos.CENTER);

    VBox buttonsAndImage = new VBox();
    buttonsAndImage.setSpacing(10);
    buttonsAndImage.setPadding(new Insets(5,5,5,5));
    buttonsAndImage.setAlignment(Pos.CENTER);

    Button next = new Button("Next");
    Button back = new Button("Back");
    Button slideShow = new Button("Slide Show");
    buttons.getChildren().addAll(next, back, slideShow);
    buttonsAndImage.getChildren().addAll(myImage, buttons);

    next.setOnAction(e ->{
      first = (first + 1) % images.length;
      myImage.setImage(images[first]);
    });

    back.setOnAction(e -> {
      first --;
      if (first < 0)
        first = images.length - 1;
      myImage.setImage(images[first]);
    });

    EventHandler<ActionEvent> handler1 = e ->{
      if (index == images.length-1){
        myImage.setImage(images[index - 1]);
        priviousIndex = index;
        index--;
      }
      else if (index == 0){
        myImage.setImage(images[index + 1]);
        priviousIndex = index;
        index++;
      }
      else if (priviousIndex - index < 0){
        myImage.setImage(images[index + 1]);
        priviousIndex = index;
        index++;
      }
      else if (priviousIndex - index > 0){
        myImage.setImage(images[index - 1]);
        priviousIndex = index;
        index--;
      }
    };

    Timeline animation = new Timeline(new KeyFrame(Duration.seconds(2), handler1));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.pause();

    slideShow.setOnAction(e -> { animation.play(); });

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(buttonsAndImage);
    borderPane.setBottom (buttons);
    BorderPane.setAlignment(buttons, Pos.CENTER);

    Scene scene = new Scene(borderPane, 500, 450);
    stage.setScene(scene);

    stage.setTitle("Lab14-15");
    stage.show();
  }
  int first = 0, priviousIndex = 0;
  public static void main(String[] args){
    launch();
  }
  
}
