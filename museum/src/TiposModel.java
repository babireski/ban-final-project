import java.sql.*;
import java.util.*;

public class TiposModel {
	static void create(TiposBean t, Connection c) throws SQLException {
		PreparedStatement s;
		s = c.prepareStatement("INSERT INTO tipos (identificador, nome) " + "VALUES (?, ?)");
		s.setInt(1, t.getId());
		s.setString(2, t.getName()); 
		s.execute();
		s.close();
	}

	static HashSet listAll(Connection c) throws SQLException {
		Statement s;
		HashSet list = new HashSet();

		s = c.createStatement();
		String sql = "SELECT identificador, nome FROM tipos";
		ResultSet result = s.executeQuery(sql);
		
		while(result.next()) {
			list.add(new TiposBean(result.getInt(1), result.getString(2)));
		}

		return list;
	}

	static HashSet listAllWithItems(Connection c) throws SQLException {
        Statement s;
        HashSet list = new HashSet();
        s = c.createStatement();

        String sql = "SELECT tipos.identificador, tipos.nome FROM tipos NATURAL JOIN itens";
        ResultSet result = s.executeQuery(sql);
    }
}
