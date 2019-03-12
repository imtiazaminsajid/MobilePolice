package com.example.ambit.mobilepolice;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NearByPoliceStation extends AppCompatActivity implements View.OnClickListener {

    private int CALL_PERMISSION_CODE = 2;

    ImageView DemraPoliceStation,
            AdaborPoliceStation,
            BaddaPoliceStation,
            BananiPoliceStation,
            BangshalPoliceStation,
            BimanbondorPoliceStation,
            CantonmentPoliceStation,
            ChalkbazarPoliceStation,
            DakshinkhanPoliceStation,
            DarusSalamPoliceStation,
            GandariaPoliceStation, DhanmondiPoliceStation,GulshanPoliceStation,HazaribagPoliceStation,
            JatrabariPoliceStation,KafrulPoliceStation,KalabaganPoliceStation,KamrangircharPoliceStation,
            KhilgaonPoliceStation,KhilkhetPoliceStation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_police_station);

        findViewById(R.id.DemraPoliceStation).setOnClickListener(this);
        findViewById(R.id.AdaborPoliceStation).setOnClickListener(this);
        findViewById(R.id.BaddaPoliceStation).setOnClickListener(this);
        findViewById(R.id.BananiPoliceStation).setOnClickListener(this);
        findViewById(R.id.BangshalPoliceStation).setOnClickListener(this);
        findViewById(R.id.DarusSalamPoliceStation).setOnClickListener(this);
        findViewById(R.id.DakshinkhanPoliceStation).setOnClickListener(this);
        findViewById(R.id.ChalkbazarPoliceStation).setOnClickListener(this);
        findViewById(R.id.CantonmentPoliceStation).setOnClickListener(this);
        findViewById(R.id.BimanbondorPoliceStation).setOnClickListener(this);

        findViewById(R.id.GandariaPoliceStation).setOnClickListener(this);
        findViewById(R.id.DhanmondiPoliceStation).setOnClickListener(this);
        findViewById(R.id.GulshanPoliceStation).setOnClickListener(this);
        findViewById(R.id.HazaribagPoliceStation).setOnClickListener(this);
        findViewById(R.id.JatrabariPoliceStation).setOnClickListener(this);
        findViewById(R.id.KafrulPoliceStation).setOnClickListener(this);
        findViewById(R.id.KalabaganPoliceStation).setOnClickListener(this);
        findViewById(R.id.KamrangircharPoliceStation).setOnClickListener(this);
        findViewById(R.id.KhilgaonPoliceStation).setOnClickListener(this);
        findViewById(R.id.KhilkhetPoliceStation).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.DemraPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801199883727";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.AdaborPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801199867799";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.BaddaPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801191001155";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.BananiPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801769058053";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.BangshalPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801199883723";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.DarusSalamPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801191001166";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.DakshinkhanPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801191001188";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.ChalkbazarPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801199883724";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.CantonmentPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801713373172";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.BimanbondorPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801191001166";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.GandariaPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801199883733";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.DhanmondiPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801199883622";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.GulshanPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801191001144";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.HazaribagPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801199883722";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.JatrabariPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801199883729";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.KafrulPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801769914772";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.KalabaganPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801713398339";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.KhilgaonPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801191003388";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.KhilkhetPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801199883611";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;

            case R.id.KamrangircharPoliceStation:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    String number = "+8801199883725";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + number));
                    startActivity(intent);
                } else {
                    requestStoragePermission();
                }

                break;



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

                            ActivityCompat.requestPermissions(NearByPoliceStation.this, new String[] {Manifest.permission.CALL_PHONE}, CALL_PERMISSION_CODE);


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
}
