package com.moeyeo.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    double result=0,val=0;
    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    private Button buttonC, buttonAc, buttonDot;

    private DecimalFormat decimalFormat;
    private TextView showValue, showResult;


    char state = '0';

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0 : showValue.setText(showValue.getText()+"0"); break;
            case R.id.button1 : showValue.setText(showValue.getText()+"1"); break;
            case R.id.button2 : showValue.setText(showValue.getText()+"2"); break;
            case R.id.button3 : showValue.setText(showValue.getText()+"3"); break;
            case R.id.button4 : showValue.setText(showValue.getText()+"4"); break;
            case R.id.button5 : showValue.setText(showValue.getText()+"5"); break;
            case R.id.button6 : showValue.setText(showValue.getText()+"6"); break;
            case R.id.button7 : showValue.setText(showValue.getText()+"7"); break;
            case R.id.button8 : showValue.setText(showValue.getText()+"8"); break;
            case R.id.button9 : showValue.setText(showValue.getText()+"9"); break;
            case R.id.buttonDot : showValue.setText(showValue.getText()+"."); break;
            case R.id.clearButton : {
                if(showValue.getText().length()>0){
                    CharSequence currentValue = showValue.getText();
                    showValue.setText(currentValue.subSequence(0,currentValue.length()-1));
                } else {
                    showValue.setText("");
                }
                break;
            }
            case R.id.acButton : {
                showResult.setText("0");
                result=0;
                state='0';
                val=0;
                break;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().setTitle("Calculator");

        decimalFormat = new DecimalFormat("#.####");

        final Button divButton = (Button) findViewById(R.id.divButton);
        final Button minusButton = (Button) findViewById(R.id.minusButton);
        final Button addButton = (Button) findViewById(R.id.addButton);
        final Button mulButton = (Button) findViewById(R.id.mulButton);
        final Button resButton = (Button) findViewById(R.id.resultButton);

        showValue = (TextView) findViewById(R.id.showVal);
        showResult = (TextView) findViewById(R.id.showResult);

        resButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
                state = '=';
            }
        });

        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
                state = '/';
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
                state = '+';
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
                state = '-';
            }
        });

        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
                state = '*';
            }
        });


        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(this);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);

        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);

        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonDot.setOnClickListener(this);

        buttonC = (Button) findViewById(R.id.clearButton);
        buttonC.setOnClickListener(this);

        buttonAc = (Button) findViewById(R.id.acButton);
        buttonAc.setOnClickListener(this);

}
    public void Calculate(){
        try{
            val = Double.parseDouble(showValue.getText().toString());
            switch (state){
                case '/': result = result/val; break;
                case '+': result = result+val; break;
                case '-': result = result-val; break;
                case '*': result = result*val; break;
                case '0': result = val; break;
                case '=': break;
            }
            showResult.setText(decimalFormat.format(result));
            showValue.setText(null);
        } catch (Exception e){}

    }

}
