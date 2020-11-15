package com.example.ataiftask.viewModel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ataiftask.models.ProductModel;
import com.example.ataiftask.networking.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsViewModel extends ViewModel {
    public MutableLiveData<List<ProductModel>> productModelMutableLiveData = new MutableLiveData<>();

    public void getProduct() {
        RetrofitBuilder.getBuilder().getData().enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                productModelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {

            }
        });

    }

}
