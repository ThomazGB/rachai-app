package com.example.rachai_mobile_front.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rachai_mobile_front.R;

import java.util.ArrayList;

public class PagamentosActivity extends AppCompatActivity {

    private ListView listPagamentos;
    private ArrayList<String> pagamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamentos);

        listPagamentos = findViewById(R.id.listPagamentos);

        // Dados simulados – substituir por dados reais no futuro
        pagamentos = new ArrayList<>();
        pagamentos.add("Maria Souza - R$ 20,00 (Pago)");
        pagamentos.add("Carlos Lima - R$ 20,00 (Pendente)");
        pagamentos.add("João Silva - R$ 20,00 (Pago)");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                pagamentos
        );

        listPagamentos.setAdapter(adapter);
    }
}

