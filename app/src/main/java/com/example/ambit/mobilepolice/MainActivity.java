package com.example.ambit.mobilepolice;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private int CALL_PERMISSION_CODE = 2;

    android.support.v7.widget.Toolbar toolbar;

    LinearLayout CradViewLinearLayout, MedicalCardViewLinearLayout;

    CircleImageView call999;

    ImageView reportToPolice;
    TextView reportToPoliceTv;

    ImageView emergencyCall;
    TextView emergencyCallTextView;

    CountDownTimer countDownTimer;
    private long timeLeftInMillisecond = 6000;
    private boolean timeRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CradViewLinearLayout = findViewById(R.id.CradViewLinearLayout);
        Animation defenceCardView  = AnimationUtils.loadAnimation(this, R.anim.bounce);
        CradViewLinearLayout.startAnimation(defenceCardView);

        MedicalCardViewLinearLayout = findViewById(R.id.MedicalCardViewLinearLayout);
        Animation medicalCardView  = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MedicalCardViewLinearLayout.startAnimation(medicalCardView);


        call999 = findViewById(R.id.img_selected);
        Animation call999Anim  = AnimationUtils.loadAnimation(this, R.anim.rotate);
        call999.startAnimation(call999Anim);

        reportToPolice = findViewById(R.id.reportToPolice);
        Animation reportToPoliceAnim  = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
        reportToPolice.startAnimation(reportToPoliceAnim);
        reportToPoliceTv = findViewById(R.id.reportToPoliceTV);
        reportToPoliceTv.startAnimation(reportToPoliceAnim);


        emergencyCall = findViewById(R.id.emergencyCall);
        emergencyCallTextView =findViewById(R.id.emergencyCallText);


    }


    public void ansar(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            String number = "01730038057";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        } else {
            requestStoragePermission();
        }
    }

    public void airForce(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            String number = "01730038057";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        } else {
            requestStoragePermission();
        }
    }

    public void rab(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            String number = "01730038057";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        } else {
            requestStoragePermission();
        }
    }

    public void fireService(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            String number = "+880-2-9555555";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        } else {
            requestStoragePermission();
        }
    }

    public void police(View view) {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            String number = "01769690033";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        } else {
            requestStoragePermission();
        }
    }

    public void call999(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            String number = "999";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        } else {
            requestStoragePermission();
        }
    }

    private void requestStoragePermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)){

            new AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("This Permission is Needed For Call")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE}, CALL_PERMISSION_CODE);


                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();

                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, CALL_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CALL_PERMISSION_CODE){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void reportToPolice(View view) {

        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    public void todatTraffic(View view) {
        Intent intent = new Intent(MainActivity.this, TrafficWebview.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder =  new AlertDialog.Builder(this);

        builder.setMessage("Do you want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                })
                .create().show();


    }

    public void dmc(View view) {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            String number = "8626812";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        } else {
            requestStoragePermission();
        }
    }

    public void berdem(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            String number = "9661551";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        } else {
            requestStoragePermission();
        }
    }

    public void cmh(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            String number = "9871469";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        } else {
            requestStoragePermission();
        }
    }

    public void ssmc(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            String number = "7319002";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        } else {
            requestStoragePermission();
        }
    }

    public void shsmc(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            String number = "9130800";
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        } else {
            requestStoragePermission();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.aboutApp:
                Intent intentForAboutApp = new Intent(MainActivity.this, AboutApp.class);
                startActivity(intentForAboutApp);
                break;

            case R.id.aboutDeveloper:
                Intent intentforDeveloper = new Intent(MainActivity.this, AboutDevelopers.class);
                startActivity(intentforDeveloper);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sosButton(View view) {

        starStop();
    }

//    private void startCountdown() {
//        countDownTimer = new CountDownTimer(timeLeftInMillisecond, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                timeLeftInMillisecond = millisUntilFinished;
//                updateCountDownText();
//
//            }
//
//            @Override
//            public void onFinish() {
//
//            }
//        }.start();
//    }

//    private void updateCountDownText() {
//        int seconds = (int) (timeLeftInMillisecond / 1000);
//
//        String timeFormet = String.format(Locale.getDefault(), "%02d", seconds);
//
//        emergencyCallTextView.setText(timeFormet);
//    }

    public void starStop() {
        if (timeRunning){
            stopTimer();
        }else {
            startTimer();
        }
    }

    public void stopTimer() {
        countDownTimer.cancel();
        timeLeftInMillisecond = 6000;
        emergencyCallTextView.setText("Press The Button For Call Police");
        timeRunning = false;
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillisecond, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timeLeftInMillisecond = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {

                timeLeftInMillisecond = 1;

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "999";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

            }
        }.start();
        emergencyCallTextView.setText("Press The Button For Cencel Call");
        timeRunning = true;
    }

    public void updateTimer() {

        int min = (int) timeLeftInMillisecond / 6000;

        int seconds = (int) timeLeftInMillisecond % 6000 / 1000;

        String timeLeftText;

        timeLeftText = "" + min;
        timeLeftText += "";
        if (seconds<10) timeLeftText +="";
        timeLeftText +=seconds;


        emergencyCallTextView.setText(timeLeftText);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null){
            countDownTimer.cancel();
        }
    }

    public void nearByPoliceStation(View view) {
        Intent intent = new Intent(MainActivity.this, NearByPoliceStation.class);
        startActivity(intent);
    }
}
