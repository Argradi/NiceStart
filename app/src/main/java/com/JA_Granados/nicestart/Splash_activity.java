package com.JA_Granados.nicestart;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class Splash_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        openApp();

        ImageView logo=findViewById(R.id.imagen);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.salto_giro);
        logo.startAnimation(myanim);

        TextView texto=findViewById(R.id.NC);
        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.aparecer);
        texto.startAnimation(myanim2);

        ImageView mfondo= findViewById(R.id.fondo);

        Glide.with(this)
                .load("https://images.unsplash.com/photo-1531366936337-7c912a4589a7?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
//                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .centerCrop()
//            .circleCrop()
//            .placeholder(new ColorDrawable(this.getResources().getColor(R.color.white)))
                .into(mfondo);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void openApp(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_activity
                        .this, Login_activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 5000);
    }
}