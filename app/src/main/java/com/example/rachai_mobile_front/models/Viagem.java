package com.example.rachai_mobile_front.models;

public class Viagem {
    private String origem;
    private String destino;
    private String data;

    public Viagem(String origem, String destino, String data) {
        this.origem = origem;
        this.destino = destino;
        this.data = data;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return origem + " → " + destino + " - " + data;
    }
}

