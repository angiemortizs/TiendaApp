package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {
	private Connection conexion;
	private ConexionBD conexionBD;
	
	public ClientesDAO() {
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
	}
	 public void crearClientes (Clientes clientes){
	        String sql = "INSERT INTO clientes (idCliente, nomCliente, contactoCliente, genero) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
	            statement.setInt(1, clientes.getIdCliente());
	            statement.setString(2, clientes.getNomCliente());
	            statement.setInt(3, clientes.getContactoCliente());
	            statement.setString (4, clientes.getGenero());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	                System.out.println("Error al crear cliente: " + e.getMessage());
	        }}
	 
	 
	 public List<Clientes> leerClientes() {
	        List<Clientes> listaClientes = new ArrayList<>();
	        String sql = "SELECT * FROM Clientes";
	        try (Statement statement = conexion.createStatement();
	             ResultSet resultSet = statement.executeQuery(sql)) {
	            
	        	while (resultSet.next()) {
	            	
	                int idCliente = resultSet.getInt("idCliente");
	                String nomCliente = resultSet.getString("nomCliente");
	                int contactoCliente = resultSet.getInt("contactoCliente");
	                String genero = resultSet.getString("genero");
	                
	                Clientes clientes = new Clientes(0,nomCliente,0,genero);
	                listaClientes.add(clientes);
	            }
	        } catch (SQLException e) {
	                System.out.println("Error al consultar los datos: " + e.getMessage());
	        }
	        return listaClientes;
	    }
	    
	    public void actualizarCliente(Clientes clientes) {
	        String sql = "UPDATE Clientes SET nomCliente = ?, contactoCliente = ? WHERE idCliente = ?";
	        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
	            statement.setString(1, clientes.getNomCliente());
	            statement.setInt(2, clientes.getContactoCliente());
	            statement.setInt(3, clientes.getIdCliente());
	            statement.setString(4, clientes.getGenero());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	                System.out.println("Error al actualizar los datos: " + e.getMessage());
	        }
	    }
	    
	    public void eliminarCliente(int idCliente) {
	        String sql = "DELETE FROM Clientes WHERE idCliente = ?";
	        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
	            statement.setInt(1, idCliente);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	                System.out.println("Error al eliminar los datos: " + e.getMessage());
	        }
	    }
	    
	    public int verificarClientes(int idCliente) {
	                String sql = "SELECT COUNT(*) AS cuenta FROM Clientes c WHERE c.idCliente =?";
	                int resultado = 0;
	        try (PreparedStatement statement = conexion.prepareStatement(sql)){
	            statement.setInt(1, idCliente);
	            ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	                resultado = resultSet.getInt("cuenta");
	            }
	        } catch (SQLException e) {
	                System.out.println("Error al consultar los datos: " + e.getMessage());
	        }
	        return resultado;
	        }
	    
	    public void cerrarConexion() {
	        conexionBD.closeConexion(conexion);
	    }
}

