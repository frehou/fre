package com.example.taskes;

import java.io.IOException;
import java.util.HashMap;

import ai.ConfigController;
import ai.ConfigFileLoader;
import ai.Coup;
import ai.Test;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LevelController {

    @FXML
    private Button facile;

    @FXML
    private Button difficile;

    @FXML
    private Button moyen;



    @FXML
    private void facileClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("model.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Model");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

