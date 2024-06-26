package modelo;

public class Clientes {
	private int idCliente;
	private String nomCliente;
	private int contactoCliente;
	private String genero;
	
	public Clientes(int idCliente, String nomCliente, int contactoCliente, String genero) {
		super();
		this.idCliente = idCliente;
		this.nomCliente = nomCliente;
		this.contactoCliente = contactoCliente;
		this.genero = genero;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public int getContactoCliente() {
		return contactoCliente;
	}

	public void setContactoCliente(int contactoCliente) {
		this.contactoCliente = contactoCliente;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
