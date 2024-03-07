package ai;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConfigController {

    @FXML
    private Label lab1;

    @FXML
    private Label lab2;

    @FXML
    private Label lab3;

    @FXML
    private TextField textf1;

    @FXML
    private TextField textf2;

    @FXML
    private TextField textf3;

    @FXML
    private TextField textf4;

    @FXML
    private TextField textf5;

    @FXML
    private TextField textf6;

    @FXML
    private TextField textf7;

    @FXML
    private TextField textf8;

    @FXML
    private TextField textf9;

    private ConfigFileLoader configFileLoader;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setConfigFileLoader(ConfigFileLoader configFileLoader) {
        this.configFileLoader = configFileLoader;
    }

    @FXML
    private void initialize() {
    }

    public void displayConfig(String levelF,String levelM,String levelD) {
        Config configF = configFileLoader.get(levelF);
        Config configM = configFileLoader.get(levelM);
        Config configD = configFileLoader.get(levelD);
        if (configF != null) {
            lab1.setText(configF.level);
            textf1.setText(Integer.toString(configF.hiddenLayerSize));
            textf2.setText(Double.toString(configF.learningRate));
            textf3.setText(Integer.toString(configF.numberOfhiddenLayers));
        }
        if (configM != null) {
            lab2.setText(configM.level);
            textf4.setText(Integer.toString(configM.hiddenLayerSize));
            textf5.setText(Double.toString(configM.learningRate));
            textf6.setText(Integer.toString(configM.numberOfhiddenLayers));
        }
        if (configD != null) {
            lab3.setText(configD.level);
            textf7.setText(Integer.toString(configD.hiddenLayerSize));
            textf8.setText(Double.toString(configD.learningRate));
            textf9.setText(Integer.toString(configD.numberOfhiddenLayers));
        }
    }
    @FXML
    private void handleSaveButtonClick() {
        String line = lab1.getText() + ":" + textf1.getText() + ":" + textf2.getText() + ":" + textf3.getText();
        String line2 = lab2.getText() + ":" + textf4.getText() + ":" + textf5.getText() + ":" + textf6.getText();
        String line3 = lab3.getText() + ":" + textf7.getText() + ":" + textf8.getText() + ":" + textf9.getText();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("config.txt", false))) {
            writer.write(line);
            writer.newLine();
            writer.write(line2);
            writer.newLine();
            writer.write(line3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.close();
    }

}
