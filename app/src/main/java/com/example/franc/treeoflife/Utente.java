package com.example.franc.treeoflife;

import java.io.Serializable;

public class Utente implements Serializable {
    private String nome;
    private String cognome;
    private String tipo;

    public Utente() {
    }

    public Utente(String nome, String cognome, String tipo) {
        this.nome = nome;
        this.cognome = cognome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTipo() {
        return tipo;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}