import java.sql.Date;
import java.util.List;

public class ItensBean {
	private String code;
	private String name;
	private String description;
	private Date creation;
	private List<String> materials;
	private TiposBean tipo;
	private float height;
	private float length;
	private float depth;
	
	/* Getters */
	
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Date getCreation() {
		return creation;
	}

	public List<String> getMaterials() {
		return materials;
	}

	public TiposBean getTipo() {
		return tipo;
	}

	public float getHeight() {
		return height;
	}
	
	public float getLength() {
		return length;
	}

	public float getDepth() {
		return depth;
	}

	/* Setters */

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public void setMaterials(List<String> materials) {
		this.materials = materials;
	}

	public void setTipo(TiposBean tipo) {
		this.tipo = tipo;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public void setDepth(float depth) {
		this.depth = depth;
	}

	/* Others */

	public String toString() {
		String s = "";
		s += "Identificador: " + code + "\n";
		s += "Nome: " + name + "\n";
		s += "Descrição: " + description + "\n";
		s += "Data de criação: " + creation + "\n";
		s += "Materiais: " + code + "\n";

		return s;
	}
}
