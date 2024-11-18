package com.JA_Granados.nicestart;

import android.content.Intent;
import android.graphics.MeshSpecification;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

public class Main_activity extends AppCompatActivity {

    private WebView texto;
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        WebView mycontext = (WebView) findViewById(R.id.texto);
        registerForContextMenu(mycontext);

        texto = (WebView) findViewById(R.id.texto);
//        miVisorWeb.getSettings().setJavaScriptEnabled(true);
//        miVisorWeb.getSettings().setBuiltInZoomControls(true);
        WebSettings webSettings = texto.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        texto.loadUrl("https://thispersondoesnotexist.com");

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(Main_activity.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
            toast0.show();
            texto.reload();
            swipeLayout.setRefreshing(false);
        }
    };

    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
 /*       switch(item.getItemId()) {
            case R.id.item1:
                Toast toast=Toast.makeText(this,"Item copied",Toast.LENGTH_LONG);
                toast.show();
                return true;

            case R.id.item2:
                Toast toast2=Toast.makeText(this,"Item copied",Toast.LENGTH_LONG);
                toast2.show();
                return true;

            default:
                return false;
        }*/
        int id=item.getItemId();
        if(id==R.id.item1){
            Toast toast2 = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
            toast2.show();
            return true;
        }
        if(id==R.id.item2) {
            Toast toast2 = Toast.makeText(this, "Item downloaded", Toast.LENGTH_LONG);
            toast2.show();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.item1) {
            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();

        }
        if (id == R.id.item2) {
            /*final ConstraintLayout mLayout = findViewById(R.id.item2);
            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });
            snackbar.show();*/
            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();
        }

        if (id == R.id.item3) {
            //Intent intent = new Intent(Main_activity.this, MainBab.class);
            //startActivity(intent);
        }

        if (id == R.id.item4) {
           // Intent intent = new Intent(Main_activity.this, MainBn.class);
           // startActivity(intent);
        }

        if (id == R.id.item5) {
            Intent intent=new Intent(Main_activity.this,Profile_activity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}