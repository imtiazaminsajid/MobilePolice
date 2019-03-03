package com.example.ambit.mobilepolice;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ambit.mobilepolice.Model.Report;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class ReportToPolice extends AppCompatActivity implements LocationListener {

    private static final int IMAGE_REQUEST = 1;
    private static final int CAMERA_REQUEST = 1;

    Bitmap photo;

    DatabaseReference databaseReference;
    StorageReference storageReference;
    StorageTask storageTask;

    EditText locationNameET, phoneNumberET, complainET;
    Button submitToPolice;
    TextView dateAndTimeET;

    CardView img_chooser, camera_btn;

    private Uri imageUri = null;

    LocationManager locationManager;

    CircleImageView capturePicture;

    double longitude;
    double latitude;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_to_police);

        locationNameET = findViewById(R.id.locationNameET);
        dateAndTimeET = findViewById(R.id.timeAndDateET);
        phoneNumberET = findViewById(R.id.phoneNumberET);
        complainET = findViewById(R.id.complainET);

        img_chooser = findViewById(R.id.img_chooser);
        camera_btn = findViewById(R.id.camera_btn);


        capturePicture = findViewById(R.id.capturePicture);

        submitToPolice = findViewById(R.id.submitToPolice);

        databaseReference = FirebaseDatabase.getInstance().getReference("Reports");
        storageReference = FirebaseStorage.getInstance().getReference("Uploads");

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm aaa");
        String time = format.format(calendar.getTime());
        dateAndTimeET.setText(time);



        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);
        onLocationChanged(location);

    }

//    public void askForLocation(){
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//            Location location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//            onLocationChanged(location);
//
//        } else {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
//                Snackbar.make(findViewById(android.R.id.content),
//                        "Needs Contacts write permission",
//                        Snackbar.LENGTH_INDEFINITE).setAction("ENABLE",
//                        new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                ActivityCompat.requestPermissions(ReportToPolice.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 6);
//                            }
//                        }).show();
//            } else {
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 6);
//            }
//        }
//
//    }

    private void openFileChoser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_REQUEST);
    }

    public void openCamera(){

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK){
//            photo = (Bitmap) data.getExtras().get("data");
//            // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
////            mImageUri = getImageUri(this, photo);
//            capturePicture.setVisibility(View.VISIBLE);
//            capturePicture.setImageBitmap(photo);
////            Picasso.get().load(mImageUri).into(showIV);
//        }

        if (requestCode==IMAGE_REQUEST && resultCode == RESULT_OK && data!=null && data.getData()!=null){
            imageUri = data.getData();
            Picasso.with(this).load(imageUri).into(capturePicture);
            capturePicture.setVisibility(View.VISIBLE);
        }


    }

    public void img_chosser(View view) {
        openFileChoser();
    }

    public void camera_btn(View view) {
        //openCamera();
    }

    public String getFileExtention(Uri imageUri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageUri));
    }

    private void submitData() {

        final String dateAndTime = dateAndTimeET.getText().toString().trim();
        final String locationName =  locationNameET.getText().toString().trim();
        final String complain = complainET.getText().toString().trim();
        final String phoneNum = phoneNumberET.getText().toString().trim();
        final double lat = latitude;
        final double lon = longitude;


        if (locationName.isEmpty()){
            locationNameET.setError("Enter Location");
            locationNameET.requestFocus();
            return;
        }
        if (complain.isEmpty()){
            complainET.setError("Enter Complain");
            complainET.requestFocus();
            return;
        }
        if (phoneNum.isEmpty()){
            phoneNumberET.setError("Enter Number");
            phoneNumberET.requestFocus();
            return;
        }

        if (imageUri == null){
            Toast.makeText(this, "Select a Photo", Toast.LENGTH_SHORT).show();
            return;
        }


        StorageReference reference = storageReference.child(System.currentTimeMillis()+"."+getFileExtention(imageUri));


        //alertProgressBar.setVisibility(View.VISIBLE);

        reference.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        //alertProgressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Alert Message Updated Successfully", Toast.LENGTH_SHORT).show();

                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();

                        while (!uriTask.isSuccessful());

                        Uri downloadUri = uriTask.getResult();

                        Report report = new Report(dateAndTime, locationName, complain, downloadUri.toString(), phoneNum, lat, lon);

                        String reportID = databaseReference.push().getKey();
                        databaseReference.child(reportID).setValue(report);

                        finish();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);




                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(getApplicationContext(), "Alert Message Updated Failed", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public void submitToPolice(View view) {
        if (storageTask!=null && storageTask.isInProgress()){
            Toast.makeText(getApplicationContext(), "Submit in Progress", Toast.LENGTH_SHORT).show();
        } else {

            submitData();
        }
    }


    //For Location

    @Override
    public void onLocationChanged(Location location) {

        longitude = location.getLongitude();
        latitude = location.getLatitude();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void homeButton(View view) {
        Intent intent = new Intent(ReportToPolice.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
