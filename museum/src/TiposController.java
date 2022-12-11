import java.sql.*;
import java.util.*;

public class TiposController
{
    public void createTipo(Connection connection) throws SQLException
	{
		try(Scanner input = new Scanner(System.in))
		{
			System.out.println("Insira os seguintes dados para a criar um novo tipo: ");

			System.out.print("Identificador: ");
			int identificador = input.nextInt();
			
			System.out.print("Nome: ");
			String nome = input.next();
			
			TiposBean type = new TiposBean(identificador, nome);
			TiposModel.create(type, connection);
			
			System.out.println("Tipo criado com sucesso!"); 
		}    
    }

    void listarTipos(Connection connection) throws SQLException
	{
        HashSet types = TiposModel.listAll(connection);
        Iterator<TiposBean> iterator = types.iterator();
        
		while(iterator.hasNext())
		{
            System.out.println(iterator.next().toString());
        }
    }
}