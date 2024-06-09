package com.upjv.pizzaphone.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.upjv.pizzaphone.R;
import com.upjv.pizzaphone.listener.ChangeNumberItemsListener;
import com.upjv.pizzaphone.model.Pizzas;
import com.upjv.pizzaphone.service.ManagementCart;

import java.util.ArrayList;

public class CommandeAdapter extends RecyclerView.Adapter<CommandeAdapter.ViewHolder> {
    private ArrayList<Pizzas> pizzasList;
    private ManagementCart managementCart;
    private ChangeNumberItemsListener changeNumberItemsListener;

    public CommandeAdapter(ArrayList<Pizzas> pizzasList, Context context, ChangeNumberItemsListener changeNumberItemsListener) {

        this.pizzasList = pizzasList;
        managementCart = new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_commande, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(pizzasList.get(position).getLibelle());
        holder.feeEachItem.setText(String.valueOf(pizzasList.get(position).getPrix()));
        holder.totalEachItem.setText(String.valueOf(Math.round((pizzasList.get(position).getNumberInCart() * Double.valueOf(pizzasList.get(position).getPrix())) * 100.0) / 100.0));
        holder.num.setText(String.valueOf(pizzasList.get(position).getNumberInCart()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(pizzasList.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);


        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managementCart.plusNumberFood(pizzasList, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });

        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managementCart.MinusNumerFood(pizzasList, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });

    }


    @Override
    public int getItemCount() {
        return pizzasList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem;
        ImageView pic, plusItem, minusItem;
        TextView totalEachItem, num;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title2Txt);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            pic = itemView.findViewById(R.id.picCard);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            num = itemView.findViewById(R.id.numberItemTxt);
            plusItem = itemView.findViewById(R.id.plusCardBtn);
            minusItem = itemView.findViewById(R.id.minusCardBtn);
        }
    }
}
