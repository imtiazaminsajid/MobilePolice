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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ambit.mobilepolice.Model.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    EditText registrationEmail, registrationPassword, registrationName, registrationPhone;
    Button registrationButton;
    TextView haveAnAccount;
    ProgressBar registrationprogressBar;
    private ImageView menuRegistration;

    LinearLayout regNameLinerLayout, regEmailLinerLayout, regPhoneLinerLayout ,regPasswordLinerLayout;

    ProgressDialog progressDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registrationEmail = findViewById(R.id.registrationEmailId);
        registrationPassword = findViewById(R.id.registrationPassword);
        registrationName = findViewById(R.id.registrationName);
        registrationPhone = findViewById(R.id.registrationPhoneId);

        registrationButton  = findViewById(R.id.registrationButton);
        Animation registrationButtonAnim  = AnimationUtils.loadAnimation(this, R.anim.bounce);
        registrationButton.startAnimation(registrationButtonAnim);

        haveAnAccount = findViewById(R.id.registrationHaveAccount);
        registrationprogressBar = findViewById(R.id.registrationProgressBar);

        mAuth = FirebaseAuth.getInstance();

        registrationButton.setOnClickListener(this);
        haveAnAccount.setOnClickListener(this);

        menuRegistration= findViewById(R.id.menuRegistration);
        menuRegistration.setOnClickListener(this);

        progressDialog = new ProgressDialog(RegistrationActivity.this);

        regNameLinerLayout = findViewById(R.id.regNameLinerLayout);
        Animation regNameLinerLayoutAnim  = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        regNameLinerLayout.startAnimation(regNameLinerLayoutAnim);

        regEmailLinerLayout = findViewById(R.id.regEmailLinerLayout);
        Animation regEmailLinerLayoutAnim  = AnimationUtils.loadAnimation(this, R.anim.righttoleft);
        regEmailLinerLayout.startAnimation(regEmailLinerLayoutAnim);

        regPhoneLinerLayout = findViewById(R.id.regPhoneLinerLayout);
        Animation regPhoneLinerLayoutAnim  = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        regPhoneLinerLayout.startAnimation(regPhoneLinerLayoutAnim);

        regPasswordLinerLayout = findViewById(R.id.regPasswordLinerLayout);
        Animation regPasswordLinerLayoutAnim  = AnimationUtils.loadAnimation(this, R.anim.righttoleft);
        regPasswordLinerLayout.startAnimation(regPasswordLinerLayoutAnim);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.registrationButton:

                registration();

                break;

            case R.id.registrationHaveAccount:
                finish();
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                break;

            case R.id.menuRegistration:
                finish();
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
                break;

        }

    }

    private void registration() {

        final String email = registrationEmail.getText().toString().trim();
        final String password = registrationPassword.getText().toString().trim();
        final String name = registrationName.getText().toString().trim();
        final String phone = registrationPhone.getText().toString().trim();

        if(email.isEmpty())
        {
            registrationEmail.setError("Enter an email address");
            registrationEmail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            registrationEmail.setError("Enter a valid email address");
            registrationEmail.requestFocus();
            return;
        }

        if(phone.isEmpty())
        {
            registrationPassword.setError("Enter a Phone");
            registrationPassword.requestFocus();
            return;
        }

        if(phone.length()<11)
        {
            registrationPassword.setError("Minimum length of a phone should be 11");
            registrationPassword.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            registrationPassword.setError("Enter a password");
            registrationPassword.requestFocus();
            return;
        }

        if(password.length()<6)
        {
            registrationPassword.setError("Minimum length of a password should be 6");
            registrationPassword.requestFocus();
            return;
        }


        progressDialog.setTitle("Wait");
        progressDialog.setMessage("Registration on Going");
        progressDialog.show();


        //registrationprogressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Users users = new Users(name, email, phone, password);

                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            progressDialog.dismiss();

                            //registrationprogressBar.setVisibility(View.GONE);

                            if (task.isSuccessful()){
                                finish();

                                Toast.makeText(RegistrationActivity.this, "Registation Is Successfull", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });



                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "User Email is Already Registered", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}
