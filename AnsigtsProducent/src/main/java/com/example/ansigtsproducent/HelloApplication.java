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
        gc.strokePolygon(new double[] {150,300,450,300,200}, new double[] {150,200,150,450,400}, 5);
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


    public static void drawMouth1() {
        gc.setFill(Color.BLACK);
        gc.fillOval(275,370,50,50);
    }

    public static void drawMouth2() {
        gc.setFill(Color.BLACK);
        gc.fillOval(275,370,50,50);
    }

    // draws 3 different types of eyes
    public static void drawNormalEyes() {
        gc.setFill(Color.BLACK);
        gc.strokeOval(210,210,45,45);
        gc.fillOval(220,220,20,20);
        gc.strokeOval(350,210,45,45);
        gc.fillOval(360,220,20,20);
    }

    public static void drawEyes1() {
        gc.fillRoundRect(220,220,20,50,20, 20);
        gc.fillRoundRect(360,220,20,70,20,20);
    }

    public static void drawEyes2() {
        gc.fillRoundRect(220,220,5,50,20, 20);
        gc.fillRoundRect(360,220,5,70,20,20);
    }

    public static void main(String[] args) {
        launch();
    }
}