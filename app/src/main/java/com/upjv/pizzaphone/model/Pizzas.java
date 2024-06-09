package com.upjv.pizzaphone.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Pizzas implements Serializable {

    private int numberInCart;

    private String libelle;

    private double prix;

    private String ingredients;

    private String image;

    //@JsonCreator @JsonProperty("libelle") @JsonProperty("prix") @JsonProperty("ingredients") @JsonProperty("image")
    public Pizzas( String libelle, double prix, String ingredients, String image) {
        this.libelle = libelle;
        this.prix = prix;
        this.ingredients = ingredients;
        this.image = image;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
