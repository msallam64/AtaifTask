package com.example.ataiftask.networking;

import com.example.ataiftask.models.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    public static final String BASE_URL = "";
    private ApiServices apiServices;
    private static RetrofitBuilder builder;

    public RetrofitBuilder() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiServices = retrofit.create(ApiServices.class);
    }

    public static RetrofitBuilder getBuilder() {
        if (null == builder) {
            builder = new RetrofitBuilder();
        }
        return builder;
    }

    public Call<List<ProductModel>> getData() {
        return apiServices.getData();
    }
}
