package com.oscaretnia.cuadernodelprofe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends AppCompatActivity {

    @BindView(R.id.btn_signin_action) Button btnSigninAction;
    @BindView(R.id.btn_signup) Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_signin_action, R.id.btn_signup})
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
