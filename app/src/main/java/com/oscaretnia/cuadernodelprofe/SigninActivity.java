package com.oscaretnia.cuadernodelprofe;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SigninActivity extends AppCompatActivity {

    @BindView(R.id.btn_signup_action) Button btnSignupAction;
    @BindView(R.id.btn_signin) Button btnSignin;
    @BindView(R.id.email_field_signin) EditText emailField;
    @BindView(R.id.password_field_signin) EditText passwordField;

    private FirebaseAuth mAuth;

    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        getSupportActionBar().hide();

        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @OnClick({R.id.btn_signin, R.id.btn_signup_action})
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_signup_action:
                goSignup();
                break;

            case R.id.btn_signin:
                email = emailField.getText().toString().trim();
                password = passwordField.getText().toString().trim();

                if(email.isEmpty() || password.isEmpty())
                    showMessage("Campo vacío");
                else
                    signin(email, password);
                break;

        }

    }


    private void signin(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) showMessage("Authentication success.");
                        else showMessage("Authentication failed");
                    }
                });
        
    }

    private void goSignup() {

        Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
        startActivity(intent);
    }

    private void showMessage(String message) {
        Toast.makeText(
                getApplicationContext(),
                message,
                Toast.LENGTH_SHORT)
                .show();
    }
}
