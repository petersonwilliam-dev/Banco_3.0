import entidades.Banco;
import entidades.Conta;
import entidades.Pessoa;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Pessoa pessoa = new Pessoa("Peterson William", "12236893442", "81998981250");
        Conta conta = new Conta(pessoa, "user", "user");

        Pessoa pessoa1 = new Pessoa("Peterson William", "12236893642", "81998981250");
        Conta conta1 = new Conta(pessoa1, "user", "user");

        try {
            banco.adicionarConta(conta);
            banco.adicionarConta(conta1);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}