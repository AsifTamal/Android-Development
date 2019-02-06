package com.example.asiftamal.chinesebanglaenglishdictionary;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asiftamal.chinesebanglaenglishdictionary.ViewHolder.AdminRecyclerViewHolderAdapter;
import com.example.asiftamal.chinesebanglaenglishdictionary.db.AdmindbClass;
import com.example.asiftamal.chinesebanglaenglishdictionary.dictionaryfiles.DictionaryMainActivity;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class AdminPanelActivity extends AppCompatActivity {

    String AdminName,AdnimUsername,AdnimEmail,AdnimPassword;
    int id;
    private Button btnAddadminpopup,btnDictionaryControlpage;
    AdminDetailClass admindetail;
    AdmindbClass admindb;
    private EditText edttxtuser,edttxtpass,edttxtconfirmpass,edttxtemail,edttxtadminname;
    private RecyclerView AdminRecyclerview;
    private AdminRecyclerViewHolderAdapter adapterAdmin;
    private Cursor cursor;
    private TextView txtInvisibleId;

    ItemTouchHelper touchxHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        btnDictionaryControlpage= (Button) findViewById(R.id.btnDictionaryControl);
        btnAddadminpopup= (Button) findViewById(R.id.btnAddAdmin);
        admindetail=new AdminDetailClass();
        admindb=new AdmindbClass(this);

        AdminControlClass adminControlClass= new AdminControlClass();
        btnDictionaryControlpage.setOnClickListener(adminControlClass);
        btnAddadminpopup.setOnClickListener(adminControlClass);
        AdminRecyclerview= (RecyclerView) findViewById(R.id.rcvAdmindetailID);
        LoadDatatoRecyclerview();



        adapterAdmin.setOnItemClickListener(new AdminRecyclerViewHolderAdapter.ClickListener() {
            @Override
            public void OnItemClick(int position, View view) {
//                 view= (LayoutInflater.from(AdminPanelActivity.this)).inflate(R.layout.add_admin_form,null);
//                AlertDialog.Builder alertBuilder= new AlertDialog.Builder(AdminPanelActivity.this);
//                alertBuilder.setView(view);
//
               Toast.makeText(getApplicationContext(),"Instant press called for position "+position,Toast.LENGTH_SHORT).show();
//                alertBuilder.create().show();
                view= (LayoutInflater.from(AdminPanelActivity.this)).inflate(R.layout.admin_detail_ontouch_popup,null);
                AlertDialog.Builder alertBuilder= new AlertDialog.Builder(AdminPanelActivity.this);
               alertBuilder.setTitle("Admin Details");

               TextView txtuserpopup=(TextView) view.findViewById(R.id.adminUserforpopup);
                TextView  txtpasswordpopup=(TextView) view.findViewById(R.id.adminPasswordforpopup);
                TextView txtEmailpopup=(TextView) view.findViewById(R.id.adminEmailforpopup);

                TextView txtnamepopup=(TextView) view.findViewById(R.id.adminNameforpopup);
                TextView txtIdpopup=(TextView)view.findViewById(R.id.adminidforpopup);
                cursor=admindb.retriveadmindataforupdate(position);
                if(cursor!=null){
                    while (cursor.moveToNext()){

                        id=cursor.getInt(0);
                        AdminName=cursor.getString(1);
                        AdnimUsername=cursor.getString(3);
                        AdnimEmail=cursor.getString(2);
                        AdnimPassword=cursor.getString(4);
                    }
                    position=id;
                    txtnamepopup.setText(AdminName);
                    txtuserpopup.setText(AdnimUsername);
                    txtEmailpopup.setText(AdnimEmail);
                    txtpasswordpopup.setText(AdnimPassword);
                    txtIdpopup.setText(String.valueOf(id));

                }
                alertBuilder.setView(view);

                alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });

                alertBuilder.create().show();
            }

            @Override
            public void OnItemLongClick(int position, View view) {
                view= (LayoutInflater.from(AdminPanelActivity.this)).inflate(R.layout.add_admin_form,null);
                AlertDialog.Builder alertBuilder= new AlertDialog.Builder(AdminPanelActivity.this);
                alertBuilder.setView(view);
                edttxtuser=(EditText) view.findViewById(R.id.edttxtusername);
                edttxtpass=(EditText) view.findViewById(R.id.edttxtpassword);
                edttxtconfirmpass=(EditText) view.findViewById(R.id.edttxtconfirmpass);
                edttxtemail=(EditText) view.findViewById(R.id.edttxtEmail);
                edttxtadminname=(EditText) view.findViewById(R.id.edttxtadminname);
                txtInvisibleId=(TextView)view.findViewById(R.id.txtinvisibleid);
                cursor=admindb.retriveadmindataforupdate(position);
                if(cursor!=null){
                    while (cursor.moveToNext()){
                    id=cursor.getInt(0);
                  AdminName=cursor.getString(1);
                     AdnimUsername=cursor.getString(3);
                     AdnimEmail=cursor.getString(2);
                     AdnimPassword=cursor.getString(4);
                    }
                    edttxtadminname.setText(AdminName);
                    edttxtuser.setText(AdnimUsername);
                    edttxtemail.setText(AdnimEmail);
                    edttxtpass.setText(AdnimPassword);
                    txtInvisibleId.setText(String.valueOf(id));

                }
                alertBuilder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String user=edttxtuser.getText().toString();
                        String password=edttxtpass.getText().toString();
                        String cpass=edttxtconfirmpass.getText().toString();
                        String adminnamee=edttxtadminname.getText().toString();
                        String email=edttxtemail.getText().toString();
                        String adminid=txtInvisibleId.getText().toString();
                        boolean valid=   validate(user,password,cpass,adminnamee,email);
                        if(valid){
                        boolean Isupdate=admindb.Updatedata(adminid,adminnamee,email,user,password);
                        if(Isupdate){
                         Toast.makeText(getApplicationContext(),"Update Successful",Toast.LENGTH_SHORT).show();
                         LoadDatatoRecyclerview();
                                        }
                            else {
                       Toast.makeText(getApplicationContext(),"Update failed",Toast.LENGTH_SHORT).show();
                                    }
                             }
                    }
                });
                alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                Toast.makeText(getApplicationContext(),"Long press called for position "+position,Toast.LENGTH_SHORT).show();
                alertBuilder.create().show();
            }

            @Override
            public void OnItemTouch(final int id, View v) {
                new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                        int position= id;
                        removeItem(position);
                        adapterAdmin.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(),"Delete successful for position "+position,Toast.LENGTH_SHORT).show();


