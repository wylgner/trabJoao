package com.example.root.trabjoao;

public class Aluno {
    int _id; String _nome;
    public Aluno(){ this._id=0; this._nome="";}; //construtor default
    public Aluno(int id, String nome){
        this._id=id; this._nome=nome; }
    public Aluno(String nome){ this._nome=nome; }
    public void setId(int id){ this._id=id;}
    public void setNome(String nome){this._nome=nome;}
    public int getId(){ return this._id;}
    public String getNome(){return this._nome;}
}