package com.biswadeep.developer.shopmaniacc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Cloth extends AppCompatActivity implements Adapter_2.onPanelClickListener{

    ArrayList<String> ImgUrl= new ArrayList<>();
    List<ClothModel> cloths;
    RecyclerView recyclerView;
    LinearLayoutManager Manager;
    Adapter_2 adapter;

    BottomNavigationView bv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        cloths= new ArrayList<>();

        bv= (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bv.setOnNavigationItemSelectedListener(navListener);

        ImgUrl.add("https://ae01.alicdn.com/kf/HTB1PvjEJVXXXXbjXpXXq6xXFXXXb/2016-Designer-s-Sky-Blue-Chiffon-Evening-Dress-Long-Lace-Halter-Prom-Dress-Summer-Style-robe.jpg"); // Blue dress for women
        ImgUrl.add("https://ae01.alicdn.com/kf/HTB1Y4vQHVXXXXXJXpXXq6xXFXXX5/Women-s-spring-2014-summer-dress-casual-dress-party-dresses-long-dress-O-neck-short-sleeve.jpg"); // Green dress for women
        ImgUrl.add("https://images.cbazaar.com/images/navy-blue-art-silk-angrakha-sherwani-shmarc3203-u.jpg");  // Golden dress for men
        // php book
        ImgUrl.add("https://www.galstyles.com/wp-content/uploads/2015/09/Latest-Men-Wedding-Suits-Dresses-Collection-2015-2016-19.jpg"); // Silver coat and pant for men
        ImgUrl.add("https://images.halloweencostumes.com/products/1029/1-1/mens-green-shoes.jpg");  // Green shoe for men
        ImgUrl.add("https://www.taghats.com/wp-content/uploads/2015/05/Dobbs-Hats-for-Men.jpg"); // Hat for men
        ImgUrl.add("https://ae01.alicdn.com/kf/HTB1EcDCPVXXXXacXXXXq6xXFXXXL/Casual-Multi-Colored-Glitter-Sequin-Loafers-Mens-Dress-Shoes-Men-Flats-Shoes-Luxury-Fashion-Brand-Chaussures.jpg"); // Black shoe for women
        ImgUrl.add("https://thumbs.dreamstime.com/x/men-s-white-dress-hat-10067969.jpg"); // White hat for men
        ImgUrl.add("http://pngriver.com/wp-content/uploads/2017/11/ound-images-free-download-clipart-pics-dress_shirt_PNG8114.png"); // Red shirt with black stripe
        ImgUrl.add("https://media03.toms.com/static/www/images/product/MENS/ATG/HERO/10011584-BlackLinenMensPreston-S1-1450x1015.jpg"); // Black casual shoe for men
        ImgUrl.add("https://dolcefugo.net/images/large/burberry_drshirt_134_g.jpg"); // Black shirt for men
        ImgUrl.add("https://ae01.alicdn.com/kf/HTB1zBZqRFXXXXapXFXXq6xXFXXX0/Summer-Women-Dress-Plus-Size-Jeans-Denim-Dress-Women-4XL-V-neck-Sexy-Casual-Office-Jeans.jpg");  // Blue jeans for women
        ImgUrl.add("https://ae01.alicdn.com/kf/HTB1dovPPpXXXXbuXXXXq6xXFXXXh/2017-New-Arrival-Fashion-Baseball-Caps-Camo-baseball-hats-Men-Casual-Top-Quality-Peaked-Caps-55.jpg");  // Green cap for men
        ImgUrl.add("https://cdnd.lystit.com/photos/2013/09/18/blackcouk-grey-mens-grey-cashmere-socks-product-1-13560887-241626659.jpeg"); // Grey socks for men

      /*  ClothModel bm= new ClothModel();
        // bm.setImageurl("https://goalkicker.com/AndroidBook/AndroidGrow.png");
        bm.setTitle("Android");
        bm.setColor("700 pages");

        cloths.add(0,bm);

        //  bm.setImageurl("http://eurodroid.com/pics/beginning_android_book.jpg");
        bm.setTitle("Android for beginner");
        bm.setColor("400 pages");

        cloths.add(1,bm);

        //  bm.setImageurl("https://www.compsmag.com/wp-content/uploads/2015/08/Beginning-PHP-and-MySQL-Book.jpg");
        bm.setTitle("php mysql");
        bm.setColor("700 pages");

        cloths.add(2,bm);

        //   bm.setImageurl("https://mercury.marmot.org/bookcover.php?size=large&format=Book&isn=9781454926122");
        bm.setTitle("php");
        bm.setColor("500 pages");

        cloths.add(3,bm);

        //   bm.setImageurl("https://whatshappbangalore.files.wordpress.com/2014/02/chacha-chaudhary-21.jpg?w=234&h=290");
        bm.setTitle("Chacha Choudhry comic book");
        bm.setColor("200 pages");

        cloths.add(4,bm);


        //    bm.setImageurl("https://2.bp.blogspot.com/-2x83VuKD4cs/UsSSlT4A68I/AAAAAAAADfM/ipiHrklfXZA/s1600/Scooby-Doo_CP_2014_Book+4_Cover_Printed.jpg");
        bm.setTitle("Scooby doo comic book");
        bm.setColor("200 pages");

        cloths.add(5,bm);

        //    bm.setImageurl("https://lostinanime.com/wp-content/uploads/2016/05/Hunter-X-Hunter-354-3.jpg");
        bm.setTitle("HunterXHunter manga");
        bm.setColor("80 pages");

        cloths.add(6,bm);

        //    bm.setImageurl("https://46nh0w2bddoq3ydz0yb6vnb1-wpengine.netdna-ssl.com/wp-content/uploads/2015/09/javascript-for-kids-for-dummies.jpg");
        bm.setTitle("Javascript for kids");
        bm.setColor("700 pages");

        cloths.add(7,bm);

        //    bm.setImageurl("https://www.journaldev.com/wp-content/uploads/2014/11/Head_First_Java_Kathy_Sierra_Bert_Bates.jpg");
        bm.setTitle("Head first java");
        bm.setColor("500 pages");

        cloths.add(8,bm);

        //    bm.setImageurl("https://covers.oreillystatic.com/images/9780596514273/lrg.jpg");
        bm.setTitle("Regular Expressions");
        bm.setColor("160 pages");

        cloths.add(9,bm);

        //    bm.setImageurl("https://cdn-images-1.medium.com/max/1600/0*Y9k47tv3KPIvetcV.jpg");
        bm.setTitle("Python book");
        bm.setColor("200 pages");

        cloths.add(10,bm);

        //    bm.setImageurl("http://www.programmerfish.com/wp-content/uploads/2011/03/image6.png");
        bm.setTitle("Data structures and algorithms");
        bm.setColor("500 pages");

        cloths.add(11,bm);

        //    bm.setImageurl("https://3.bp.blogspot.com/-nSkW0WKbfMA/VF5oY9nTv8I/AAAAAAAABok/I7RHe67nD5c/s1600/naruto_manga_cover_63_by_chekoaguilar-d5pa3ym.jpg");
        bm.setTitle("Naruto shippuden manga");
        bm.setColor("500 pages");

        cloths.add(12,bm);

        //    bm.setImageurl("https://vignette1.wikia.nocookie.net/dragonball/images/1/15/DBS-0.png/revision/latest?cb=20160126203700");
        bm.setTitle("Dragon ball super manga");
        bm.setColor("400 pages");

        cloths.add(13,bm);   */



        this.recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        Manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(Manager);
        adapter = new Adapter_2(this,ImgUrl, cloths,this);
        recyclerView.setAdapter(adapter);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    startActivity(new Intent(Cloth.this,MainActivity.class));
                    finish();
                    break;
                case R.id.cart:
                    startActivity(new Intent(Cloth.this, Cart.class));
                    finish();
                    break;
            }
            return false;
        }
    };

    @Override
    public void onPanelClick(int position) {
        Toast.makeText(this, " " + position, Toast.LENGTH_SHORT).show();

        String content="", price="", img_url="";
        if (position==0) {
            content="Blue dress for women";
            price= "500";
            img_url="https://ae01.alicdn.com/kf/HTB1PvjEJVXXXXbjXpXXq6xXFXXXb/2016-Designer-s-Sky-Blue-Chiffon-Evening-Dress-Long-Lace-Halter-Prom-Dress-Summer-Style-robe.jpg";
        }
        else if (position==1) {
            content="Green dress for women";
            price= "2500";
            img_url="https://ae01.alicdn.com/kf/HTB1Y4vQHVXXXXXJXpXXq6xXFXXX5/Women-s-spring-2014-summer-dress-casual-dress-party-dresses-long-dress-O-neck-short-sleeve.jpg";
        }
        else if (position==2) {
            content="Golden dress for men";
            price= "3500";
            img_url="https://images.cbazaar.com/images/navy-blue-art-silk-angrakha-sherwani-shmarc3203-u.jpg";
        }
        else if (position==3) {
            content="Silver coat and pant for men";
            price= "7500";
            img_url="https://www.galstyles.com/wp-content/uploads/2015/09/Latest-Men-Wedding-Suits-Dresses-Collection-2015-2016-19.jpg";
        }
        else if (position==4) {
            content="Green shoe for men";
            price= "2000";
            img_url="https://images.halloweencostumes.com/products/1029/1-1/mens-green-shoes.jpg";
        }
        else if (position==5) {
            content="Hat for men";
            price= "700";
            img_url="https://images.halloweencostumes.com/products/1029/1-1/mens-green-shoes.jpg";
        }
        else if (position==6) {
            content="Black shoe for women";
            price= "2500";
            img_url="https://ae01.alicdn.com/kf/HTB1EcDCPVXXXXacXXXXq6xXFXXXL/Casual-Multi-Colored-Glitter-Sequin-Loafers-Mens-Dress-Shoes-Men-Flats-Shoes-Luxury-Fashion-Brand-Chaussures.jpg";
        }
        else if (position==7) {
            content="White hat for men";
            price= "500";
            img_url="https://thumbs.dreamstime.com/x/men-s-white-dress-hat-10067969.jpg";
        }
        else if (position==8) {
            content="Red shirt with black stripe";
            price= "700";
            img_url="http://pngriver.com/wp-content/uploads/2017/11/ound-images-free-download-clipart-pics-dress_shirt_PNG8114.png";
        }
        else if (position==9) {
            content="White hat for men";
            price= "1500";
            img_url="https://thumbs.dreamstime.com/x/men-s-white-dress-hat-10067969.jpg";
        }
        else if (position==10) {
            content = "Black casual shoe for men";
            price= "2500";
            img_url="https://media03.toms.com/static/www/images/product/MENS/ATG/HERO/10011584-BlackLinenMensPreston-S1-1450x1015.jpg";
        }
        else if (position==11) {
            content="Black shirt for men";
            price= "500";
            img_url="https://dolcefugo.net/images/large/burberry_drshirt_134_g.jpg";
        }
        else if (position==12) {
            content="Green cap for men";
            price= "700";
            img_url="https://ae01.alicdn.com/kf/HTB1dovPPpXXXXbuXXXXq6xXFXXXh/2017-New-Arrival-Fashion-Baseball-Caps-Camo-baseball-hats-Men-Casual-Top-Quality-Peaked-Caps-55.jpg";
        }
        else if (position==13) {
            content = "Socks for men";
            price= "2000";
            img_url="https://cdnd.lystit.com/photos/2013/09/18/blackcouk-grey-mens-grey-cashmere-socks-product-1-13560887-241626659.jpeg";
        }

        alert(content,price,img_url);
    }

    private void alert(final String content, final String price, final String img_url) {

       /* Intent sendData= new Intent(Food.this, CustomDialog.class);
        sendData.putExtra("mycontext", String.valueOf(Food.this));
        sendData.putExtra("mycontent",content);
        sendData.putExtra("myprice",price);
        startActivity(sendData);  */



        final AlertDialog.Builder builder1 = new AlertDialog.Builder(Cloth.this);

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

                        AlertDialog.Builder builder2 = new AlertDialog.Builder(Cloth.this);

                        builder2.setTitle("payment options");

                        builder2.setMessage("\nChoose your payment options from the two provided\n\n");

                        builder2.setCancelable(false);

                        builder2.setPositiveButton("Pay on delivery",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(Cloth.this, "Due to high demand and to ensure social distancing, Pay on Delivery is not available.", Toast.LENGTH_LONG).show();
                                        dialog.cancel();
                                    }
                                });
                        builder2.setNegativeButton("Google pay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Cloth.this, "Proceeding to the payment section", Toast.LENGTH_SHORT).show();
                                // startActivity(new Intent(Food.this, Payment_Activity.class));
                                Intent sendData= new Intent(Cloth.this, Payment_Activity.class);
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
                AlertDialog.Builder builder11 = new AlertDialog.Builder(Cloth.this);

                builder11.setTitle("Add to cart");
                builder11.setCancelable(false);

                builder11.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // startActivity(new Intent(Food.this, Cart.class));
                        Intent sendData= new Intent(Cloth.this, Cart.class);
                        sendData.putExtra("mycontent",content);
                        sendData.putExtra("myprice",price);
                        sendData.putExtra("myimageurl",img_url);
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