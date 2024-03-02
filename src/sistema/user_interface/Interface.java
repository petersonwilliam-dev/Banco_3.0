package sistema.user_interface;

import entidades.Conta;

import java.util.Scanner;

public class Interface {

    public static void menuInicial() {
        System.out.println("===== MENU INICIAL =====");
        System.out.println("1 - ACESSAR MINHA CONTA");
        System.out.println("2 - CRIAR UMA CONTA");
        System.out.println("3 - SAIR");
    }

    public static void menuConta() {
        System.out.println("===== BEM-VINDO =====");
        System.out.println("1 - DEPOSITAR DINHEIRO");
        System.out.println("2 - SACAR DINHEIRO");
        System.out.println("3 - CONSULTAR MEUS DADOS");
        System.out.println("4 - EXCLUIR MINHA CONTA");
        System.out.println("5 - SAIR");
    }
}
