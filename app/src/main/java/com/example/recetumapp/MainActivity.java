package com.example.recetumapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            Toast.makeText(getApplicationContext(),"Usted se encuentra conectado a una red inalámbrica",Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "No se pudo conectar, verifique" +
                    "el acceso a internet nuevamente para ingresar a la aplicación", Toast.LENGTH_LONG).show();
            //Intent intent= new Intent(this, listas.class);

        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progress_bar);
        textView = findViewById(R.id.text_view);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressAnimation();
    }
    public void progressAnimation(){

        ProgressBarAnimation anim= new ProgressBarAnimation(this, progressBar, textView,   0f, 100f);
        anim.setDuration(2500);
        progressBar.setAnimation(anim);
    }
}
