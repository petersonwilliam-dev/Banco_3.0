package sistema.entradas;

import entidades.Conta;
import entidades.Pessoa;

import java.util.List;

public class ValidarDadosBancarios {
    public static boolean verificaUsuario(String usuario, List<Conta> contas) {
        for (Conta conta : contas) {
            if (conta.getUsuario().equals(usuario)) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificaTitular(Pessoa titularDaConta, List<Pessoa> titulares) {
        for (Pessoa titular : titulares) {
            if (titular.equals(titularDaConta)) {
                return false;
            }
        }
        return true;
    }

}
