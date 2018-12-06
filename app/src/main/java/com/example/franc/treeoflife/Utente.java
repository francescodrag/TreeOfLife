package com.example.franc.treeoflife;

public class Utente {
    private String nome;
    private String cognome;
    private String tipo;
    private String user;
    private String password;

    public Utente() {
    }

    public Utente(String nome, String cognome, String tipo, String user, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.tipo = tipo;
        this.user = user;
        this.password = password;
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

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
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

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}