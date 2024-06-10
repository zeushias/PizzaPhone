package com.upjv.pizzaphone.model;

import java.util.List;

public class Commandes {

    private Integer idCommande;

    private Double total;

    private String time;

    private String reference;

    private List<Pizzas> pizzas;

    private int idUtilisateur;

    public Commandes(){}

    public Commandes(Double total, String time, String reference, List<Pizzas> pizzas) {
        this.total = total;
        this.time = time;
        this.reference = reference;
        this.pizzas = pizzas;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Pizzas> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizzas> pizzas) {
        this.pizzas = pizzas;
    }
}
