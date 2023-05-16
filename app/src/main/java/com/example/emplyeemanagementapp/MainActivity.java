package com.example.emplyeemanagementapp;

import androidx.databinding.BindingAdapter;

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


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    RecyclerView recview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//    }
//}



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








        if (!ConnectivityUtils.isNetworkConnected(this)) {
            showNoInternetDialog();
        }
    }

    private void showNoInternetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("No Internet Connection");
        builder.setMessage("Please check your internet connection and try again.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish(); // Close the activity or handle appropriately
            }
        });
        builder.setCancelable(false);
        builder.show();

    }
//    public void onBackPressed() {
//        Intent intent = new Intent(DoctorAppointmentsModuleActivity.this,DoctorDashboardActivity.class);
//        startActivity(intent );
//    }
}