package com.upjv.pizzaphone.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.upjv.pizzaphone.R;
import com.upjv.pizzaphone.model.Pizzas;
import com.upjv.pizzaphone.service.ManagementCart;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCardBtn;
    private TextView libelleTxt, prixTxt, ingredientsTxt, numberOrderTxt;
    private ImageView plusBtn, minusBtn, picFood;
    private Pizzas object;
    private int numberOrder = 1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // appel de l'activité
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        // appel de la classe ManagementCart
        managementCart = new ManagementCart(this);

        initView();
        getBundle();
    }

    private void getBundle() {
        object = (Pizzas) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getImage(), "drawable", this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        libelleTxt.setText(object.getLibelle());
        prixTxt.setText("€" + object.getPrix());
        ingredientsTxt.setText(object.getIngredients());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        // bouton plus
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        // bouton moins
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        // bouton ajouter au panier
        addToCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
            }
        });
    }

    private void initView() {
        // initialisation
        addToCardBtn = findViewById(R.id.addToCardBtn);
        libelleTxt = findViewById(R.id.libelleTxt);
        prixTxt = findViewById(R.id.prixTxt);
        ingredientsTxt = findViewById(R.id.ingredientsTxt);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        picFood = findViewById(R.id.foodPic);
    }
}