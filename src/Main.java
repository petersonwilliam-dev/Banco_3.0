import entidades.Banco;
import entidades.Conta;
import sistema.entradas.ValidarEntradas;
import sistema.user_interface.CreateEnt;
import sistema.user_interface.Interface;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Conta contaLogada = null;
        final Scanner sc = new Scanner(System.in);

        while (true) {
            if (contaLogada == null) {
                Interface.menuInicial();
                int opcao = ValidarEntradas.recebeInteiro(sc, "DIGITE QUAL OPÇÃO DESEJA: ");
                if (opcao == 1) {
                    String usuario = ValidarEntradas.recebeString(sc, "DIGITE SEU USUÁRIO: ");
                    String senha = ValidarEntradas.recebeString(sc, "DIGITE SUA SENHA: ");
                    try {
                        contaLogada = Banco.buscarConta(usuario, senha);
                    } catch (RuntimeException exception) {
                        System.out.println(exception.getMessage());
                    }
                } else if (opcao == 2) {
                    Conta conta = CreateEnt.criarConta(sc);
                    try {
                        Banco.adicionarConta(conta);
                    } catch (SQLException exception) {
                        System.out.println(exception.getMessage());
                    }
                } else {
                    break;
                }

            } else {
                Interface.menuConta();
                int opcao = ValidarEntradas.recebeInteiro(sc, "DIGITE QUAL OPERAÇÃO DESEJA REALIZAR: ");
                if (opcao == 1) {
                    float valor = ValidarEntradas.recebeFloat(sc, "DIGITE O VALOR DE DEPÓSITO: ");
                    try {
                        contaLogada.depositar(valor);
                    } catch (RuntimeException exception) {
                        System.out.println(exception.getMessage());
                    }
                    contaLogada.depositar(valor);
                } else if (opcao == 2) {
                    float valor = ValidarEntradas.recebeFloat(sc, "DIGITE O VALOR QUE VOCÊ DESEJA SACAR: ");
                    try {
                        contaLogada.sacar(valor);
                    } catch (RuntimeException exception) {
                        System.out.println(exception.getMessage());
                    }
                } else if (opcao == 3) {
                    System.out.println(contaLogada);
                } else if (opcao == 4) {
                    Banco.excluirConta(contaLogada);
                    contaLogada = null;
                } else {
                    contaLogada = null;
                }
            }
        }
    }
}