package com.example.roldan_villaber.e_palm;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Dialog;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUserName, editTextPassword;
    Button btnLogin;
    Context context = this;
    LoginDataBaseAdapter loginDataBaseAdapter;
    private SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // setting default screen to login.xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            session.setLogin(false);
        }


        //Initialize
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        editTextUserName = (EditText) findViewById(R.id.login_email);
        editTextPassword = (EditText) findViewById(R.id.login_password);
        btnLogin = (Button) findViewById(R.id.btnLogin);


        // Listening to login
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                final Dialog dialog = new Dialog(LoginActivity.this);
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String storedPassword = loginDataBaseAdapter
                        .getSinlgeEntry(userName);
                String userEmail = loginDataBaseAdapter
                        .getUsername(userName);
                if (password.equals(storedPassword)) {
                    Toast.makeText(LoginActivity.this,
                            "Congrats: Login Successfull" + userEmail, Toast.LENGTH_LONG)
                            .show();
                    dialog.dismiss();

                    Intent main = new Intent(LoginActivity.this, DashboardForAndroidApp.class);
                    main.putExtra("userEmail", userEmail);
                    startActivity(main);
                    session.setLogin(true);

                } else {
                    Toast.makeText(LoginActivity.this,
                            "User Name or Password does not match",
                            Toast.LENGTH_LONG).show();
                }
            }
        });



        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);

        // Listening to register new account link
        registerScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }
}
