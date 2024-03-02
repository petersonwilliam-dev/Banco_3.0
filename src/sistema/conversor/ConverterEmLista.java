package sistema.conversor;

import DAO.PessoaDAO;
import entidades.Conta;
import entidades.Pessoa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConverterEmLista {

    public static List retornarListaPessoas() throws SQLException {
        ResultSet resultSet = PessoaDAO.retornaPessoas();
        List listaPessoas = new ArrayList<Pessoa>();

        while (resultSet.next()) {
            Pessoa pessoa = new Pessoa(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
            listaPessoas.add(pessoa);
        }

        return listaPessoas;
    }

    public static List retornaListaContas(ResultSet resultSet)  throws SQLException{
        List listaContas = new ArrayList<Conta>();
        while (resultSet.next()) {
            Pessoa pessoa = new Pessoa(resultSet.getInt(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10));
            Conta conta = new Conta(resultSet.getInt(1), pessoa, resultSet.getFloat(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5));
            listaContas.add(conta);
        }

        return listaContas;
    }
}
