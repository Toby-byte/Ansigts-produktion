package com.example.ansigtsproducent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

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
    }

    // master method aka. draws face
    public static void drawPrimitiveFace() {
        drawHeadShape();
        drawNormalMouth();
        drawNormalEyes();
    }
    // draw 3 different head shapes
    public static void drawHeadShape() {
        // hoved er normalt 300 pixels
        //gc.strokeOval(150, 150, 300, 300);
        // square headShape
        // gc.strokeRect(150,150,300,300);
        gc.strokePolygon(new double[] {150,300,450,400,300,200}, new double[] {150,200,150,400,450,400}, 6);
    }

    public static void drawTriangularHeadShape() {
        // hoved er normalt 300 pixels
        gc.strokeOval(150, 150, 300, 300);
    }

    public static void drawSquareHeadShape() {
        // hoved er normalt 300 pixels
        gc.strokeOval(150, 150, 300, 300);
    }

    // draws 3 different types of mouth
    public static void drawNormalMouth() {
        /*
        gc.setFill(Color.BLACK);
        gc.fillOval(250,370,50,50);
        */
        gc.strokeArc(250,370,50,50,180,180, ArcType.OPEN);
    }

    // giver et vilkårligt tal tilbage mellem to tal
    public static int Randomizer(int minNumber, int maxNumber) {
        Random random = new Random();
        int randomizer = random.nextInt(maxNumber-minNumber)+minNumber;
        return randomizer;
    }

    // draws 3 different types of eyes
    public static void drawNormalEyes() {
        // outer eyes
        int outerEyesRandom = Randomizer(40,80);
        // outer eyes
        // inner eyes
        int innerEyesRandom = Randomizer(10,20);
        // inner eyes
        // eye color
        int innerEyesRandomColor = Randomizer(1,6);
        // eye color
        System.out.println("Outer eyes is: "+outerEyesRandom);
        System.out.println("Inner eyes is: "+innerEyesRandom);
        System.out.println("Inner eyes color is: "+innerEyesRandomColor);

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
           gc.setFill(Color.YELLOW);
       } else if (eyeColor == 4) {
           gc.setFill(Color.GREEN);
       } else if (eyeColor == 5) {
           gc.setFill(Color.PURPLE);
       } else if (eyeColor == 6) {
           gc.setFill(Color.PINK);
       }
    }

    public static void main(String[] args) {
        System.out.println(Randomizer(1,10));
        launch();
    }
}