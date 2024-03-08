package application;

import ai.ConfigController;
import ai.ConfigFileLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuBarController {
    @FXML
    MenuItem config;

    @FXML
    MenuItem models;
    private ConfigFileLoader configFileLoader;

    public MenuBarController() {
        configFileLoader = new ConfigFileLoader();
    }

    @FXML
    private void handleConfigMenuItemClick() {

        configFileLoader.loadConfigFile("config.txt");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("lireConfig.fxml"));
            Parent root = loader.load();

            ConfigController configController = loader.getController();
            configController.setConfigFileLoader(configFileLoader);
            configController.displayConfig("F","M","D");

            Stage stage = new Stage();
            stage.setTitle("Lire Config");
            stage.setScene(new Scene(root));
            configController.setStage(stage);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void aiClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("level.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Level");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void model() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("repmodel.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Repmodel");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
