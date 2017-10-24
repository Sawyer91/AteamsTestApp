package com.sawyerd.ateamstest;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Dmitriy on 23.10.2017.
 */

 public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.UserHolder> {
    
    private ArrayList<Users> usersD;
    private Activity mActivity;

    public CustomAdapter(ArrayList<Users> users, Activity activity) {
        this.usersD = users;
        this.mActivity = activity;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        Users user = usersD.get(position);
        
        holder.setName(user.getName());
        holder.setEmail(user.getEmail());
        holder.setStreet(user.getStreet());
        holder.setSuite(user.getSuite());
        holder.setCity(user.getCity());
        holder.setZipcode(user.getZipcode());
        holder.setPhone(user.getPhone());
        holder.setWebsite(user.getWebsite());

    }

    @Override
    public int getItemCount() {
        if(usersD == null)
            return 0;
        return usersD.size();
    }


    public class UserHolder extends RecyclerView.ViewHolder {

        public TextView userName;
        public TextView userEmail;
        public TextView userStreet;
        public TextView userSuite;
        public TextView userCity;
        public TextView userZipcode;
        public TextView userPhone;
        public TextView userWebsite;

        public UserHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.userName);
            userEmail = (TextView) itemView.findViewById(R.id.userEmail);
            userStreet = (TextView) itemView.findViewById(R.id.userStreet);
            userSuite = (TextView) itemView.findViewById(R.id.userSuit);
            userCity = (TextView) itemView.findViewById(R.id.userCity);
            userZipcode = (TextView) itemView.findViewById(R.id.userZipcode);
            userPhone = (TextView) itemView.findViewById(R.id.userPhone);
            userWebsite = (TextView) itemView.findViewById(R.id.userWebsite);
        }

        public void setName(String name){
            userName.setText(name);
        }

        public void setEmail(String email){
            userEmail.setText(email);
        }

        public void setStreet(String street){
            userStreet.setText(street);
        }

        public void setSuite(String suite){
            userSuite.setText(suite);
        }

        public void setCity(String city){
            userCity.setText(city);
        }

        public void setZipcode(String zipcode){
            userZipcode.setText(zipcode);
        }

        public void setPhone(String phone){
            userPhone.setText(phone);
        }

        public void setWebsite(String website){
            userWebsite.setText(website);
        }
    }
}
