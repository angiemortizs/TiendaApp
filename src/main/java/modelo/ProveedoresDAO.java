package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresDAO {
	private Connection conexion;
	private ConexionBD conexionBD;
	
	public ProveedoresDAO() {
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
	}
	 public void crearProveedor (Proveedores proveedores){
	        String sql = "INSERT INTO proovedores (idProveedor, nomProveedor, contactoProveedor, direccionProveedor) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
	            statement.setInt(1, proveedores.getIdProveedor());
	            statement.setString(2, proveedores.getNomProveedor());
	            statement.setInt(3, proveedores.getContactoProveedor());
	            statement.setString (4, proveedores.getDireccionProveedor());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	                System.out.println("Error al crear proveedor: " + e.getMessage());
	        }
	 }
	    
	    public void cerrarConexion() {
	        conexionBD.closeConexion(conexion);
	    }
}
