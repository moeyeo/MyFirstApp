package com.moeyeo.myfirstapplication;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class GradeActivity extends AppCompatActivity {

    private EditText assignmentScore;
    private EditText midtermScore;
    private EditText finalScore;
    private Button confirmButton ;
    private TextView showGrade;
    private RadioButton gradePass,gradeAf;
    private String resultGrade;
    private int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        assignmentScore = (EditText) findViewById(R.id.assignmentScore);
        midtermScore = (EditText) findViewById(R.id.midScore);
        finalScore = (EditText) findViewById(R.id.finalScore);

        gradePass = (RadioButton) findViewById(R.id.gradePass);
        gradeAf = (RadioButton) findViewById(R.id.gradeAf);

        showGrade = (TextView) findViewById(R.id.showGrade);
        confirmButton = (Button) findViewById(R.id.buttonConfirm);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int assignmentResult = Integer.parseInt(assignmentScore.getText().toString());
                int midResult = Integer.parseInt(midtermScore.getText().toString());
                int finalResult = Integer.parseInt(finalScore.getText().toString());

                result = assignmentResult+midResult+finalResult;
                if (gradeAf.isChecked()) {
                    gradePass.setChecked(false);
                    String res = calGradeAf(result);
                    showGrade.setText(res);
                }
                else if(gradePass.isChecked()) {
                    gradeAf.setChecked(false);
                    String res = calGradePass(result);
                    showGrade.setText(res);
                }
                else showGrade.setText("Plase check type grade calculator");


            }
        });

        gradePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gradeAf.setChecked(false);
            }
        });

        gradeAf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gradePass.setChecked(false);
            }
        });

    }


    private String calGradePass(int result) {

        if (result>=50&&result<=100) resultGrade = "Pass";
        else if (result <50) resultGrade = "Not Pass";
        else resultGrade = "input error score must between 0-100)";

        return resultGrade;
    }

    private String calGradeAf(int result) {

        if (result >= 80 &&result<=100) resultGrade = "A";
        else if (result >= 75) resultGrade = "B+ or Pass";
        else if (result >= 70) resultGrade = "B";
        else if (result >= 65) resultGrade = "C+";
        else if (result >= 60) resultGrade = "C";
        else if (result >= 55) resultGrade = "D+";
        else if (result >= 50) resultGrade = "D";
        else if (result>=0) resultGrade = "F";
        else resultGrade = "input error score must between 0-100)";

        return resultGrade;
    }


}
