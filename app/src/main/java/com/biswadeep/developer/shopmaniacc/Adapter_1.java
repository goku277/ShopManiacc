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
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

public class Adapter_1 extends RecyclerView.Adapter<Adapter_1.ViewHolder>{

    LayoutInflater inflater;
    ArrayList<String> songList;
    List<BookModel> books;
    Context ctx;
    onPanelClickListener onplcc;
    public Adapter_1(Context ctx, ArrayList<String> songList, List<BookModel> books, onPanelClickListener onplcc) {
        this.inflater= LayoutInflater.from(ctx);
        this.songList= songList;
        this.books= books;
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
            holder.Title.setText("Android for professional");
            holder.Pages.setText("700 pages");
         //   Toast.makeText(ctx, " You clicked on Android for professional" , Toast.LENGTH_SHORT).show();
        }
        else if (position==1) {
            holder.Title.setText("Android for beginers");
            holder.Pages.setText("400 pages");
         //   Toast.makeText(ctx, " You clicked on Android for beginers" , Toast.LENGTH_SHORT).show();
        }
        else if (position==2) {
            holder.Title.setText("Php & mysql");
            holder.Pages.setText("700 pages");
         //   Toast.makeText(ctx, " You clicked on Php & mysql" , Toast.LENGTH_SHORT).show();
        }
        else if (position==3) {
            holder.Title.setText("Php");
            holder.Pages.setText("500 pages");
         //   Toast.makeText(ctx, " You clicked on Php" , Toast.LENGTH_SHORT).show();
        }
        else if (position==4) {
            holder.Title.setText("Chacha Choudhry comic book");
            holder.Pages.setText("200 pages");
         //   Toast.makeText(ctx, " You clicked on Chacha Choudhry comic book" , Toast.LENGTH_SHORT).show();
        }
        else if (position==5) {
            holder.Title.setText("Scooby doo comic book");
            holder.Pages.setText("200 pages");
          //  Toast.makeText(ctx, "You clicked on Chacha Scooby doo comic book", Toast.LENGTH_SHORT).show();
        }
        else if (position==6) {
            holder.Title.setText("HunterXHunter manga");
            holder.Pages.setText("80 pages");
         //   Toast.makeText(ctx, "You clicked on HunterXHunter manga", Toast.LENGTH_SHORT).show();
        }
        else if (position==7) {
            holder.Title.setText("Javascript for kids");
            holder.Pages.setText("700 pages");
         //   Toast.makeText(ctx, "You clicked on Javascript for kids", Toast.LENGTH_SHORT).show();
        }
        else if (position==8) {
            holder.Title.setText("Head first java");
            holder.Pages.setText("500 pages");
          //  Toast.makeText(ctx, "You clicked on Head first java", Toast.LENGTH_SHORT).show();
        }
        else if (position==9) {
            holder.Title.setText("Regular Expressions");
            holder.Pages.setText("160 pages");
         //   Toast.makeText(ctx, "You clicked on Regular Expressions", Toast.LENGTH_SHORT).show();
        }
        else if (position==10) {
            holder.Title.setText("Python book");
            holder.Pages.setText("200 pages");
         //   Toast.makeText(ctx, "You clicked on Python book", Toast.LENGTH_SHORT).show();
        }
        else if (position==11) {
            holder.Title.setText("Data structures and algorithms");
            holder.Pages.setText("500 pages");
         //   Toast.makeText(ctx, "You clicked on Data structures and algorithms", Toast.LENGTH_SHORT).show();
        }
        else if (position==12) {
            holder.Title.setText("Naruto shippuden manga");
            holder.Pages.setText("500 pages");
         //   Toast.makeText(ctx, "You clicked on Naruto shippuden manga", Toast.LENGTH_SHORT).show();
        }
        else if (position==13) {
            holder.Title.setText("Dragon ball super manga");
            holder.Pages.setText("400 pages");
         //   Toast.makeText(ctx, "You clicked on Dragon ball super manga", Toast.LENGTH_SHORT).show();
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