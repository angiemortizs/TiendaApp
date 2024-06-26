package controller;

import modelo.Productos;
import modelo.ProductosDAO;
import view.ProductosView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductosController implements ActionListener {
    private ProductosView productosView;
    private ProductosDAO productoDAO;

    public ProductosController(ProductosView productosView, ProductosDAO productoDAO) {
        this.productosView = productosView;
        this.productoDAO = productoDAO;
        this.productosView.btnCrearProducto.addActionListener(this);
        this.productosView.btnLeerProductos.addActionListener(this);
        this.productosView.btnActualizarProducto.addActionListener(this);
        this.productosView.btnEliminarProducto.addActionListener(this);
    }

    public ProductosController() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == productosView.btnCrearProducto) {
            crearProducto();
        } else if (e.getSource() == productosView.btnLeerProductos) {
            leerProductos();
        } else if (e.getSource() == productosView.btnActualizarProducto) {
            actualizarProducto();
        } else if (e.getSource() == productosView.btnEliminarProducto) {
            eliminarProducto();
        }
    }

    private void crearProducto() {
        String nombre = productosView.getNombreProducto();
        double precio = productosView.getPrecioProducto();
        int categoriaId = productosView.getCategoriaId();
        Productos producto = new Productos(0, nombre, precio, categoriaId);
        productoDAO.crearProducto(producto);
        ProductosView.mostrarMensaje("Producto creado exitosamente.");
    }

    private void leerProductos() {
        List<Productos> productos = productoDAO.leerProductos();
        ProductosView.mostrarProductos(productos);
    }

    private void actualizarProducto() {
        int id = productosView.getIdProducto();
        String nombre = productosView.getNombreProducto();
        double precio = productosView.getPrecioProducto();
        int categoriaId = productosView.getCategoriaId();
        Productos producto = new Productos(id, nombre, precio, categoriaId);
        productoDAO.actualizarProducto(producto);
        ProductosView.mostrarMensaje("Producto actualizado exitosamente.");
    }

    private void eliminarProducto() {
        int id = productosView.getIdProducto();
        productoDAO.eliminarProducto(id);
        ProductosView.mostrarMensaje("Producto eliminado exitosamente.");
    }

	public void mostrarMenu() {
		// TODO Auto-generated method stub
		
	}
}
