package com.upjv.pizzaphone.activities;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.upjv.pizzaphone.impl.ApiClient;
import com.upjv.pizzaphone.listener.PizzaApi;
import com.upjv.pizzaphone.R;
import com.upjv.pizzaphone.adapter.PopularAdapter;
import com.upjv.pizzaphone.model.Pizzas;
import com.upjv.pizzaphone.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String apiUrl = "https://daviddurand.info/D228/pizza";
    private TextView dateDuJour, cat;

    private RecyclerView recyclerViewPopularList;

    List<Pizzas> pizzasList = new ArrayList();

    private PopularAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // appel de l'activité
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        System.gc();
        // utilisateur si connecté

        // date du jour
        dateDuJour = findViewById(R.id.dateDuJour);
        dateDuJour.setText(Utils.getDate());

        // afficher liste de pizza
       //fetchPizzas();

        recyclerViewListPizza();
        bottomNavigation();
    }
    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout ConnexionBtn = findViewById(R.id.ConnexionBtn);

        // bouton panier
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CommandeActivity.class));
            }
        });

        // bouton home
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        // bouton connexion
        ConnexionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(ConnexionActivity.this, MainActivity.class));
            }
        });
    }

    private void fetchPizzas() {

        PizzaApi api = ApiClient.getClient().create(PizzaApi.class);
        System.out.println("begin");
        try {
            Call<ArrayList<Pizzas>> call = api.getPizzaList();

        call.enqueue(new Callback<ArrayList<Pizzas>>() {
            @Override
            public void onResponse(Call<ArrayList<Pizzas>> call, Response<ArrayList<Pizzas>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter = new PopularAdapter(response.body());
                    recyclerViewPopularList.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load pizzas", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Pizzas>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        } catch(Exception e){
            System.out.println(e);
        }
    }
    private void recyclerViewListPizza() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        pizzasList.add(new Pizzas("Vegetarienne", 12.9,"Coulis, oignons, tomates fraiches, persillade, fromage, olives.","vege"));
        pizzasList.add(new Pizzas("Regina", 13.9 ,"Coulis, jambon, champignons, fromage, olives.","regina"));
        pizzasList.add(new Pizzas("Chorizo", 14.9, "Coulis, chorizo, poivrons, fromage, olives.","chorizo"));
        pizzasList.add(new Pizzas("4Fromages", 13.9, "Coulis, chevre, mozzarella, emmenthal, roquefort, creme fraiche, olives.", "froma4"));
        pizzasList.add(new Pizzas("Marguerita", 15.9, "Coulis, double fromages, olives.", "marguerita"));
        pizzasList.add(new Pizzas("Campagne", 15.9, "Coulis, double chevre, champignons, herbes de Provence, olives.", "campagne"));
        pizzasList.add(new Pizzas("Champignons", 12.9, "Coulis, champignons, fromage, olives.","champi"));
        pizzasList.add(new Pizzas("Poulet", 14.9, "Coulis, poulet, chevre, creme fraiche, fromage, olives.", "poulet"));
        pizzasList.add(new Pizzas("3Fromages", 13.9, "Coulis, chevre, emmenthal, mozzarella, creme fraiche, olives.", "froma3"));
        pizzasList.add(new Pizzas("Chevre", 13.9, "Coulis, chevre, creme fraiche, oeuf, fromage, olives.", "chevre"));
        adapter = new PopularAdapter(new ArrayList(pizzasList));
        recyclerViewPopularList.setAdapter(adapter);
        System.gc();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }
}