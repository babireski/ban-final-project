import java.sql.*;
import java.util.*;

public class ItensModel
{
	static void create(ItensBean item, Connection connection) throws SQLException
	{
		PreparedStatement statement;

		statement = connection.prepareStatement("INSERT INTO itens (codigo, nome, descricao, ano, tipo, altura, largura, profundidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		statement.setInt(1, item.getCode());
		statement.setString(2, item.getNome());
		statement.setString(3, item.getDescription());

		if(item.getYear() != 0)
		{
			statement.setInt(4, item.getYear());
		}

		else
		{
			statement.setNull(4, Types.INTEGER);
		}
		
		statement.setInt(5, item.getIdTipo());
		statement.setFloat(6, item.getHeight());
		statement.setFloat(7, item.getLength());
		statement.setFloat(8, item.getDepth());

		statement.execute();
		statement.close();
	}

	static HashSet listAll(Connection connection) throws SQLException
	{
		Statement statement;
		HashSet itens = new HashSet();

		statement = connection.createStatement();
		String sql = "SELECT codigo, nome, descricao, ano, tipo, altura, largura, profundidade FROM itens";
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next())
		{
			itens.add(new ItensBean(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5), result.getFloat(6), result.getFloat(7), result.getFloat(8)));
		}

		return itens;
	}

	static HashSet listAllWithTipos(Connection connection) throws SQLException
	{
			Statement statement = connection.createStatement();;
			HashSet itens = new HashSet();
			
			String sql = "SELECT codigo, itens.nome, descricao, ano, tipo, altura, largura, profundidade, identificador, tipos.nome FROM itens JOIN tipos ON itens.tipo = tipos.identificador;";
			ResultSet result = statement.executeQuery(sql);

			while(result.next())
			{
				ItensBean item = new ItensBean(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5), result.getFloat(6), result.getFloat(7), result.getFloat(8));
				TiposBean tipo = new TiposBean(result.getInt(9), result.getString(10));
				item.setTipo(tipo);
				itens.add(item);
			}

			return itens;
	}

	static HashSet listHigherThanAverage(Connection connection) throws SQLException
	{
		Statement statement;
		HashSet itens = new HashSet();

		statement = connection.createStatement();
		String sql = "SELECT codigo, nome, descricao, ano, tipo, altura, largura, profundidade FROM itens WHERE altura > (SELECT AVG(altura) FROM itens)";
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next())
		{
			itens.add(new ItensBean(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5), result.getFloat(6), result.getFloat(7), result.getFloat(8)));
		}

		return itens;
	}
}