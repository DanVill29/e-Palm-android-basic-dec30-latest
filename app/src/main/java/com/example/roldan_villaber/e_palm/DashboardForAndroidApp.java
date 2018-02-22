package com.example.roldan_villaber.e_palm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardForAndroidApp extends AppCompatActivity {

    Button btnLogout,btnStudyMaterials,btnExercise,btnModules;
    String usr;
    TextView DashboardEmail;
    private SessionManager session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_xml_ui_design);

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            session.setLogin(false);
        }


        btnLogout = (Button) findViewById(R.id.btnLogout_dashboard);
        btnStudyMaterials = (Button) findViewById(R.id.dashboard_redir_modules);
        btnExercise = (Button) findViewById(R.id.dashboard_redir_exercises);
        btnModules = (Button) findViewById(R.id.dashboard_redir_subjectinfo1);

        DashboardEmail = (TextView) findViewById(R.id.email_dashboard);


        //get data from previous activity
        String name = this.getIntent().getStringExtra("userEmail");
        /*
        Toast.makeText(DashboardActivity.this,
                "Hey" + name, Toast.LENGTH_LONG)
                .show(); */
        DashboardEmail.setText(name);


        btnLogout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Account Successfully Log-out! ", Toast.LENGTH_LONG)
                        .show();
                session.setLogin(false);
                Intent i = new Intent(DashboardForAndroidApp.this,
                        LoginActivity.class);
                startActivity(i);
                finish();

            }
        });


        btnStudyMaterials.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(DashboardForAndroidApp.this,
                        AndroidVideoPlayer.class);
                startActivity(i);
                finish();

            }
        });


        btnExercise.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(DashboardForAndroidApp.this,
                        ExerciseActivity.class);
                startActivity(i);
                finish();

            }
        });


        btnModules.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(DashboardForAndroidApp.this,
                        ModuleActivity.class);
                startActivity(i);
                finish();

            }
        });


    }



    public void goToSo (View view) {
        goToUrl ( "http://www.e-palm.net/login_student.php");
    }



    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}