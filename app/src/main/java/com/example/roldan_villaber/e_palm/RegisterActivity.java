package com.example.roldan_villaber.e_palm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;



public class RegisterActivity extends AppCompatActivity {

    EditText editTextUserName, editTextPassword;
    Button btnCreateAccount;
    Context context = this;
    LoginDataBaseAdapter loginDataBaseAdapter;
    private SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set View to register.xml
        setContentView(R.layout.activity_register);

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            session.setLogin(false);
        }

        //Initialize
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        editTextUserName = (EditText) findViewById(R.id.reg_email);
        editTextPassword = (EditText) findViewById(R.id.reg_password);
        btnCreateAccount = (Button) findViewById(R.id.btnRegister);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();

                if (userName.equals("") || password.equals("")
                      ) {

                    Toast.makeText(getApplicationContext(), "Field Vaccant",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                    loginDataBaseAdapter.insertEntry(userName, password);
                    Toast.makeText(getApplicationContext(),
                            "Account Successfully Created ", Toast.LENGTH_LONG)
                            .show();
                    Intent i = new Intent(RegisterActivity.this,
                            LoginActivity.class);
                    startActivity(i);
                    finish();


            }
        });



        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);

        // Listening to Login Screen link
        loginScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Closing registration screen
                // Switching to Login Screen/closing register screen
                finish();
            }
        });
    }
}
