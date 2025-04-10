package com.example.rachai_mobile_front.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rachai_mobile_front.R;

public class AvaliacaoActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private EditText editComentario;
    private Button btnEnviarAvaliacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);

        ratingBar = findViewById(R.id.ratingBar);
        editComentario = findViewById(R.id.editComentario);
        btnEnviarAvaliacao = findViewById(R.id.btnEnviarAvaliacao);

        btnEnviarAvaliacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float nota = ratingBar.getRating();
                String comentario = editComentario.getText().toString();

                // Futuramente, salvar avaliação no banco de dados
                Toast.makeText(AvaliacaoActivity.this,
                        "Avaliação enviada! Nota: " + nota + "\nComentário: " + comentario,
                        Toast.LENGTH_LONG).show();

                finish(); // Fecha a tela após envio
            }
        });
    }
}

