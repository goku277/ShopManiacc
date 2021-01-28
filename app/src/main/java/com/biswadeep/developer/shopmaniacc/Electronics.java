package com.biswadeep.developer.shopmaniacc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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

public class Electronics extends AppCompatActivity implements ElectronicsAdapter.onPanelClickListener{

    ArrayList<String> ImgUrl= new ArrayList<>();
    List<ElectronicSModel> electronics= new ArrayList<>();
    RecyclerView recyclerView;
    LinearLayoutManager Manager;
    ElectronicsAdapter adapter;
    BottomNavigationView bv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);

        bv= (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bv.setOnNavigationItemSelectedListener(navListener);

        ImgUrl.add("https://cnet2.cbsistatic.com/img/vEkFcpyGOFpFXJzv27fggeswL5s=/1070x602/2017/02/23/5bf20b56-a1a7-4587-868f-f9f848dbc7bf/nintendo-switch-console-4923.jpg"); // Nitendo
        ImgUrl.add("https://www.gannett-cdn.com/-mm-/e354e30d329423f9f54934e16f3010fff4a5567c/c=0-110-2397-1464/local/-/media/2016/09/07/USATODAY/USATODAY/636088638499723914-ps4-pro.jpg?width=3200&height=1680&fit=crop"); // ps4
        ImgUrl.add("https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Xbox-console.jpg/1200px-Xbox-console.jpg");  //x-box
        // php book
        ImgUrl.add("https://i.ebayimg.com/images/i/121918373771-0-1/s-l1000.jpg"); // Game boy
        ImgUrl.add("https://i.ytimg.com/vi/_0NtJfjcN7A/maxresdefault.jpg");  // ps5
        ImgUrl.add("https://www.gamingdragons.com/images/game_img/crash_bandicoot_ps4.jpg"); // ps4 game CRASH
        ImgUrl.add("https://i.ytimg.com/vi/zfbAhwZ41qI/maxresdefault.jpg"); // Spiderman ps4
        ImgUrl.add("https://images-na.ssl-images-amazon.com/images/I/51YyFTR-Q1L._SY400_.jpg"); // Fortnite ps4
        ImgUrl.add("http://www.boomerangshop.com/web/files/product/201502/01146696-20150212144649-0.jpg"); // Evolve ps4
        ImgUrl.add("https://www.lukiegames.com/assets/images/PS4/ps4_skylanders_imaginators-image-2d682j.jpg"); // Sky landers imaginators ps4
        ImgUrl.add("https://www.nairaland.com/attachments/11584261_img20200522151221_jpegacf50b422c18eda37f55633cdc9a8574"); // Dishonour ps4
        ImgUrl.add("https://capitalstore.com/wp-content/uploads/2019/01/unnamed-file.jpg");  // FIFA 11 ps4
        ImgUrl.add("https://images.anandtech.com/doci/14761/dg5090_aw310h_aw310k_s3220dgf_aw510m_gsy_shot02_bk_clear_genericgame.jpg");  // Dell gaming computer
        ImgUrl.add("https://mygaming.co.za/news/wp-content/uploads/2015/03/Average-gaming-setup.jpg"); // Gaming Computers trio
        ImgUrl.add("https://www.pcgamesn.com/wp-content/uploads/2018/07/Upcoming-PC-games-Disco-Elysium.jpg");  // Elysium pc game
        ImgUrl.add("https://www.greenmangaming.com/free-to-play/wp-content/uploads/2019/03/Archeage-9.jpg"); // Archeage pc game
        ImgUrl.add("https://icdn4.digitaltrends.com/image/2016-best-pc-games-video-2-1200x630-c-ar1.91.jpg?ver=1");   // Shooting game pc
        ImgUrl.add("https://i.ytimg.com/vi/lhOL-egdsGM/maxresdefault.jpg");  // Macbook
        ImgUrl.add("https://i.ytimg.com/vi/7Q5CLKLmxKk/maxresdefault.jpg");   // Macbook
        ImgUrl.add("https://cdn2.macworld.co.uk/cmsdata/reviews/3660144/macbook_pro_201700.jpg");   //  Macbook pro
        ImgUrl.add("https://www.notebookcheck.net/uploads/tx_nbc2/macbook_pro_2008.jpg");  // Macbook pro
        ImgUrl.add("https://www.picclickimg.com/d/l400/pict/293807795006_/SILENT-MOBIUS-anime-series-CD-Music-Album-2.jpg");  // Classic anime dvd
        ImgUrl.add("http://animeggroll.com/wp-content/uploads/2015/11/704400092862_anime-Buddy-Complex-DVD-Bluray.jpg");   // Buddy Complex Anime
        ImgUrl.add("https://static.shoplightspeed.com/shops/608693/files/005447990/funimation-entertainment-kiddy-girl-and-blu-ray-dv.jpg");  // Kiddy Girl Anime
        ImgUrl.add("http://animeshumi.com/image/data/Funimation/Steinsgate-Complete-Series-Classic-Line-Anime-DVD-Bluray.jpg");    // Steins Gate
        ImgUrl.add("https://i.ytimg.com/vi/JEcCDcoeJQw/maxresdefault.jpg");    // Canaan Anime
        ImgUrl.add("https://i.ytimg.com/vi/NH9ygFb5X6I/maxresdefault.jpg");   // Adventure Anime
        ImgUrl.add("https://www.rightstufanime.com/images/productImages/704400060045_anime-Yu-Yu-Hakusho-The-Movie--Eizou-Hakusho-DVD-Set-Hyb.jpg?resizeid=3&resizeh=600&resizew=600");  // Yu- Yu Hakusho
        ImgUrl.add("https://i.ytimg.com/vi/Oh-SSys4CCM/maxresdefault.jpg");  // MyHero Academia


        ElectronicSModel bm= new ElectronicSModel();
        // bm.setImageurl("https://goalkicker.com/AndroidBook/AndroidGrow.png");
        bm.setTitle("Nitendo");
        bm.setPrice("10000 bucks");

        electronics.add(0,bm);

        //  bm.setImageurl("http://eurodroid.com/pics/beginning_android_book.jpg");
        bm.setTitle("Ps4");
        bm.setPrice("30000 bucks");

        electronics.add(1,bm);

        //  bm.setImageurl("https://www.compsmag.com/wp-content/uploads/2015/08/Beginning-PHP-and-MySQL-Book.jpg");
        bm.setTitle("X-Box");
        bm.setPrice("30000 bucks");

        electronics.add(2,bm);

        //   bm.setImageurl("https://mercury.marmot.org/bookcover.php?size=large&format=Book&isn=9781454926122");
        bm.setTitle("Game boy");
        bm.setPrice("2000 bucks");

        electronics.add(3,bm);

        //   bm.setImageurl("https://whatshappbangalore.files.wordpress.com/2014/02/chacha-chaudhary-21.jpg?w=234&h=290");
        bm.setTitle("Ps5");
        bm.setPrice("40000 bucks");

        electronics.add(4,bm);


        //    bm.setImageurl("https://2.bp.blogspot.com/-2x83VuKD4cs/UsSSlT4A68I/AAAAAAAADfM/ipiHrklfXZA/s1600/Scooby-Doo_CP_2014_Book+4_Cover_Printed.jpg");
        bm.setTitle("Ps4- game cd - CRASH");
        bm.setPrice("2000 bucks");

        electronics.add(5,bm);

        //    bm.setImageurl("https://lostinanime.com/wp-content/uploads/2016/05/Hunter-X-Hunter-354-3.jpg");
        bm.setTitle("Spiderman Ps4");
        bm.setPrice("1200 bucks");

        electronics.add(6,bm);

        //    bm.setImageurl("https://46nh0w2bddoq3ydz0yb6vnb1-wpengine.netdna-ssl.com/wp-content/uploads/2015/09/javascript-for-kids-for-dummies.jpg");
        bm.setTitle("Fortnite ps4");
        bm.setPrice("1500 bucks");

        electronics.add(7,bm);

        //    bm.setImageurl("https://www.journaldev.com/wp-content/uploads/2014/11/Head_First_Java_Kathy_Sierra_Bert_Bates.jpg");
        bm.setTitle("Evolve Ps4");
        bm.setPrice("5000 bucks");

        electronics.add(8,bm);

        //    bm.setImageurl("https://covers.oreillystatic.com/images/9780596514273/lrg.jpg");
        bm.setTitle("Sky landers imaginators ps4");
        bm.setPrice("400 bucks");

        electronics.add(9,bm);

        //    bm.setImageurl("https://cdn-images-1.medium.com/max/1600/0*Y9k47tv3KPIvetcV.jpg");
        bm.setTitle("Dsihonour ps4");
        bm.setPrice("500 bucks");

        electronics.add(10,bm);

        //    bm.setImageurl("http://www.programmerfish.com/wp-content/uploads/2011/03/image6.png");
        bm.setTitle("FIFA 11 ps4");
        bm.setPrice("1200 bucks");

        electronics.add(11,bm);

        //    bm.setImageurl("https://3.bp.blogspot.com/-nSkW0WKbfMA/VF5oY9nTv8I/AAAAAAAABok/I7RHe67nD5c/s1600/naruto_manga_cover_63_by_chekoaguilar-d5pa3ym.jpg");
        bm.setTitle("Dell gaming computer");
        bm.setPrice("40000 bucks");

        electronics.add(12,bm);

        //    bm.setImageurl("https://vignette1.wikia.nocookie.net/dragonball/images/1/15/DBS-0.png/revision/latest?cb=20160126203700");
        bm.setTitle("Gaming computers trio");
        bm.setPrice("40000 bucks");

        electronics.add(13,bm);

        bm.setTitle("Gaming computers trio");
        bm.setPrice("40000 bucks");

        electronics.add(14,bm);

        bm.setTitle("Archeage pc game");
        bm.setPrice("1100 bucks");

        electronics.add(15,bm);

        bm.setTitle("Gaming computers trio");
        bm.setPrice("65000 bucks");

        electronics.add(16,bm);

        bm.setTitle("Shooting game ps");
        bm.setPrice("500 bucks");

        electronics.add(17,bm);

        bm.setTitle("Macbook");
        bm.setPrice("50000 bucks");

        electronics.add(18,bm);

        bm.setTitle("Macbook");
        bm.setPrice("70000 bucks");

        electronics.add(19,bm);

        bm.setTitle("Macbook pro");
        bm.setPrice("200000 bucks");

        electronics.add(20,bm);

        bm.setTitle("Macbook pro");
        bm.setPrice("90000 bucks");

        electronics.add(21,bm);

        bm.setTitle("Classic Anime Dvd");
        bm.setPrice("210 bucks");

        electronics.add(22,bm);

        bm.setTitle("Buddy complex anime");
        bm.setPrice("500 bucks");

        electronics.add(23,bm);

        bm.setTitle("Kiddy girl");
        bm.setPrice("2500 bucks");

        electronics.add(24,bm);

        bm.setTitle("Steins gate");
        bm.setPrice("3500 bucks");

        electronics.add(25,bm);

        bm.setTitle("Canaan Anime");
        bm.setPrice("25 bucks");

        electronics.add(26,bm);

        bm.setTitle("Gaming computers trio");
        bm.setPrice("26 bucks");

        electronics.add(27,bm);

        bm.setTitle("Adventure Anime");
        bm.setPrice("2000 bucks");

        electronics.add(28,bm);

        bm.setTitle("My Hero Academia");
        bm.setPrice("5000 bucks");

        electronics.add(29,bm);

        this.recyclerView = (RecyclerView)findViewById(R.id.electronics_list_id);
        Manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(Manager);
        adapter = new ElectronicsAdapter(this,ImgUrl, electronics, this);
        recyclerView.setAdapter(adapter);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    startActivity(new Intent(Electronics.this,MainActivity.class));
                    finish();
                    break;
                case R.id.cart:
                    startActivity(new Intent(Electronics.this, Cart.class));
                    finish();
                    break;
            }
            return false;
        }
    };

    @Override
    public void onPanelClick(int position) {
        Toast.makeText(this, " " + position, Toast.LENGTH_SHORT).show();

        String content="", price="",img_url="";
        if (position==0) {
            content="Nitendo";
            price= "10000";
            img_url="https://cnet2.cbsistatic.com/img/vEkFcpyGOFpFXJzv27fggeswL5s=/1070x602/2017/02/23/5bf20b56-a1a7-4587-868f-f9f848dbc7bf/nintendo-switch-console-4923.jpg";
        }
        else if (position==1) {
            content="Ps4";
            price= "30000";
            img_url="https://www.gannett-cdn.com/-mm-/e354e30d329423f9f54934e16f3010fff4a5567c/c=0-110-2397-1464/local/-/media/2016/09/07/USATODAY/USATODAY/636088638499723914-ps4-pro.jpg?width=3200&height=1680&fit=crop";
        }
        else if (position==2) {
            content="X-Box";
            price= "30000";
            img_url="https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Xbox-console.jpg/1200px-Xbox-console.jpg";
        }
        else if (position==3) {
            content="Game boy";
            price= "2000";
            img_url="https://i.ebayimg.com/images/i/121918373771-0-1/s-l1000.jpg";
        }
        else if (position==4) {
            content="Ps5";
            price= "40000";
            img_url="https://i.ytimg.com/vi/_0NtJfjcN7A/maxresdefault.jpg";
        }
        else if (position==5) {
            content="Ps4- game cd - CRASH";
            price= "2000";
            img_url="https://www.gamingdragons.com/images/game_img/crash_bandicoot_ps4.jpg";
        }
        else if (position==6) {
            content="Spiderman Ps4";
            price= "1200";
            img_url="https://i.ytimg.com/vi/zfbAhwZ41qI/maxresdefault.jpg";
        }
        else if (position==7) {
            content="Fortnite ps4";
            price= "1500";
            img_url="https://images-na.ssl-images-amazon.com/images/I/51YyFTR-Q1L._SY400_.jpg";
        }
        else if (position==8) {
            content="Evolve Ps4";
            price= "5000";
            img_url="http://www.boomerangshop.com/web/files/product/201502/01146696-20150212144649-0.jpg";
        }
        else if (position==9) {
            content="Sky landers imaginators ps4";
            price= "400";
            img_url="https://www.lukiegames.com/assets/images/PS4/ps4_skylanders_imaginators-image-2d682j.jpg";
        }
        else if (position==10) {
            content = "Dsihonour ps4";
            price= "400";
            img_url="https://www.nairaland.com/attachments/11584261_img20200522151221_jpegacf50b422c18eda37f55633cdc9a8574";
        }
        else if (position==11) {
            content="FIFA 11 ps4";
            price= "1200";
            img_url="https://capitalstore.com/wp-content/uploads/2019/01/unnamed-file.jpg";
        }
        else if (position==12) {
            content="Dell gaming computer";
            price= "40000";
            img_url="https://images.anandtech.com/doci/14761/dg5090_aw310h_aw310k_s3220dgf_aw510m_gsy_shot02_bk_clear_genericgame.jpg";
        }
        else if (position==13) {
            content = "Gaming computers trio";
            price= "40000";
            img_url="https://icdn4.digitaltrends.com/image/2016-best-pc-games-video-2-1200x630-c-ar1.91.jpg?ver=1";
        }
        else if (position==14) {
            content = "Gaming computers trio";
            price= "40000";
            img_url="https://cdn2.macworld.co.uk/cmsdata/reviews/3660144/macbook_pro_201700.jpg";
        }
        else if (position==15) {
            content = "Archeage pc game";
            price= "1100";
            img_url="https://www.greenmangaming.com/free-to-play/wp-content/uploads/2019/03/Archeage-9.jpg";
        }
        else if (position==16) {
            content = "Gaming computers trio";
            price= "65000";
            img_url="https://mygaming.co.za/news/wp-content/uploads/2015/03/Average-gaming-setup.jpg";
        }
        else if (position==17) {
            content = "Shooting game ps";
            price= "500";
            img_url="https://icdn4.digitaltrends.com/image/2016-best-pc-games-video-2-1200x630-c-ar1.91.jpg?ver=1";
        }
        else if (position==18) {
            content = "Macbook";
            price= "50000";
            img_url="https://i.ytimg.com/vi/lhOL-egdsGM/maxresdefault.jpg";
        }
        else if (position==19) {
            content = "Macbook";
            price= "90000";
            img_url="https://i.ytimg.com/vi/7Q5CLKLmxKk/maxresdefault.jpg";
        }
        else if (position==20) {
            content = "Macbook pro";
            price= "125000";
            img_url="https://www.notebookcheck.net/uploads/tx_nbc2/macbook_pro_2008.jpg";
        }
        else if (position==21) {
            content = "Macbook pro";
            price= "200000";
            img_url="https://www.notebookcheck.net/uploads/tx_nbc2/macbook_pro_2008.jpg";
        }
        else if (position==22) {
            content = "Classic Anime Dvd";
            price= "210";
            img_url="https://www.picclickimg.com/d/l400/pict/293807795006_/SILENT-MOBIUS-anime-series-CD-Music-Album-2.jpg";
        }
        else if (position==23) {
            content = "Buddy complex anime";
            price= "500";
            img_url="http://animeggroll.com/wp-content/uploads/2015/11/704400092862_anime-Buddy-Complex-DVD-Bluray.jpg";
        }
        else if (position==24) {
            content = "Kiddy girl";
            price= "2500";
            img_url="https://static.shoplightspeed.com/shops/608693/files/005447990/funimation-entertainment-kiddy-girl-and-blu-ray-dv.jpg";
        }
        else if (position==25) {
            content = "Steins gate";
            price= "3500";
            img_url="http://animeshumi.com/image/data/Funimation/Steinsgate-Complete-Series-Classic-Line-Anime-DVD-Bluray.jpg";
        }
        else if (position==26) {
            content = "Canaan Anime";
            price= "Canaan Anime";
            img_url="https://i.ytimg.com/vi/JEcCDcoeJQw/maxresdefault.jpg";
        }
        else if (position==27) {
            content = "YuYuHakusho";
            price= "5000";
            img_url="https://www.rightstufanime.com/images/productImages/704400060045_anime-Yu-Yu-Hakusho-The-Movie--Eizou-Hakusho-DVD-Set-Hyb.jpg?resizeid=3&resizeh=600&resizew=600";
        }
        else if (position==28) {
            content = "Adventure anime";
            price= "4500";
            img_url="https://i.ytimg.com/vi/NH9ygFb5X6I/maxresdefault.jpg";
        }
        else if (position==29) {
            content = "My Hero Academia";
            price= "5000";
            img_url="https://i.ytimg.com/vi/Oh-SSys4CCM/maxresdefault.jpg";
        }

        alert(content,price,img_url);
    }

    private void alert(final String content, final String price, final String img_url) {

       /* Intent sendData= new Intent(Food.this, CustomDialog.class);
        sendData.putExtra("mycontext", String.valueOf(Food.this));
        sendData.putExtra("mycontent",content);
        sendData.putExtra("myprice",price);
        startActivity(sendData);  */



        final AlertDialog.Builder builder1 = new AlertDialog.Builder(Electronics.this);

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

                        AlertDialog.Builder builder2 = new AlertDialog.Builder(Electronics.this);

                        builder2.setTitle("payment options");

                        builder2.setMessage("\nChoose your payment options from the two provided\n\n");

                        builder2.setCancelable(false);

                        builder2.setPositiveButton("Pay on delivery",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(Electronics.this, "Due to high demand and to ensure social distancing, Pay on Delivery is not available.", Toast.LENGTH_LONG).show();
                                        dialog.cancel();
                                    }
                                });
                        builder2.setNegativeButton("Google pay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Electronics.this, "Proceeding to the payment section", Toast.LENGTH_SHORT).show();
                                // startActivity(new Intent(Food.this, Payment_Activity.class));
                                Intent sendData= new Intent(Electronics.this, Payment_Activity.class);
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
                AlertDialog.Builder builder11 = new AlertDialog.Builder(Electronics.this);

                builder11.setTitle("Add to cart");
                builder11.setCancelable(false);
                builder11.setMessage("Add " + content + " @ " + price + " bucks to the cart\n\n\n");

                builder11.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // startActivity(new Intent(Food.this, Cart.class));
                        Intent sendData= new Intent(Electronics.this, Cart.class);
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