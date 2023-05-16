package com.example.emplyeemanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EmployeeUI extends AppCompatActivity {

    TextView idTextView,nameTextView,usernameTextView,emailTextView,streetTextView,
            suiteTextView,cityTextView,zipcodeTextView,latTextView,lngTextView,
    phoneTextView,websiteTextView,companynameTextView,catchphraseTextView,bsTextView;

//    emailTextView,lastNameTextView;
//            genderTextView,contactNoTextView,emailIDTextView,reasonTextView,
//            docDepartmentTextView,selectDoctorTextView,appintmentDateTextView,slotTextView;
private EmployeeModel data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_ui);

//        idTextView = findViewById(R.id.textView_Id);
        nameTextView = findViewById(R.id.name_TextView);
        emailTextView = findViewById(R.id.email_TextView);
        streetTextView = findViewById(R.id.suite_TextView);
        suiteTextView = findViewById(R.id.street_TextView);
        cityTextView = findViewById(R.id.city_TextView);
        zipcodeTextView = findViewById(R.id.zipcode_TextView);
//        latTextView = findViewById(R.id.lastName_TextView);
//        lngTextView = findViewById(R.id.lastName_TextView);
        phoneTextView = findViewById(R.id.contact_TextView);
        websiteTextView = findViewById(R.id.website_TextView);
        companynameTextView = findViewById(R.id.companyname_TextView);
//        catchphraseTextView = findViewById(R.id.lastName_TextView);
//        bsTextView = findViewById(R.id.lastName_TextView);

        ImageView leftIcon = findViewById(R.id.left_icon);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toDoctordashboard = new Intent(EmployeeUI.this,MainActivity.class);
                startActivity(toDoctordashboard );
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            data = intent.getParcelableExtra("data");
        }

//        int Id= Intent.GetIntExtra("ID",-1);

        nameTextView.setText(getIntent().getExtras().getString("getName"));
        emailTextView.setText(getIntent().getExtras().getString("getEmail"));
//        usernameTextView.setText(getIntent().getExtras().getString("getUsername"));
        streetTextView.setText(getIntent().getExtras().getString("getStreet"));
        suiteTextView.setText(getIntent().getExtras().getString("getSuite"));
        cityTextView.setText(getIntent().getExtras().getString("getCity"));
        zipcodeTextView.setText(getIntent().getExtras().getString("getZipcode"));
//        latTextView.setText(getIntent().getExtras().getString("getLat"));
//        lngTextView.setText(getIntent().getExtras().getString("getLng"));
        phoneTextView.setText(getIntent().getExtras().getString("getPhone"));
        websiteTextView.setText(getIntent().getExtras().getString("getWebsite"));
        companynameTextView.setText(getIntent().getExtras().getString("getCompanyname"));
//        catchphraseTextView.setText(getIntent().getExtras().getString("getCatchPhrase"));
//        bsTextView.setText(getIntent().getExtras().getString("getBs"));

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EmployeeUI.this,MainActivity.class);
        startActivity(intent );
    }
}