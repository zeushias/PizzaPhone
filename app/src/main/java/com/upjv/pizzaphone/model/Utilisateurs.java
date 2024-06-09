package com.upjv.pizzaphone.model;

import java.util.Base64;
public class Utilisateurs {

    private Integer idUtilisateur;

    private String email;

    private String nomComplet;

    private String password;

    public Utilisateurs(String email, String nomComplet, String password) {
        this.email = email;
        this.nomComplet = nomComplet;
        this.password = password;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
