package DAO;

import connectionDB.ConnectionDB;
import entidades.Pessoa;

import java.sql.*;

public class PessoaDAO {
    private static Connection connection;

    static {
        try {
            connection = ConnectionDB.getConnectionDB();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static int adicionarPessoa(Pessoa pessoa) throws SQLException{
        String sql = "INSERT INTO pessoas (nome, cpf, numero_telefone) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, pessoa.getNome());
        preparedStatement.setString(2, pessoa.getCpf());
        preparedStatement.setString(3, pessoa.getNumero_telefone());

        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();
        int id_titular = resultSet.getInt(1);

        return id_titular;
    }

    public static ResultSet retornaPessoas() throws SQLException{
        String sql = "SELECT * FROM pessoas";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        return preparedStatement.getResultSet();
    }

    public static void editarPessoa(Pessoa pessoa) throws SQLException{
        String sql = "UPDATE pessoas SET nome = ?, numero_telefone = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, pessoa.getNome());
        preparedStatement.setString(2, pessoa.getNumero_telefone());
        preparedStatement.setInt(3, pessoa.getId());

        preparedStatement.execute();
    }

    public static void excluirPessoa(int id) throws SQLException{
        String sql = "DELETE FROM pessoas WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);

        preparedStatement.execute();
    }
}
