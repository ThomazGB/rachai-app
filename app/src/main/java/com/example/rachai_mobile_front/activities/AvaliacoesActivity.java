package com.example.rachai_mobile_front.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rachai_mobile_front.R;

import java.util.ArrayList;

public class AvaliacoesActivity extends AppCompatActivity {

    private ListView listAvaliacoes;
    private ArrayList<String> avaliacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacoes);

        listAvaliacoes = findViewById(R.id.listAvaliacoes);

        // Dados simulados – futuramente virão do backend
        avaliacoes = new ArrayList<>();
        avaliacoes.add("Maria Souza ★★★★☆\nMotorista foi pontual e educado.");
        avaliacoes.add("Carlos Lima ★★★★★\nViagem tranquila e carro confortável.");
        avaliacoes.add("João Silva ★★★☆☆\nTeve um pequeno atraso, mas foi ok.");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                avaliacoes
        );

        listAvaliacoes.setAdapter(adapter);
    }
}


