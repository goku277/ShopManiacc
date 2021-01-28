package com.biswadeep.developer.shopmaniacc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.biswadeep.developer.shopmaniacc.android.storeage.CartStorage;
import com.biswadeep.developer.shopmaniacc.android.storeage.c_store;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    private ArrayList<String> content11= new ArrayList<>();
    private ArrayList<String> price11= new ArrayList<>();
    private ArrayList<String> image_url= new ArrayList<>();
    final static String TAG="Cart";
    c_store cs;
    CartAdapter cad;

    BottomNavigationView bv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cs= new c_store(Cart.this);

        bv= (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bv.setOnNavigationItemSelectedListener(navListener);

        init();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home_cart_bottom_nav:
                    startActivity(new Intent(Cart.this,MainActivity.class));
                    finish();
                    break;
                case R.id.food_cart_bottom_nav:
                    startActivity(new Intent(Cart.this, Food.class));
                    finish();
                    break;
                case R.id.books_cart_bottom_nav:
                    startActivity(new Intent(Cart.this, Books.class));
                    finish();
                    break;
                case R.id.cloth_cart_bottom_nav:
                    startActivity(new Intent(Cart.this, Cloth.class));
                    finish();
                    break;
                case R.id.electronics_cart_bottom_nav:
                    startActivity(new Intent(Cart.this, Electronics.class));
                    finish();
                    break;

            }
            return false;
        }
    };

    private void init() {
        Intent getData = getIntent();
        String content_1 = getData.getStringExtra("mycontent"), price_1 = getData.getStringExtra("myprice"), img_url = getData.getStringExtra("myimageurl");
        System.out.println("content_1 and price_1 are: " + content_1 + " " + price_1 + " " + img_url);

        cs.insertData(content_1, price_1, img_url);
        String query = "select * from cart";
        SQLiteDatabase db = cs.getWritableDatabase();
        Cursor c1 = db.rawQuery(query, null);

        if (c1 != null && c1.getCount() > 0) {
                if (c1.moveToFirst()) {
                    do {
                        content11.add(c1.getString(0));
                        price11.add(c1.getString(1));
                        image_url.add(c1.getString(2));
                    } while (c1.moveToNext());
                }
            }
            initRecyclerView();
        }

        private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: started");

        RecyclerView recyclerView= findViewById(R.id.recycler_view_cart);
        cad= new CartAdapter(content11,price11,image_url,Cart.this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(cad);
        recyclerView.setLayoutManager(new LinearLayoutManager(Cart.this));
        RecyclerView.ViewHolder viewHolder = null;
    }

    ItemTouchHelper.SimpleCallback itemTouchHelperCallback= new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            SQLiteDatabase db= cs.getWritableDatabase();
            cs.delete(content11.get(viewHolder.getAdapterPosition()), price11.get(viewHolder.getAdapterPosition()));
            content11.remove(viewHolder.getAdapterPosition());
            price11.remove(viewHolder.getAdapterPosition());
            cad.notifyDataSetChanged();
        }
    };
}