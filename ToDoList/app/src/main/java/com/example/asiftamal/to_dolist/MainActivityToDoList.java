package com.example.asiftamal.to_dolist;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Nullable;


public class MainActivityToDoList extends AppCompatActivity {

    private FirebaseAuth mAuth;
    TextView txtshoeuser;
    CheckBox chkStatus;
    List<ToDo> toDoList=new ArrayList<>();
    FirebaseFirestore firebaseFirestoredb;
    RecyclerView RvListView;
    RecyclerView.LayoutManager layoutManager;
    FloatingActionButton fab;
    public EditText editTexttitle,editTextdescription;
    public boolean isUpdate=false;
    public String idUpdate="";
    ListItemHolderAdapter listItemHolderAdapter;
    Dialog dialog;
  //  boolean state=true;
    String id;
     String s,getdate;
     DatePickerDialog datePickerDialog;
     TextView txtDatePicker;
     Button btnDatePicker;
     MenuItem searchItem, signoutItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_to_do_list);
        txtshoeuser=(TextView)findViewById(R.id.showuser);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        txtshoeuser.setText(user.getUid().toString());
        s= (String) txtshoeuser.getText();
        dialog= new Dialog (MainActivityToDoList.this);
        editTexttitle=(EditText)findViewById(R.id.titletodotxtid);
        editTextdescription=(EditText)findViewById(R.id.Descrptntodotxtid);
        fab=(FloatingActionButton)findViewById(R.id.floadingActionaddid);
        chkStatus=(CheckBox) findViewById(R.id.chkbxIsState);
        txtDatePicker=(TextView)findViewById(R.id.txtdatepicker);
        btnDatePicker=(Button)findViewById(R.id.btndatepicker);
        todaysdate();

        datepickercls datepick=new datepickercls();


        firebaseFirestoredb=FirebaseFirestore.getInstance();
        RvListView=(RecyclerView)findViewById(R.id.todoList);
        RvListView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        RvListView.setLayoutManager(layoutManager);
        btnDatePicker.setOnClickListener(datepick);
        fab.setOnClickListener(datepick);
        loadData();
    }
//set default date to today
    private void todaysdate() {
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        txtDatePicker.setText(thisDate);
        getdate= (String) txtDatePicker.getText();
    }
    //make a class to handle button clicks
    private class datepickercls implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v.getId()== R.id.btndatepicker){

                DatePicker datePicker=new DatePicker(MainActivityToDoList.this);
                int currentDay=datePicker.getDayOfMonth();
                int currentMonth=(datePicker.getMonth())+1;
                int currentYear=datePicker.getYear();



datePickerDialog=new DatePickerDialog(MainActivityToDoList.this, new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
txtDatePicker.setText(dayOfMonth+"/"+(month+1)+"/"+year);
getdate= (String) txtDatePicker.getText();
    }
},currentYear,currentMonth,currentDay);
datePickerDialog.show();
            }
            else if(v.getId()== R.id.floadingActionaddid){
                if(!isUpdate){

                    SavetodoData(editTexttitle.getText().toString(),editTextdescription.getText().toString(),s,chkStatus.isChecked(),getdate);
                }
                else {
                    UpdatetodoData(editTexttitle.getText().toString(),editTextdescription.getText().toString(),s,chkStatus.isChecked(),getdate);
                }
            }
        }
    }
    //handle the long click and delete item from recyclerview
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle().equals("DELETE")){
            deleteItem(item.getOrder());
        }
        return super.onContextItemSelected(item);
    }


    //delete item from firestore

    private void deleteItem(int index) {
        firebaseFirestoredb.collection("TodoList")
                .document(toDoList.get(index).getId())
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        loadData();

                    }
                });
    }

//update item to firestore
    private void UpdatetodoData(String title, String description, String userID,Boolean status, String getdate) {
      if(!validation(title,description)){


        firebaseFirestoredb.collection("TodoList").document(idUpdate)
                .update("title",title,"description",description,"userId",userID,"state",status,"date",getdate)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"Updated!",Toast.LENGTH_SHORT).show();
                        editTextdescription.setText("");
                        editTexttitle.setText("");
                        isUpdate=false;
                        todaysdate();
                    }
                });
            firebaseFirestoredb.collection("TodoList").document(idUpdate)
                    .addSnapshotListener(new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                            loadData();
                            editTextdescription.setText("");
                            editTexttitle.setText("");

                        }
                    });
      }
    }
    //field validation
    private boolean validation(String title, String description) {


        if(title.isEmpty()){
            editTexttitle.setError("Please Enter Title");
            editTexttitle.requestFocus();
            return true;

        }

        if(description.isEmpty()){
            editTextdescription.setError("Please Enter Description");
            editTextdescription.requestFocus();
            return true;
        }

return false;


    }
    //save to firestore
    private void SavetodoData(String title, String description, String userid,Boolean status, String getdate) {
         id= UUID.randomUUID().toString();
        if(!validation(title,description)) {
            Map<String, Object> todo = new HashMap<>();


            todo.put("id", id);
            todo.put("title", title);
            todo.put("description", description);
            todo.put("userId", userid);
            todo.put("state", status);
            todo.put("date", getdate);
            firebaseFirestoredb.collection("TodoList")
                    .document(id)
                    .set(todo).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    loadData();

                    todaysdate();
                    Toast.makeText(getApplicationContext(), "Added!", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "failed!" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
//load fire store data to recyclerview only who logged in
    private void loadData() {
        dialog.show();

        firebaseFirestoredb.collection("TodoList")
                .get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        if(!queryDocumentSnapshots.isEmpty()){
//                            List<DocumentSnapshot> todooList=queryDocumentSnapshots.getDocuments();
//                            for(DocumentSnapshot d: todooList){
//                                ToDo todo= d.toObject(ToDo.class);
//                                toDoList.add(todo);
//                            }
//                            listItemHolderAdapter=new ListItemHolderAdapter(MainActivityToDoList.this,toDoList);
//                        RvListView.setAdapter(listItemHolderAdapter);
//                        dialog.dismiss();
//                        }
//                    }
//                })
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        toDoList.clear();
                        for(DocumentSnapshot doc:task.getResult()){
                           if( doc.getString("userId").equals(s)){
                                ToDo toDo=new ToDo(
                                        doc.getString("id"),
                                        doc.getString("title"),
                                        doc.getString("description"),
                                        doc.getString("userId"),
                                        doc.getString("date"),
                                        doc.getBoolean("state")
                                );
                                toDoList.add(toDo);
                            }

                      }
                        listItemHolderAdapter=new ListItemHolderAdapter(MainActivityToDoList.this,toDoList);
                        RvListView.setAdapter(listItemHolderAdapter);
                        dialog.dismiss();
                        editTextdescription.setText("");
                        editTexttitle.setText("");
                        id="";
                        chkStatus.setChecked(false);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"" +e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

//menu item handler(search task and logout)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        searchItem= menu.findItem(R.id.default_action_search);
        signoutItem=menu.findItem(R.id.SignoutID);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.default_action_search) {

            SearchView searchView = (SearchView) searchItem.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    listItemHolderAdapter.getFilter().filter(s);

                    return false;
                }
            });
            return true;
        }
        else if (item.getItemId() == R.id.SignoutID) {
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent= new Intent(getApplicationContext(),SignInActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Sign out Successful",Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }


}
