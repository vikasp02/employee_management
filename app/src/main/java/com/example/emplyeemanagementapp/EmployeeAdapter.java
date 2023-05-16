package com.example.emplyeemanagementapp;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
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
        holder.textViewEmail.setText(data.get(position).getEmail().toLowerCase());
        holder.textViewStreet.setText(data.get(position).getAddress().getStreet());
        holder.textViewSuite.setText(data.get(position).getAddress().getSuite());
        holder.textViewCity.setText(data.get(position).getAddress().getCity());
        holder.textViewZipcode.setText(data.get(position).getAddress().getZipcode());
        holder.textViewLat.setText(data.get(position).getAddress().getGeo().getLat());
        holder.textViewLng.setText(data.get(position).getAddress().getGeo().getLng());
        holder.textViewPhone.setText(data.get(position).getPhone());
        holder.textViewWebsite.setText(data.get(position).getWebsite());
        holder.textViewCompanyname.setText(data.get(position).getCompany().getName());
        holder.textViewCatchPhrase.setText(data.get(position).getCompany().getCatchPhrase());
        holder.textViewBs.setText(data.get(position).getCompany().getBs());
//


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(view.getContext(),EmployeeUI.class);


//                intent.putExtra("id",currentItem.getId());

                intent.putExtra("getName",currentItem.getName());
                intent.putExtra("getUsername",currentItem.getUsername());
                intent.putExtra("getEmail",currentItem.getEmail().toLowerCase());
                intent.putExtra("getStreet",currentItem.getAddress().getStreet());
                intent.putExtra("getSuite",currentItem.getAddress().getSuite());
                intent.putExtra("getCity",currentItem.getAddress().getCity());
                intent.putExtra("getZipcode",currentItem.getAddress().getZipcode());
                intent.putExtra("getLat",currentItem.getAddress().getGeo().getLat());
                intent.putExtra("getLng",currentItem.getAddress().getGeo().getLng());
                intent.putExtra("getPhone",currentItem.getPhone());
                intent.putExtra("getWebsite",currentItem.getWebsite());
                intent.putExtra("getCompanyname",currentItem.getCompany().getName());
                intent.putExtra("getCatchPhrase",currentItem.getCompany().getCatchPhrase());
                intent.putExtra("getBs",currentItem.getCompany().getBs());


                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewloder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

        ImageView imageButton;
        TextView textViewId, textViewName, textViewUsername, textViewEmail,textViewStreet,
                textViewSuite,textViewCity,textViewZipcode,textViewLat,textViewLng,textViewPhone,
                textViewWebsite,textViewCompanyname,textViewCatchPhrase,textViewBs;

//        textViewFullname,textViewMiddlename,textViewLastname, textViewEmail, textViewMobileNumber, textViewGender, textViewSlot, textViewReason;

        public myviewloder(@NonNull View itemView) {
            super(itemView);

            textViewId = itemView.findViewById(R.id.textView_Id);
            textViewName = itemView.findViewById(R.id.textView_Name);
            textViewUsername = itemView.findViewById(R.id.textView_Username);
            textViewEmail = itemView.findViewById(R.id.textView_Email);
            textViewStreet = itemView.findViewById(R.id.textViewStreet);
            textViewSuite = itemView.findViewById(R.id.textViewSuite);
            textViewCity = itemView.findViewById(R.id.textViewCity);
            textViewZipcode = itemView.findViewById(R.id.textViewZipcode);
            textViewLat = itemView.findViewById(R.id.textViewLat);
            textViewLng = itemView.findViewById(R.id.textViewLng);
            textViewPhone = itemView.findViewById(R.id.textViewPhone);
            textViewWebsite = itemView.findViewById(R.id.textViewWebsite);
            textViewCompanyname = itemView.findViewById(R.id.textViewCompanyname);
            textViewCatchPhrase = itemView.findViewById(R.id.textViewCatchPhrase);
            textViewBs = itemView.findViewById(R.id.textViewBs);


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
