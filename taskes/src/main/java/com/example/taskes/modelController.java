package com.example.taskes;


import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.HashMap;

import ai.MultiLayerPerceptron;

import ai.Coup;
import ai.SigmoidalTransferFunction;
import javafx.stage.Stage;


public class modelController {

    @FXML
    TextField erreur;
    @FXML
    ProgressBar probar;
    @FXML
    Button Apprentissage;

    public static HashMap<Integer, Coup> loadCoupsFromFile(String file){
        System.out.println("loadCoupsFromFile from "+file+" ...");
        HashMap<Integer, Coup> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] sIn = s.split("\t")[0].split(" ");
                String[] sOut = s.split("\t")[1].split(" ");

                double[] in = new double[sIn.length];
                double[] out = new double[sOut.length];

                for (int i = 0; i < sIn.length; i++) {
                    in[i] = Double.parseDouble(sIn[i]);
                }

                for (int i = 0; i < sOut.length; i++) {
                    out[i] = Double.parseDouble(sOut[i]);
                }

                Coup c = new Coup(9, "");
                c.in = in ;
                c.out = out ;
                map.put(map.size(), c);
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("Test.loadCoupsFromFile()");
            e.printStackTrace();
            System.exit(-1);
        }
        return map ;
    }

    public MultiLayerPerceptron learne(int size, HashMap<Integer, Coup> mapTrain, int h, double lr, int l, boolean verbose, double epochs){
        try {
            if ( verbose ) {
                System.out.println();
                System.out.println("START TRAINING ...");
                System.out.println();
            }
            //
            //			int[] layers = new int[]{ size, 128, 128, size };
            int[] layers = new int[l+2];
            layers[0] = size ;
            for (int i = 0; i < l; i++) {
                layers[i+1] = h ;
            }
            layers[layers.length-1] = size ;
            //

            MultiLayerPerceptron net = new MultiLayerPerceptron(layers, lr, new SigmoidalTransferFunction());
            if ( verbose ) {
                System.out.println("---");
                System.out.println("Load data ...");
                System.out.println("---");
            }
            probar.progressProperty().unbind();
            probar.setProgress(0);

            Task<Double> task = new Task<Double>() {
                @Override
                protected Double call() throws Exception {
                    System.out.println("Task ...");
                    double error = 0.0 ;
                    //TRAINING ...
                    for(int i = 0; i < epochs; i++){

                        Coup c = null ;
                        while ( c == null )
                            c = mapTrain.get((int)(Math.round(Math.random() * mapTrain.size())));

                        error += net.backPropagate(c.in, c.out);

                        if ( i % 10000 == 0 && verbose) erreur.setText("Error at step "+i+" is "+ (error/(double)i));
                        updateProgress(i,epochs);
                    }
                    if ( verbose )
                        System.out.println("Learning completed!");

                    return error ;

                }
            };

            probar.progressProperty().bind(task.progressProperty());

            Thread thread = new Thread(task);

            thread.start();
            System.out.println("Task complete ...");

        }
        catch (Exception e) {
            System.out.println("Test.learn()");
            e.printStackTrace();
            System.exit(-1);
        }

        return null ;
    }

    public void apprends() {
        double epochs = 10000 ;
        HashMap<Integer, Coup> mapTrain = loadCoupsFromFile("train.txt");
        learne(9,mapTrain,128,0.5,2,true,epochs);
    }

}

