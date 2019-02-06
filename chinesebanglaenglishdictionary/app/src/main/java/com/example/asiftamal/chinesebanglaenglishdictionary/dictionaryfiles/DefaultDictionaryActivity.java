package com.example.asiftamal.chinesebanglaenglishdictionary.dictionaryfiles;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asiftamal.chinesebanglaenglishdictionary.R;
import com.example.asiftamal.chinesebanglaenglishdictionary.db.DictionaryDBclass;

import java.util.ArrayList;

public class DefaultDictionaryActivity extends AppCompatActivity {
//this activity for user only
    String EnglishWord,BanglaWord,ChineseWord,BanglaPron,ChinesePron,Bangladefinition,EnglishDefinition;
    int WordId,IsActiveValue;
    DictionaryDBclass dictnrydb;
    DictionaryRclcylerViewHolderAdapter dicRclrVwAdapter;
    DictionaryDetailcls Dctnryndetail;
    private Cursor cursor;
    RecyclerView rv_DictionaryDefaultWordList;
    Toolbar toolbarDictionayDefault;
    MenuItem searchItem,myInfoItem,feedbackItem;
    TextView txtinfomine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_dictionary);
        toolbarDictionayDefault=(Toolbar)findViewById(R.id.dictionaryDefaulttoolberid);
        setSupportActionBar(toolbarDictionayDefault);
        dictnrydb= new DictionaryDBclass(this);
        Dctnryndetail=new DictionaryDetailcls();
        rv_DictionaryDefaultWordList=(RecyclerView) findViewById(R.id.DefaultRcVwId);
        LoadDictionaryDatatoDefaultRecyclerview();
        LoadDetailDataforRvItem();
    }

    private void LoadDetailDataforRvItem() {
        dicRclrVwAdapter.setOnItemClickListener(new DictionaryRclcylerViewHolderAdapter.ClickListenerWordRV(){

            @Override
            public void OnItemClick(int position, View view) {
                Intent intent=new Intent(DefaultDictionaryActivity.this,WordDetailsActivity.class);
                cursor= dictnrydb.RetriveWordsbyId(position);
                if(cursor!=null) {
                    while (cursor.moveToNext()) {
                        WordId = cursor.getInt(0);
                        EnglishWord = cursor.getString(1);
                        BanglaWord = cursor.getString(2);
                        ChineseWord = cursor.getString(5);
                        BanglaPron = cursor.getString(3);
                        ChinesePron = cursor.getString(6);
                        IsActiveValue=cursor.getInt(7);
                        Bangladefinition=cursor.getString(9);
                        EnglishDefinition=cursor.getString(8);

                    }
                }
                intent.putExtra("INTENTWORDID",WordId);
                intent.putExtra("INTENTENGLISH",EnglishWord);
                intent.putExtra("INTENTBANGLA",BanglaWord);
                intent.putExtra("INTENTPRONCBANGLA",BanglaPron);
                intent.putExtra("INTENTCHINESE",ChineseWord);
                intent.putExtra("INTENTPRONCCHINESE",ChinesePron);
                intent.putExtra("INTENTISACTIVE",IsActiveValue);
                intent.putExtra("INTENTDEFENGLISH",EnglishDefinition);
                intent.putExtra("INTENTDEFBANGLA",Bangladefinition);
                startActivity(intent);

            }
        });
    }

    private void LoadDictionaryDatatoDefaultRecyclerview() {
        ArrayList<DictionaryDetailcls> arrayList=new ArrayList<>();

        cursor=dictnrydb.ShowAllWordsDatailRrcyclrVw();
        if(cursor!=null) {
            while (cursor.moveToNext()){
                DictionaryDetailcls DicWorddetails=new DictionaryDetailcls();
                DicWorddetails.setWordID(cursor.getInt(0));
                DicWorddetails.setEnglishword(cursor.getString(1));
                DicWorddetails.setBanglaword(cursor.getString(2));
                DicWorddetails.setPronctnbangla(cursor.getString(3));
                DicWorddetails.setChineseword(cursor.getString(5));
                DicWorddetails.setPronctnchinese(cursor.getString(6));
                arrayList.add(DicWorddetails);
            }

        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        dicRclrVwAdapter=new DictionaryRclcylerViewHolderAdapter(getApplicationContext(),arrayList);
        rv_DictionaryDefaultWordList.setLayoutManager(linearLayoutManager);
        rv_DictionaryDefaultWordList.setHasFixedSize(true);
        rv_DictionaryDefaultWordList.setAdapter(dicRclrVwAdapter);
    }
    //for search


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.topcrnr_right_menu_item,menu);


         searchItem=menu.findItem(R.id.default_action_search);
         feedbackItem=menu.findItem(R.id.feedback);
         myInfoItem=(MenuItem) findViewById(R.id.myinfo);


        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.default_action_search){
            //MenuItem searchItem=menu.findItem(R.id.default_action_search);
            android.support.v7.widget.SearchView searchView=(android.support.v7.widget.SearchView) searchItem.getActionView();

            searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    dicRclrVwAdapter.getFilter().filter(s);
                    return false;
                }
            });
            return true;
        }
        else  if(item.getItemId()==R.id.myinfo){
          final   Dialog myinfoDialog=new Dialog(this);
           myinfoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
           // myinfoDialog.setTitle("Developer Information");

myinfoDialog.setContentView(R.layout.myinfo_popup_dialog);
            txtinfomine=(TextView)findViewById(R.id.txtmyinfo);
            Button hello = (Button)myinfoDialog.findViewById(R.id.hello);
            Button close = (Button)myinfoDialog.findViewById(R.id.close);

            hello.setEnabled(true);
            close.setEnabled(true);

            hello.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Hello, Thanks For Come here", Toast.LENGTH_LONG).show();
                }
            });
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myinfoDialog.cancel();
                }
            });
            myinfoDialog.show();



        }
        else  if(item.getItemId()==R.id.feedback){

//
//            LayoutInflater.from(DefaultDictionaryActivity.this).inflate(R.layout.add_admin_form,null);
//               AlertDialog.Builder alertBuilder= new AlertDialog.Builder(DefaultDictionaryActivity.this);
//               alertBuilder.setView(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
