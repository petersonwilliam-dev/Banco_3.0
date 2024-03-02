package DAO;

import connectionDB.ConnectionDB;
import entidades.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {
    private static Connection connection;

    static {
        try {
            connection = ConnectionDB.getConnectionDB();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void adicionarPessoa(Pessoa pessoa) throws SQLException{
        String sql = "INSERT INTO pessoas (nome, cpf, numero_telefone) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, pessoa.getNome());
        preparedStatement.setString(2, pessoa.getCpf());
        preparedStatement.setString(3, pessoa.getNumero_telefone());

        preparedStatement.execute();
        preparedStatement.close();
    }

    public static ResultSet retornaPessoas() throws SQLException{
        String sql = "SELECT * FROM pessoas";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();
        preparedStatement.close();
        return resultSet;
    }

    public static void editarPessoa(Pessoa pessoa) throws SQLException{
        String sql = "UPDATE pessoas SET nome = ?, numero_telefone = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, pessoa.getNome());
        preparedStatement.setString(2, pessoa.getNumero_telefone());
        preparedStatement.setInt(3, pessoa.getId());

        preparedStatement.execute();
        preparedStatement.close();
    }

    public static void excluirPessoa(int id) throws SQLException{
        String sql = "DELETE FROM pessoas WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);

        preparedStatement.execute();
        preparedStatement.close();
    }
}
