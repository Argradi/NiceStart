package com.JA_Granados.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ImageView mgirl= findViewById(R.id.girl);

        Glide.with(this)
                .load("https://images.unsplash.com/photo-1729508418556-f692e940cbb0?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
//                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .centerCrop()
//                .circleCrop()
//            .placeholder(new ColorDrawable(this.getResources().getColor(R.color.white)))
                .into(mgirl);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void openSignup(View v) {
        Intent intent = new Intent(Login_activity.this, SignUp.class);
        startActivity(intent);
    }

    public void Login(View v) {
        Intent intent = new Intent(Login_activity.this, Main_activity.class);
        startActivity(intent);
    }
}