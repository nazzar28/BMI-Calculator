package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BMICalculator extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Starting the application..."); // Вывод для отладки

        Label weightLabel = new Label("Enter weight (kg):");
        TextField weightInput = new TextField();

        Label heightLabel = new Label("Enter height (m):");
        TextField heightInput = new TextField();

        Button calculateButton = new Button("Count BMI");

        Label resultLabel = new Label();
        Label statusLabel = new Label();

        calculateButton.setOnAction(event -> {
            try {
                double weight = Double.parseDouble(weightInput.getText());
                double height = Double.parseDouble(heightInput.getText());

                double bmi = weight / (height * height);

                resultLabel.setText(String.format("Your BMI: %.2f", bmi));

                String status;
                if (bmi < 18.5) {
                    status = "Not enough weight";
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    status = "Normal BMI";
                } else if (bmi >= 25 && bmi < 29.9) {
                    status = "Way too much weight";
                } else {
                    status = "Fat";
                }
                statusLabel.setText("Status: " + status);
            } catch (NumberFormatException e) {
                resultLabel.setText("Error: enter correct variables for weight and height.");
                statusLabel.setText("");
            }
        });

        VBox vbox = new VBox(10, weightLabel, weightInput, heightLabel, heightInput, calculateButton, resultLabel, statusLabel);
        vbox.setPadding(new Insets(10));
        vbox.setStyle("-fx-alignment: center;");

        Scene scene = new Scene(vbox, 300, 250);

        stage.setTitle("BMI Калькулятор");
        stage.setScene(scene);
        stage.show();

        System.out.println("Application started.");
    }


    public static void main(String[] args) {
        launch();
    }
}
