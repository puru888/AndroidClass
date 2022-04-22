package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText input = null;
    boolean addition = false;
    boolean subtraction = false;
    boolean decimal = false;
    float firstInputHalf = 0f;
    float secondInputHalf = 0f;
    float answer = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
        Button one = findViewById(R.id.btn_one);
        Button two = findViewById(R.id.btn_two);
        Button three = findViewById(R.id.btn_three);
        Button four = findViewById(R.id.btn_four);
        Button five = findViewById(R.id.btn_five);
        Button six = findViewById(R.id.btn_six);
        Button seven = findViewById(R.id.btn_seven);
        Button eight = findViewById(R.id.btn_eight);
        Button nine = findViewById(R.id.btn_nine);
        Button zero = findViewById(R.id.btn_zero);
        Button clear = findViewById(R.id.btn_c);
        Button plus = findViewById(R.id.btn_plus);
        Button minus = findViewById(R.id.btn_minus);
        Button dot = findViewById(R.id.btn_dot);
        Button equal = findViewById(R.id.btn_equal);
        input = findViewById(R.id.input_text);

        one.setOnClickListener(this::btn_action);
        two.setOnClickListener(this::btn_action);
        three.setOnClickListener(this::btn_action);
        four.setOnClickListener(this::btn_action);
        five.setOnClickListener(this::btn_action);
        six.setOnClickListener(this::btn_action);
        seven.setOnClickListener(this::btn_action);
        eight.setOnClickListener(this::btn_action);
        nine.setOnClickListener(this::btn_action);
        zero.setOnClickListener(this::btn_action);
        clear.setOnClickListener(this::btn_action);
        plus.setOnClickListener(this::btn_action);
        minus.setOnClickListener(this::btn_action);
        dot.setOnClickListener(this::btn_action);
        equal.setOnClickListener(this::btn_action);



    }


    public void btn_action(View view) {

        switch (view.getId()){
            case R.id.btn_one:
                input.append("1");
                break;
            case R.id.btn_two:
                input.append("2");
                break;
            case R.id.btn_three:
                input.append("3");
                break;
            case R.id.btn_four:
                input.append("4");
                break;
            case R.id.btn_five:
                input.append("5");
                break;
            case R.id.btn_six:
                input.append("6");
                break;
            case R.id.btn_seven:
                input.append("7");
                break;
            case R.id.btn_eight:
                input.append("8");
                break;
            case R.id.btn_nine:
                input.append("9");
                break;
            case R.id.btn_zero:
                input.append("0");
                break;
            case R.id.btn_c:
                input.setText("");
                break;
            case R.id.btn_dot:
                decimal = true;
                input.append(".");
                break;
            case R.id.btn_plus:
                addition = true;
                firstInputHalf = Float.parseFloat(input.getText().toString());
                input.setText("");
                break;
            case R.id.btn_minus:
                subtraction = true;
                firstInputHalf = Float.parseFloat(input.getText().toString());
                input.setText("");
                break;
            case R.id.btn_equal:
                secondInputHalf = Float.parseFloat(input.getText().toString());
                if (decimal){
                    if (addition){
                        answer = firstInputHalf+secondInputHalf;
                        addition = false;
                    }else {
                        answer = firstInputHalf-secondInputHalf;
                        subtraction = false;
                    }

                    input.setText(Float.toString(answer));
                }else{
                    if (addition){
                        answer = firstInputHalf+secondInputHalf;
                        addition = false;
                    }else {
                        answer = firstInputHalf-secondInputHalf;
                        subtraction = false;
                    }
                    input.setText(Integer.toString(Math.round(answer)));
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

    }

    @Override
    public void onClick(View view) {

    }
}