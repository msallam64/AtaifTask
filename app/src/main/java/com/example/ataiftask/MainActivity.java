package com.example.ataiftask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ataiftask.adapters.CategoriesAdapter;
import com.example.ataiftask.models.ProductModel;
import com.example.ataiftask.viewModel.ProductsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ProductsViewModel productsViewModel;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productsViewModel = ViewModelProviders.of(this).get(ProductsViewModel.class);
        productsViewModel.getProduct();
        RecyclerView recyclerView = findViewById(R.id.categories_rv);
        recyclerView.setLayoutManager(layoutManager);
        final CategoriesAdapter adapter = new CategoriesAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        productsViewModel.productModelMutableLiveData.observe(this, new Observer<List<ProductModel>>() {
            @Override
            public void onChanged(List<ProductModel> productModels) {
                adapter.setModels((ArrayList<ProductModel>) productModels);
            }
        });

    }
}