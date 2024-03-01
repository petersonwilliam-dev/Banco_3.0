package entidades;

import sistema.entradas.ValidarDadosBancarios;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;
    private List<Pessoa> pessoas;

    public Banco() {
        this.contas = new ArrayList<Conta>();
        this.pessoas = new ArrayList<Pessoa>();
    }

    public void adicionarConta(Conta conta) {
        if (ValidarDadosBancarios.verificaTitular(conta.getTitularConta(), this.pessoas)) {
            if (ValidarDadosBancarios.verificaUsuario(conta.getUsuario(), this.contas)) {
                this.contas.add(conta);
                this.pessoas.add(conta.getTitularConta());
            } else {
                throw new RuntimeException("USUÁRIO JÁ FOI USADO");
            }
        } else {
            throw new RuntimeException("CPF JÁ FOI USADO!");
        }
    }

    public void excluirConta(Conta conta) {
        this.contas.remove(conta);
        this.pessoas.remove(conta.getTitularConta());
    }

    public void transferência(Conta remetente, Conta destinatário , float valor) {
        try {
            remetente.sacar(valor);
            destinatário.depositar(valor);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    public Conta buscarConta(String usuario, String senha) {
        for (Conta c : this.contas) {
            if (c.getUsuario().equals(usuario)) {
                if (c.getSenha().equals(senha)) {
                    return c;
                } else {
                    throw new RuntimeException("SENHA INCORRETA!");
                }
            }
        }
        throw new RuntimeException("CONTA NÃO ENCONTRADA!");
    }
}
