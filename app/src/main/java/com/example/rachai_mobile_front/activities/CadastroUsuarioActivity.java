package com.example.rachai_mobile_front.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rachai_mobile_front.R;

import java.util.regex.Pattern;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText etNome, etEmail, etSenha;
    private Button btnCadastrar;

    // Regex para senha forte (mínimo 8 caracteres, uma maiúscula, uma minúscula, um número, um caractere especial)
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!*]).{8,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String senha = etSenha.getText().toString().trim();

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(CadastroUsuarioActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isEmailValido(email)) {
                    Toast.makeText(CadastroUsuarioActivity.this, "Email deve ser institucional (@fatec.sp.gov.br)", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isSenhaValida(senha)) {
                    Toast.makeText(CadastroUsuarioActivity.this, "Senha fraca! Use pelo menos 8 caracteres, uma maiúscula, uma minúscula, um número e um caractere especial", Toast.LENGTH_LONG).show();
                    return;
                }

                // Sucesso
                Toast.makeText(CadastroUsuarioActivity.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CadastroUsuarioActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean isEmailValido(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.endsWith("@fatec.sp.gov.br");
    }

    private boolean isSenhaValida(String senha) {
        return PASSWORD_PATTERN.matcher(senha).matches();
    }
}
