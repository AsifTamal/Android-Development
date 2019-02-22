package com.example.asiftamal.chinesebanglaenglishdictionary.dictionaryfiles;

import android.app.ActionBar;
import android.app.Dialog;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import android.graphics.Color;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;


import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asiftamal.chinesebanglaenglishdictionary.R;
import com.example.asiftamal.chinesebanglaenglishdictionary.db.DictionaryDBclass;

import java.util.ArrayList;


import static java.security.AccessController.getContext;

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
    MenuItem searchItem,myInfoItem,feedbackItem,shareItem;
    TextView txtinfomine;
    EditText edttxtfeedbackName,edttxtfeedbackEmail,edttxtfeedbackOpinion;
    Button submit,close;


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
        shareItem=menu.findItem(R.id.share);
         feedbackItem=menu.findItem(R.id.feedback);
         myInfoItem=(MenuItem) findViewById(R.id.myinfo);


        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.default_action_search) {

            SearchView searchView=(SearchView) searchItem.getActionView();
           // searchView.setBackgroundColor(Color.LTGRAY);
            searchView.setQueryHint("Search Here");
            String[] terms = dictnrydb.dictionaryWords();

            ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, terms);




            // Get SearchView autocomplete object.
            final SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
            searchAutoComplete.setBackgroundColor(Color.WHITE);
            searchAutoComplete.setTextColor(Color.BLACK);
            searchAutoComplete.setDropDownBackgroundResource(android.R.color.holo_purple);
            searchAutoComplete.setAdapter(listAdapter);


           //  Listen to search view item on click event.
            searchAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String queryString=(String)parent.getItemAtPosition(position);
                    searchAutoComplete.setText("" + queryString);
                    Toast.makeText(DefaultDictionaryActivity.this, "you clicked " + queryString, Toast.LENGTH_LONG).show();
                }


            });



                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

        else if (item.getItemId() == R.id.myinfo) {
                final Dialog myinfoDialog = new Dialog(this);
                myinfoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                // myinfoDialog.setTitle("Developer Information");

                myinfoDialog.setContentView(R.layout.myinfo_popup_dialog);

                Button hello = (Button) myinfoDialog.findViewById(R.id.hello);
                Button close = (Button) myinfoDialog.findViewById(R.id.close);

                hello.setEnabled(true);
                close.setEnabled(true);

                hello.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Hello, Thanks For Coming here", Toast.LENGTH_LONG).show();
                    }
                });
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myinfoDialog.cancel();
                    }
                });
                myinfoDialog.show();


            } else if (item.getItemId() == R.id.feedback) {

            final Dialog FeedbackDialog = new Dialog(this);
            FeedbackDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            // myinfoDialog.setTitle("Developer Information");

            FeedbackDialog.setContentView(R.layout.feedback_popup);

            //txtinfomine = (TextView) findViewById(R.id.txtmyinfo);
             submit = (Button) FeedbackDialog.findViewById(R.id.btnfeedbackSubmit);
             close = (Button) FeedbackDialog.findViewById(R.id.btnfeedbackclose);

            submit.setEnabled(true);
            close.setEnabled(true);

            submit.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    edttxtfeedbackName=(EditText)FeedbackDialog.findViewById(R.id.edttxtfeedbackUserNameid);
                    edttxtfeedbackEmail=(EditText)FeedbackDialog.findViewById(R.id.edttxtfeedbackUserEmailid);
                    edttxtfeedbackOpinion=(EditText)FeedbackDialog.findViewById(R.id.edttxtfeedbackUserOpinionid);
                    String name= edttxtfeedbackName.getText().toString();
                    String  email=edttxtfeedbackEmail.getText().toString();
                    String  feedbackOpinion= edttxtfeedbackOpinion.getText().toString();
                    Toast.makeText(getApplicationContext(), "Hello, Thanks For Coming here", Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(Intent.ACTION_SEND);
                    intent.setType("text/email");
                    String subject="Feedback from Dictionary App";
                    String body="Name : "+name+"\n Email: "+email+"\n Message: "+feedbackOpinion;
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"asifultamal159@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                    intent.putExtra(Intent.EXTRA_TEXT,body);
                    startActivity(Intent.createChooser(intent,"Feedback with"));
                    FeedbackDialog.dismiss();
                }
            });
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FeedbackDialog.cancel();
                }
            });
            FeedbackDialog.show();
            }
            else if(item.getItemId() == R.id.share){
                    Intent intent= new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String subject="Dictionary App";
                    String body="This is an offline English chinese bangla searchable app";
                    intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                    intent.putExtra(Intent.EXTRA_TEXT,body);
                    startActivity(Intent.createChooser(intent,"Share with"));

        }

            return super.onOptionsItemSelected(item);

        }
}
