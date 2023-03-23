package com.example.temperature_app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Temperature extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init");
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("TEMPERATURE!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(event -> System.out.println("TEMPERATURE"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tempApp.fxml"));
        VBox root = loader.load();
        StackPane nodeRoot = new StackPane();
        nodeRoot.getChildren().add(btn);

        // Create menu bar
        MenuBar menubar = createMenu();
//        createMenu(menubar);

        root.getChildren().add(0,menubar);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private MenuBar createMenu() {
        // Create menu
        MenuBar menubar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem newmi = new MenuItem("New");
        newmi.setOnAction(actionEvent -> System.out.println("new menu selected"));
        MenuItem quitmi = new MenuItem("Quit");
        quitmi.setOnAction(Event -> {
            System.out.println("quit selected ");
            Platform.exit();
            System.exit(0);
        });

        fileMenu.getItems().addAll(newmi, quitmi);
        Menu helpMenu = new Menu("Help");
        MenuItem mi1 = new MenuItem("About");
        mi1.setOnAction(Event-> {
            System.out.println("about selected");
            aboutApp();

        });
        MenuItem mi2 = new MenuItem("How to Play");
        mi2.setOnAction(Event->{
            Alert ap = new Alert(Alert.AlertType.INFORMATION);
            ap.setTitle("my firt desktop app");
            ap.setHeaderText("how it works");
            ap.setContentText("just simply select which type of conversion you want and click on convert button ");
            ButtonType nobtn= new ButtonType("OK");
            ap.getButtonTypes().setAll(nobtn);
            ap.show();
        });
        helpMenu.getItems().addAll(mi1, mi2);
        menubar.getMenus().addAll(fileMenu, helpMenu);
        return menubar;
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("stop");
    }

    public void aboutApp(){
        Alert ap = new Alert(Alert.AlertType.INFORMATION);
        ap.setTitle("my firt desktop app");
        ap.setHeaderText("About");
        ap.setContentText("It is a Temperature Converter Tool , helps you to covert Temperature into celsius to fahrenheit and fahrenheit to celsius ");
        ButtonType okbtn= new ButtonType("OK");
        ap.getButtonTypes().setAll(okbtn);
        ap.show();

    }


}

