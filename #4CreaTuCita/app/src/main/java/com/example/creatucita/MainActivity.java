package com.example.creatucita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_cita;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("msgI", "Main activity create");

        et_cita = findViewById(R.id.et_cita);
        btn_next = findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CitaActivity.class);
                intent.putExtra("cita", et_cita.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("msgI", "Main activity pause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("msgI", "Main activity start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("msgI", "Main activity resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("msgI", "Main activity restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("msgI", "Main activity stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("msgI", "Main activity destroy");
    }
}