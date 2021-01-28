package com.biswadeep.developer.shopmaniacc.android.storeage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccessCredentials extends SQLiteOpenHelper {
    Context context;
    public AccessCredentials(@Nullable Context context) {
        super(context, "accesscredentials", null,1);
        this.context= context;
    }

    public void insertData(String emailid, String name, String password) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("EmailId",emailid);
        cv.put("Name",name);
        cv.put("Password",password);
        db.insert("username",null,cv);
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table= "create table username(emailid text, name text, password text);";
        db.execSQL(table);
    }

    public void delete() {
        String query= "select * from username";
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor c1= db.rawQuery(query,null);
        if (c1.getCount() > 0) {
            db.delete("username", null, null);
        }
        else Toast.makeText(context, " sorry but no data to delete!", Toast.LENGTH_SHORT).show();
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    ArrayList<String> email= new ArrayList<>();
    ArrayList<String> name= new ArrayList<>();
    ArrayList<String> pass= new ArrayList<>();
    Map<String,ArrayList<String>> map= new HashMap<>();

    public Map<String, ArrayList<String>> verifyData() {
    String res[]= {"EmailId,Name,Password"};
    SQLiteDatabase db= this.getWritableDatabase();
    Cursor cur= db.query("username",res,null,null,null,null,null);
    cur.moveToFirst();
    if (cur.moveToFirst()) {
        do {
            email.add(cur.getString(0));
            name.add(cur.getString(1));
            pass.add(cur.getString(2));
            map.put("email", email);
            map.put("name", name);
            map.put("pass", pass);
        } while (cur.moveToNext());
    }
    return map;
}

    public void update(String getemail, String getuser, String getpass) {

    }
}