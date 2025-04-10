package com.example.rachai_mobile_front.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rachai_mobile_front.R;

import java.util.ArrayList;

public class ParticipantesActivity extends AppCompatActivity {

    private ListView listParticipantes;
    private ArrayList<String> participantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participantes); // Certifique-se de que este XML seja o correto

        // CORREÇÃO: usando o ID que está no seu XML
        listParticipantes = findViewById(R.id.listViewParticipantes);

        // Participantes fictícios – substituir por dados reais futuramente
        participantes = new ArrayList<>();
        participantes.add("João Silva (Motorista)");
        participantes.add("Maria Souza (Passageira)");
        participantes.add("Carlos Lima (Passageiro)");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                participantes
        );

        listParticipantes.setAdapter(adapter);
    }
}
