package com.example.agendacontactos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_contacts;
    private Button btn_add;

    private ArrayList<Contacto> list_contactos;
    private RecyclerView.Adapter adapter;

    private TinyDB tinyDB;

    private final String KEY_CONTACTOS = "ID_CONTACTOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tinyDB = new TinyDB(getBaseContext());

        rv_contacts = findViewById(R.id.rv_contacts);
        btn_add = findViewById(R.id.btn_add);

        list_contactos = tinyDB.getListContactos(KEY_CONTACTOS);

        rv_contacts.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration divider = new DividerItemDecoration(rv_contacts.getContext(),
                DividerItemDecoration.VERTICAL);
        rv_contacts.addItemDecoration(divider);

        adapter = new CustomAdapter(list_contactos);
        rv_contacts.setAdapter(adapter);


        updateViewAndData();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_contact, null);

                final EditText et_nombre = mView.findViewById(R.id.et_nombre);
                final EditText et_apellidos = mView.findViewById(R.id.et_apellidos);
                final EditText et_numero = mView.findViewById(R.id.et_numero);

                builder.setTitle("Añade tu contacto")
                        .setView(mView)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list_contactos.add(new Contacto(et_nombre.getText().toString(),
                                        et_apellidos.getText().toString(),
                                        et_numero.getText().toString()));

                                updateViewAndData();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        rv_contacts.addOnItemTouchListener(new RecyclerTouchListener(MainActivity.this, rv_contacts, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_contact, null);

                final EditText et_nombre = mView.findViewById(R.id.et_nombre);
                final EditText et_apellidos = mView.findViewById(R.id.et_apellidos);
                final EditText et_numero = mView.findViewById(R.id.et_numero);

                et_nombre.setText(list_contactos.get(position).getNombre());
                et_apellidos.setText(list_contactos.get(position).getApellidos());
                et_numero.setText(list_contactos.get(position).getTelefono());

                builder.setTitle("Edita tu contacto")
                        .setView(mView)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list_contactos.set(position, new Contacto(et_nombre.getText().toString(),
                                        et_apellidos.getText().toString(),
                                        et_numero.getText().toString()));

                                updateViewAndData();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }

            @Override
            public void onLongClick(View view, int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setMessage("Deseas borrar el contacto")
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list_contactos.remove(position);
                                updateViewAndData();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }));
    }

    public void updateViewAndData() {
        tinyDB.putListContactos(KEY_CONTACTOS, list_contactos);
        adapter.notifyDataSetChanged();
    }

    public String getContactsText() {
        if(list_contactos.size() == 0)
            return "No tienes ningún contacto";
        else {
            String text = "";
            for(Contacto c : list_contactos)
                text += c.toString();

            return text;
        }
    }
}