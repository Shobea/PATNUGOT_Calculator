package com.example.patnugot_calculator;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String oldNum="";
    String op = "+";
    boolean NewOp = true;
    EditText input;
    Button clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clear= findViewById(R.id.clearbtn);
        input = findViewById(R.id.input);
    }

    public void numberSetup(View view) {
        if(NewOp) //If a button is clicked, input will be cleared. (Default zero is removed)
            input.setText("");
        NewOp = false;
        String number = input.getText().toString();
        switch (view.getId()){         //When buttons are clicked, the numbers will concatenate
            case R.id.onebtn:
                number += "1";
                break;
            case R.id.twobtn:
                number += "2";
                break;
            case R.id.threebtn:
                number += "3";
                break;
            case R.id.fourbtn:
                number += "4";
                break;
            case R.id.fivebtn:
                number += "5";
                break;
            case R.id.sixbtn:
                number += "6";
                break;
            case R.id.sevenbtn:
                number += "7";
                break;
            case R.id.eightbtn:
                number += "8";
                break;
            case R.id.ninebtn:
                number += "9";
                break;
            case R.id.zerobtn:
                number += "0";
                break;
            case R.id.decimal:
                number += ".";
                break;
        }
        input.setText(number);
    }

    public void operatorSetup(View view) { //when button is clicked, op is assigned to an operator. Once button is clicked, input will be stored to oldNum
        NewOp = true;
        oldNum = input.getText().toString();
        switch (view.getId()){
            case R.id.plusbtn:
                op = "+";
            break;

            case R.id.minusbtn:
                op = "-";
                break;

            case R.id.multiplybtn:
                op = "*";
            break;

            case R.id.dividebtn:
                op = "/";
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    public void solution(View view) { //If = button is clicked, new input will be stored to newNumber
        String newNumber = input.getText().toString();
        double result = 0.0;
        switch (op){ //Depending on the button clicked in operatorSetup, the numbers will be calculated according to the operator
            case "+":
                result = Double.parseDouble(oldNum)+ Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNum)- Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNum)* Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNum)/ Double.parseDouble(newNumber);
                break;
        }
        input.setText(result+"");

        clear.setOnClickListener(view1 -> { //delete numbers one by one, from right to left
            if (input.getText().length()>0) {
                CharSequence numbers =input.getText().toString();
                input.setText(numbers.subSequence(0, numbers.length()-1));
        }
    });
}}