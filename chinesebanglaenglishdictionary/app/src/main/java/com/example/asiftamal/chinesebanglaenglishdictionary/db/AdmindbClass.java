package com.example.asiftamal.chinesebanglaenglishdictionary.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.example.asiftamal.chinesebanglaenglishdictionary.AdminDetailClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AdmindbClass extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="dictionary.db";
    private static String DB_PATH="";
    private static final String TABLE_NAME="admin_details";

    private static final String ID="Id";
    private static final String ADMIN_NAME="Admin_name";
    private static final String EMAIL="Email";
    private static final String USER_NAME="Admin_user_name";
    private static final String PASSWORD="Password";
    private static final String ENCODING_SETTING = "PRAGMA encoding ='windows-1256'";

    private static final int VERSION_NUMBER=1;
    private  Context context;
    private  SQLiteDatabase myDictioaryDB;

    private static final String CREATE_TABLE = "CREATE TABLE " +TABLE_NAME+ "  ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ADMIN_NAME+" VARCHAR(255) NOT NULL,"+EMAIL+" TEXT NOT NULL, "+USER_NAME+" TEXT NOT NULL,"+PASSWORD+" TEXT NOT NULL);";
   // private static final String CREATE_DICTIONARY_TABLE = "CREATE TABLE " +DICTIONARY_TABLE+ "  ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ADMIN_NAME+" VARCHAR(255) NOT NULL,"+EMAIL+" TEXT NOT NULL, "+USER_NAME+" TEXT NOT NULL,"+PASSWORD+" TEXT NOT NULL);";
    private static final String DROP_TABLE="DROP TABLE IF EXISTS "  +TABLE_NAME;


    public AdmindbClass(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
//        if(Build.VERSION.SDK_INT>=15){
//            DB_PATH=context.getApplicationInfo().dataDir + "/"+"database/";
//        }else {
//            DB_PATH=Environment.getDataDirectory()+"/data/"+context.getPackageName()+"/"+"database/";
//        }
        DB_PATH="/data/data/" + context.getPackageName() + "/" + "databases/";
        this.context=context;
    }


    @Override
    public void onOpen(SQLiteDatabase db) {
        if (!db.isReadOnly()) {
            db.execSQL(ENCODING_SETTING);
        }
    }
    public long insertData(AdminDetailClass admindetails){
                String myPath = DB_PATH + DATABASE_NAME;
                myDictioaryDB = SQLiteDatabase.openDatabase(myPath, null,
                        SQLiteDatabase.OPEN_READWRITE);
                       ContentValues contentValues=new ContentValues();
                       contentValues.put(ADMIN_NAME,admindetails.getName());
                           contentValues.put(PASSWORD,admindetails.getPasswword());
                           contentValues.put(USER_NAME,admindetails.getUsername());
                  //contentValues.put(ID,admindetails.getName());
                 contentValues.put(EMAIL,admindetails.getEmail());
                  long rowId= myDictioaryDB.insert(TABLE_NAME,null,contentValues);
                return rowId;
                }
                public  boolean findPassword(String user, String pass){
                   //SQLiteDatabase db=this.getReadableDatabase();
                    String myPath = DB_PATH + DATABASE_NAME;
                    myDictioaryDB = SQLiteDatabase.openDatabase(myPath, null,
                            SQLiteDatabase.OPEN_READWRITE);
                    Cursor cursor=myDictioaryDB.rawQuery("select * from admin_details",null);
                    Boolean  result=false;
                    if(cursor.getCount()==0){
                        Toast.makeText(context,"No data is found",Toast.LENGTH_LONG).show();

                    }
                    else {
                        while (cursor.moveToNext()){
                            String username= cursor.getString(3);
                            String email=cursor.getString(2);
                            String password=cursor.getString(4);
                            if ((username.equals(user)||email.equals(user))&&password.equals(pass)){
                                result=true;
                                break;
                            }

                        }
                    }
                    return result;
                }

    public Cursor ShowAllAdminDatailLV() {
        String mypath=DB_PATH+DATABASE_NAME;
        myDictioaryDB=SQLiteDatabase.openDatabase(mypath,null,SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor=myDictioaryDB.rawQuery("Select * from admin_details",null);
        return cursor;
    }
    public void checkAndCopyDatabase() throws IOException{
        boolean dbExist=checkDatabase();
        if(dbExist){
            Log.d("TAG","Already Exist");
            Toast.makeText(context,"Already Exist",Toast.LENGTH_LONG).show();
//           try {
//               copyDatabase();
//               Toast.makeText(context,"override and Copy successful",Toast.LENGTH_LONG).show();
//          }
//           catch (IOException e) {
//               e.printStackTrace();
//               Log.d("TAG","Exist but Error copy database");
//               Toast.makeText(context,"Exist but Error copy database",Toast.LENGTH_LONG).show();
//           }
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
        myDictioaryDB=SQLiteDatabase.openDatabase(mypath,null,SQLiteDatabase.OPEN_READWRITE);
    }
    public synchronized void close(){
        if(myDictioaryDB!=null){
            myDictioaryDB.close();
        }
        super.close();
    }
    public Cursor retriveadmindataforupdate(int position) {
        String mypath=DB_PATH+DATABASE_NAME;
        myDictioaryDB=SQLiteDatabase.openDatabase(mypath,null,SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor=myDictioaryDB.rawQuery("Select * from admin_details where Id="+ position,null);
        return cursor;
    }
    public boolean Updatedata(String adminid, String adminnamee, String email, String user, String password) {
        String myPath = DB_PATH + DATABASE_NAME;
        myDictioaryDB = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READWRITE);
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID,adminid);
        contentValues.put(ADMIN_NAME,adminnamee);
        contentValues.put(PASSWORD,password);
        contentValues.put(USER_NAME,user);
        //contentValues.put(ID,admindetails.getName());
        contentValues.put(EMAIL,email);
        myDictioaryDB.update(TABLE_NAME,contentValues,ID+"=?",new String[]{adminid});
        return true;
    }
    public int DeleteData(long adminid){
        String myPath = DB_PATH + DATABASE_NAME;
        myDictioaryDB = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READWRITE);
        return myDictioaryDB.delete(TABLE_NAME,ID+"=?",new String[]{String.valueOf(adminid)});
    }
    public Cursor QueryData(String query){
        return myDictioaryDB.rawQuery(query,null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
               // db.execSQL(CREATE_TABLE);
            Toast.makeText(context,"OnCreate is called",Toast.LENGTH_LONG).show();

        }
        catch (Exception e){
            Toast.makeText(context,"Exception: "+e,Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context,"onUpgrade is called",Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);


        }
        catch (Exception e){
            Toast.makeText(context,"Exception: "+e,Toast.LENGTH_LONG).show();
        }
    }


}
