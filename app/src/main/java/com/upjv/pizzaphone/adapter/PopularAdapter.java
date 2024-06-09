package com.upjv.pizzaphone.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upjv.pizzaphone.R;
import com.upjv.pizzaphone.activities.ShowDetailActivity;
import com.upjv.pizzaphone.model.Pizzas;
import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    ArrayList<Pizzas> pizzas;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public PopularAdapter(ArrayList<Pizzas> pizzas) {
        this.pizzas = pizzas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.libelle.setText(pizzas.get(position).getLibelle());
        holder.prix.setText(String.valueOf(pizzas.get(position).getPrix()));
        holder.ingredients.setText(pizzas.get(position).getIngredients());

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(pizzas.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());

        /*Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.image);

         */

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", pizzas.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pizzas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView libelle, prix, ingredients;
        ImageView image;
        TextView addBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            libelle = itemView.findViewById(R.id.libelle);
            prix = itemView.findViewById(R.id.prix);
            ingredients = itemView.findViewById(R.id.ingredients);
            image = itemView.findViewById(R.id.image);
            addBtn = itemView.findViewById(R.id.addBtn);
        }

    }
}