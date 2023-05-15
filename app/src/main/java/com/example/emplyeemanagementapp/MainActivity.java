package com.example.emplyeemanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout leftIcon = findViewById(R.id.left_icon);
        recview=findViewById(R.id.recyclerView);
//       ImageView rightIcon= findViewById(R.id.right_icon);
//        TextView title = findViewById(R.id.toolbar_title);

//
//        leftIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent toDoctordashboard = new Intent(DoctorAppointmentsModuleActivity.this,DoctorDashboardActivity.class);
//                startActivity(toDoctordashboard );
//            }
//        });



        recview.setLayoutManager(new LinearLayoutManager(this));

        processdata();
    }



    public void processdata()
    {
        Call<List<EmployeeModel>> call= ApiController
                .getInstance()
                .getApiSet()
                .getdataEmployee();
        call.enqueue(new Callback<List<EmployeeModel>>() {
            @Override
            public void onResponse(Call<List<EmployeeModel>> call, Response<List<EmployeeModel>> response) {
                List<EmployeeModel> data=response.body();
                System.out.println("printapi;::::::::"+data.toString());
                EmployeeAdapter adapter=new EmployeeAdapter(data);
                recview.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<EmployeeModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
//    public void onBackPressed() {
//        Intent intent = new Intent(DoctorAppointmentsModuleActivity.this,DoctorDashboardActivity.class);
//        startActivity(intent );
//    }
}