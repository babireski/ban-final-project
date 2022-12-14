import java.sql.*;

public class ItensBean
{
	private int code;
	private String nome;
	private String description;
	private int year;
	private int idTipo;
	private TiposBean tipo;
	private float height;
	private float length;
	private float depth;

	public ItensBean(int code, String nome, String description, int year, int idTipo, float height, float length, float depth)
	{
		this.code = code;
		this.nome = nome;
		this.description = description;
		this.year = year;
		this.idTipo = idTipo;
		this.height = height;
		this.length = length;
		this.depth = depth;
	}
	
	/* Getters */
	
	public int getCode()
	{
		return code;
	}

	public String getNome()
	{
		return nome;
	}

	public String getDescription()
	{
		return description;
	}

	public int getYear()
	{
		return year;
	}

	public TiposBean getTipo()
	{
		return tipo;
	}

	public float getHeight()
	{
		return height;
	}
	
	public float getLength()
	{
		return length;
	}

	public float getDepth()
	{
		return depth;
	}

	public int getIdTipo()
	{
		return this.idTipo;
	}

	/* Setters */

	public void setCode(int code)
	{
		this.code = code;
	}

	public void setnome(String nome)
	{
		this.nome = nome;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public void setTipo(TiposBean tipo)
	{
		this.tipo = tipo;
	}

	public void setHeight(float height)
	{
		this.height = height;
	}

	public void setLength(float length)
	{
		this.length = length;
	}

	public void setDepth(float depth)
	{
		this.depth = depth;
	}

	public void setId(int idTipo)
	{
		this.idTipo = idTipo;
	}

	/* Others */

	public String toString()
	{
		String string = "";

		string += "Identificador: " + code + "\n";
		string += "Nome: " + nome + "\n";
		string += "Descrição: " + description + "\n";
		string += "Ano: " + (year != 0 ? year : "Desconhecido") + "\n";
		string += "Identificador do tipo: " + idTipo + "\n";
		string += "Dimensões: " + height + " x " + length + " x " + depth + "\n";
		
		if(tipo != null) string += "Tipo: "+ tipo.getName() + "\n";
		
		return string;
	}
}