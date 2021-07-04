package com.example.alergiasfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {

    private TextView tv_info;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_info = findViewById(R.id.tv_info);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("alergias");
        System.out.println(mDatabase);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String text = "";
                for(DataSnapshot dss : snapshot.getChildren())
                    text += "> " + dss.getValue() + "\n";

                tv_info.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("ERROR", error.getDetails());
            }
        });
    }
}