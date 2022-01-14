package com.example.patnugot_calculator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button zero, one, two, three, four, five, six, seven, eight, nine;
    private Button add, subtract, multiply, divide, decimal;
    private Button equal, clear;
    private TextView input, result;
    private final char addition = '+';
    private final char subtraction = '-';
    private final char multiplication = '*';
    private final char division = '/';
    private final char equals = 0;
    private double var1 = Double.NaN; //not a number
    private double var2;
    private char action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSetup();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + "9");
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString() + ".");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = addition;
                result.setText(String.valueOf(var1) + "+");
                input.setText(null);
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = subtraction;
                result.setText(String.valueOf(var1) + "-");
                input.setText(null);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = multiplication;
                result.setText(String.valueOf(var1) + "*");
                input.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = division;
                result.setText(String.valueOf(var1) + "/");
                input.setText(null);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = equals;
                result.setText(result.getText().toString() + String.valueOf(var2) + "=" + String.valueOf(var1));
                input.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.getText().length() > 0) {
                    CharSequence numbers = input.getText().toString();
                    input.setText(numbers.subSequence(0, numbers.length() - 1));
                } else {
                    var1 = Double.NaN;
                    var2 = Double.NaN;
                    input.setText(null);
                    result.setText(null);
                }
            }
        });
    }

    private void buttonSetup() {
        zero = (Button) findViewById(R.id.zerobtn);
        one = (Button) findViewById(R.id.onebtn);
        two = (Button) findViewById(R.id.twobtn);
        three = (Button) findViewById(R.id.threebtn);
        four = (Button) findViewById(R.id.fourbtn);
        five = (Button) findViewById(R.id.fivebtn);
        six = (Button) findViewById(R.id.sixbtn);
        seven = (Button) findViewById(R.id.sevenbtn);
        eight = (Button) findViewById(R.id.eightbtn);
        nine = (Button) findViewById(R.id.ninebtn);
        add = (Button) findViewById(R.id.plusbtn);
        subtract = (Button) findViewById(R.id.minusbtn);
        multiply = (Button) findViewById(R.id.multiplybtn);
        divide = (Button) findViewById(R.id.dividebtn);
        decimal = (Button) findViewById(R.id.decimal);
        clear = (Button) findViewById(R.id.clearbtn);
        equal = (Button) findViewById(R.id.equal);
        input = (TextView) findViewById(R.id.input);
        result = (TextView) findViewById(R.id.answer);
    }

    private void compute() {
        if (!Double.isNaN(var1)) {
            var2 = Double.parseDouble(input.getText().toString());
            switch (action) {
                case addition:
                    var1 = var1 + var2;
                    break;
                case subtraction:
                    var1 = var1 - var2;
                    break;
                case multiplication:
                    var1 = var1 * var2;
                    break;
                case division:
                    var1 = var1 / var2;
                    break;
                case equals:
                    break;

            }
        } else {
            var1 = Double.parseDouble(input.getText().toString());
        }

    }
}