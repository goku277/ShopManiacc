package com.biswadeep.developer.shopmaniacc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Food extends AppCompatActivity implements Adapter_4.onPanelClickListener {

    ArrayList<String> ImgUrl= new ArrayList<>();
    List<FoodModel> foods;
    RecyclerView recyclerView;
    LinearLayoutManager Manager;
    Adapter_4 adapter;
    List<ClothModel> cmList;

    BottomNavigationView bv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        foods= new ArrayList<>();

        cmList= new ArrayList<>();

        bv= (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bv.setOnNavigationItemSelectedListener(navListener);

        ImgUrl.add("https://cdn-images-1.medium.com/max/1200/1*5TFY5poxnDCtOGkrV3ThGg.jpeg"); // Burger
        ImgUrl.add("https://deliciouspot.files.wordpress.com/2012/10/img_3725.jpg"); // Puff
        ImgUrl.add("https://www.realbharat.org/wp-content/uploads/2015/10/laddoo_boondi.jpg");  // Laddoo
        // php book
        ImgUrl.add("https://i2.wp.com/www.spainonafork.com/wp-content/uploads/2019/04/popcornHOR-11.png?fit=750%2C750&ssl=1"); // Popcorn
        ImgUrl.add("https://i.ytimg.com/vi/kAJwMEWEnyg/maxresdefault.jpg");  // Samosa
        ImgUrl.add("https://rasamalaysia.com/wp-content/uploads/2019/03/tandoori-chicken1.jpg"); // Chicken tandoori
        ImgUrl.add("https://delightfulemade.com/wp-content/uploads/2014/07/Grilled-Chicken-and-Plum-Skewers-by-DelightfulEMade.com-vert2.png"); // Grill chicken
        ImgUrl.add("http://www.samanthastephens.com/wp-content/uploads/2014/02/coke.png"); // Cola
        ImgUrl.add("https://i.ytimg.com/vi/aafmrrx7Bh4/maxresdefault.jpg"); // Ramen
        ImgUrl.add("https://simpleveganblog.com/wp-content/uploads/2020/04/Baked-Frech-Fries-3.jpg"); // French Fries
        ImgUrl.add("https://foodcomas.files.wordpress.com/2012/01/2012-01-13-garlic_butter_noodles-15.jpg"); // Noodles
        ImgUrl.add("https://outlet.sg/wp-content/uploads/2018/10/pepsi.jpg");  // Pepsi
        ImgUrl.add("http://spicyworld.in/recipeimages/mutton-biriyani.jpg");  // Biriyani
        ImgUrl.add("https://i.ytimg.com/vi/PWsBG0_asnQ/maxresdefault.jpg"); // Paneer Manchurian

        FoodModel bm= new FoodModel();
        // bm.setImageurl("https://goalkicker.com/AndroidBook/AndroidGrow.png");
        bm.setTitle("Burger");
        bm.setPrice("50/-");

        foods.add(0,bm);

        //  bm.setImageurl("http://eurodroid.com/pics/beginning_android_book.jpg");
        bm.setTitle("Puff");
        bm.setPrice("5/-");

        foods.add(1,bm);

        //  bm.setImageurl("https://www.compsmag.com/wp-content/uploads/2015/08/Beginning-PHP-and-MySQL-Book.jpg");
        bm.setTitle("Laddoo");
        bm.setPrice("10/-");

        foods.add(2,bm);

        //   bm.setImageurl("https://mercury.marmot.org/bookcover.php?size=large&format=Book&isn=9781454926122");
        bm.setTitle("Popcorn");
        bm.setPrice("50/-");

        foods.add(3,bm);

        //   bm.setImageurl("https://whatshappbangalore.files.wordpress.com/2014/02/chacha-chaudhary-21.jpg?w=234&h=290");
        bm.setTitle("Samosa");
        bm.setPrice("10/-");

        foods.add(4,bm);


        //    bm.setImageurl("https://2.bp.blogspot.com/-2x83VuKD4cs/UsSSlT4A68I/AAAAAAAADfM/ipiHrklfXZA/s1600/Scooby-Doo_CP_2014_Book+4_Cover_Printed.jpg");
        bm.setTitle("Chicken tandoori");
        bm.setPrice("100/-");

        foods.add(5,bm);

        //    bm.setImageurl("https://lostinanime.com/wp-content/uploads/2016/05/Hunter-X-Hunter-354-3.jpg");
        bm.setTitle("Grill chicken");
        bm.setPrice("100/-");

        foods.add(6,bm);

        //    bm.setImageurl("https://46nh0w2bddoq3ydz0yb6vnb1-wpengine.netdna-ssl.com/wp-content/uploads/2015/09/javascript-for-kids-for-dummies.jpg");
        bm.setTitle("Coke");
        bm.setPrice("45/-");

        foods.add(7,bm);

        //    bm.setImageurl("https://www.journaldev.com/wp-content/uploads/2014/11/Head_First_Java_Kathy_Sierra_Bert_Bates.jpg");
        bm.setTitle("Ramen");
        bm.setPrice("400/-");

        foods.add(8,bm);

        //    bm.setImageurl("https://covers.oreillystatic.com/images/9780596514273/lrg.jpg");
        bm.setTitle("French Fries");
        bm.setPrice("50/-");

        foods.add(9,bm);

        //    bm.setImageurl("https://cdn-images-1.medium.com/max/1600/0*Y9k47tv3KPIvetcV.jpg");
        bm.setTitle("Noodles");
        bm.setPrice("20/-");

        foods.add(10,bm);

        //    bm.setImageurl("http://www.programmerfish.com/wp-content/uploads/2011/03/image6.png");
        bm.setTitle("Pepsi");
        bm.setPrice("45/-");

        foods.add(11,bm);

        //    bm.setImageurl("https://3.bp.blogspot.com/-nSkW0WKbfMA/VF5oY9nTv8I/AAAAAAAABok/I7RHe67nD5c/s1600/naruto_manga_cover_63_by_chekoaguilar-d5pa3ym.jpg");
        bm.setTitle("Biriyani");
        bm.setPrice("150/-");

        foods.add(12,bm);

        //    bm.setImageurl("https://vignette1.wikia.nocookie.net/dragonball/images/1/15/DBS-0.png/revision/latest?cb=20160126203700");
        bm.setTitle("Paneer manchurian");
        bm.setPrice("200/-");

        foods.add(13,bm);

        System.out.println("foods.add(bm) " + foods);



        this.recyclerView = (RecyclerView)findViewById(R.id.food_list_id);
        Manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(Manager);
        adapter = new Adapter_4(this,ImgUrl, foods, this);
        recyclerView.setAdapter(adapter);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    startActivity(new Intent(Food.this,MainActivity.class));
                    finish();
                    break;
                case R.id.cart:
                    startActivity(new Intent(Food.this, Cart.class));
                    finish();
                    break;
            }
            return false;
        }
    };

    @Override
    public void onPanelClick(int position) {
        Toast.makeText(this, " " + position, Toast.LENGTH_SHORT).show();

        String content="", price="", imageurl="";
        if (position==0) {
            content="Burger";
            price="50";
            imageurl="https://cdn-images-1.medium.com/max/1200/1*5TFY5poxnDCtOGkrV3ThGg.jpeg";
        }
        else if (position==1) {
            content="Puff";
            price="5";
            imageurl="https://deliciouspot.files.wordpress.com/2012/10/img_3725.jpg";
        }
        else if (position==2) {
            content="Laddoo";
            price="10";
            imageurl="https://www.realbharat.org/wp-content/uploads/2015/10/laddoo_boondi.jpg";
        }
        else if (position==3) {
            content="Popcorn";
            price="50";
            imageurl="https://i2.wp.com/www.spainonafork.com/wp-content/uploads/2019/04/popcornHOR-11.png?fit=750%2C750&ssl=1";
        }
        else if (position==4) {
            content="Samosa";
            price="10";
            imageurl="https://i.ytimg.com/vi/kAJwMEWEnyg/maxresdefault.jpg";
        }
        else if (position==5) {
            content="Chicken tandoori";
            price="100";
            imageurl="https://rasamalaysia.com/wp-content/uploads/2019/03/tandoori-chicken1.jpg";
        }
        else if (position==6) {
            content="Grill chicken";
            price="100";
            imageurl="https://delightfulemade.com/wp-content/uploads/2014/07/Grilled-Chicken-and-Plum-Skewers-by-DelightfulEMade.com-vert2.png";
        }
        else if (position==7) {
            content="Coke";
            price="45";
            imageurl="http://www.samanthastephens.com/wp-content/uploads/2014/02/coke.png";
        }
        else if (position==8) {
            content="Ramen";
            price="400";
            imageurl="https://i.ytimg.com/vi/aafmrrx7Bh4/maxresdefault.jpg";
        }
        else if (position==9) {
            content="French Fries";
            price="50";
            imageurl="https://simpleveganblog.com/wp-content/uploads/2020/04/Baked-Frech-Fries-3.jpg";
        }
        else if (position==10) {
            content = "Noodles";
            price="20";
            imageurl="https://foodcomas.files.wordpress.com/2012/01/2012-01-13-garlic_butter_noodles-15.jpg";
        }
        else if (position==11) {
            content="Pepsi";
            price="45";
            imageurl="https://outlet.sg/wp-content/uploads/2018/10/pepsi.jpg";
        }
        else if (position==12) {
            content="Biriyani";
            price="150";
            imageurl="http://spicyworld.in/recipeimages/mutton-biriyani.jpg";
        }
        else if (position==13) {
            content = "Paneer manchurian";
            price="200";
            imageurl="https://i.ytimg.com/vi/PWsBG0_asnQ/maxresdefault.jpg";
        }

        alert(content,price,imageurl);

    }

    public Context sendContext() {
        return Food.this;
    }


    private void alert(final String content, final String price, final String imageurl) {

       /* Intent sendData= new Intent(Food.this, CustomDialog.class);
        sendData.putExtra("mycontext", String.valueOf(Food.this));
        sendData.putExtra("mycontent",content);
        sendData.putExtra("myprice",price);
        startActivity(sendData);  */



        final AlertDialog.Builder builder1 = new AlertDialog.Builder(Food.this);

        final ImageView image = new ImageView(this);


        builder1.setTitle(content + " " + price);
        builder1.setMessage("\nPay " + price + " bucks for this " + content + " item");
        builder1.setCancelable(true);

        builder1.setCancelable(false);

      //  builder1.setPositiveButtonIcon(android.R.drawable.ic_menu_add);

        builder1.setPositiveButton(
                "Go to payments",
                new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, int id) {
                        // dialog.cancel();

                        AlertDialog.Builder builder2 = new AlertDialog.Builder(Food.this);

                        builder2.setTitle("payment options");

                        builder2.setMessage("\nChoose your payment options from the two provided\n\n");

                        builder2.setCancelable(false);

                        builder2.setPositiveButton("Pay on delivery",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(Food.this, "Due to high demand and to ensure social distancing, Pay on Delivery is not available.", Toast.LENGTH_LONG).show();
                                        dialog.cancel();
                                    }
                                });
                        builder2.setNegativeButton("Google pay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Food.this, "Proceeding to the payment section", Toast.LENGTH_SHORT).show();
                               // startActivity(new Intent(Food.this, Payment_Activity.class));
                                Intent sendData= new Intent(Food.this, Payment_Activity.class);
                                sendData.putExtra("activityname", "Food");
                                startActivity(sendData);
                                finish();
                            }
                        });

                        AlertDialog alert111 = builder2.create();
                        alert111.show();

                    }
                });

        builder1.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder1.setNeutralButton("Add to cart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder builder11 = new AlertDialog.Builder(Food.this);

                builder11.setTitle("Add to cart");
                builder11.setCancelable(false);

                builder11.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       // startActivity(new Intent(Food.this, Cart.class));
                        Intent sendData= new Intent(Food.this, Cart.class);
                        sendData.putExtra("mycontent",content);
                        sendData.putExtra("myprice",price);
                        sendData.putExtra("myimageurl",imageurl);
                        startActivity(sendData);
                        finish();
                    }
                });

                builder11.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog alert111 = builder11.create();
                alert111.show();

            }
        });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}