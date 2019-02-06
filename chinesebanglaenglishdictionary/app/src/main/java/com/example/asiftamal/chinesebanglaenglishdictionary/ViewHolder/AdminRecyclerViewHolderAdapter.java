package com.example.asiftamal.chinesebanglaenglishdictionary.ViewHolder;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asiftamal.chinesebanglaenglishdictionary.AdminDetailClass;
import com.example.asiftamal.chinesebanglaenglishdictionary.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminRecyclerViewHolderAdapter extends RecyclerView.Adapter<AdminRecycleViewHolder> {
    public static ClickListener clickListener;
    private  Context context;
   public static ArrayList<AdminDetailClass> item_adminDetail;

    public AdminRecyclerViewHolderAdapter(Context context, ArrayList<AdminDetailClass> item_adminDetail) {

        this.item_adminDetail = item_adminDetail;
        this.context=context;
    }

    @NonNull
    @Override
    public AdminRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.admindetailforlistview,viewGroup,false);

      return new AdminRecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminRecycleViewHolder adminRecycleViewHolder, final int i) {
        //AdminDetailClass adminDetailClass=item_adminDetail.get(i);
        adminRecycleViewHolder.txt_AdminId.setText(Integer.toString(item_adminDetail.get(i).getId()));
        adminRecycleViewHolder.txt_AdminName.setText(item_adminDetail.get(i).getName());
        adminRecycleViewHolder.txt_AdminEmail.setText(item_adminDetail.get(i).getEmail());
        adminRecycleViewHolder.txt_AdminUserName.setText(item_adminDetail.get(i).getUsername());
        adminRecycleViewHolder.txt_AdminPasword.setText(item_adminDetail.get(i).getPasswword());
         adminRecycleViewHolder.itemView.setTag(i);

    }

    @Override
    public int getItemCount() {

//        if(item_adminDetail!=null){
//            return item_adminDetail.size();
//        }
//        else {
//            return 0;
//        }
        return item_adminDetail.size();

    }

    public interface ClickListener{
        void OnItemClick(int position,View view);
        void OnItemLongClick(int position,View view);

        void OnItemTouch(int id, View v);
    }
    public void setOnItemClickListener(ClickListener clickListenerr){
        AdminRecyclerViewHolderAdapter.clickListener=clickListenerr;
    }
     
}
