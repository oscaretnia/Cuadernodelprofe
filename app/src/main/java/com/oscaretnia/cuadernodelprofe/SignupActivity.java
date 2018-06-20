package com.oscaretnia.cuadernodelprofe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSigninAction;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

        btnSigninAction = findViewById(R.id.btn_signin_action);
        btnSignup = findViewById(R.id.btn_signup);

        btnSigninAction.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_signin_action:
                goSignin();
                break;

            case R.id.btn_signup:
                signup();
                break;

        }

    }

    private void signup() {

    }

    private void goSignin() {

        Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
        startActivity(intent);

    }
}
