package br.com.consultassmt.smt_consultas.modelo;

/**
 * Created by Kassio on 28/09/2017.
 */

public class Pessoa {
    private int codigo;
    private String nome;
    private String sexo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo(String sexo) {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
