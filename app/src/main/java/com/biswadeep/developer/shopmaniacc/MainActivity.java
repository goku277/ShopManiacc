package com.biswadeep.developer.shopmaniacc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.biswadeep.developer.shopmaniacc.android.storeage.Session;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView food, electronics,books, clothes, food_1,electronics_1,books_1,clothes_1;
    Session s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1= new Session(MainActivity.this);

        books= (ImageView) findViewById(R.id.books_chooser_img_id);
        clothes= (ImageView) findViewById(R.id.cloth_chooser_img_id);
        food= (ImageView) findViewById(R.id.food_chooser_img_id);
        electronics= (ImageView) findViewById(R.id.electronics_chooser_img_id);

        food_1= (ImageView) findViewById(R.id.new_food_img_id);
        electronics_1= (ImageView) findViewById(R.id.new_electronics_img_id);
        books_1= (ImageView) findViewById(R.id.new_books_img_id);
        clothes_1= (ImageView) findViewById(R.id.new_clothes_img_id);


        books.setOnClickListener(this);
        clothes.setOnClickListener(this);
        food.setOnClickListener(this);
        electronics.setOnClickListener(this);

        Glide.with(MainActivity.this).load("https://stevenanichols.files.wordpress.com/2015/02/donut.jpg").centerCrop().into(food_1);
        Glide.with(MainActivity.this).load("https://gcs.thesouthafrican.com/2020/06/6efa1b16-ps5-console-playstation-5-sony-4.jpg").centerCrop().into(electronics_1);
        Glide.with(MainActivity.this).load("https://vignette.wikia.nocookie.net/kenja-no-mago/images/0/0d/Manga_Volume_2.jpg/revision/latest?cb=20171130103818").centerCrop().into(books_1);
        Glide.with(MainActivity.this).load("https://mammothworkwear.com/frontier-brown-carhartt-weathered-shirt-jacket-w1280h1024q90i13931.jpg").centerCrop().into(clothes_1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,Menu.FIRST,Menu.NONE,"Logout");
        menu.add(0,Menu.FIRST+1,Menu.NONE,"Exit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String loggedin="yes", notloggedin="no";
        switch (item.getItemId()) {
            case Menu.FIRST:
                s1.insertData(notloggedin);
                Intent logout= new Intent(MainActivity.this,Login.class);
                startActivity(logout);
                finish();
                break;
            case Menu.FIRST+1:
                int currentapiVersion = android.os.Build.VERSION.SDK_INT;


                if (currentapiVersion < 16) {
                    ActivityCompat.finishAffinity(this);
                } else if (currentapiVersion >= 16){
                    finishAffinity();
                }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.books_chooser_img_id:
                startActivity(new Intent(getApplicationContext(), Books.class));
                finish();
                break;
            case R.id.cloth_chooser_img_id:
                startActivity(new Intent(getApplicationContext(), Cloth.class));
                finish();
                break;
            case R.id.food_chooser_img_id:
                startActivity(new Intent(getApplicationContext(), Food.class));
                finish();
                break;
            case R.id.electronics_chooser_img_id:
                startActivity(new Intent(getApplicationContext(), Electronics.class));
                finish();
                break;
        }
    }
}