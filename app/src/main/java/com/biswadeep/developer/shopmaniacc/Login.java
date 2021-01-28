package com.biswadeep.developer.shopmaniacc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.biswadeep.developer.shopmaniacc.android.storeage.AccessCredentials;
import com.biswadeep.developer.shopmaniacc.android.storeage.Session;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText user,pass;
    Button login;
    TextView gotoreg;

    AccessCredentials adb;
    Session s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        s1= new Session(Login.this);

        SQLiteDatabase dbs= s1.getWritableDatabase();
        String q11= "select * from session";
        Cursor c11= dbs.rawQuery(q11,null);
        if (c11.moveToFirst()) Toast.makeText(this, "" + c11.getString(1), Toast.LENGTH_SHORT).show();
        if (c11!=null) {
            if (c11.moveToFirst()) {
                if (c11.getString(1).equals("yes")) {
                    AlertDialog.Builder alert1= new AlertDialog.Builder(Login.this);
                    alert1.setCancelable(true);
                    alert1.setTitle("Session details");
                    String details= c11.getString(1);
                    alert1.setMessage(details);
                    AlertDialog a1= alert1.create();
                    a1.show();
                    startActivity(new Intent(Login.this, MainActivity.class));
                    finish();
                }
            }
        }

        adb= new AccessCredentials(Login.this);

        user= (EditText) findViewById(R.id.user_name_login_id);
        pass= (EditText) findViewById(R.id.password_login_id);
        login= (Button) findViewById(R.id.signin_login_id);
        gotoreg= (TextView) findViewById(R.id.gotoregister_login_id);

        login.setOnClickListener(this);
        gotoreg.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signin_login_id:
                String username= user.getText().toString().trim(), password= pass.getText().toString().trim();
                String query= "select * from username";
                SQLiteDatabase db= adb.getWritableDatabase();
                Cursor c1= db.rawQuery(query,null);
                if (c1.moveToFirst()) {
                    if (c1.getString(1).equalsIgnoreCase(username) && c1.getString(2).equalsIgnoreCase(password)) {
                        Toast.makeText(this, " Login successfull!", Toast.LENGTH_SHORT).show();
                        SQLiteDatabase dbs= s1.getWritableDatabase();
                        String q1= "select * from session";
                        Cursor c11= dbs.rawQuery(q1,null);
                        if (c11.getCount() > 0) {
                            s1.update("yes","no");
                        }
                        else if (c11.getCount() > 0) {
                            s1.insertData("yes");
                        }
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                    else Toast.makeText(this, "username or password donot match!", Toast.LENGTH_SHORT).show();
                }
                //  adb.delete();
              //  Toast.makeText(this, "Data deleted successfully!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gotoregister_login_id:
                startActivity(new Intent(getApplicationContext(), Register.class));
                finish();
                break;
        }
    }
}