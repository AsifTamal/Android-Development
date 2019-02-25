package com.example.asiftamal.to_dolist;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class  ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener{

    ItemClickListener itemClickListener;
    TextView txtItemTitle,txtItemDescription, txtStatus, txtdate;


    public ListItemHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);
        txtItemTitle=(TextView)itemView.findViewById(R.id.txtcardtitleholder);
        txtItemDescription=(TextView)itemView.findViewById(R.id.txtcardDescrptionholder);
        txtStatus=(TextView)itemView.findViewById(R.id.txtcardstatusholder);
        txtdate=(TextView)itemView.findViewById(R.id.txtcarddateholder);
//        Iscompleted.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int adapterPosition = getAdapterPosition();
//                if (items.get(adapterPosition).getChecked()) {
//                    mCheckedTextView.setChecked(false);
//                    items.get(adapterPosition).setChecked(false);
//                }
//                else {
//                    mCheckedTextView.setChecked(true);
//                    items.get(adapterPosition).setChecked(true);
//                }
//            }
//        });
    }
    //set click listener for recyclerview
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
        this.itemClickListener=itemClickListener;

        }
    @Override
    public void onClick(View v) {
    itemClickListener.onClick(v,getAdapterPosition(),false);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select The Action");
        menu.add(0,0,getAdapterPosition(),"DELETE");

    }
}

public class ListItemHolderAdapter extends RecyclerView.Adapter<ListItemHolder> implements Filterable {
    MainActivityToDoList mainActivityToDoList;
    public static List<ToDo> todoList;
    private List<ToDo> item_todofullList;

    public ListItemHolderAdapter(MainActivityToDoList mainActivityToDoList, List<ToDo> todoList) {
        this.mainActivityToDoList = mainActivityToDoList;
        this.todoList = todoList;
        item_todofullList=new ArrayList<>(todoList);
    }

    @NonNull
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(mainActivityToDoList.getBaseContext());
        View view= inflater.inflate(R.layout.cardviewtodolistitem,viewGroup,false);
        return new ListItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemHolder listItemHolder, int i) {


            //set data for item
        listItemHolder.txtItemTitle.setText(todoList.get(i).getTitle());
        listItemHolder.txtItemDescription.setText(todoList.get(i).getDescription());
        if(todoList.get(i).getState()==false){
            listItemHolder.txtStatus.setText("Not Complete");
        }else {
            listItemHolder.txtStatus.setText("Complete");
        }
        listItemHolder.txtdate.setText(todoList.get(i).getDate());

        // when data selected item will automatically load in edit text view
        listItemHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClck) {
                mainActivityToDoList.editTexttitle.setText(todoList.get(position).getTitle());
                mainActivityToDoList.editTextdescription.setText(todoList.get(position).getDescription());
                mainActivityToDoList.txtshoeuser.setText(todoList.get(position).getUserId());
                mainActivityToDoList.chkStatus.setChecked(todoList.get(position).getState());
                mainActivityToDoList.txtDatePicker.setText(todoList.get(position).getDate());
                mainActivityToDoList.isUpdate=true;
                mainActivityToDoList.idUpdate=todoList.get(position).getId();
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    //region For Search
    @Override
    public  Filter getFilter() {
        return filterlistforsearch;
    }
    private Filter filterlistforsearch=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ToDo> filteredList= new ArrayList<>();
            if(constraint==null||constraint.length()==0){
                filteredList.addAll(item_todofullList);
            }
            else {
                String filterPattern=constraint.toString().toLowerCase().trim();
                for(ToDo item:item_todofullList){
                    if(item.getTitle().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);

                    }
                }
            }
            FilterResults results=new FilterResults();
            results.values=filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            todoList.clear();;
            todoList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };
    //endregion
}
