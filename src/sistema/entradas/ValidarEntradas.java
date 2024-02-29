package sistema.entradas;

import java.util.Scanner;

public class ValidarEntradas {
    
    public static String recebeString(Scanner sc, String msg) {
        System.out.print(msg);
        while ((!sc.hasNext()) || (sc.hasNextDouble())) {
            System.out.println("DIGITE UM VALOR VÁLIDO!");
            sc.nextLine();
            System.out.print(msg);
        }
        String resposta = sc.nextLine();
        return resposta;
    }

    public static int recebeInteiro(Scanner sc, String msg) {
        System.out.print(msg);
        while ((!sc.hasNextInt())) {
            System.out.println("DIGITE UM VALOR VÁLIDO!");
            sc.nextLine();
            System.out.print(msg);
        }

        int resposta = Integer.parseInt(sc.nextLine());
        return resposta;
    }
}
