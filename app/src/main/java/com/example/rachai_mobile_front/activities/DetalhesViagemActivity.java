package com.example.rachai_mobile_front.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rachai_mobile_front.R;

public class DetalhesViagemActivity extends AppCompatActivity {

    private TextView tvValorOrigem, tvValorDestino, tvValorData, tvValorMotorista;
    private Button btnEditar, btnParticipantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_viagem);

        tvValorOrigem = findViewById(R.id.tvValorOrigem);
        tvValorDestino = findViewById(R.id.tvValorDestino);
        tvValorData = findViewById(R.id.tvValorData);
        tvValorMotorista = findViewById(R.id.tvValorMotorista);

        btnEditar = findViewById(R.id.btnEditar);
        btnParticipantes = findViewById(R.id.btnParticipantes);

        // Dados recebidos
        String origem = getIntent().getStringExtra("origem");
        String destino = getIntent().getStringExtra("destino");
        String data = getIntent().getStringExtra("data");
        String motorista = getIntent().getStringExtra("motorista");

        tvValorOrigem.setText(origem);
        tvValorDestino.setText(destino);
        tvValorData.setText(data);
        tvValorMotorista.setText(motorista);

        btnEditar.setOnClickListener(v -> {
            Intent intent = new Intent(this, EditarViagemActivity.class);
            startActivity(intent);
        });

        btnParticipantes.setOnClickListener(v -> {
            Intent intent = new Intent(this, ParticipantesActivity.class);
            startActivity(intent);
        });
    }
}
