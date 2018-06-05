package com.moeyeo.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gradingFunction(View view) {
        Toast.makeText(this, "Grading Clicked!", Toast.LENGTH_SHORT).show();

    }

    public void calFunction(View view) {
        Intent intent = new Intent(this, Cal.class);
        startActivity(intent);
    }

    public void randomFunction(View view) {
    }

}
