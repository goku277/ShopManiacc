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

public class Register extends AppCompatActivity implements View.OnClickListener {

    EditText email, user, pass;
    Button reg;
    TextView gotologin;

    AccessCredentials adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        adb= new AccessCredentials(Register.this);

        email= (EditText) findViewById(R.id.email_register_id);
        user= (EditText) findViewById(R.id.username_register_id);
        pass= (EditText) findViewById(R.id.password_register_id);

        reg= (Button) findViewById(R.id.button);

        gotologin= (TextView) findViewById(R.id.gotologin__id);

        reg.setOnClickListener(this);
        gotologin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Toast.makeText(this, " Registration is successful!", Toast.LENGTH_SHORT).show();
                String getemail= email.getText().toString().trim(), getuser= user.getText().toString().trim(), getpass= pass.getText().toString().trim();
                SQLiteDatabase db= adb.getWritableDatabase();
                Cursor c1= db.rawQuery("select * from username",null);
                if (c1.getCount() < 1) {
                    adb.insertData(getemail, getuser, getpass);
                    System.out.println(adb.verifyData());
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                }
                else if (c1.getCount() >= 1) {
                    AlertDialog.Builder ad = new AlertDialog.Builder(this);
                    ad.setTitle("Wrong attemp!");
                    ad.setMessage("You are already registered! Only single registration allowed!");
                    ad.show();
                }
                break;
            case R.id.gotologin__id:
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                break;
        }
    }

}