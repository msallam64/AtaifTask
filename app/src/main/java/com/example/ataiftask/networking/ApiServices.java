package com.example.ataiftask.networking;

import com.example.ataiftask.models.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("")
    Call<List<ProductModel>> getData();
}
