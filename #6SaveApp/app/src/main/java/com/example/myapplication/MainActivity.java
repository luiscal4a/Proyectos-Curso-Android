package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREF = "SHARED_PREFS";
    private static final String SAVE_TEXT = "SAVE_TEXT";
    private static final String PROGRESS = "PROGRESS";

    private String str_text;
    private int int_progress;

    private EditText et_text;
    private Button btn_save;
    private TextView tv_text;
    private SeekBar sk_progress;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);

        et_text = findViewById(R.id.et_text);
        btn_save = findViewById(R.id.btn_save);
        tv_text = findViewById(R.id.tv_text);
        sk_progress = findViewById(R.id.sk_progress);

        loadData();
        updateView();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                updateView();
            }
        });
    }

    private void loadData() {
        str_text = sharedPreferences.getString(SAVE_TEXT, "");
        int_progress = sharedPreferences.getInt(PROGRESS, 0);
    }

    private void saveData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        str_text = et_text.getText().toString();
        int_progress = sk_progress.getProgress();

        editor.putString(SAVE_TEXT, str_text);
        editor.putInt(PROGRESS, int_progress);

        editor.apply();
    }

    private void updateView() {
        tv_text.setText(str_text);
        sk_progress.setProgress(int_progress);
    }
}