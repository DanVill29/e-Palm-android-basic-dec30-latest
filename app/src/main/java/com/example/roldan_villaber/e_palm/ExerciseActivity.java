package com.example.roldan_villaber.e_palm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExerciseActivity extends AppCompatActivity {
    Button btnBackDashboard;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);


        btnBackDashboard = (Button) findViewById(R.id.btnBackDash_exercises);

        btnBackDashboard.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(ExerciseActivity.this,
                        DashboardForAndroidApp.class);
                startActivity(i);
                finish();

            }
        });
    }
}
