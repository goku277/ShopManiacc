package com.biswadeep.developer.shopmaniacc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsAdapter extends RecyclerView.Adapter<ElectronicsAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<String> electronicList;
    List<ElectronicSModel> electronic;
    Context ctx;
    onPanelClickListener onplcc;
    public ElectronicsAdapter(Context ctx, ArrayList<String> electronicList, List<ElectronicSModel> electronic, onPanelClickListener onplcc) {
        this.inflater= LayoutInflater.from(ctx);
        this.electronicList= electronicList;
        this.electronic= electronic;
        this.ctx= ctx;

        this.onplcc= onplcc;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.electronic_list,parent,false);
        return new ViewHolder(view, onplcc);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position==0) {
            holder.Title.setText("Nitendo");
            holder.Price.setText("10000 bucks");
            //  Toast.makeText(ctx, "You clicked on Burger", Toast.LENGTH_SHORT).show();
        }
        else if (position==1) {
            holder.Title.setText("Ps4");
            holder.Price.setText("30000 bucks");
            //  Toast.makeText(ctx, "You clicked on Puff", Toast.LENGTH_SHORT).show();
        }
        else if (position==2) {
            holder.Title.setText("X-Box");
            holder.Price.setText("30000 bucks");
            //  Toast.makeText(ctx, "You clicked on Laddoo", Toast.LENGTH_SHORT).show();
        }
        else if (position==3) {
            holder.Title.setText("Game boy");
            holder.Price.setText("2000 bucks");
            //  Toast.makeText(ctx, "You clicked on Popcorn", Toast.LENGTH_SHORT).show();
        }
        else if (position==4) {
            holder.Title.setText("Ps5");
            holder.Price.setText("40000 bucks");
            //  Toast.makeText(ctx, "You clicked on Samosa", Toast.LENGTH_SHORT).show();
        }
        else if (position==5) {
            holder.Title.setText("Ps4- game cd - CRASH");
            holder.Price.setText("2000 bucks");
            //  Toast.makeText(ctx, "You clicked on Chicken tandoori", Toast.LENGTH_SHORT).show();
        }
        else if (position==6) {
            holder.Title.setText("Spiderman Ps4");
            holder.Price.setText("1200 bucks");
            //   Toast.makeText(ctx, "You clicked on Grill chicken", Toast.LENGTH_SHORT).show();
        }
        else if (position==7) {
            holder.Title.setText("Fortnite ps4");
            holder.Price.setText("1500 bucks");
            //   Toast.makeText(ctx, "You clicked on Coke", Toast.LENGTH_SHORT).show();
        }
        else if (position==8) {
            holder.Title.setText("Evolve Ps4");
            holder.Price.setText("5000 bucks");
            //  Toast.makeText(ctx, "You clicked on Ramen", Toast.LENGTH_SHORT).show();
        }
        else if (position==9) {
            holder.Title.setText("Sky landers imaginators ps4");
            holder.Price.setText("400 bucks");
            //   Toast.makeText(ctx, "You clicked on French fries", Toast.LENGTH_SHORT).show();
        }
        else if (position==10) {
            holder.Title.setText("Dsihonour ps4");
            holder.Price.setText("500 bucks");
            //  Toast.makeText(ctx, "You clicked on Noodles", Toast.LENGTH_SHORT).show();
        }
        else if (position==11) {
            holder.Title.setText("FIFA 11 ps4");
            holder.Price.setText("1200 bucks");
            //   Toast.makeText(ctx, "You clicked on Pepsi", Toast.LENGTH_SHORT).show();
        }
        else if (position==12) {
            holder.Title.setText("Dell gaming computer");
            holder.Price.setText("40000 bucks");
            //   Toast.makeText(ctx, "You clicked on Biriyani", Toast.LENGTH_SHORT).show();
        }
        else if (position==13) {
            holder.Title.setText("Gaming computers trio");
            holder.Price.setText("40000 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        else if (position==14) {
            holder.Title.setText("Gaming computers trio");
            holder.Price.setText("40000 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }

        else if (position==15) {
            holder.Title.setText("Archeage pc game");
            holder.Price.setText("1100 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        else if (position==16) {
            holder.Title.setText("Gaming computers trio");
            holder.Price.setText("500 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        else if (position==17) {
            holder.Title.setText("Macbook");
            holder.Price.setText("50000 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }

        else if (position==18) {
            holder.Title.setText("Macbook");
            holder.Price.setText("70000 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }

        else if (position==19) {
            holder.Title.setText("Macbook pro");
            holder.Price.setText("200000 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        else if (position==20) {
            holder.Title.setText("Macbook pro");
            holder.Price.setText("90000 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        else if (position==21) {
            holder.Title.setText("Classic Anime Dvd");
            holder.Price.setText("210 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        else if (position==22) {
            holder.Title.setText("Buddy complex anime");
            holder.Price.setText("500 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        else if (position==23) {
            holder.Title.setText("Kiddy girl");
            holder.Price.setText("2500 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        else if (position==24) {
            holder.Title.setText("Steins gate");
            holder.Price.setText("3500 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        else if (position==25) {
            holder.Title.setText("Canaan anime");
            holder.Price.setText("35 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        else if (position==26) {
            holder.Title.setText("Adventure anime");
            holder.Price.setText("25 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        else if (position==27) {
            holder.Title.setText("Yu yu hakusho");
            holder.Price.setText("5000 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        else if (position==28) {
            holder.Title.setText("Adventure Anime");
            holder.Price.setText("2000 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        else if (position==29) {
            holder.Title.setText("My Hero Academia");
            holder.Price.setText("5000 bucks");
            //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }



        //  Picasso.with(ctx).load(songList.get(position).getCoverImage()).into(holder.songCoverImage);
        Glide.with(ctx).load(electronicList.get(position)).centerCrop().into(holder.CoverImage);
    }

    @Override
    public int getItemCount() {
        return electronicList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView Title, Price;
        ImageView CoverImage;

        onPanelClickListener onplc;

        public ViewHolder(@NonNull View itemView, onPanelClickListener onplc) {
            super(itemView);

            Title= (TextView) itemView.findViewById(R.id.electronics_title_id);
            Price= (TextView) itemView.findViewById(R.id.electronics_price_id);
            CoverImage= (ImageView) itemView.findViewById(R.id.electronics_img_id);

            this.onplc= onplc;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onplc.onPanelClick(getAdapterPosition());
        }
    }

    public interface onPanelClickListener {
        public void onPanelClick(int position);
    }



}
