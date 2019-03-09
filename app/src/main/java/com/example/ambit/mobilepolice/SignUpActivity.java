package com.example.ambit.mobilepolice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText signInEmail, signInPassword;
    Button signInButton;
    TextView dontHaveAccount;

    LinearLayout signInEmailLinearLayout, signInPasswordLinearLayout;

    private FirebaseAuth mAuth;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signInEmail = findViewById(R.id.signInEmail);
        signInPassword = findViewById(R.id.signInPassword);
        signInButton = findViewById(R.id.signInButton);

        signInEmailLinearLayout =  findViewById(R.id.signInEmailLinearLayout);
        signInPasswordLinearLayout =  findViewById(R.id.signInPasswordLinearLayout);

        Animation emailAnim  = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        signInEmailLinearLayout.startAnimation(emailAnim);

        Animation passAnim  = AnimationUtils.loadAnimation(this, R.anim.righttoleft);
        signInPasswordLinearLayout.startAnimation(passAnim);

        Animation buttonAnim  = AnimationUtils.loadAnimation(this, R.anim.bounce);
        signInButton.startAnimation(buttonAnim);

        dontHaveAccount = findViewById(R.id.signinDontHaveAccount);

        signInButton.setOnClickListener(this);
        dontHaveAccount.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(SignUpActivity.this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.signInButton:

                signIn();


                break;

            case R.id.signinDontHaveAccount:
                finish();
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
                break;

        }

    }


    private void signIn() {

        String email = signInEmail.getText().toString().trim();
        String password = signInPassword.getText().toString().trim();

        if(email.isEmpty())
        {
            signInEmail.setError("Enter an email address");
            signInEmail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signInEmail.setError("Enter a valid email address");
            signInEmail.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            signInPassword.setError("Enter a password");
            signInPassword.requestFocus();
            return;
        }

        if(password.length()<6)
        {
            signInPassword.setError("Minimum length of a password should be 6");
            signInPassword.requestFocus();
            return;
        }

        progressDialog.setTitle("Wait");
        progressDialog.setMessage("SignIn on Going");
        progressDialog.show();

        //progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                //progressBar.setVisibility(View.GONE);
                progressDialog.dismiss();

                if (task.isSuccessful()){
                    finish();
                    Intent intent = new Intent(getApplicationContext(), ReportToPolice.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else {

                    Toast.makeText(getApplicationContext(), "Sign In Failed", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
