package com.moeyeo.myfirstapplication;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class GradeActivity extends AppCompatActivity {

    private EditText Assignment ;
    private EditText Midterm ;
    private EditText Final ;
    private Button confirmButton ;
    private TextView show_grade;
    private RadioButton grade_pass,grade_af;
    private boolean type;
    //@RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        getSupportActionBar().setTitle("Grade Calculator");

        Assignment = (EditText) findViewById(R.id.AssignmentScore);
        Midterm = (EditText) findViewById(R.id.MidScore);
        Final = (EditText) findViewById(R.id.FinalScore);
        //grade_pass = (RadioButton) findViewById(R.id.grade_pass);
        //grade_af = (RadioButton) findViewById(R.id.grade_af);

        confirmButton = (Button) findViewById(R.id.buttonConfirm);

        calGreadeAf();


    }

    /*public void SelectType(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.grade_af:
                if(checked) type = false; break;
            case R.id.grade_pass:
                if(checked) type = true; break;
        }
    }*/
    private void calGreadePass() {
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //BottomGradeLayout bottomGradeLayout = new BottomGradeLayout();
                //bottomGradeLayout.show(getSupportFragmentManager(),"bottomGrade");

                int assignment_score = Integer.parseInt(Assignment.getText().toString());
                int mid_score = Integer.parseInt(Midterm.getText().toString());
                int final_score = Integer.parseInt(Final.getText().toString());

                show_grade = (TextView) findViewById(R.id.showGrade);
                int result = assignment_score+mid_score+final_score;
                String result_grade = new String();

                if(result<=100&&result>=0) {
                    if (result >= 50 && result <= 100) result_grade = "Pass";
                    else if (result < 50) result_grade = "Not Pass";

                    show_grade.setText(result_grade);
                }
                else
                {
                    show_grade.setText("input error (score 0-100)");

                }

            }
        });
    }

    private void calGreadeAf() {

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //BottomGradeLayout bottomGradeLayout = new BottomGradeLayout();
                //bottomGradeLayout.show(getSupportFragmentManager(),"bottomGrade");

                int assignment_score = Integer.parseInt(Assignment.getText().toString());
                int mid_score = Integer.parseInt(Midterm.getText().toString());
                int final_score = Integer.parseInt(Final.getText().toString());

                show_grade = (TextView) findViewById(R.id.showGrade);
                int result = assignment_score+mid_score+final_score;
                String result_grade = new String();

                if(result<=100&&result>=0) {
                    if (result >= 80 && result <= 100) result_grade = "Grade A";
                    else if (result >= 75 && result <= 79) result_grade = "Grade B+";
                    else if (result >= 70 && result <= 74) result_grade = "Grade B";
                    else if (result >= 65 && result <= 69) result_grade = "Grade C+";
                    else if (result >= 60 && result <= 64) result_grade = "Grade C";
                    else if (result >= 55 && result <= 59) result_grade = "Grade D+";
                    else if (result >= 50 && result <= 54) result_grade = "Grade D";
                    else if (result < 50) result_grade = "Grade F";

                    show_grade.setText(result_grade);
                }
                else
                {
                    show_grade.setText("input error (score 0-100)");

                }

            }
        });


    }
}
