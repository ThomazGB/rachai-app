package com.example.rachai_mobile_front.activities;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rachai_mobile_front.R;

public class EditarViagemActivity extends AppCompatActivity {

    private EditText etOrigem, etDestino, etData, etHorario;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_viagem);

        etOrigem = findViewById(R.id.etOrigem);
        etDestino = findViewById(R.id.etDestino);
        etData = findViewById(R.id.etData);
        etHorario = findViewById(R.id.etHorario);
        btnSalvar = findViewById(R.id.btnSalvar);

        // Carregamento dos dados antigos omitido por simplicidade

        btnSalvar.setOnClickListener(v -> {
            String origem = etOrigem.getText().toString();
            String destino = etDestino.getText().toString();
            String data = etData.getText().toString();
            String horario = etHorario.getText().toString();

            // Simula salvamento
            Toast.makeText(this, "Viagem atualizada com sucesso!", Toast.LENGTH_SHORT).show();
            finish(); // Fecha e volta para tela anterior
        });
    }
}


