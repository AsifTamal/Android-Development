package com.example.asiftamal.chinesebanglaenglishdictionary.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asiftamal.chinesebanglaenglishdictionary.R;

import static com.example.asiftamal.chinesebanglaenglishdictionary.ViewHolder.AdminRecyclerViewHolderAdapter.clickListener;
import static com.example.asiftamal.chinesebanglaenglishdictionary.ViewHolder.AdminRecyclerViewHolderAdapter.item_adminDetail;

public class AdminRecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener, View.OnTouchListener {

    TextView txt_AdminName,txt_AdminUserName,txt_AdminEmail,txt_AdminId,txt_AdminPasword;
    public AdminRecycleViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_AdminId=(TextView)itemView.findViewById(R.id.AdmindetailtxtViewid);
        txt_AdminName=(TextView) itemView.findViewById(R.id.AdmindetailtxtViewName);
        txt_AdminEmail=(TextView)itemView.findViewById(R.id.AdmindetailtxtViewEmail);
        txt_AdminUserName=(TextView)itemView.findViewById(R.id.AdmindetailtxtViewUser);
        txt_AdminPasword=(TextView)itemView.findViewById(R.id.AdmindetailtxtViewPassword);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        itemView.setOnTouchListener(this);
    }


    @Override
    public void onClick(View v) {

        clickListener.OnItemClick(item_adminDetail.get(getAdapterPosition()).getId(),v);
    }

    @Override
    public boolean onLongClick(View v) {
        clickListener.OnItemLongClick(item_adminDetail.get(getAdapterPosition()).getId(),v);
        return false;
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        clickListener.OnItemTouch(item_adminDetail.get(getAdapterPosition()).getId(),v);
        return false;
    }
}
