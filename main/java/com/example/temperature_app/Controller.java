package com.example.temperature_app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public boolean ISc2f =true;
    @FXML
    public Label welcomeLabel;
    @FXML
    public TextField tempratureTEXT;
    @FXML
    public ChoiceBox choiceBox;
    @FXML
    public Button Convertbtn;

    public static final String C2F = "celcius to fahrenheit ";
    public static final String F2C = "fahrenheit to celcius ";



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.getItems().add(C2F);
        choiceBox.getItems().add(F2C);
        choiceBox.setValue(C2F);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            if (t1.equals(C2F)) {
                ISc2f=true;
            }
            else {
                ISc2f = false;
            }
        });
        Convertbtn.setOnAction(Event-> {
            Convert();
        });



    }

    private void Convert() {
        float EnterTemprature = 0.0f;

        String input =tempratureTEXT.getText();
        try {
            EnterTemprature = Float.parseFloat(input);

        }
        catch (Exception e){
            warnuser();
            return;
        }
        float newtemp = 0.0f;

        if (ISc2f){
            newtemp=(EnterTemprature * 9 / 5) + 32;
        }
        else {
            newtemp = (EnterTemprature-32) * 5 / 9;
        }

        display(newtemp);

    }

    private void warnuser() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText("Wrong credential Entered");
        alert.setContentText("please enter valid Temperature" );
        alert.show();
    }

    private void display(float newtemp) {
        String unit = ISc2f ? "F" : "C";
//        System.out.println("The new Temperature : "+ newtemp+"'" +unit  );

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("RESULT");
        alert.setHeaderText("The converted Temprature is");
        alert.setContentText("The is Temperature : "+ newtemp+"'" +unit  );
        alert.show();
    }
}
