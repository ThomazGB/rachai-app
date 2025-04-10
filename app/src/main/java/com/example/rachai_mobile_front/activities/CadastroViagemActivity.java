package com.example.rachai_mobile_front.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rachai_mobile_front.R;

public class CadastroViagemActivity extends AppCompatActivity {

    private EditText etOrigem, etDestino, etData;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_viagem);

        etOrigem = findViewById(R.id.etOrigem);
        etDestino = findViewById(R.id.etDestino);
        etData = findViewById(R.id.etData);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(v -> cadastrarViagem());
    }

    private void cadastrarViagem() {
        String origem = etOrigem.getText().toString().trim();
        String destino = etDestino.getText().toString().trim();
        String data = etData.getText().toString().trim();

        if (origem.isEmpty() || destino.isEmpty() || data.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Simulação de armazenamento da viagem
        Intent intent = new Intent(this, ListaViagensActivity.class);
        intent.putExtra("novaOrigem", origem);
        intent.putExtra("novoDestino", destino);
        intent.putExtra("novaData", data);
        startActivity(intent);
        finish();
    }
}

