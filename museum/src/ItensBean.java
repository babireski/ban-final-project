import java.sql.*;

public class ItensBean
{
	private int code;
	private String nome;
	private String description;
	private Date creation;
	private String materials;
	private int idTipo;
	private TiposBean tipo;
	private float height;
	private float length;
	private float depth;

	public ItensBean(int code, String nome, String description, Date creation, String materials, int idTipo, float height, float length, float depth)
	{
		this.code = code;
		this.nome = nome;
		this.description = description;
		this.creation = creation;
		this.materials = materials;
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

	public Date getCreation()
	{
		return creation;
	}

	public String getMaterials()
	{
		return materials;
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

	public void setCreation(Date creation)
	{
		this.creation = creation;
	}

	public void setMaterials(String materials)
	{
		this.materials = materials;
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
		StringBuffer buffer = new StringBuffer();
		buffer.append("Identificador: " + code +"\nNome: "+ nome + "\nDescricao: "+ description + "\nData de Criação: " + creation + "\n Materiais: "+ materials + "\n");
		if(tipo != null) buffer.append("\nTipo: "+ tipo.getName());
		
		return buffer.toString();
	}
}