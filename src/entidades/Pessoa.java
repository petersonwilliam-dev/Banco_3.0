package entidades;

import java.util.Objects;

public class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private String numero_telefone;

    public Pessoa(String nome, String cpf, String numero_telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.numero_telefone = numero_telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumero_telefone() {
        return numero_telefone;
    }

    public void setNumero_telefone(String numero_telefone) {
        this.numero_telefone = numero_telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa that)) return false;
        return  Objects.equals(getCpf(), that.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getNumero_telefone());
    }
}
