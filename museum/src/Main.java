import java.sql.*;
import java.text.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws SQLException, ParseException, ClassNotFoundException
	{
		Connection connection = new Connect().getConnection();
		int option = 0;

		do
		{
			option = menu();
			
			try
			{
				switch(option)
				{
					case 1: new ItensController().createItem(connection);
						break;
					case 2: new TiposController().createTipo(connection);
						break;
				}
			}
			
			catch(SQLException exception)
			{
				System.out.println(exception.getMessage());
				continue;
			}
		}
		while(option > 0 && option < 6);  
		
		connection.close();
	}    
	
	private static int menu()
	{
		System.out.println();
		System.out.println("Informe o número da opção que desejas executar: ");
		System.out.println();
		System.out.println("1 - Inserir um novo item");
		System.out.println("2 - Inserir um novo tipo");
		System.out.println("3 - Exibir todos os itens");
		System.out.println("4 - Exibir todos os tipos");
		System.out.println("5 - Exibir todos os itens e seus respectivos tipos");
		System.out.println("6 - Exibir todos os itens de um determinado tipo");
		System.out.println("0 - Digite qualquer outro valor para sair");
		System.out.print("Sua escolha: ");

		try(Scanner input = new Scanner(System.in))
		{
			return input.nextInt();
		}
	}
}