import java.sql.*;
import java.text.*;
import java.util.*;

public class Main
{
	public static Scanner input = new Scanner(System.in);

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
					case 1:
						new ItensController().createItem(connection);
						break;

					case 2:
						new TiposController().createTipo(connection);
						break;

					case 3:
						new ItensController().listarItens(connection);
						break;

					case 4:
						new TiposController().listarTipos(connection);
						break;

					case 5:
						new ItensController().listarItensTipos(connection);
						break;
					
					case 6:
						new ItensController().listarMaioresQueAMedia(connection);
						break;

				}
			}
			
			catch(SQLException exception)
			{
				System.out.println(exception.getMessage());
				continue;
			}
		}
		while(option > 0 && option < 7);  
		
		connection.close();
	}    
	
	private static int menu()
	{
		System.out.println("1 - Inserir um novo item");
		System.out.println("2 - Inserir um novo tipo");
		System.out.println("3 - Exibir todos os itens");
		System.out.println("4 - Exibir todos os tipos");
		System.out.println("5 - Exibir todos os itens e seus respectivos tipos");
		System.out.println("6 - Exibir todos os itens com altura maior que a média de todas as alturas");
		System.out.println("0 - Digite qualquer outro valor para sair");
		System.out.println();
		System.out.print("Escolha uma funcionalidade: ");

		return Integer.parseInt(input.nextLine());
	}
}