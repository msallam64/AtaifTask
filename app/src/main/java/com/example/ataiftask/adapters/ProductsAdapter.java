package com.example.ataiftask.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ataiftask.R;
import com.example.ataiftask.models.Pokemon;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyHolder> {
    private ArrayList<Pokemon> mList = new ArrayList<>();
    private Context mContext;

    public ProductsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.products_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Glide.with(mContext).load(mList.get(position).getUrl()).into(holder.product_Image);
        holder.bio_Tv.setText(mList.get(position).getName());
        holder.oldPrice_Tv.setText("14000 جنيه");
        holder.oldPrice_Tv.setPaintFlags(holder.oldPrice_Tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.newPrice_Tv.setText("1000 جنيه");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(ArrayList<Pokemon> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView product_Image, favourt_Icon, cart_Icon;
        TextView bio_Tv, oldPrice_Tv, newPrice_Tv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            product_Image = itemView.findViewById(R.id.product_iv);
            favourt_Icon = itemView.findViewById(R.id.favourit_icon_iv);
            cart_Icon = itemView.findViewById(R.id.cart_icon_iv);
            bio_Tv = itemView.findViewById(R.id.product_bio_tv);
            oldPrice_Tv = itemView.findViewById(R.id.product_oldprice_tv);
            newPrice_Tv = itemView.findViewById(R.id.product_newprice_tv);
        }
    }
}
