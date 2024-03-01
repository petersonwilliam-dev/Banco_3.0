package entidades;

public class Conta {
    private int numero_conta;
    private TitularDaConta titularConta;
    private double saldo;

    private String usuario;
    private String senha;

    public Conta(int numero_conta, TitularDaConta titularConta, double saldo, String usuario, String senha) {
        this.numero_conta = numero_conta;
        this.titularConta = titularConta;
        this.saldo = saldo;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Conta(TitularDaConta titularConta, String usuario, String senha) {
        this.titularConta = titularConta;
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getNumero_conta() {
        return numero_conta;
    }

    public TitularDaConta getTitularConta() {
        return titularConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(float valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            throw new RuntimeException("VALOR INVÁLIDO");
        }
    }

    public void sacar(float valor) {
        if ((valor <= this.saldo) && (valor > 0)) {
            this.saldo -= valor;
        } else {
            throw new RuntimeException("SALDO INSUFICIENTE!");
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
