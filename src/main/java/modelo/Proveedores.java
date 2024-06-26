package modelo;

public class Proveedores {
	private int idProveedor;
	private String nomProveedor;
	private int contactoProveedor;
	private String direccionProveedor;
	
	public Proveedores(int idProveedor, String nomProveedor, int contactoProveedor, String direccionProveedor) {
		super();
		this.idProveedor = idProveedor;
		this.nomProveedor = nomProveedor;
		this.contactoProveedor = contactoProveedor;
		this.direccionProveedor = direccionProveedor;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}

	public int getContactoProveedor() {
		return contactoProveedor;
	}

	public void setContactoProveedor(int contactoProveedor) {
		this.contactoProveedor = contactoProveedor;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

}
