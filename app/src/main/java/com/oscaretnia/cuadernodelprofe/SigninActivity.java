package com.oscaretnia.cuadernodelprofe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SigninActivity extends AppCompatActivity {

    @BindView(R.id.btn_signup_action) Button btnSignupAction;
    @BindView(R.id.btn_signin) Button btnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        getSupportActionBar().hide();

        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_signin, R.id.btn_signup_action})
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
