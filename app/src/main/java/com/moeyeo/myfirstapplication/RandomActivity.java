package com.moeyeo.myfirstapplication;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        getSupportActionBar().setTitle("Random Number");

        Button random_button = (Button) findViewById(R.id.randomButton);
        final EditText minNum = (EditText) findViewById(R.id.minInput);
        final EditText maxNum = (EditText) findViewById(R.id.maxInput);
        final TextView showResult = (TextView) findViewById(R.id.showResult);

        random_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int min = Integer.parseInt(minNum.getText().toString());
                    int max = Integer.parseInt(maxNum.getText().toString());
                    showResult.setText(""+Random(min,max));
                } catch (Exception e){new AlertDialog.Builder(RandomActivity.this).setMessage("Incorrect input!").show();}

            }

            public int Random(int min, int max){
                Random ran = new Random();
                return (ran.nextInt(max-min) + min);
            }
        });

    }

}
