package com.example.project.tabianconsulting;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText mUsername;
    EditText mPassword;
    EditText mConfirmPassword;
    EditText mEmail;
    Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText) findViewById(R.id.email_login);
        mUsername = (EditText) findViewById(R.id.username_login);
        mPassword = (EditText) findViewById(R.id.password_login);
        mConfirmPassword = (EditText) findViewById(R.id.cnfr_password_login);

        mLogin = (Button) findViewById(R.id.login_button);


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isValid(mUsername.getText().toString()) && isValid(mPassword.getText().toString())
                        && isValid(mConfirmPassword.getText().toString()) && isValid(mEmail.getText().toString())) {

                    if (testEmail(mEmail.getText().toString()))
                        Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();

                    else
                        Toast.makeText(LoginActivity.this, "Enter valid Email address", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(LoginActivity.this, "You must fill all the fields properly !", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    public boolean testEmail(String email) {
        String domain = email.substring(email.indexOf("@") + 1);
        return domain.contains(".");
    }

    public boolean isValid(String text) {
        return !TextUtils.isEmpty(text) && !text.contains(" ");
    }


}
