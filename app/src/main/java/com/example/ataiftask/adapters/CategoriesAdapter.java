package com.example.ataiftask.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ataiftask.R;
import com.example.ataiftask.models.ProductModel;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyHolder> {
    private ArrayList<ProductModel> models = new ArrayList<>();

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categories_list_item, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.categoryBtn.setText(models.get(position).getname());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void setModels(ArrayList<ProductModel> models) {
        this.models = models;
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        Button categoryBtn;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            categoryBtn = itemView.findViewById(R.id.categories_btn);
        }
    }
}
