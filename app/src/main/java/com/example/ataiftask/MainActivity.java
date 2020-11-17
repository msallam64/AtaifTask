package com.example.ataiftask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ataiftask.adapters.CategoriesAdapter;
import com.example.ataiftask.adapters.ProductsAdapter;
import com.example.ataiftask.models.Pokemon;
import com.example.ataiftask.viewModel.ProductsViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    ProductsViewModel viewModel;
    RecyclerView.LayoutManager layoutManager1, layoutManager2, layoutManager3;
    private RecyclerView recyclerViewCategories, recyclerViewbestoffers, recyclerViewnewProduct;
    private CategoriesAdapter categoriesAdapter;
    private ProductsAdapter productsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCategories = findViewById(R.id.categories_rv);
        recyclerViewbestoffers = findViewById(R.id.bestoffers_rv);
        recyclerViewnewProduct = findViewById(R.id.newprodust_rv);
        recyclerViewCategories.setLayoutManager(layoutManager1);
        recyclerViewbestoffers.setLayoutManager(layoutManager2);
        recyclerViewnewProduct.setLayoutManager(layoutManager3);
        LinearLayoutManager manager1 = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager manager2 = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager manager3 = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        categoriesAdapter = new CategoriesAdapter(this);
        productsAdapter = new ProductsAdapter(this);
        recyclerViewCategories.setLayoutManager(manager1);
        recyclerViewCategories.setAdapter(categoriesAdapter);
        recyclerViewbestoffers.setLayoutManager(manager2);
        recyclerViewbestoffers.setAdapter(productsAdapter);
        recyclerViewnewProduct.setLayoutManager(manager3);
        recyclerViewnewProduct.setAdapter(productsAdapter);

        viewModel = new ViewModelProvider(this).get(ProductsViewModel.class);

        viewModel.getProducts();
        viewModel.getPokemonList().observe(this, new Observer<ArrayList<Pokemon>>() {
            @Override
            public void onChanged(ArrayList<Pokemon> pokemons) {
                categoriesAdapter.setList(pokemons);
                productsAdapter.setList(pokemons);
            }
        });

    }
}