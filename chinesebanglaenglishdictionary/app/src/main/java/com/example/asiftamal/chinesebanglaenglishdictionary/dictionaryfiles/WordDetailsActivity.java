package com.example.asiftamal.chinesebanglaenglishdictionary.dictionaryfiles;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import android.support.v7.widget.Toolbar;


import com.example.asiftamal.chinesebanglaenglishdictionary.R;

public class WordDetailsActivity extends AppCompatActivity {
TextView txtEnglishWord,txtBanglaword,txtChineseWord,txtBanglaPronc,txtChinesePronc,txtDefEnglish,txtDefBangla;
Toolbar toolbarworddetailActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_details);
        toolbarworddetailActivity=(Toolbar) findViewById(R.id.toolbarforworddetailactivity);

        toolbarworddetailActivity.setTitle("Word Details");
        setSupportActionBar(toolbarworddetailActivity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Loadpage();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void Loadpage() {
        txtEnglishWord=(TextView)findViewById(R.id.txtEnglishWordDetails) ;
        txtBanglaword=(TextView)findViewById(R.id.txtBanglaWordDetails);
        txtChineseWord=(TextView)findViewById(R.id.txtChineseWordDetails);
        txtBanglaPronc=(TextView)findViewById(R.id.txtBanglaWordPronDetails);
        txtChinesePronc=(TextView)findViewById(R.id.txtChineseWordPronDetails);
        txtDefEnglish=(TextView)findViewById(R.id.txtEnglishWordDefinition);
        txtDefBangla=(TextView)findViewById(R.id.txtBanglaWordDefinition);

        Bundle bundle= getIntent().getExtras();
        if(bundle!=null){

            String wordid=bundle.getString("INTENTWORDID");
            String  EnglishWord=bundle.getString("INTENTENGLISH");
            String BanglaWord=bundle.getString("INTENTBANGLA");
            String BanglawordePronc=bundle.getString("INTENTPRONCBANGLA");
            String ChineseWord=bundle.getString("INTENTCHINESE");
            String ChineseWordPronc=bundle.getString("INTENTPRONCCHINESE");
            String EnglishDefinition=bundle.getString("INTENTDEFENGLISH");
            String BanglaDefinition=bundle.getString("INTENTDEFBANGLA");

            txtEnglishWord.setText(EnglishWord);
            txtBanglaword.setText(BanglaWord);
            txtChineseWord.setText(ChineseWord);
            txtChinesePronc.setText(ChineseWordPronc);
            txtBanglaPronc.setText(BanglawordePronc);
            txtDefEnglish.setText(EnglishDefinition);
            txtDefBangla.setText(BanglaDefinition);
        }
    }
}
