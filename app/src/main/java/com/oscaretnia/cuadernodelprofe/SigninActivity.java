package com.oscaretnia.cuadernodelprofe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSignupAction;
    private Button btnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        getSupportActionBar().hide();

        btnSignupAction = findViewById(R.id.btn_signup_action);
        btnSignin = findViewById(R.id.btn_signin);
        
        btnSignupAction.setOnClickListener(this);
        btnSignin.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_signup_action:
                goSignup();
                break;

            case R.id.btn_signin:
                signin();
                break;

        }

    }

    private void signin() {

        Intent intent = new Intent(SigninActivity.this, HomeActivity.class);
        startActivity(intent);
        
    }

    private void goSignup() {

        Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
        startActivity(intent);
    }
}
