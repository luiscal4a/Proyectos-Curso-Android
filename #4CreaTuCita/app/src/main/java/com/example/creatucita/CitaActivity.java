package com.example.creatucita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class CitaActivity extends AppCompatActivity {
    private RelativeLayout rl_cita;
    private TextView tv_cita;
    private Random rnd_seed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.i("msgI", "Cita activity create");

        rl_cita = findViewById(R.id.rl_cita);
        tv_cita = findViewById(R.id.tv_cita);

        rnd_seed = new Random();

        Intent intent = getIntent();
        tv_cita.setText(intent.getStringExtra("cita"));

        int r = rnd_seed.nextInt(256);
        int g = rnd_seed.nextInt(256);
        int b = rnd_seed.nextInt(256);

        rl_cita.setBackgroundColor(Color.rgb(r,g,b));
        tv_cita.setTextColor(getTextColor(Color.rgb(r,g,b)));

        tv_cita.setSelected(true);
    }

    private int getTextColor(int color) {
        double y = (299 * Color.red(color) + 587 * Color.green(color) + 114 * Color.blue(color)) /1000;
        return y >= 128 ? Color.BLACK : Color.WHITE;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("msgI", "Cita activity pause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("msgI", "Cita activity start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("msgI", "Cita activity resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("msgI", "Cita activity restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("msgI", "Cita activity stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("msgI", "Cita activity destroy");
    }
}