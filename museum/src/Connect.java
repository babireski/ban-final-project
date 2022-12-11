import java.sql.*;
import java.util.logging.*;

public class Connect
{
	private Connection connection = null;
	
	public Connect() throws ClassNotFoundException
	{
		String username = "postgres";
		String password = "postgres";
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/museum";

		// try
		// {
		// 	Enumeration<Driver> drivers = DriverManager.getDrivers();
		// 	while (drivers.hasMoreElements())
		// 	{
		// 		Driver nextElement = drivers.nextElement();
		// 		JOptionPane.showMessageDialog(null, nextElement.acceptsURL("jdbc:postgresql://localhost:5432/museum"));
		// 		JOptionPane.showMessageDialog(null, nextElement.acceptsURL("jdbc:postgresql://localhost:5432/postgres"));
		// 	}
		// } 
		
		// catch(SQLException exception)
		// {
		// 	exception.printStackTrace();
		// }

		try
		{
			Class.forName(driver);
			this.connection = (Connection) DriverManager.getConnection(url, username, password);
		}
		
		catch(ClassNotFoundException exception)
		{
			Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, exception);
			exception.printStackTrace();
			System.exit(1);
		}
		
		catch(SQLException exception)
		{
			Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, exception);
			exception.printStackTrace();
			System.exit(1);
		}
	}
	
	public Connection getConnection()
	{
		return connection;
	}
	
	public void closeConnection()
	{
		try
		{
			this.connection.close();
		}
		
		catch(SQLException exception)
		{
			Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, exception);
			exception.printStackTrace();
			System.exit(1);
		}
	}
}