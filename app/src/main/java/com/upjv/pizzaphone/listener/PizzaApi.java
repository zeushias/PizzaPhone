package com.upjv.pizzaphone.listener;

import com.upjv.pizzaphone.model.Commandes;
import com.upjv.pizzaphone.model.Pizzas;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PizzaApi {

    @GET("pizza/")
    Call<Pizzas> getPizzaList();

    @POST("login/{user}")
    void postLogin();

    @POST("/order/{reference}")
    void postCommande();

    @GET("/mescommandes")
    Call<ArrayList<Commandes>> getCommandeList();
}
