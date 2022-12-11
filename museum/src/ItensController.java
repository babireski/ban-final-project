import java.sql.*;
import java.text.*;
import java.util.*;

public class ItensController
{
	public void createItem(Connection connection) throws SQLException, ParseException
	{
		try(Scanner input = new Scanner(System.in))
		{
			System.out.println("Insira os seguintes dados para a criar um novo item: ");

			System.out.print("Identificador: ");
			int id = input.nextInt();

			System.out.print("Nome: ");
			String name = input.next();

			System.out.print("Descrição: ");
			String description = input.next();

			System.out.print("Criação: ");
			String date = input.next();    
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date parser = format.parse(date);
			java.sql.Date creation = new java.sql.Date(parser.getTime());

			System.out.print("Materiais: ");
			String materials = input.next();    

			System.out.print("Tipo: ");
			int type = input.nextInt();        

			System.out.print("Altura: ");
			float height = input.nextFloat();     

			System.out.print("Largura: ");
			float length = input.nextFloat();     

			System.out.print("Profundidade: ");
			float depth = input.nextFloat();
			
			ItensBean item = new ItensBean(id, name, description, creation, materials, type, height, length, depth);
			ItensModel.create(item, connection);

			System.out.println("Item criado com sucesso!");  
		}   
	}

	void listarItens(Connection connection) throws SQLException
	{
		HashSet items = ItensModel.listAll(connection);
		Iterator<ItensBean> iterator = items.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next().toString());
		}
	}
}