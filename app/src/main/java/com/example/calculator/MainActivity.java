package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String operation = "";
    private Double first;
    private Double second;
    private Boolean isOperationClick;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text0);
    }
    public void onNumberClick(View view) {


        if (view instanceof MaterialButton) {
            String text = ((MaterialButton) view).getText().toString();
            if (text.equals("AC")) {
                textView.setText("0");
                first = 0.0;
                second = 0.0;
            } else if (textView.getText().toString().equals("0") || isOperationClick) {
                textView.setText(text);
            } else if (textView.getText().toString().contains(".0")) {
                textView.append(".");

            } else {
                textView.append(text);
            }
            isOperationClick = false;
        }
    }


    public void onOperationClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        Double sum;
        switch (text) {
            case "+":
                first = Double.parseDouble(textView.getText().toString());
                operation = "+";
                isOperationClick = true;
                break;
            case "-":
                first = Double.parseDouble(textView.getText().toString());
                operation = "-";
                isOperationClick = true;
                break;
            case "/":
                first = Double.parseDouble(textView.getText().toString());
                operation = "/";
                isOperationClick = true;
                break;
            case ".":
                first = Double.parseDouble(textView.getText().toString());
                operation = ".";
                isOperationClick = true;
                break;
            case "x":
                first = Double.parseDouble(textView.getText().toString());
                operation = "x";
                isOperationClick = true;
                break;

            case "%":
                if (first != null) {
                    double value = Double.parseDouble(textView.getText().toString());
                    value = first * (value / 100.0);
                    textView.setText(cancelDouble(value));
                    isOperationClick = true;
                }
                break;

            case "C":
                String currentText = textView.getText().toString();
                if (!currentText.isEmpty()) {
                    currentText = currentText.substring(0, currentText.length() - 1);
                }
                if (currentText.isEmpty()) {
                    currentText = "0";
                }
                textView.setText(currentText);
                isOperationClick = true;
                break;



            case "=":

                second = Double.parseDouble(textView.getText().toString());
                switch (operation) {
                    case "+":
                    case ".":
                        sum = first + second;
                        textView.setText(cancelDouble(sum));
                        break;
                    case "-":
                        sum = first - second;
                        textView.setText(cancelDouble(sum));
                        break;
                    case "/":
                        sum = first / second;
                        textView.setText(cancelDouble(sum));
                        break;
                    case "x":
                        sum = first * second;
                        textView.setText(cancelDouble(sum));
                        break;

                }

                isOperationClick = true;
                break;
        }
    }

    private String cancelDouble(Double number) {
        String text = number.toString();
        if (text.endsWith(".0")) {
            return text.substring(0, text.length() - 2);
        } else {
            return number.toString();
        }
    }
}