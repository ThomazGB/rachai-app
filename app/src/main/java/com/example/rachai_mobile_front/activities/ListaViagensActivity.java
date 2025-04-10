package com.example.rachai_mobile_front.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.rachai_mobile_front.models.Viagem;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rachai_mobile_front.R;
import com.example.rachai_mobile_front.models.Viagem;

import java.util.ArrayList;

public class ListaViagensActivity extends AppCompatActivity {

    private ListView listViewViagens;
    private Button btnNovaViagem;
    private ArrayList<Viagem> listaViagens;
    private ArrayAdapter<Viagem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_viagens);

        listViewViagens = findViewById(R.id.listViewViagens);
        btnNovaViagem = findViewById(R.id.btnNovaViagem);

        listaViagens = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaViagens);
        listViewViagens.setAdapter(adapter);

        btnNovaViagem.setOnClickListener(v -> {
            Intent intent = new Intent(ListaViagensActivity.this, CadastroViagemActivity.class);
            startActivity(intent);
        });

        // Adiciona nova viagem vinda de outra activity
        Intent intent = getIntent();
        if (intent != null) {
            String novaOrigem = intent.getStringExtra("novaOrigem");
            String novoDestino = intent.getStringExtra("novoDestino");
            String novaData = intent.getStringExtra("novaData");

            if (novaOrigem != null && novoDestino != null && novaData != null) {
                listaViagens.add(new Viagem(novaOrigem, novoDestino, novaData));
                adapter.notifyDataSetChanged();
            }
        }

        listViewViagens.setOnItemClickListener((parent, view, position, id) -> {
            Viagem viagem = listaViagens.get(position);
            Intent detalhesIntent = new Intent(ListaViagensActivity.this, DetalhesViagemActivity.class);
            detalhesIntent.putExtra("origem", viagem.getOrigem());
            detalhesIntent.putExtra("destino", viagem.getDestino());
            detalhesIntent.putExtra("data", viagem.getData());
            detalhesIntent.putExtra("motorista", "Fulano da Silva"); // Ou substitua com dado real
            startActivity(detalhesIntent);
        });
    }
}
