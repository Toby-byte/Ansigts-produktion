package com.example.ansigtsproducent;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HelloApplication extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();


    @Override
    //ikke relevant Herfra
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Face");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);
        //ikke relevant Hertil
        drawPrimitiveFace();

        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            gc.clearRect(0, 0, width, height);
            drawPrimitiveFace();
        }));
        timeline.setCycleCount(360);
        timeline.play();
    }

    // master method aka. draws face
    public static void drawPrimitiveFace() {
        drawHeadShape();
        drawNormalMouth();
        drawBeard();
        drawEyes();
    }
    // draw 3 different head shapes
    public static void drawHeadShape() {
        // hoved er normalt 300 pixels
        //gc.strokeOval(150, 150, 300, 300);
        // square headShape
        // gc.strokeRect(150,150,300,300);
        //corner 1
        int corner1PolygonX = Randomizer(50,150);
        int corner1PolygonY = Randomizer(100,150);
        // corner 2
        int corner2PolygonY = Randomizer(50,200);
        // corner 3
        int corner3PolygonX = Randomizer(450,600);
        int corner3PolygonY = Randomizer(100,150);
        // corner 5
        int corner5PolygonY = Randomizer(450,550);
        polygonColor(Randomizer(1,4));
        gc.fillPolygon(new double[] {corner1PolygonX,300,corner3PolygonX,400,300,200}, new double[] {corner1PolygonY,corner2PolygonY,corner3PolygonY,400,corner5PolygonY,400}, 6);
    }

    public static void polygonColor(int faceColor) {
        if (faceColor == 1) {
            gc.setFill(Color.YELLOW);
        } else if (faceColor == 2) {
            gc.setFill(Color.OLIVE);
        } else if (faceColor == 3) {
            gc.setFill(Color.DEEPSKYBLUE);
        }
    }

    public static void drawBeard() {
        // start 200,400
        // slut 400, 400
        for (int x_value=200; x_value<=400; x_value=x_value+3) {
            int y_value = Randomizer(400,500);
            gc.strokeLine(x_value,400,x_value,y_value);

        }
    }

    public static void drawSquareHeadShape() {
        // hoved er normalt 300 pixels
        gc.strokeOval(150, 150, 300, 300);
    }

    // draws 3 different types of mouth
    public static void drawNormalMouth() {
        int mood = Randomizer(1,6);
        gc.setFill(Color.BLACK);
        if (mood == 1) {
            // happy
            gc.strokeArc(250,340,50,50,180,180, ArcType.OPEN);
        } else if (mood == 2) {
            // sad
            gc.strokeArc(250,370,50,50,0,180, ArcType.OPEN);
        } else if (mood == 3) {
            // normal
            gc.strokeLine(250,370,280,370);
        } else if (mood == 4) {
            // very happy
            gc.fillArc(250,340,50,50,180,180, ArcType.CHORD);
        } else if (mood == 5) {
            // very sad
            gc.fillArc(250,370,50,50,0,180, ArcType.CHORD);
        }
    }

    // giver et vilkårligt tal tilbage mellem to tal
    public static int Randomizer(int minNumber, int maxNumber) {
        Random random = new Random();
        int randomizer = random.nextInt(maxNumber-minNumber)+minNumber;
        return randomizer;
    }

    // draws 3 different types of eyes
    public static void drawEyes() {
        // outer eyes
        int outerEyesRandom = Randomizer(40,80);
        // outer eyes
        // inner eyes
        int innerEyesRandom = Randomizer(10,20);
        // inner eyes
        // eye color
        int innerEyesRandomColor = Randomizer(1,6);
        // eye color
        eyeColor(innerEyesRandomColor);
        gc.strokeOval(210,210,outerEyesRandom,outerEyesRandom);
        gc.fillOval(220,220,innerEyesRandom,innerEyesRandom);
        gc.strokeOval(350,210,outerEyesRandom,outerEyesRandom);
        gc.fillOval(360,220,innerEyesRandom,innerEyesRandom);
    }

    public static void eyeColor(int eyeColor) {
       if (eyeColor == 1) {
           gc.setFill(Color.BLACK);
       } else if (eyeColor == 2) {
           gc.setFill(Color.BLUE);
       } else if (eyeColor == 3) {
           gc.setFill(Color.MOCCASIN);
       } else if (eyeColor == 4) {
           gc.setFill(Color.GREEN);
       } else if (eyeColor == 5) {
           gc.setFill(Color.BROWN);
       } else if (eyeColor == 6) {
           gc.setFill(Color.PINK);
       }
    }

    public static void main(String[] args) {
        launch();
    }
}