package com.example.ataiftask.repositary;

import androidx.lifecycle.LiveData;

import com.example.ataiftask.models.PokemonRespons;
import com.example.ataiftask.networking.ApiServices;


import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;


public class Repositary {
    private ApiServices pokemonAPIservice;

    @Inject
    public Repositary(ApiServices pokemonAPIservice) {
        this.pokemonAPIservice = pokemonAPIservice;
    }

    public Observable<PokemonRespons> getPokemons() {
        return pokemonAPIservice.getPokemons();
    }


}
