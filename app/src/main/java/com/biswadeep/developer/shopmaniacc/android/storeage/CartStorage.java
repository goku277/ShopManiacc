package com.biswadeep.developer.shopmaniacc.android.storeage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CartStorage extends SQLiteOpenHelper {
    Context ctx;
    public CartStorage(@Nullable Context context) {
        super(context, "cartstorage", null, 1);
        this.ctx= context;
    }

    public void insertData(String content, String price, String image) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("content",content);
        cv.put("price",price);
        cv.put("imageurl",image);
        db.insert("cart",null,cv);
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "create table cart(content text, price text, imageurl text);";
        db.execSQL(query);
    }

    public void delete() {
        String query= "select * from cart";
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor c1= db.rawQuery(query,null);
        if (c1.getCount() > 0) {
            db.delete("cart", null, null);
        }
        else Toast.makeText(ctx, " sorry but no data to delete!", Toast.LENGTH_SHORT).show();
        db.close();
    }

    public void delete(String content11, String price11) {
        String cols[]= {content11,price11};
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete("cart","content=? and price = ?", cols);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}