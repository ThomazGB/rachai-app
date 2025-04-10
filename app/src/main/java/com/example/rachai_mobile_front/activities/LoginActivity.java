package com.example.rachai_mobile_front.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rachai_mobile_front.R;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput;
    private Button loginButton, registerButton;

    // Padrão de senha forte
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!*]).{8,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        loginButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String senha = passwordInput.getText().toString().trim();

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!isEmailValido(email)) {
                Toast.makeText(this, "Email deve ser institucional (@fatec.sp.gov.br)", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!isSenhaValida(senha)) {
                Toast.makeText(this, "Senha inválida. Deve conter ao menos 8 caracteres, 1 letra maiúscula, 1 minúscula, 1 número e 1 caractere especial.", Toast.LENGTH_LONG).show();
                return;
            }

            // Simula login bem-sucedido
            Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, ListaViagensActivity.class);
            startActivity(intent);
            finish();
        });

        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, CadastroUsuarioActivity.class);
            startActivity(intent);
        });
    }

    private boolean isEmailValido(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.endsWith("@fatec.sp.gov.br");
    }

    private boolean isSenhaValida(String senha) {
        return PASSWORD_PATTERN.matcher(senha).matches();
    }
}
