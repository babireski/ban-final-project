public class Connect
{
	private Connect connection;

	public Connect()
	{
		String driver = "org.postgresql.Driver";
        String username = "postgres";
        String password = "udesc";
        String url = "jdbc:postgresql://localhost:5432/clinica";

		try
		{
            Class.forName(driver);
            this.connection = (Connection) DriverManager.getConnection(url, user, senha);
        }
		
		catch(ClassNotFoundException ex)
		{
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        }
		
		catch(SQLException ex)
		{
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        }  
	}
}