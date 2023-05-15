package com.example.emplyeemanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EmployeeUI extends AppCompatActivity {

    TextView fullNameTextView,middleNameTextView,lastNameTextView;
//            genderTextView,contactNoTextView,emailIDTextView,reasonTextView,
//            docDepartmentTextView,selectDoctorTextView,appintmentDateTextView,slotTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_ui);

        fullNameTextView = findViewById(R.id.fullName_TextView);
        middleNameTextView = findViewById(R.id.middleName_TextView);
        lastNameTextView = findViewById(R.id.lastName_TextView);
//        genderTextView = findViewById(R.id.gender_TextView);
//        contactNoTextView = findViewById(R.id.contactNo_TextView);
//        emailIDTextView = findViewById(R.id.emailID_TextView);
//        reasonTextView = findViewById(R.id.reason_TextView);
//        docDepartmentTextView = findViewById(R.id.docDepartment_TextView);
//        selectDoctorTextView = findViewById(R.id.selectDoctor_TextView);
//        appintmentDateTextView = findViewById(R.id.appintmentDate_TextView);
//        slotTextView = findViewById(R.id.slot_TextView);


        ImageView leftIcon = findViewById(R.id.left_icon);



        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toDoctordashboard = new Intent(EmployeeUI.this,MainActivity.class);
                startActivity(toDoctordashboard );
            }
        });


//        doctorIdTextView.setText(getIntent().getExtras().getString("id"));
//        uhidTextView.setText(getIntent().getExtras().getString("getUhid"));
        fullNameTextView.setText(getIntent().getExtras().getString("getName"));
        middleNameTextView.setText(getIntent().getExtras().getString("getUsername"));
        lastNameTextView.setText(getIntent().getExtras().getString("getEmail"));
//        genderTextView.setText(getIntent().getExtras().getString("getGender"));
//        contactNoTextView.setText(getIntent().getExtras().getString("getMobilenumber"));
//        emailIDTextView.setText(getIntent().getExtras().getString("getEmail"));
//        reasonTextView.setText(getIntent().getExtras().getString("getReason"));
//        docDepartmentTextView.setText(getIntent().getExtras().getString("getDepartment"));
//        selectDoctorTextView.setText(getIntent().getExtras().getString("getDoctorname"));
//        appintmentDateTextView.setText(getIntent().getExtras().getString("getDate"));
//        slotTextView.setText(getIntent().getExtras().getString("getSlot"));


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EmployeeUI.this,MainActivity.class);
        startActivity(intent );
    }
}