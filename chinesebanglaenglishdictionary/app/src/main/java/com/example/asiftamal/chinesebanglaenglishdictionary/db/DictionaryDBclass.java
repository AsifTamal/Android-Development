package com.example.asiftamal.chinesebanglaenglishdictionary.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.asiftamal.chinesebanglaenglishdictionary.dictionaryfiles.DictionaryDetailcls;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DictionaryDBclass extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="dictionary.db";
    private static String DB_PATH="";
    private static final String DICTIONARY_TABLE="dictionary_table";
    private static final String DICTIONARY_WORD_ID="word_id";
    private static final String DICTIONARY_WORD_ENGLISH="word_english";
    private static final String DICTIONARY_WORD_BANGLA="word_bangla";
    private static final String DICTIONARY_PRONUNCIATION_BANGLA_="pronunciation_bangla";
    private static final String DICTIONARY_AUDIOCLIP_BANGLA_="audio_clip_bangla";
    private static final String DICTIONARY_WORD_CHINESE="word_chinese";
    private static final String DICTIONARY_PRONUNCIATION_CHINESE="pronunciation_chinese";
    private static final String DICTIONARY_DEFINITION_ENGLISH="definition_english";
    private static final String DICTIONARY_DEFINITION_BANGLA="definition__bangla";
    private static final String IsActive= "IsActive";
    private static final int VERSION_NUMBER=1;
    private  Context context;
    private  SQLiteDatabase myDictioaryWordDB;
    private static final String ENCODING_SETTING = "PRAGMA encoding ='windows-1256'";

    // private static final String CREATE_DICTIONARY_TABLE = "CREATE TABLE " +DICTIONARY_TABLE+
    //         "  ("+DICTIONARY_WORD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+DICTIONARY_WORD_ENGLISH+" VARCHAR(255) NOT NULL," +DICTIONARY_WORD_BANGLA+" TEXT NOT NULL, "+DICTIONARY_PRONUNCIATION_BANGLA_+" TEXT NOT NULL,"+DICTIONARY_AUDIOCLIP_BANGLA_+" BLOB, " +DICTIONARY_WORD_CHINESE+
    //         "TEXT NOT NULL, "+DICTIONARY_PRONUNCIATION_CHINESE+ "TEXT NOT NULL, "+IsActive+ "BOOLEAN NOT NULL);";
  //  private static final String DROP_TABLE="DROP TABLE IF EXISTS "  +DICTIONARY_TABLE;


    public DictionaryDBclass( Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        DB_PATH="/data/data/" + context.getPackageName() + "/" + "databases/";
        this.context=context;
    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        if (!db.isReadOnly()) {
            db.execSQL(ENCODING_SETTING);
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL(CREATE_DICTIONARY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL(DROP_TABLE);
       // onCreate(db);
    }

    public String[] dictionaryWords(){
        String mypath=DB_PATH+DATABASE_NAME;
        myDictioaryWordDB=SQLiteDatabase.openDatabase(mypath,null,SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor=myDictioaryWordDB.rawQuery("Select * from dictionary_table ",null);


        ArrayList<String> wordTerms = new ArrayList<String>();

        if(cursor.moveToFirst()){

            do{

                String word = cursor.getString(cursor.getColumnIndexOrThrow("word_english"));
                String cword = cursor.getString(cursor.getColumnIndexOrThrow("word_chinese"));
                wordTerms.add(word);
                wordTerms.add(cword);
            }while(cursor.moveToNext());

        }

        cursor.close();

        String[] dictionaryWords = new String[wordTerms.size()];

        dictionaryWords = wordTerms.toArray(dictionaryWords);

        return dictionaryWords;

    }

    public void checkAndCopyDatabase() throws IOException {
        boolean dbExist=checkDatabase();
        if(dbExist){
            Log.d("TAG","Already Exist");
            Toast.makeText(context,"Already Exist",Toast.LENGTH_LONG).show();
//            try {
//                copyDatabase();
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//                Log.d("TAG","Exist but Error copy database");
//                Toast.makeText(context,"Exist but Error copy database",Toast.LENGTH_LONG).show();
//            }
        }
        else {
            this.getReadableDatabase();

            try {
                copyDatabase();
                Toast.makeText(context,"Copy successful",Toast.LENGTH_LONG).show();
            }
            catch (IOException e) {
                e.printStackTrace();
                Log.d("TAG","Error copy database");
                Toast.makeText(context,"eeeError copy database",Toast.LENGTH_LONG).show();
            }

        }
    }
    public boolean checkDatabase(){
//        SQLiteDatabase checkDB=null;
//        String myPath=DB_PATH+DATABASE_NAME;
//        checkDB=SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);
//
//        if(checkDB!=null){
//            checkDB.close();
//        }
//        return checkDB!=null?true:false;
        File dbFile = new File(DB_PATH + DATABASE_NAME);
        return dbFile.exists();
    }
    public void copyDatabase() throws IOException{
        InputStream myInput=context.getAssets().open(DATABASE_NAME);
        String outFileName=DB_PATH+DATABASE_NAME;
        OutputStream myOutput=new FileOutputStream(outFileName);
        byte [] buffer= new byte[1024];
        int length;
        while ((length=myInput.read(buffer))>0){
            myOutput.write(buffer,0,length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }
    public void openDatabase(){
        String mypath=DB_PATH+DATABASE_NAME;
        myDictioaryWordDB=SQLiteDatabase.openDatabase(mypath,null,SQLiteDatabase.OPEN_READWRITE);
    }
    public synchronized void close(){
        if(myDictioaryWordDB!=null){
            myDictioaryWordDB.close();
        }
        super.close();
    }

    public long insertdictionaryData(DictionaryDetailcls dictionaryndetail) {
        String myPath = DB_PATH + DATABASE_NAME;
        myDictioaryWordDB = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READWRITE);
        ContentValues contentValues=new ContentValues();
        contentValues.put(DICTIONARY_WORD_ENGLISH,dictionaryndetail.getEnglishword());
        contentValues.put(DICTIONARY_WORD_BANGLA,dictionaryndetail.getBanglaword());
        contentValues.put(DICTIONARY_PRONUNCIATION_BANGLA_,dictionaryndetail.getPronctnbangla());
        contentValues.put(DICTIONARY_AUDIOCLIP_BANGLA_,dictionaryndetail.getAudio());
        contentValues.put(DICTIONARY_WORD_CHINESE,dictionaryndetail.getChineseword());
        contentValues.put(DICTIONARY_PRONUNCIATION_CHINESE,dictionaryndetail.getPronctnchinese());
        contentValues.put(IsActive,dictionaryndetail.getIsactive());
        contentValues.put(DICTIONARY_DEFINITION_ENGLISH,dictionaryndetail.getDefinitionEnglishWord());
        contentValues.put(DICTIONARY_DEFINITION_BANGLA,dictionaryndetail.getDefinitionbanglaWord());
        long rowId= myDictioaryWordDB.insert(DICTIONARY_TABLE,null,contentValues);
        return rowId;
    }

    public Cursor ShowAllWordsDatailRrcyclrVw() {
        String mypath=DB_PATH+DATABASE_NAME;
        myDictioaryWordDB=SQLiteDatabase.openDatabase(mypath,null,SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor=myDictioaryWordDB.rawQuery("Select * from dictionary_table ORDER BY word_english ASC",null);
        return cursor;
    }

    public Cursor RetriveWordsbyId(int position) {
        String mypath=DB_PATH+DATABASE_NAME;
        myDictioaryWordDB=SQLiteDatabase.openDatabase(mypath,null,SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor=myDictioaryWordDB.rawQuery("Select * from dictionary_table where word_id="+ position,null);
        return cursor;
    }

    public Cursor ShowEnglishChineseWordForAutocomplete() {
        String mypath=DB_PATH+DATABASE_NAME;
        myDictioaryWordDB=SQLiteDatabase.openDatabase(mypath,null,SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor=myDictioaryWordDB.rawQuery("Select * from dictionary_table ",null);
        return cursor;
    }
}
