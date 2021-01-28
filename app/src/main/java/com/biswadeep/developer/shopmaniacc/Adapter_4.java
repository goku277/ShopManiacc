package com.biswadeep.developer.shopmaniacc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Adapter_4 extends RecyclerView.Adapter<Adapter_4.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<String> songList;
    List<FoodModel> foods;
    Context ctx;
    onPanelClickListener onplcc;
    public Adapter_4(Context ctx, ArrayList<String> songList, List<FoodModel> foods, onPanelClickListener onplcc) {
        this.inflater= LayoutInflater.from(ctx);
        this.songList= songList;
        this.foods= foods;
        this.ctx= ctx;
        this.onplcc= onplcc;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.food_list,parent,false);
        return new ViewHolder(view, onplcc);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position==0) {
            holder.Title.setText("Burger");
            holder.Price.setText("50/-");
          //  Toast.makeText(ctx, "You clicked on Burger", Toast.LENGTH_SHORT).show();
        }
        else if (position==1) {
            holder.Title.setText("Puff");
            holder.Price.setText("5/-");
          //  Toast.makeText(ctx, "You clicked on Puff", Toast.LENGTH_SHORT).show();
        }
        else if (position==2) {
            holder.Title.setText("Laddoo");
            holder.Price.setText("10/-");
          //  Toast.makeText(ctx, "You clicked on Laddoo", Toast.LENGTH_SHORT).show();
        }
        else if (position==3) {
            holder.Title.setText("Popcorn");
            holder.Price.setText("50/-");
          //  Toast.makeText(ctx, "You clicked on Popcorn", Toast.LENGTH_SHORT).show();
        }
        else if (position==4) {
            holder.Title.setText("Samosa");
            holder.Price.setText("10/-");
          //  Toast.makeText(ctx, "You clicked on Samosa", Toast.LENGTH_SHORT).show();
        }
        else if (position==5) {
            holder.Title.setText("Chicken tandoori");
            holder.Price.setText("100/-");
          //  Toast.makeText(ctx, "You clicked on Chicken tandoori", Toast.LENGTH_SHORT).show();
        }
        else if (position==6) {
            holder.Title.setText("Grill chicken");
            holder.Price.setText("100/-");
         //   Toast.makeText(ctx, "You clicked on Grill chicken", Toast.LENGTH_SHORT).show();
        }
        else if (position==7) {
            holder.Title.setText("Coke");
            holder.Price.setText("45/-");
         //   Toast.makeText(ctx, "You clicked on Coke", Toast.LENGTH_SHORT).show();
        }
        else if (position==8) {
            holder.Title.setText("Ramen");
            holder.Price.setText("400/-");
          //  Toast.makeText(ctx, "You clicked on Ramen", Toast.LENGTH_SHORT).show();
        }
        else if (position==9) {
            holder.Title.setText("French fries");
            holder.Price.setText("50/-");
         //   Toast.makeText(ctx, "You clicked on French fries", Toast.LENGTH_SHORT).show();
        }
        else if (position==10) {
            holder.Title.setText("Noodles");
            holder.Price.setText("20/-");
          //  Toast.makeText(ctx, "You clicked on Noodles", Toast.LENGTH_SHORT).show();
        }
        else if (position==11) {
            holder.Title.setText("Pepsi");
            holder.Price.setText("45/-");
         //   Toast.makeText(ctx, "You clicked on Pepsi", Toast.LENGTH_SHORT).show();
        }
        else if (position==12) {
            holder.Title.setText("Biriyani");
            holder.Price.setText("150/-");
         //   Toast.makeText(ctx, "You clicked on Biriyani", Toast.LENGTH_SHORT).show();
        }
        else if (position==13) {
            holder.Title.setText("Paneer manchurian");
            holder.Price.setText("200/-");
         //   Toast.makeText(ctx, "You clicked on Paneer manchurian", Toast.LENGTH_SHORT).show();
        }
        //  Picasso.with(ctx).load(songList.get(position).getCoverImage()).into(holder.songCoverImage);
        Glide.with(ctx).load(songList.get(position)).centerCrop().into(holder.CoverImage);

    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView Title, Price;
        ImageView CoverImage;

        onPanelClickListener onplc;

        public ViewHolder(@NonNull View itemView, onPanelClickListener onplc) {
            super(itemView);

            Title= (TextView) itemView.findViewById(R.id.food_title_id);
            Price= (TextView) itemView.findViewById(R.id.food_price_id);
            CoverImage= (ImageView) itemView.findViewById(R.id.food_img_id);
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
