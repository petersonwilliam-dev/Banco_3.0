package sistema.user_interface;

import entidades.Conta;
import entidades.Pessoa;
import sistema.entradas.ValidarEntradas;

import java.util.Scanner;

public class CreateEnt {
    public static Pessoa criarPessoa(Scanner sc) {
        String nome = ValidarEntradas.recebeString(sc, "DIGITE SEU NOME: ");
        String CPF = ValidarEntradas.recebeString(sc, "DIGITE SEU CPF (SOMENTE OS NÚMEROS): ");
        String numero_telefone = ValidarEntradas.recebeString(sc, "DIGITE SEU NÚMERO DE TELEFONE: ");

        Pessoa pessoa = new Pessoa(nome, CPF, numero_telefone);
        return pessoa;
    }

    public static Conta criarConta(Scanner sc) {
        Pessoa pessoa = criarPessoa(sc);
        String usuario = ValidarEntradas.recebeString(sc, "DIGITE UM NOME DE USUÁRIO: ");
        String senha = ValidarEntradas.recebeString(sc, "DIGITE UMA SENHA: ");

        Conta conta = new Conta(pessoa, usuario, senha);

        return conta;
    }
}
