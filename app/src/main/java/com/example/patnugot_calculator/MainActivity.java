package com.example.patnugot_calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String oldNum="";
    String op = "+";
    boolean newOp = true;
    EditText input;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        clear=findViewById(R.id.clearbtn);


    }



    public void numberSetup(View view) {
        if(newOp)
            input.setText("");
        newOp = false;
        String number = input.getText().toString();
        switch (view.getId()){
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

    public void operatorSetup(View view) {
        newOp = true;
        oldNum = input.getText().toString();
        switch (view.getId()){
                case R.id.dividebtn:
                op = "/";
                break;
                case R.id.multiplybtn:
                op = "*";
                break;
                case R.id.plusbtn:
                op = "+";
                break;
                case R.id.minusbtn:
                op = "-";
                break;
        }
    }

    public void solution(View view) {
        String newNumber = input.getText().toString();
        double result = 0.0;
        switch (op){
            case "addition":
                result = Double.parseDouble(oldNum)+ Double.parseDouble(newNumber);
                break;
            case "subtraction":
                result = Double.parseDouble(oldNum)- Double.parseDouble(newNumber);
                break;
            case "multiplication":
                result = Double.parseDouble(oldNum)* Double.parseDouble(newNumber);
                break;
            case "division":
                result = Double.parseDouble(oldNum)/ Double.parseDouble(newNumber);
                break;
        }
        input.setText(result+"");

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.getText().length() > 0) {
                    CharSequence numbers = input.getText().toString();
                    input.setText(numbers.subSequence(0, numbers.length() - 1));
                }
            }
        });
    };
}