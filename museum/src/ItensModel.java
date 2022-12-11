import java.sql.*;
import java.util.*;

public class ItensModel
{
	static void create(ItensBean item, Connection connection) throws SQLException
	{
		PreparedStatement statement;

		statement = connection.prepareStatement("INSERT INTO itens (codigo, nome, descricao, criacao, materiais, tipo, altura, largura, profundidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		statement.setInt(1, item.getCode());
		statement.setString(2, item.getNome());
		statement.setString(3, item.getDescription());
		statement.setDate(4, item.getCreation());
		statement.setString(5, item.getMaterials());
		statement.setInt(6, item.getIdTipo());
		statement.setFloat(7, item.getHeight());
		statement.setFloat(8, item.getLength());
		statement.setFloat(9, item.getDepth());

		statement.execute();
		statement.close();
	}

	static HashSet listAll(Connection connection) throws SQLException
	{
		Statement statement;
		HashSet list = new HashSet();

		statement = connection.createStatement();
		String sql = "SELECT codigo, nome, descricao, criacao, materiais, tipo, altura, largura, profundidade FROM itens";
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next())
		{
			list.add(new ItensBean(result.getInt(1), result.getString(2), result.getString(3), result.getDate(4), result.getString(5), result.getInt(6), result.getFloat(7), result.getFloat(8), result.getFloat(9)));
		}

		return list;
	}
}