package com.example.emplyeemanagementapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.myviewloder> {



    private Context mContext;
    private TextView mLog;
    APIendpoints userService;
    List<EmployeeModel> data;

    public EmployeeAdapter(List<EmployeeModel> data) {
        this.data = data;
        this.mContext=mContext;

    }

    @NonNull
    @Override
    public myviewloder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign_employee, parent, false);
        return new myviewloder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewloder holder, int position) {
        EmployeeModel currentItem = data.get(position);
        holder.textViewId.setText(Integer.toString(data.get(position).getId()));
        holder.textViewName.setText(data.get(position).getName());
        holder.textViewUsername.setText(data.get(position).getUsername());
        holder.textViewEmail.setText(data.get(position).getEmail());
//        holder.textViewAddress.setText(data.get(position).getAddress());
//        holder.textViewMiddlename.setText(data.get(position).getMiddlename());
//        holder.textViewLastname.setText(data.get(position).getLastname());
//        holder.textViewEmail.setText(data.get(position).getEmail());
//        holder.textViewMobileNumber.setText(data.get(position).getMobilenumber());
//        holder.textViewGender.setText(data.get(position).getGender());
//        holder.textViewSlot.setText(data.get(position).getSlot());
//        holder.textViewReason.setText(data.get(position).getReason());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),EmployeeUI.class);
//                intent.putExtra("id",currentItem.getId());
//                intent.putExtra("getUhid",currentItem.getUhid());
                intent.putExtra("getName",currentItem.getName());
                intent.putExtra("getUsername",currentItem.getUsername());
                intent.putExtra("getEmail",currentItem.getEmail());
//                intent.putExtra("getAddress",currentItem.getAddress());
//                intent.putExtra("getMiddlename",currentItem.getMiddlename());
//                intent.putExtra("getLastname",currentItem.getLastname());
//                intent.putExtra("getEmail",currentItem.getEmail());
//                intent.putExtra("getMobilenumber",currentItem.getMobilenumber());
//                intent.putExtra("getGender",currentItem.getGender());
//                intent.putExtra("getSlot",currentItem.getSlot());
//                intent.putExtra("getReason",currentItem.getReason());

                view.getContext().startActivity(intent);

            }
        });

//        holder.menuPopUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PopupMenu popupMenu=new PopupMenu(mContext, view);
//                PopupMenu.getMenuInflater().inflate(R.menu.pop_menu,popupMenu.getMenu());
//                popupMenu.show();
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewloder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

        ImageView imageButton;
        TextView textViewId, textViewName, textViewUsername, textViewEmail,textViewAddress;

//        textViewFullname,textViewMiddlename,textViewLastname, textViewEmail, textViewMobileNumber, textViewGender, textViewSlot, textViewReason;

        public myviewloder(@NonNull View itemView) {
            super(itemView);

            textViewId = itemView.findViewById(R.id.textView_Id);
//            textViewDepartment = itemView.findViewById(R.id.textView_Department);
//            textViewDoctorname = itemView.findViewById(R.id.textView_Doctorname);
//            textViewDate = itemView.findViewById(R.id.textView_Date);
            textViewName = itemView.findViewById(R.id.textView_Fullname);
//            textViewMiddlename = itemView.findViewById(R.id.textView_Middlename);
//            textViewLastname = itemView.findViewById(R.id.textView_Lastname);
//            textViewEmail = itemView.findViewById(R.id.textView_Email);
            textViewUsername = itemView.findViewById(R.id.textView_MobileNumber);
            textViewEmail = itemView.findViewById(R.id.textView_Gender);
//            textViewAddress = itemView.findViewById(R.id.textView_Address);
//            textViewSlot = itemView.findViewById(R.id.textView_Slot);
//            textViewReason = itemView.findViewById(R.id.textView_Reason);

            imageButton = itemView.findViewById(R.id.menuMore);
            imageButton.setOnClickListener(this);





//            imageButton.setOnClickListener(new View.OnClickListener() {
//               @Override
//                public void onClick(View v) {
//                    deleteUser(Integer.parseInt(userId));
//
////                    Intent intent = new Intent(getItemCount(), DoctorAppointmentsAdapter.class);
////                    startActivity(intent);
//                }
//           });
//           imageButton.setOnClickListener(new View.OnClickListener() {
//               @Override
//                public void onClick(View v) {
//                    deleteUser(Integer.parseInt(userId));
//
//                    Intent intent = new Intent(getItemCount(), DoctorAppointmentsAdapter.class);
//                    startActivity(intent);
//                }
//           });
        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            return false;
        }


//        @Override
//        public void onClick(View view) {
//            showPopupmenu(view);
//        }
//
//        private void showPopupmenu(View view) {
//            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
//            popupMenu.inflate(R.menu.pop_menu);
//            popupMenu.setOnMenuItemClickListener(this);
//            popupMenu.show();
//
//
//
//        }



//        public void deleteUser(int id){
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(APIendpoints.url)
//
//                    .addConverterFactory(GsonConverterFactory.create())
//
//                    .build();
//
//            APIendpoints retrofitAPI = retrofit.create(APIendpoints.class);
//
//            Call<String> call = retrofitAPI
//                    .deletePostById(152);
//            call.enqueue(new Callback<String>() {
//                @Override
//                public void onResponse(Call<String> call, Response<String> response) {
//                    if(response.isSuccessful()){
////                        Toast.makeText(DoctorAppointmentsModuleActivity.this, "User deleted successfully!", Toast.LENGTH_SHORT).show();
//                        System.out.println("If Delete User-Success");
//                    }
//                    System.out.println("Delete User-Success "+response.message());
//                }
//
//                @Override
//                public void onFailure(Call<String> call, Throwable t) {
//                    Log.e("ERROR: ", t.getMessage());
//                    System.out.println("Delete User-Failure "+t.getMessage());
//                }
//            });
//        }
//
//
//        @Override
//        public boolean onMenuItemClick(MenuItem item) {
//
//            switch (item.getItemId()) {
//                case R.id.edit:
//
//                    Log.d(TAG, "onMenuItemClick:edit" + getAdapterPosition());
//                    return true;
//                case R.id.delete:
//                    System.out.println("Print item delete id:::::"+item.getItemId()+"__"+Integer.valueOf(item.toString()).intValue());
//                    deleteUser(Integer.valueOf(item.toString()));
//                    Log.d(TAG, "onMenuItemClick:delete" + getAdapterPosition());
//
//                    return true;
//                default:
//
//                    return false;
//            }
//        }


    }
}
