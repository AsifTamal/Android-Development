package com.brighteststar.asiftamal.csharpaspnetinterviewquestion.dbHelper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Environment;

public class dbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="csharpinterviewquestion.db";
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





    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        if(Build.VERSION.SDK_INT>=15){

            DB_PATH=Environment.getDataDirectory()+"/data/"+context.getPackageName()+"/"+"databases/";
        }else {
            DB_PATH=Environment.getDataDirectory()+"/data/"+context.getPackageName()+"/"+"databases/";
        }

        this.context=context;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
