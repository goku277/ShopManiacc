package com.biswadeep.developer.shopmaniacc.android.storeage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Session extends SQLiteOpenHelper {
    Context ctx;
    public Session(@Nullable Context context) {
        super(context, "usersession", null, 1);
        this.ctx= context;
    }

    public void update(String newUser, String oldUser) {
        ContentValues cv= new ContentValues();
        cv.put("login",newUser);
        String values[]= {oldUser};
        SQLiteDatabase db= this.getWritableDatabase();
        db.update("session",cv,"oldUser=?",values);
        db.close();
    }

    public void insertData(String isLoggedin) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("content",isLoggedin);
        db.insert("session",null,cv);
        db.close();
    }

    public void delete() {
        String query= "select * from session";
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor c1= db.rawQuery(query,null);
        if (c1.getCount() > 0) {
            db.delete("session", null, null);
        }
        else Toast.makeText(ctx, " sorry but no data to delete!", Toast.LENGTH_SHORT).show();
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "create table session(login text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
