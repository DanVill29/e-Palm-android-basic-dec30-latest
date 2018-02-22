package com.example.roldan_villaber.e_palm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {
    Button btnLogout;
    String usr;
    TextView DashboardEmail;
    private SessionManager session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            session.setLogin(false);
        }


        btnLogout = (Button) findViewById(R.id.btnLogout_dashboard);
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
                Intent i = new Intent(DashboardActivity.this,
                        LoginActivity.class);
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
