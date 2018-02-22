package com.example.roldan_villaber.e_palm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModuleActivity extends AppCompatActivity {
    Button btnBackDashboard;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);


        btnBackDashboard = (Button) findViewById(R.id.btnBackDash_module);

        btnBackDashboard.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(ModuleActivity.this,
                        DashboardForAndroidApp.class);
                startActivity(i);
                finish();

            }
        });
    }
}

