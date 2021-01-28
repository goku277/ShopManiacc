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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Books extends AppCompatActivity implements Adapter_1.onPanelClickListener{

    ArrayList<String> ImgUrl= new ArrayList<>();
    List<BookModel> books;
    RecyclerView recyclerView;
    LinearLayoutManager Manager;
    Adapter_1 adapter;
    BottomNavigationView bv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        bv= (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bv.setOnNavigationItemSelectedListener(navListener);

        books= new ArrayList<>();

        ImgUrl.add("https://goalkicker.com/AndroidBook/AndroidGrow.png"); // Head First Android
        ImgUrl.add("http://eurodroid.com/pics/beginning_android_book.jpg"); // Android book
        ImgUrl.add("https://www.compsmag.com/wp-content/uploads/2015/08/Beginning-PHP-and-MySQL-Book.jpg");
        // php book
        ImgUrl.add("https://mercury.marmot.org/bookcover.php?size=large&format=Book&isn=9781454926122"); // Game reading book
        ImgUrl.add("https://whatshappbangalore.files.wordpress.com/2014/02/chacha-chaudhary-21.jpg?w=234&h=290");  // chacha choudhry
        ImgUrl.add("https://2.bp.blogspot.com/-2x83VuKD4cs/UsSSlT4A68I/AAAAAAAADfM/ipiHrklfXZA/s1600/Scooby-Doo_CP_2014_Book+4_Cover_Printed.jpg"); // scooby doo
        ImgUrl.add("https://lostinanime.com/wp-content/uploads/2016/05/Hunter-X-Hunter-354-3.jpg"); // HunterXHunter
        ImgUrl.add("https://46nh0w2bddoq3ydz0yb6vnb1-wpengine.netdna-ssl.com/wp-content/uploads/2015/09/javascript-for-kids-for-dummies.jpg"); // Java script for kids
        ImgUrl.add("https://www.journaldev.com/wp-content/uploads/2014/11/Head_First_Java_Kathy_Sierra_Bert_Bates.jpg"); // Head First Java
        ImgUrl.add("https://covers.oreillystatic.com/images/9780596514273/lrg.jpg"); // Regular Expression
        ImgUrl.add("https://cdn-images-1.medium.com/max/1600/0*Y9k47tv3KPIvetcV.jpg"); // Python Book
        ImgUrl.add("http://www.programmerfish.com/wp-content/uploads/2011/03/image6.png");  // Data Structures And Algorithms
        ImgUrl.add("https://3.bp.blogspot.com/-nSkW0WKbfMA/VF5oY9nTv8I/AAAAAAAABok/I7RHe67nD5c/s1600/naruto_manga_cover_63_by_chekoaguilar-d5pa3ym.jpg");  // Naruto Manga
        ImgUrl.add("https://vignette1.wikia.nocookie.net/dragonball/images/1/15/DBS-0.png/revision/latest?cb=20160126203700"); // Dragon Ball Super Manga

        BookModel bm= new BookModel();
       // bm.setImageurl("https://goalkicker.com/AndroidBook/AndroidGrow.png");
        bm.setTitle("Android for professional");
        bm.setPage("700 pages");

        books.add(0,bm);

      //  bm.setImageurl("http://eurodroid.com/pics/beginning_android_book.jpg");
        bm.setTitle("Android for beginner");
        bm.setPage("400 pages");

        books.add(1,bm);

      //  bm.setImageurl("https://www.compsmag.com/wp-content/uploads/2015/08/Beginning-PHP-and-MySQL-Book.jpg");
        bm.setTitle("php mysql");
        bm.setPage("700 pages");

        books.add(2,bm);

     //   bm.setImageurl("https://mercury.marmot.org/bookcover.php?size=large&format=Book&isn=9781454926122");
        bm.setTitle("php");
        bm.setPage("500 pages");

        books.add(3,bm);

     //   bm.setImageurl("https://whatshappbangalore.files.wordpress.com/2014/02/chacha-chaudhary-21.jpg?w=234&h=290");
        bm.setTitle("Chacha Choudhry comic book");
        bm.setPage("200 pages");

        books.add(4,bm);


    //    bm.setImageurl("https://2.bp.blogspot.com/-2x83VuKD4cs/UsSSlT4A68I/AAAAAAAADfM/ipiHrklfXZA/s1600/Scooby-Doo_CP_2014_Book+4_Cover_Printed.jpg");
        bm.setTitle("Scooby doo comic book");
        bm.setPage("200 pages");

        books.add(5,bm);

    //    bm.setImageurl("https://lostinanime.com/wp-content/uploads/2016/05/Hunter-X-Hunter-354-3.jpg");
        bm.setTitle("HunterXHunter manga");
        bm.setPage("80 pages");

        books.add(6,bm);

    //    bm.setImageurl("https://46nh0w2bddoq3ydz0yb6vnb1-wpengine.netdna-ssl.com/wp-content/uploads/2015/09/javascript-for-kids-for-dummies.jpg");
        bm.setTitle("Javascript for kids");
        bm.setPage("700 pages");

        books.add(7,bm);

    //    bm.setImageurl("https://www.journaldev.com/wp-content/uploads/2014/11/Head_First_Java_Kathy_Sierra_Bert_Bates.jpg");
        bm.setTitle("Head first java");
        bm.setPage("500 pages");

        books.add(8,bm);

    //    bm.setImageurl("https://covers.oreillystatic.com/images/9780596514273/lrg.jpg");
        bm.setTitle("Regular Expressions");
        bm.setPage("160 pages");

        books.add(9,bm);

    //    bm.setImageurl("https://cdn-images-1.medium.com/max/1600/0*Y9k47tv3KPIvetcV.jpg");
        bm.setTitle("Python book");
        bm.setPage("200 pages");

        books.add(10,bm);

    //    bm.setImageurl("http://www.programmerfish.com/wp-content/uploads/2011/03/image6.png");
        bm.setTitle("Data structures and algorithms");
        bm.setPage("500 pages");

        books.add(11,bm);

    //    bm.setImageurl("https://3.bp.blogspot.com/-nSkW0WKbfMA/VF5oY9nTv8I/AAAAAAAABok/I7RHe67nD5c/s1600/naruto_manga_cover_63_by_chekoaguilar-d5pa3ym.jpg");
        bm.setTitle("Naruto shippuden manga");
        bm.setPage("500 pages");

        books.add(12,bm);

    //    bm.setImageurl("https://vignette1.wikia.nocookie.net/dragonball/images/1/15/DBS-0.png/revision/latest?cb=20160126203700");
        bm.setTitle("Dragon ball super manga");
        bm.setPage("400 pages");

        books.add(13,bm);

        this.recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        Manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(Manager);
        adapter = new Adapter_1(this,ImgUrl, books, this);
        recyclerView.setAdapter(adapter);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    startActivity(new Intent(Books.this,MainActivity.class));
                    finish();
                    break;
                case R.id.cart:
                    startActivity(new Intent(Books.this, Cart.class));
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
            content="Android for professional";
            price= "700";
            img_url="https://goalkicker.com/AndroidBook/AndroidGrow.png";
        }
        else if (position==1) {
            content="Android for beginner";
            price= "400";
            img_url="http://eurodroid.com/pics/beginning_android_book.jpg";
        }
        else if (position==2) {
            content="php book";
            price= "400";
            img_url="https://www.compsmag.com/wp-content/uploads/2015/08/Beginning-PHP-and-MySQL-Book.jpg";
        }
        else if (position==3) {
            content="php";
            price= "500";
            img_url="https://mercury.marmot.org/bookcover.php?size=large&format=Book&isn=9781454926122";
        }
        else if (position==4) {
            content="Chacha Choudhry comic book";
            price= "100";
            img_url="https://whatshappbangalore.files.wordpress.com/2014/02/chacha-chaudhary-21.jpg?w=234&h=290";
        }
        else if (position==5) {
            content="Scooby doo comic book";
            price= "200";
            img_url="https://2.bp.blogspot.com/-2x83VuKD4cs/UsSSlT4A68I/AAAAAAAADfM/ipiHrklfXZA/s1600/Scooby-Doo_CP_2014_Book+4_Cover_Printed.jpg";
        }
        else if (position==6) {
            content="HunterXHunter manga";
            price= "4000";
            img_url="https://lostinanime.com/wp-content/uploads/2016/05/Hunter-X-Hunter-354-3.jpg";
        }
        else if (position==7) {
            content="Javascript for kids";
            price= "500";
            img_url="https://46nh0w2bddoq3ydz0yb6vnb1-wpengine.netdna-ssl.com/wp-content/uploads/2015/09/javascript-for-kids-for-dummies.jpg";
        }
        else if (position==8) {
            content="Head first java";
            price= "499";
            img_url="https://www.journaldev.com/wp-content/uploads/2014/11/Head_First_Java_Kathy_Sierra_Bert_Bates.jpg";
        }
        else if (position==9) {
            content="Regular Expressions";
            price= "10";
            img_url="https://covers.oreillystatic.com/images/9780596514273/lrg.jpg";
        }
        else if (position==10) {
            content = "Python book";
            price= "250";
            img_url="https://cdn-images-1.medium.com/max/1600/0*Y9k47tv3KPIvetcV.jpg";
        }
        else if (position==11) {
            content="Data structures and algorithms";
            price= "4500";
            img_url="http://www.programmerfish.com/wp-content/uploads/2011/03/image6.png";
        }
        else if (position==12) {
            content="Naruto shippuden manga";
            price= "2500";
            img_url="https://3.bp.blogspot.com/-nSkW0WKbfMA/VF5oY9nTv8I/AAAAAAAABok/I7RHe67nD5c/s1600/naruto_manga_cover_63_by_chekoaguilar-d5pa3ym.jpg";
        }
        else if (position==13) {
            content = "Dragon ball super manga";
            price= "100";
            img_url="https://vignette1.wikia.nocookie.net/dragonball/images/1/15/DBS-0.png/revision/latest?cb=20160126203700";
        }

        alert(content,price,img_url);
    }

    private void alert(final String content, final String price, final String img_url) {

       /* Intent sendData= new Intent(Food.this, CustomDialog.class);
        sendData.putExtra("mycontext", String.valueOf(Food.this));
        sendData.putExtra("mycontent",content);
        sendData.putExtra("myprice",price);
        startActivity(sendData);  */



        final AlertDialog.Builder builder1 = new AlertDialog.Builder(Books.this);

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

                        AlertDialog.Builder builder2 = new AlertDialog.Builder(Books.this);

                        builder2.setTitle("payment options");

                        builder2.setMessage("\nChoose your payment options from the two provided\n\n");

                        builder2.setCancelable(false);

                        builder2.setPositiveButton("Pay on delivery",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(Books.this, "Due to high demand and to ensure social distancing, Pay on Delivery is not available.", Toast.LENGTH_LONG).show();
                                        dialog.cancel();
                                    }
                                });
                        builder2.setNegativeButton("Google pay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Books.this, "Proceeding to the payment section", Toast.LENGTH_SHORT).show();
                                // startActivity(new Intent(Food.this, Payment_Activity.class));
                                Intent sendData= new Intent(Books.this, Payment_Activity.class);
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
                AlertDialog.Builder builder11 = new AlertDialog.Builder(Books.this);

                builder11.setTitle("Add to cart");
                builder11.setCancelable(false);

                builder11.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // startActivity(new Intent(Food.this, Cart.class));
                        Intent sendData= new Intent(Books.this, Cart.class);
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