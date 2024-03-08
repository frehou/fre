package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
        	int size = 0;
        	double learningRate = 0.0;
        	int hiddenLayers=0;
            // Lire la première ligne du fichier config.txt
            BufferedReader configReader = new BufferedReader(new FileReader("config.txt"));
            String configLine;

            while ((configLine = configReader.readLine()) != null) {
                String[] configValues = configLine.split(":");
                if (configValues.length >= 4 && configValues[0].equals("F")) {
                     size = Integer.parseInt(configValues[1]);
                     learningRate = Double.parseDouble(configValues[2]);
                     hiddenLayers = Integer.parseInt(configValues[3]);
                }
            }
            configReader.close();

            // Construire le nom du fichier à créer
            String fileName = "model_" + size + "_" + hiddenLayers + "_" + learningRate + ".srl";
            System.out.println(fileName);

            // Vérifier si le fichier existe dans le répertoire models
            File modelsDirectory = new File("/home/nas-wks01/users/uapv2200719/eclipse-workspace/exam/src/exam/hellotest/models");
            File[] modelFiles = modelsDirectory.listFiles();
            boolean modelExists = false;

            if (modelFiles != null) {
                for (File modelFile : modelFiles) {
                	 System.out.println(modelFile.getName());
                    if (modelFile.getName().equals(fileName)) {
                        modelExists = true;
                        System.out.println(modelExists);
                        break;
                    }
                }
            }

            if (!modelExists) {
                // Créer le fichier s'il n'existe pas
                FileWriter fileWriter = new FileWriter(modelsDirectory.getPath() + File.separator + fileName);
                // Vous pouvez ajouter des données supplémentaires au fichier si nécessaire
                fileWriter.close();
                // Rediriger vers "model.fxml" si le fichier existe
                FXMLLoader loader = new FXMLLoader(getClass().getResource("model.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Model");
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Model");
                stage.setScene(new Scene(root));
                stage.show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void moyenClick() {
        try {
        	int size = 0;
        	double learningRate = 0.0;
        	int hiddenLayers=0;
            // Lire la première ligne du fichier config.txt
            BufferedReader configReader = new BufferedReader(new FileReader("config.txt"));
            String configLine;

            while ((configLine = configReader.readLine()) != null) {
                String[] configValues = configLine.split(":");
                if (configValues.length >= 4 && configValues[0].equals("M")) {
                     size = Integer.parseInt(configValues[1]);
                     learningRate = Double.parseDouble(configValues[2]);
                     hiddenLayers = Integer.parseInt(configValues[3]);
                }
            }
            configReader.close();

            // Construire le nom du fichier à créer
            String fileName = "model_" + size + "_" + hiddenLayers + "_" + learningRate + ".srl";
            System.out.println(fileName);

            // Vérifier si le fichier existe dans le répertoire models
            File modelsDirectory = new File("/home/nas-wks01/users/uapv2200719/eclipse-workspace/exam/src/exam/hellotest/models");
            File[] modelFiles = modelsDirectory.listFiles();
            boolean modelExists = false;

            if (modelFiles != null) {
                for (File modelFile : modelFiles) {
                	 System.out.println(modelFile.getName());
                    if (modelFile.getName().equals(fileName)) {
                        modelExists = true;
                        System.out.println(modelExists);
                        break;
                    }
                }
            }

            if (!modelExists) {
                // Créer le fichier s'il n'existe pas
                FileWriter fileWriter = new FileWriter(modelsDirectory.getPath() + File.separator + fileName);
                // Vous pouvez ajouter des données supplémentaires au fichier si nécessaire
                fileWriter.close();
                // Rediriger vers "model.fxml" si le fichier existe
                FXMLLoader loader = new FXMLLoader(getClass().getResource("model.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Model");
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Model");
                stage.setScene(new Scene(root));
                stage.show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void dificileClick() {
        try {
        	int size = 0;
        	double learningRate = 0.0;
        	int hiddenLayers=0;
            // Lire la première ligne du fichier config.txt
            BufferedReader configReader = new BufferedReader(new FileReader("config.txt"));
            String configLine;

            while ((configLine = configReader.readLine()) != null) {
                String[] configValues = configLine.split(":");
                if (configValues.length >= 4 && configValues[0].equals("D")) {
                     size = Integer.parseInt(configValues[1]);
                     learningRate = Double.parseDouble(configValues[2]);
                     hiddenLayers = Integer.parseInt(configValues[3]);
                }
            }
            configReader.close();

            // Construire le nom du fichier à créer
            String fileName = "model_" + size + "_" + hiddenLayers + "_" + learningRate + ".srl";
            System.out.println(fileName);

            // Vérifier si le fichier existe dans le répertoire models
            File modelsDirectory = new File("/home/nas-wks01/users/uapv2200719/eclipse-workspace/exam/src/exam/hellotest/models");
            File[] modelFiles = modelsDirectory.listFiles();
            boolean modelExists = false;

            if (modelFiles != null) {
                for (File modelFile : modelFiles) {
                	 System.out.println(modelFile.getName());
                    if (modelFile.getName().equals(fileName)) {
                        modelExists = true;
                        System.out.println(modelExists);
                        break;
                    }
                }
            }

            if (!modelExists) {
                // Créer le fichier s'il n'existe pas
                FileWriter fileWriter = new FileWriter(modelsDirectory.getPath() + File.separator + fileName);
                // Vous pouvez ajouter des données supplémentaires au fichier si nécessaire
                fileWriter.close();
                // Rediriger vers "model.fxml" si le fichier existe
                FXMLLoader loader = new FXMLLoader(getClass().getResource("model.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Model");
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Model");
                stage.setScene(new Scene(root));
                stage.show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}