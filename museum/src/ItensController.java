import java.sql.*;
import java.text.*;
import java.util.*;

public class ItensController
{
	public static Scanner input = new Scanner(System.in);

	public void createItem(Connection connection) throws SQLException, ParseException
	{
		System.out.println();
		System.out.println("Insira os seguintes dados para a criar um novo item: ");
		System.out.println();

		System.out.print("Identificador: ");
		int id = Integer.parseInt(input.nextLine());

		System.out.print("Nome: ");
		String name = input.nextLine();

		System.out.print("Descrição: ");
		String description = input.nextLine();

		System.out.print("Ano (0 - desconhecido): ");
		int year = Integer.parseInt(input.nextLine()); 
   
		System.out.print("Tipo: ");
		int type = Integer.parseInt(input.nextLine());        

		System.out.print("Altura: ");
		float height = Float.parseFloat(input.nextLine());    

		System.out.print("Largura: ");
		float length = Float.parseFloat(input.nextLine());   

		System.out.print("Profundidade: ");
		float depth = Float.parseFloat(input.nextLine());
		
		ItensBean item = new ItensBean(id, name, description, year, type, height, length, depth);
		ItensModel.create(item, connection);

		System.out.println();
		System.out.println("Item criado com sucesso!");
		System.out.println();
	}

	void listarItens(Connection connection) throws SQLException
	{
		HashSet items = ItensModel.listAll(connection);
		Iterator<ItensBean> iterator = items.iterator();
		
		System.out.println();

		while(iterator.hasNext())
		{
			System.out.println(iterator.next().toString());
		}
	}

	void listarItensTipos(Connection connection) throws SQLException
	{
		HashSet itens = ItensModel.listAllWithTipos(connection);
		Iterator<ItensBean> iterator = itens.iterator();

		System.out.println();

		while(iterator.hasNext())
		{
			System.out.println(iterator.next().toString());
		}
	}

	void listarMaioresQueAMedia(Connection connection) throws SQLException
	{
		HashSet itens = ItensModel.listHigherThanAverage(connection);
		Iterator<ItensBean> iterator = itens.iterator();

		System.out.println();

		while(iterator.hasNext())
		{
			System.out.println(iterator.next().toString());
		}
	}
}