package com.example.ooplab10;


import calculator.CalculatorProcessor;
import calculator.ICalculator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import result.Result;

public class HelloController {
    @FXML
    private TextField countIntervalField;
    @FXML
    private TextField threadsField;
    @FXML
    private Label infoIntegralLabel;
    @FXML
    private Label infoTimeLabel;
    public void Integral() {
        ICalculator calculator = new CalculatorProcessor();
        Result res = calculator.calculatorIntegral(Integer.parseInt(countIntervalField.getText()), Integer.parseInt(threadsField.getText()));
        infoIntegralLabel.setText("Значення iнтегралу: "+(res.integral()));
        infoTimeLabel.setText("Витрачено часу: "+(res.time()));
    }
}