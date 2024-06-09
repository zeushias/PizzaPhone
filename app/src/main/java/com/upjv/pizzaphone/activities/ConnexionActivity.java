package com.upjv.pizzaphone.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.upjv.pizzaphone.R;

public class ConnexionActivity extends AppCompatActivity {

    private TextView connectBtn;
    private TextView titreTxt;
    private EditText loginText;
    private ImageView ConnexionPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        initView();
        getBundle();
    }

    private void getBundle() {

        loginText = findViewById(R.id.LoginText);
        titreTxt = findViewById(R.id.textView4);

        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginText != null ){
                    titreTxt.setText("Hi" + loginText.getText().toString());
                }

            }
        });
    }

    private void initView() {

    }
}