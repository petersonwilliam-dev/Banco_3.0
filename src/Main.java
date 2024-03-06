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
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                } else if (opcao == 2) {
                    Conta conta = CreateEnt.criarConta(sc);
                    try {
                        Banco.adicionarConta(conta);
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                } else {
                    try {
                        Banco.atualizarBanco();
                        break;
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                }

            } else {
                Interface.menuConta();
                int opcao = ValidarEntradas.recebeInteiro(sc, "DIGITE QUAL OPERAÇÃO DESEJA REALIZAR: ");
                if (opcao == 1) {
                    float valor = ValidarEntradas.recebeFloat(sc, "DIGITE O VALOR DE DEPÓSITO: ");
                    try {
                        contaLogada.depositar(valor);
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                } else if (opcao == 2) {
                    float valor = ValidarEntradas.recebeFloat(sc, "DIGITE O VALOR QUE VOCÊ DESEJA SACAR: ");
                    try {
                        contaLogada.sacar(valor);
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }

                } else if (opcao == 3) {
                    float valor = ValidarEntradas.recebeFloat(sc, "DIGITE O VALOR QUE VOCÊ DESEJA TRANSFERIR: ");
                    int numero_conta_destinatario = ValidarEntradas.recebeInteiro(sc, "DIGITE O NÚMERO DA CONTA DO DESTINATÁRIO: ");
                    try {
                        Conta conta_destinatario = Banco.buscarConta(numero_conta_destinatario);
                        Banco.transferência(contaLogada, conta_destinatario, valor);
                    } catch (Exception exception){
                        System.out.println(exception.getMessage());
                    }
                } else if (opcao == 4) {
                    System.out.println(contaLogada);
                } else if (opcao == 5) {
                    try {
                        Banco.excluirConta(contaLogada);
                        contaLogada = null;
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                } else {
                    contaLogada = null;
                }
            }
        }
    }
}
