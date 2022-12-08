import java.sql.Date;
import java.util.List;

public class Itens
{
	private int code;
	private String name;
	private List<String> materials;
	private Date creation;
	private float height;
	private float width;
	private float depth;

	public Itens(int code, String name, List<String> materials, Date creation, float height, float width, float depth)
	{
		this.code = code;
		this.name = name;
		this.materials = materials;
		this.creation = creation;
		this.height = height;
		this.width = width;
		this.depth = depth;
	}

	/* Setters */

	public void setCode(int code)
	{
		this.code = code;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setMaterials(List<String> materials)
	{
		this.materials = materials;
	}

	public void setCreation(Date creation)
	{
		this.creation = creation;
	}

	public void setHeight(float height)
	{
		this.height = height;
	}

	public void setWidth(float width)
	{
		this.width = width;
	}

	public void setDepth(float depth)
	{
		this.depth = depth;
	}

	/* Getters */

	public int getCode()
	{
		return code;
	}

	public String getName()
	{
		return name;
	}

	public List<String> getMaterials()
	{
		return materials;
	}

	public Date getCreation()
	{
		return creation;
	}

	public float getHeight()
	{
		return height;
	}

	public float getDepth()
	{
		return depth;
	}

	public float getWidth()
	{
		return width;
	}

	/* Other */

	public String toString()
	{
		String s = "";

		s += "Código: " + code + "\n";
		s += "Nome: " + name + "\n";
		s += "Materiais: " + materials + "\n";
		s += "Criação: " + creation + "\n";
		s += "Dimensões: " + height + " x " + width + " x " + depth + " x " + "\n";

		return s;
	}
}
