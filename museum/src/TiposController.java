import java.sql.*;
import java.util.*;

public class TiposController
{
	public static Scanner input = new Scanner(System.in);

	public void createTipo(Connection connection) throws SQLException
	{
		System.out.println();
		System.out.println("Insira os seguintes dados para a criar um novo tipo: ");
		System.out.println();

		System.out.print("Identificador: ");
		int identificador = Integer.parseInt(input.nextLine());
		
		System.out.print("Nome: ");
		String nome = input.nextLine();
		
		TiposBean type = new TiposBean(identificador, nome);
		TiposModel.create(type, connection);
		
		System.out.println();
		System.out.println("Tipo criado com sucesso!"); 
		System.out.println();
	}

	void listarTipos(Connection connection) throws SQLException
	{
		HashSet types = TiposModel.listAll(connection);
		Iterator<TiposBean> iterator = types.iterator();
		
		System.out.println();

		while(iterator.hasNext())
		{
			System.out.println(iterator.next().toString());
		}
	}
}