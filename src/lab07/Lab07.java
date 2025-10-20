/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab07;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
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
        
        Path rectPath = new Path();
        rectPath.getElements().add(new MoveTo(200,200));
        rectPath.getElements().add(new LineTo(500,200));
        rectPath.getElements().add(new LineTo(500,500));
        rectPath.getElements().add(new LineTo(200,500));
        rectPath.getElements().add(new ClosePath());
        rectPath.setStroke(Color.BLACK);
        
        Circle circle = new Circle(200, 200, 10);
        circle.setFill(Color.BLUE);
        circle.setStroke(Color.BLUE);
        
        Ellipse ellipse = new Ellipse(350, 350, 60, 50);
        ellipse.setFill(Color.RED);
        
        
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(10000));
        pathTransition.setNode(circle);
        pathTransition.setPath(rectPath);
        pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
        
        
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(2500), ellipse);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.1);
        fadeTransition.setCycleCount(1);
        
        
        
        
        
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2500), ellipse);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(2);
        scaleTransition.setToY(2);
        scaleTransition.setCycleCount(1);
        
        
        
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(2500), ellipse);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2500), ellipse);
        translateTransition.setFromX(350);
        translateTransition.setFromY(350);
        translateTransition.setByY(50);

        
        SequentialTransition seq = new SequentialTransition(fadeTransition, scaleTransition, rotateTransition, translateTransition);
        seq.play();
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        pane.getChildren().add(rectPath);
        pane.getChildren().add(ellipse);
        
        Button start = new Button("START");
        start.setOnAction(e -> {
            seq.play();
            pathTransition.play();
        });
        
        Button reset = new Button("RESET");
        reset.setOnAction(e -> {
            seq.play();
            pathTransition.play();
        });
        
        Button exit = new Button("EXIT");
        exit.setOnAction(e -> {
            seq.stop();
            pathTransition.stop();
        });
        
        HBox hb = new HBox(10, start, reset, exit);
        hb.setAlignment(Pos.CENTER);
        VBox root = new VBox(pane, hb);
        
        
        Scene scene = new Scene(root, 700, 800);
        stage.setScene(scene);
        stage.show();
    }
    
}

