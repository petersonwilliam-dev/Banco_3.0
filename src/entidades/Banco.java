package entidades;

import sistema.entradas.ValidarDadosBancarios;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List contas;
    private List titulares;

    public Banco() {
        this.contas = new ArrayList<Conta>();
        this.titulares = new ArrayList<Pessoa>();
    }

    public void adicionarConta(Conta conta) {
        if (ValidarDadosBancarios.verificaTitular(conta.getTitularConta(), this.titulares)) {
            if (ValidarDadosBancarios.verificaUsuario(conta.getUsuario(), this.contas)) {
                this.contas.add(conta);
                this.titulares.add(conta.getTitularConta());
            } else {
                throw new RuntimeException("USUÁRIO JÁ FOI USADO");
            }
        } else {
            throw new RuntimeException("CPF JÁ FOI USADO!");
        }
    }

    public List getContas() {
        return contas;
    }
}
