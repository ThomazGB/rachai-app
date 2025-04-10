package com.example.rachai_mobile_front.activities;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rachai_mobile_front.R;

public class NovaViagemActivity extends AppCompatActivity {

    private EditText etOrigem, etDestino, etData, etHora, etValor;
    private Button btnCriarViagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_viagem);

        etOrigem = findViewById(R.id.etOrigem);
        etDestino = findViewById(R.id.etDestino);
        etData = findViewById(R.id.etData);
        etHora = findViewById(R.id.etHora);
        etValor = findViewById(R.id.etValor);
        btnCriarViagem = findViewById(R.id.btnCriarViagem);

        btnCriarViagem.setOnClickListener(v -> {
            String origem = etOrigem.getText().toString();
            String destino = etDestino.getText().toString();
            String data = etData.getText().toString();
            String hora = etHora.getText().toString();
            String valor = etValor.getText().toString();

            if (origem.isEmpty() || destino.isEmpty() || data.isEmpty() || hora.isEmpty() || valor.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Aqui você pode salvar no banco ou enviar para API futuramente
            Toast.makeText(this, "Viagem cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
            finish(); // Volta para a tela anterior
        });
    }
}