//                Snackbar snackbar = Snackbar
//                        .make(this, " removed from cart!", Snackbar.LENGTH_LONG);
//                snackbar.setAction("UNDO", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        // undo is selected, restore the deleted item
//                        adapterAdmin.restoreItem(deletedItem, deletedIndex);
//                    }
//                });
//                snackbar.setActionTextColor(Color.YELLOW);
//                snackbar.show();
                    }
                }).attachToRecyclerView(AdminRecyclerview);
            }
        });


    }

    private void removeItem(long itemId) {
        admindb.DeleteData(itemId);
        LoadDatatoRecyclerview();
    }

    private boolean validate(String user, String password, String cpass, String adminnamee, String email) {
        boolean temp=true;
        final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
                "[a-zA-Z0-9+._%-+]{1,256}" +
                        "@" +
                        "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
                        "(" +
                        "." +
                        "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
                        ")+"
        );

        if(!EMAIL_ADDRESS_PATTERN.matcher(email).matches()){
            Toast.makeText(getApplicationContext(),"Invalid Email Address",Toast.LENGTH_SHORT).show();
            temp=false;
        }
        else if(!password.equals(cpass)){
            Toast.makeText(getApplicationContext(),"Password Not matching",Toast.LENGTH_SHORT).show();
            temp=false;
        }
        else if(user==null&&password==null&&cpass==null&&adminnamee==null&&email==null){
            Toast.makeText(getApplicationContext(),"No field should be empty",Toast.LENGTH_SHORT).show();
            temp=false;
        }
        return temp;

    }

    private void LoadDatatoRecyclerview() {
         ArrayList<AdminDetailClass> arrayList=new ArrayList<>();

        cursor=admindb.ShowAllAdminDatailLV();
        if(cursor!=null) {
            while (cursor.moveToNext()){
            AdminDetailClass details=new AdminDetailClass();
                    details.setId(cursor.getInt(0));
                    details.setName(cursor.getString(1));
                    details.setEmail(cursor.getString(2));
                    details.setUsername(cursor.getString(3));
                    details.setPasswword(cursor.getString(4));
                    arrayList.add(details);
                }

        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        adapterAdmin=new AdminRecyclerViewHolderAdapter(getApplicationContext(),arrayList);
        AdminRecyclerview.setLayoutManager(linearLayoutManager);
        AdminRecyclerview.setItemAnimator(new DefaultItemAnimator());
        AdminRecyclerview.setHasFixedSize(true);
        AdminRecyclerview.setAdapter(adapterAdmin);

    }


    private class AdminControlClass implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.btnDictionaryControl){
                Intent intent=new Intent(AdminPanelActivity.this,DictionaryMainActivity.class);
                startActivity(intent);
            }
            else if(v.getId()==R.id.btnAddAdmin){

                View view= (LayoutInflater.from(AdminPanelActivity.this)).inflate(R.layout.add_admin_form,null);
                AlertDialog.Builder alertBuilder= new AlertDialog.Builder(AdminPanelActivity.this);
                alertBuilder.setView(view);
                edttxtuser=(EditText) view.findViewById(R.id.edttxtusername);
                edttxtpass=(EditText) view.findViewById(R.id.edttxtpassword);
                edttxtconfirmpass=(EditText) view.findViewById(R.id.edttxtconfirmpass);
                edttxtemail=(EditText) view.findViewById(R.id.edttxtEmail);
                edttxtadminname=(EditText) view.findViewById(R.id.edttxtadminname);

                alertBuilder.setPositiveButton("Submit",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String user=edttxtuser.getText().toString();
                        String password=edttxtpass.getText().toString();
                        String cpass=edttxtconfirmpass.getText().toString();
                        String adminnamee=edttxtadminname.getText().toString();
                        String email=edttxtemail.getText().toString();
                        boolean valid=   validate(user,password,cpass,adminnamee,email);
                        if(valid){

                            admindetail.setName(adminnamee);
                            admindetail.setEmail(email);
                            admindetail.setPasswword(password);
                            admindetail.setUsername(user);
                            long rowId=admindb.insertData(admindetail);
                            if(rowId>0){

                                Toast.makeText(getApplicationContext(),"Row "+rowId+" successfully inserted",Toast.LENGTH_SHORT).show();
                                LoadDatatoRecyclerview();
                            }else {
                                Toast.makeText(getApplicationContext(),"Invalid ",Toast.LENGTH_SHORT).show();
                            }

                        }

                    }
                });
                alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertBuilder.create().show();
            }

        }


    }


}
