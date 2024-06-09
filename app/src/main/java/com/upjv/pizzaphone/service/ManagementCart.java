package com.upjv.pizzaphone.service;

import android.content.Context;
import android.widget.Toast;

import com.upjv.pizzaphone.listener.ChangeNumberItemsListener;
import com.upjv.pizzaphone.model.Pizzas;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(Pizzas item) {
        ArrayList<Pizzas> listCommande = getListCard();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listCommande.size(); i++) {
            if (listCommande.get(i).getLibelle().equals(item.getLibelle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            listCommande.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listCommande.add(item);
        }

        tinyDB.putListObject("CardList", listCommande);
        Toast.makeText(context, "Added To Your Card", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<Pizzas> getListCard() {
        return tinyDB.getListObject("CardList");
    }

    public void plusNumberFood(ArrayList<Pizzas> listCommande, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listCommande.get(position).setNumberInCart(listCommande.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CardList", listCommande);
        changeNumberItemsListener.changed();
    }

    public void MinusNumerFood(ArrayList<Pizzas> listCommande, int position, ChangeNumberItemsListener listener) {
        if (listCommande.get(position).getNumberInCart() == 1) {
            listCommande.remove(position);
        } else {
            listCommande.get(position).setNumberInCart(listCommande.get(position).getNumberInCart() - 1);
        }
        tinyDB.putListObject("CardList", listCommande);
        listener.changed();
    }

    public Double getTotalFee() {
        ArrayList<Pizzas> listCommande = getListCard();
        double fee = 0;
        for (int i = 0; i < listCommande.size(); i++) {
            fee = fee + listCommande.get(i).getPrix() * listCommande.get(i).getNumberInCart();
        }
        return fee;
    }

}
