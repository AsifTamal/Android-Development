package com.example.asiftamal.chinesebanglaenglishdictionary.dictionaryfiles;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.asiftamal.chinesebanglaenglishdictionary.AdminDetailClass;
import com.example.asiftamal.chinesebanglaenglishdictionary.AdminPanelActivity;
import com.example.asiftamal.chinesebanglaenglishdictionary.R;
import com.example.asiftamal.chinesebanglaenglishdictionary.ViewHolder.AdminRecyclerViewHolderAdapter;
import com.example.asiftamal.chinesebanglaenglishdictionary.db.DictionaryDBclass;

import java.util.ArrayList;

public class DictionaryMainActivity extends AppCompatActivity {

    String EnglishWord,BanglaWord,ChineseWord,BanglaPron,ChinesePron,Bangladefinition,EnglishDefinition;
    int WordId,IsActiveValue;
    DictionaryDBclass dicdb;
    DictionaryRclcylerViewHolderAdapter dictionaryRclcylerViewAdapter;
    DictionaryDetailcls Dictionaryndetail;
    FloatingActionButton AddpopupFloatingActionBtn;
    EditText edttxtenglisgword,edttxtbanglaword,edttxtpronbangla,edttxtchineseword,edttxtpronchinese,edttxtEnglishDefinition,edttxtBanglaDefinition;
    RadioGroup IsActiveRadiogrpp;
    RadioButton isactiveRadioButton,rdTrue,rdFalse;
    TextView audiotxt;
    android.support.v7.widget.Toolbar toolbarDictionaymain;
    private Cursor cursor;
    RecyclerView rv_DictionaryWordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_main);
        toolbarDictionaymain=(android.support.v7.widget.Toolbar)findViewById(R.id.dictionarymaintoolberid);
        setSupportActionBar(toolbarDictionaymain);
        dicdb= new DictionaryDBclass(this);
        Dictionaryndetail=new DictionaryDetailcls();
        rv_DictionaryWordList=(RecyclerView) findViewById(R.id.rcvIdDictionaryWordList);
        AddpopupFloatingActionBtn= (FloatingActionButton)findViewById(R.id.btnAddWordpopup);
        clsAddWord word= new clsAddWord();
        AddpopupFloatingActionBtn.setOnClickListener(word);
        LoadDictionaryDatatoRecyclerview();
        LoadDetailDicDataforRvItem();

    }

    private void LoadDetailDicDataforRvItem() {
        dictionaryRclcylerViewAdapter.setOnItemClickListener(new DictionaryRclcylerViewHolderAdapter.ClickListenerWordRV(){

            @Override
            public void OnItemClick(int position, View view) {
                Intent intent=new Intent(DictionaryMainActivity.this,WordDetailsActivity.class);
                cursor= dicdb.RetriveWordsbyId(position);
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

    private class clsAddWord implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            View view= (LayoutInflater.from(DictionaryMainActivity.this)).inflate(R.layout.addupdate_word_popup_form,null);
            AlertDialog.Builder alertBuilder= new AlertDialog.Builder(DictionaryMainActivity.this);
            alertBuilder.setView(view);

            IsActiveRadiogrpp=(RadioGroup) view.findViewById(R.id.IsActiveRadiogrp);
            edttxtenglisgword=(EditText) view.findViewById(R.id.edttxtEnglishWord);
            edttxtbanglaword=(EditText) view.findViewById(R.id.edttxtBanglaword);
            edttxtpronbangla=(EditText) view.findViewById(R.id.edttxtPronounciationBangla);
            edttxtchineseword=(EditText) view.findViewById(R.id.edttxtChineseWord);
            edttxtpronchinese=(EditText) view.findViewById(R.id.edttxtPronounciationChinese);
            edttxtBanglaDefinition=(EditText) view.findViewById(R.id.edttxtDefinitionBangla);
            edttxtEnglishDefinition=(EditText) view.findViewById(R.id.edttxtDefinitionEnglish);

            int selectedactivity=IsActiveRadiogrpp.getCheckedRadioButtonId();
            isactiveRadioButton=(RadioButton) view.findViewById(selectedactivity);
            rdTrue=(RadioButton)view.findViewById(R.id.IsActiveTrueRadio);
            rdFalse=(RadioButton) view.findViewById(R.id.IsActiveFalseRadio);
            audiotxt=(TextView)view.findViewById(R.id.adio);

            alertBuilder.setPositiveButton("Submit",new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String engword=edttxtenglisgword.getText().toString();
                    String bangword=edttxtbanglaword.getText().toString();
                    String pronctnbangla=edttxtpronbangla.getText().toString();
                    String chineseword=edttxtchineseword.getText().toString();
                    String pronctnchinese=edttxtpronchinese.getText().toString();
                    String isactive= isactiveRadioButton.getText().toString();
                    String defintionbangla=edttxtBanglaDefinition.getText().toString();
                    String defintionEnglish=edttxtEnglishDefinition.getText().toString();
//                    if(isactive == rdTrue.getText().toString()){
//                        IsActiveValue=1;
//                    }
//                    else if(isactive == rdFalse.getText().toString()){
//                        IsActiveValue=0;
//                    }
                    if(isactive.equals("True")){
                        IsActiveValue=1;
                    }
                    else if(isactive.equals("False")){
                        IsActiveValue=0;
                    }
                    String audio="";
                    boolean valid =   validate(engword,bangword,pronctnbangla,chineseword,pronctnchinese,isactive);
                    if(valid){

                        Dictionaryndetail.setEnglishword(engword);
                        Dictionaryndetail.setBanglaword(bangword);
                        Dictionaryndetail.setPronctnbangla(pronctnbangla);
                        Dictionaryndetail.setChineseword(chineseword);
                        Dictionaryndetail.setPronctnchinese(pronctnchinese);
                        Dictionaryndetail.setIsactive(IsActiveValue);
                        Dictionaryndetail.setAudio(audio);
                        Dictionaryndetail.setDefinitionbanglaWord(defintionbangla);
                        Dictionaryndetail.setDefinitionEnglishWord(defintionEnglish);

                        long rowId=dicdb.insertdictionaryData(Dictionaryndetail);
                        if(rowId>0){

                            Toast.makeText(getApplicationContext(),"Row "+rowId+" successfully inserted",Toast.LENGTH_SHORT).show();
                            LoadDictionaryDatatoRecyclerview();
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

    private void LoadDictionaryDatatoRecyclerview() {
        ArrayList<DictionaryDetailcls> arrayList=new ArrayList<>();

        cursor=dicdb.ShowAllWordsDatailRrcyclrVw();
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
        dictionaryRclcylerViewAdapter=new DictionaryRclcylerViewHolderAdapter(getApplicationContext(),arrayList);
        rv_DictionaryWordList.setLayoutManager(linearLayoutManager);
        rv_DictionaryWordList.setHasFixedSize(true);
        rv_DictionaryWordList.setAdapter(dictionaryRclcylerViewAdapter);
    }
    //for search


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.search_menu_admin,menu);

        MenuItem searchItem=menu.findItem(R.id.admin_action_search);
        android.support.v7.widget.SearchView searchView=(android.support.v7.widget.SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                dictionaryRclcylerViewAdapter.getFilter().filter(s);
                return false;
            }
        });


        return true;

    }

    private boolean validate(String engword, String bangword, String pronctnbangla, String chineseword, String pronctnchinese, String isactive) {
        boolean temp=true;
        if(engword==null||bangword==null||pronctnbangla==null||chineseword==null||pronctnchinese==null){
            Toast.makeText(getApplicationContext(),"No field should be empty",Toast.LENGTH_SHORT).show();
            temp=false;
        }
        return temp;

    }
}
