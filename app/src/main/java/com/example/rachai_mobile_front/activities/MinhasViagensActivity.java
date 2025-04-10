package com.example.rachai_mobile_front.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rachai_mobile_front.R;
import com.example.rachai_mobile_front.activities.DetalhesViagemActivity;

import java.util.ArrayList;

public class MinhasViagensActivity extends AppCompatActivity {

    private ListView listViewViagens;
    private ArrayList<String> listaViagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_viagens);

        listViewViagens = findViewById(R.id.listViewViagens);

        // Exemplo de dados mockados (você pode popular com API ou banco depois)
        listaViagens = new ArrayList<>();
        listaViagens.add("São Paulo → Rio de Janeiro - 12/04/2025 - 14:00");
        listaViagens.add("Campinas → Santos - 15/04/2025 - 09:00");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listaViagens
        );

        listViewViagens.setAdapter(adapter);

        listViewViagens.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, DetalhesViagemActivity.class);
            intent.putExtra("infoViagem", listaViagens.get(position));
            startActivity(intent);
        });
    }
}
