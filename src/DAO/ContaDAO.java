package DAO;

import connectionDB.ConnectionDB;
import entidades.Conta;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDAO {

    private static Connection connection;

    static {
        try {
            connection = ConnectionDB.getConnectionDB();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void adicionarConta(Conta conta) throws SQLException{
        int id_titular = PessoaDAO.adicionarPessoa(conta.getTitularConta());

        String sql = "INSERT INTO contas (saldo, usuario, senha, id_titular) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setFloat(1, conta.getSaldo());
        preparedStatement.setString(2, conta.getUsuario());
        preparedStatement.setString(3, conta.getSenha());
        preparedStatement.setInt(4, id_titular);

        preparedStatement.execute();
        preparedStatement.close();
    }

    public static ResultSet retornaContas() throws SQLException{
        String sql = "SELECT * FROM contas";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        preparedStatement.close();

        return resultSet;
    }

    public static void editarConta(Conta conta) throws SQLException{
        String sql = "UPDATE contas SET saldo = ?, usuario = ?, senha = ? WHERE = numero_conta = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setFloat(1, conta.getSaldo());
        preparedStatement.setString(2, conta.getUsuario());
        preparedStatement.setString(3, conta.getSenha());
        preparedStatement.setInt(4, conta.getNumero_conta());

        preparedStatement.execute();
        preparedStatement.close();
    }

    public static void excluirConta(Conta conta) throws SQLException{
        PessoaDAO.excluirPessoa(conta.getId_titular());
        String sql = "DELETE FROM contas WHERE numero_conta = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, conta.getNumero_conta());

        preparedStatement.execute();
        preparedStatement.close();
    }
}
