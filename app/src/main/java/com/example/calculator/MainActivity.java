package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String operation = "";
    private Double first, second, sum;
    private Boolean isOperationClick;
    private MaterialButton sendButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text0);
    }


    public void onNumberClick(View view) {

        sendButton = findViewById(R.id.send);
        if (view instanceof MaterialButton) {
            String text = ((MaterialButton) view).getText().toString();
            if (text.equals("AC")) {
                textView.setText("0");
                sendButton.setVisibility(View.INVISIBLE);
                first = 0.0;
                second = 0.0;
            } else if (textView.getText().toString().equals("0") || isOperationClick) {
                textView.setText(text);
                sendButton.setVisibility(View.INVISIBLE);
            } else if (textView.getText().toString().contains(".0")) {
                textView.append(".");
                sendButton.setVisibility(View.INVISIBLE);

            } else {
                textView.append(text);
            }
            isOperationClick = false;
        }
    }


    public void onOperationClick(View view) {
        sendButton = findViewById(R.id.send);
        String text = ((MaterialButton) view).getText().toString();
        switch (text) {
            case "+":
                first = Double.parseDouble(textView.getText().toString());
                operation = "+";
                isOperationClick = true;
                sendButton.setVisibility(View.INVISIBLE);
                break;
            case "-":
                first = Double.parseDouble(textView.getText().toString());
                operation = "-";
                isOperationClick = true;
                sendButton.setVisibility(View.INVISIBLE);
                break;
            case "/":
                first = Double.parseDouble(textView.getText().toString());
                operation = "/";
                isOperationClick = true;
                sendButton.setVisibility(View.INVISIBLE);
                break;
            case ".":
                first = Double.parseDouble(textView.getText().toString());
                operation = ".";
                isOperationClick = true;
                sendButton.setVisibility(View.INVISIBLE);
                break;
            case "x":
                first = Double.parseDouble(textView.getText().toString());
                operation = "x";
                isOperationClick = true;
                sendButton.setVisibility(View.INVISIBLE); // Скрываем кнопку "Result"
                break;

            case "%":
                if (first != null) {
                    double value = Double.parseDouble(textView.getText().toString());
                    value = first * (value / 100.0);
                    textView.setText(cancelDouble(value));
                    isOperationClick = true;
                }
                sendButton.setVisibility(View.INVISIBLE);
                break;

            case "+/-":
                double value = Double.parseDouble(textView.getText().toString());
                value *= -1;
                textView.setText(cancelDouble(value));
                isOperationClick = true;
                sendButton.setVisibility(View.INVISIBLE);
                break;


            case "=":

                second = Double.parseDouble(textView.getText().toString());
                if (operation.equals("+")) {
                    sum = first + second;
                    textView.setText(cancelDouble(sum));
                    sendButton.setVisibility(View.VISIBLE);
                } else if (operation.equals("-")) {
                    sum = first - second;
                    textView.setText(cancelDouble(sum));
                    sendButton.setVisibility(View.VISIBLE);
                } else if (operation.equals("/")) {
                    sum = first / second;
                    textView.setText(cancelDouble(sum));
                    sendButton.setVisibility(View.VISIBLE);
                } else if (operation.equals("x")) {
                    sum = first * second;
                    textView.setText(cancelDouble(sum));
                    sendButton.setVisibility(View.VISIBLE);
                } else if (operation.equals(".")) {
                    sum = first + second;
                    textView.setText(cancelDouble(sum));
                    sendButton.setVisibility(View.VISIBLE);

                }

                isOperationClick = true;
                break;


        }
    }

    private String cancelDouble(Double number) {
        String text = number.toString();
        if (text.substring(text.length() - 2).equals(".0")) {
            return text.substring(0, text.length() - 2);
        } else {
            return number.toString();
        }
    }

    public void onSendClick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("result", textView.getText().toString());
        startActivity(intent);
    }

}