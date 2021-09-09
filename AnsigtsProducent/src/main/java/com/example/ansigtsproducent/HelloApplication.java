package com.example.ansigtsproducent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
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

    public static void drawPrimitiveFace() {
        drawHeadShape();
        drawMouth();
        drawEyes();
    }

    public static void drawHeadShape() {
        // scanner object lavet
        Scanner scanner = new Scanner(System.in);
        // spørger bruger
        System.out.println("Hvilken størrelse vil du gerne have hovedet? skriv i pixels");
        // bruger input bliver brugt
        int hovedDiameter = scanner.nextInt();
        // indsætter pixels i diameter
        // hoved er normalt 300 pixels
        gc.strokeOval(150, 150, hovedDiameter, hovedDiameter);
    }

    public static void drawMouth() {
        // scanner object lavet
        Scanner scanner = new Scanner(System.in);
        // spørger bruger
        System.out.println("Hvilken størrelse vil du gerne have din mund? skriv i pixels");
        // bruger input bliver brugt
        int mundDiameter = scanner.nextInt();
        // indsætter pixels i diameter
        // mund er normalt 50 pixels
        gc.setFill(Color.BLACK);
        gc.fillOval(275,370,mundDiameter,mundDiameter);
    }

    public static void drawEyes() {
        // scanner object lavet
        Scanner scanner = new Scanner(System.in);
        // spørger bruger
        System.out.println("Hvilken størrelse vil du gerne have dine øjne? skriv i pixels");
        // bruger input bliver brugt
        int øjneDiameter = scanner.nextInt();
        // indsætter pixels i diameter
        // øjne er normalt 20 pixels
        gc.setFill(Color.BLACK);
        gc.fillOval(220,220,øjneDiameter,øjneDiameter);
        gc.fillOval(360,220,øjneDiameter,øjneDiameter);
    }

    public static void main(String[] args) {
        System.out.println("Hvordan vil du gerne have dit vilkårlige ansigt i dag?");
        launch();
    }
}