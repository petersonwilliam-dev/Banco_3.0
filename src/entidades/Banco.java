package entidades;

import DAO.ContaDAO;
import sistema.conversor.ConverterEmLista;
import sistema.entradas.ValidarDadosBancarios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static List<Conta> contas = new ArrayList<Conta>();
    private static List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public static void adicionarConta(Conta conta) throws SQLException{
        if (ValidarDadosBancarios.verificaTitular(conta.getTitularConta(), pessoas)) {
            if (ValidarDadosBancarios.verificaUsuario(conta.getUsuario(), contas)) {
                pessoas.add(conta.getTitularConta());
                contas.add(conta);
            } else {
                throw new SQLException("USUÁRIO JÁ FOI USADO");
            }
        } else {
            throw new SQLException("CPF JÁ FOI USADO!");
        }
    }

    public static void excluirConta(Conta conta) {
        contas.remove(conta);
        pessoas.remove(conta.getTitularConta());
    }

    public static void transferência(Conta remetente, Conta destinatário , float valor) {
        try {
            remetente.sacar(valor);
            destinatário.depositar(valor);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    public static Conta buscarConta(String usuario, String senha) {
        for (Conta c : contas) {
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

    public static Conta buscarConta(int numero_conta) {
        for (Conta c : contas) {
            if (c.getNumero_conta() == numero_conta) {
                return c;
            }
        }
        throw new RuntimeException("CONTA NÃO ENCONTRADA!");
    }

}
