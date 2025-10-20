/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab07;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author 2493077
 */
public class Lab07 extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle circle = new Circle(50, 50, 30, Color.AQUAMARINE);
        TranslateTransition ttrans = new TranslateTransition(new Duration(3000), circle);
        ttrans.setToX(500);
        ttrans.setToY(500);
        ttrans.setCycleCount(Animation.INDEFINITE);
        ttrans.setAutoReverse(false);
        ttrans.play();
        stage.show();
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane, 800, 800);
        stage.setScene(scene);
        stage.show();
    }
    
}

