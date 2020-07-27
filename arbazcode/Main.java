package com.blogspot.arbazcode;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("design.fxml"));
        GridPane gridPane = loader.load();

        controller = loader.getController();
        controller.setXO();
        controller.setInitialValue();

        Pane menuPane = (Pane)gridPane.getChildren().get(9);
        MenuBar menuBar = createMenu();
        menuPane.getChildren().add(menuBar);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    private MenuBar createMenu()
    {
        Menu file = new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        MenuItem quit = new MenuItem("Quit");

        Menu help = new Menu("Help");

        MenuItem aboutMe = new MenuItem("About Me");
        MenuItem aboutGame = new MenuItem("How to Play");

        file.getItems().addAll(newGame,quit);
        help.getItems().addAll(aboutMe,aboutGame);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(file,help);

        newGame.setOnAction(event -> {
            controller.resetGame();
        });

        quit.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });

        aboutMe.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About Me");
            alert.setHeaderText("Arbaz Wassan");
            alert.setContentText("My name is Arbaz Wassan and I am a Softwer Engineer currently working in an MNC company called VIRTUSA");
            alert.show();
        });

        aboutGame.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("How to Play");
            alert.setHeaderText("How to Play");
            alert.setContentText("The game is played on a grid that's 3 squares by 3 squares.\n" +
                    "You are X, your friend is O. Players take turns putting their marks in empty squares.\n" +
                    "The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.\n" +
                    "When all 9 squares are full, the game is over");
            alert.show();
        });

        return menuBar;
    }
}
