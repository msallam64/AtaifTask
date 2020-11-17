package com.example.ataiftask.networking;

import com.example.ataiftask.models.PokemonRespons;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("pokemon")
    Observable<PokemonRespons> getPokemons();
}
