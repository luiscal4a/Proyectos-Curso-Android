package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tv_cita;
    private Button btn_next;
    private String[] arr_citas;
    private Random rnd;
    private int indiceCita = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_cita = findViewById(R.id.tv_cita);
        btn_next = findViewById(R.id.btn_next);

        rnd = new Random();

        arr_citas = new String[] {
                "Somos sentimientos y tenemos seres humanos",
                "Lo que nosotros hemos hecho, cosa que no hizo usted, es engañar a la gente",
                "Cuanto peor mejor para todos y cuanto peor para todos mejor, mejor para mí el suyo. Beneficio político",
                "Es el alcalde el que quiere que sean los vecinos el alcalde",
                "Un vaso es un vaso y un plato es un plato",
                "Es que no es lo mismo que gobierne uno que gobierne otro, no es lo mismo, dicho de otra forma, es muy distinto",
                "No he dormido nada, no me pregunten demasiado",
                "Una cosa es ser solidario y otra cosa es serlo a cambio de nada",
                "Me gustan los catalanes porque hacen cosas",
                "La cerámica de Talavera no es cosa menor, dicho de otra forma, es cosa mayor",
                "A veces lo mejor es no tomar decisiones, y eso en sí, es una decisión",
                "Los españoles son muy españoles y mucho españoles",
                "It´s very difficult todo esto",
                "Hay que fabricar máquinas que nos permitan seguir fabricando máquinas, porque lo que no va a hacer nunca la máquina es fabricar máquinas",
                "Haré todo lo que pueda y un poco más de lo que pueda si es que eso es posible, y haré todo lo posible e incluso lo imposible si también lo imposible es posible",
                "¿Ustedes piensan antes de hablar o hablan tras pensar?"
        };

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCita();
            }
        });
        tv_cita.setSelected(true);

        setCita();
    }

    private void setCita() {
        int indice;
        do {
            indice = rnd.nextInt(arr_citas.length);
        } while(indice == indiceCita);

        indiceCita = indice;
        tv_cita.setText(arr_citas[indice]);
    }

}