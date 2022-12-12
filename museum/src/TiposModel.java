import java.sql.*;
import java.util.*;

public class TiposModel
{
	static void create(TiposBean type, Connection connection) throws SQLException
	{
		PreparedStatement statement;
		
		statement = connection.prepareStatement("INSERT INTO tipos (identificador, nome) VALUES (?, ?)");
		statement.setInt(1, type.getId());
		statement.setString(2, type.getName()); 
		
		statement.execute();
		statement.close();
	}

	static HashSet listAll(Connection connection) throws SQLException
	{
		Statement statement;
		HashSet tipos = new HashSet();

		statement = connection.createStatement();
		String sql = "SELECT identificador, nome FROM tipos";
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next())
		{
			tipos.add(new TiposBean(result.getInt(1), result.getString(2)));
		}

		return tipos;
	}
}