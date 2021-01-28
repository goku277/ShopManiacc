package com.biswadeep.developer.shopmaniacc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {


    ArrayList<String> mImage= new ArrayList<>();
    ArrayList<String> mContent= new ArrayList<>();
    ArrayList<String> mPrice= new ArrayList<>();
    Context mContext;

    public CartAdapter(ArrayList<String> mContent, ArrayList<String> mPrice, ArrayList<String> mImage, Context mContext) {
        this.mContent= mContent;
        this.mPrice= mPrice;
        this.mImage= mImage;
        this.mContext= mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cart_item,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext).load(mImage.get(position)).centerCrop().into(holder.img);
        holder.content.setText(mContent.get(position));
        holder.price.setText(mPrice.get(position));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "" + mContent.get(position), Toast.LENGTH_SHORT).show();
                AlertDialog.Builder paymentAlert= new AlertDialog.Builder(mContext);
                paymentAlert.setTitle("Go to payment");
                paymentAlert.setMessage("Pay " + mPrice.get(position) + " bucks for this item " + mContent.get(position) + "\n\n\n");
                paymentAlert.setPositiveButton("Pay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent sendData= new Intent(mContext, Payment_Activity.class);
                        sendData.putExtra("mymoney",mPrice.get(position));
                        sendData.putExtra("mytext",mContent.get(position));
                        mContext.startActivity(sendData);
                    }
                });
                paymentAlert.setNeutralButton("Pay on delivery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, " Due to high demand and to ensure social distancing, Pay on Delivery is not available.", Toast.LENGTH_SHORT).show();
                    }
                });
                paymentAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog a1= paymentAlert.create();
                a1.show();
            }

        });
    }

    @Override
    public int getItemCount() {
        return mContent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView content, price;
        RelativeLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.cart_imageview_placeholder_id);
            content= itemView.findViewById(R.id.text_content_id);
            price= itemView.findViewById(R.id.text_price_id);
            layout= itemView.findViewById(R.id.reletivelayout_id);
        }
    }
}