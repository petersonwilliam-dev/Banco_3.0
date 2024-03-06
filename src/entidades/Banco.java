package entidades;

import DAO.ContaDAO;
import DAO.PessoaDAO;
import sistema.conversor.ConverterEmLista;
import sistema.entradas.ValidarDadosBancarios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static List<Conta> contas = new ArrayList<Conta>();
    private static List<Pessoa> pessoas = new ArrayList<Pessoa>();

    static {
        try {
            atualizaDados();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void adicionarConta(Conta conta) throws SQLException{
        if (ValidarDadosBancarios.verificaTitular(conta.getTitularConta(), pessoas)) {
            if (ValidarDadosBancarios.verificaUsuario(conta.getUsuario(), contas)) {
                ContaDAO.adicionarConta(conta);
                atualizaDados();
            } else {
                throw new RuntimeException("USUÁRIO JÁ FOI USADO");
            }
        } else {
            throw new RuntimeException("CPF JÁ FOI USADO!");
        }
    }

    public static void excluirConta(Conta conta) throws SQLException{
        ContaDAO.excluirConta(conta);
        atualizaDados();
    }

    public static void transferência(Conta remetente, Conta destinatário , float valor) throws RuntimeException{
        remetente.sacar(valor);
        destinatário.depositar(valor);
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

    public static void atualizarBanco() throws SQLException{
        for (Conta c : contas) {
            ContaDAO.editarConta(c);
            PessoaDAO.editarPessoa(c.getTitularConta());
        }
    }

    public static void atualizaDados() throws SQLException{
        pessoas = ConverterEmLista.retornarListaPessoas();
        contas = ConverterEmLista.retornaListaContas();
    }
}
