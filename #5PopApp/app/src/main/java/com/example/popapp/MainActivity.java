package com.example.popapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_alert;
    private Button btn_alert_list;
    private Button btn_alert_multiple;
    private Button btn_alert_custom;
    private Button btn_toast;
    private Button btn_toast_long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_alert = findViewById(R.id.btn_alert);
        btn_alert_list = findViewById(R.id.btn_alert_list);
        btn_alert_multiple = findViewById(R.id.btn_alert_multiple);
        btn_alert_custom = findViewById(R.id.btn_alert_custom);
        btn_toast = findViewById(R.id.btn_toast);
        btn_toast_long = findViewById(R.id.btn_toast_long);

        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle(R.string.str_dialog_title)
                        .setMessage(R.string.str_dialog_message)
                        .setPositiveButton(R.string.str_dialog_ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                btn_alert.setBackgroundColor(Color.RED);
                            }
                        })
                        .setNegativeButton(R.string.str_dialog_cancel, null)
                        .setCancelable(false);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btn_alert_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String[] arr_colores = getResources().getStringArray(R.array.arr_colores);
                final int[] arr_colores_valor = new int[] {Color.RED, Color.GREEN, Color.BLUE};

                builder.setTitle(R.string.str_dialog_title)
                        .setItems(arr_colores, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                btn_alert_list.setBackgroundColor(arr_colores_valor[i]);
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btn_alert_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<Integer> arl_colores = new ArrayList<>();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final String[] arr_colores = getResources().getStringArray(R.array.arr_colores);

                builder.setTitle(R.string.str_dialog_title)
                        .setMultiChoiceItems(arr_colores, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                if(b) {
                                    arl_colores.add(i);
                                } else if(arl_colores.contains(i)) {
                                    arl_colores.remove(Integer.valueOf(i));
                                }
                            }
                        })
                        .setPositiveButton(R.string.str_dialog_ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String texto = "";
                                for(Integer indice: arl_colores) {
                                    texto += arr_colores[indice]+ " ";
                                }
                                btn_alert_multiple.setText(texto);
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btn_alert_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_custom, null);
                final EditText et_titulo = mView.findViewById(R.id.et_titulo);

                builder.setTitle(R.string.str_dialog_title)
                        .setView(mView)
                        .setPositiveButton(R.string.str_dialog_ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                btn_alert_custom.setText(et_titulo.getText());
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.str_toast_message, Toast.LENGTH_SHORT).show();
            }
        });

        btn_toast_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.str_toast_long_message, Toast.LENGTH_LONG).show();
            }
        });
    }
}