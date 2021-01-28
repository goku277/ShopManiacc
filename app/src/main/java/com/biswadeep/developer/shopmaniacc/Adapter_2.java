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

public class Adapter_2 extends RecyclerView.Adapter<Adapter_2.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<String> songList;
    List<ClothModel> cloths;
    Context ctx;
    onPanelClickListener onplcc;
    public Adapter_2(Context ctx, ArrayList<String> songList, List<ClothModel> cloths, onPanelClickListener onplcc) {
        this.inflater= LayoutInflater.from(ctx);
        this.songList= songList;
        this.cloths= cloths;
        this.ctx= ctx;
        this.onplcc= onplcc;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.book_list,parent,false);
        return new ViewHolder(view, onplcc);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position==0) {
            holder.Title.setText("Dress for women");
            holder.Pages.setText("Blue color");
          //  Toast.makeText(ctx, "You clicked on Dress for women", Toast.LENGTH_SHORT).show();
        }
        else if (position==1) {
            holder.Title.setText("Dress for women");
            holder.Pages.setText("Green color");
         //   Toast.makeText(ctx, "You clicked on Dress for women", Toast.LENGTH_SHORT).show();
        }
        else if (position==2) {
            holder.Title.setText("Dress for men");
            holder.Pages.setText("Golden color");
         //   Toast.makeText(ctx, "You clicked on Dress for men", Toast.LENGTH_SHORT).show();
        }
        else if (position==3) {
            holder.Title.setText("Coat and pant for men");
            holder.Pages.setText("Silver color");
         //   Toast.makeText(ctx, "You clicked on Coat and pant for men", Toast.LENGTH_SHORT).show();
        }
        else if (position==4) {
            holder.Title.setText("Shoe for men");
            holder.Pages.setText("Green color");
         //   Toast.makeText(ctx, "You clicked on Shoe for men", Toast.LENGTH_SHORT).show();
        }
        else if (position==5) {
            holder.Title.setText("Hat for men");
            holder.Pages.setText("Green color");
         //   Toast.makeText(ctx, "You clicked on Hat for men", Toast.LENGTH_SHORT).show();
        }
        else if (position==6) {
            holder.Title.setText("Shoe for women");
            holder.Pages.setText("Black color");
         //   Toast.makeText(ctx, "You clicked on Shoe for women", Toast.LENGTH_SHORT).show();
        }
        else if (position==7) {
            holder.Title.setText("Hat for men");
            holder.Pages.setText("White color");
         //   Toast.makeText(ctx, "You clicked on Hat for men", Toast.LENGTH_SHORT).show();
        }
        else if (position==8) {
            holder.Title.setText("Shirt for men");
            holder.Pages.setText("Black & red color");
          //  Toast.makeText(ctx, "You clicked on Shirt for men", Toast.LENGTH_SHORT).show();
        }
        else if (position==9) {
            holder.Title.setText("Casual shoe for men");
            holder.Pages.setText("Black color");
         //   Toast.makeText(ctx, "You clicked on Casual shoe for men", Toast.LENGTH_SHORT).show();
        }
        else if (position==10) {
            holder.Title.setText("Shirt for men");
            holder.Pages.setText("Black color");
         //   Toast.makeText(ctx, "You clicked on Shirt for men", Toast.LENGTH_SHORT).show();
        }
        else if (position==11) {
            holder.Title.setText("Jeans for women");
            holder.Pages.setText("Blue color");
         //   Toast.makeText(ctx, "You clicked on Jeans for women", Toast.LENGTH_SHORT).show();
        }
        else if (position==12) {
            holder.Title.setText("Cap for men");
            holder.Pages.setText("Green color");
          //  Toast.makeText(ctx, "You clicked on Cap for men", Toast.LENGTH_SHORT).show();
        }
        else if (position==13) {
            holder.Title.setText("Socks for men");
            holder.Pages.setText("Grey color");
         //   Toast.makeText(ctx, "You clicked on Socks for men", Toast.LENGTH_SHORT).show();
        }
        //  Picasso.with(ctx).load(songList.get(position).getCoverImage()).into(holder.songCoverImage);
        Glide.with(ctx).load(songList.get(position)).centerCrop().into(holder.CoverImage);

    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView Title, Pages;
        ImageView CoverImage;

        onPanelClickListener onplc;

        public ViewHolder(@NonNull View itemView, onPanelClickListener onplc) {
            super(itemView);

            Title= (TextView) itemView.findViewById(R.id.book_title_id);
            Pages= (TextView) itemView.findViewById(R.id.page_id);
            CoverImage= (ImageView) itemView.findViewById(R.id.book_img_id);

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
