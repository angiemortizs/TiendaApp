package main;

import controller.CategoriaController;
import controller.ClientesController;
import controller.ProductosController;
import controller.ProveedoresController;

public class main {
	public static void main(String[] args) {
        CategoriaController categoriaController = new CategoriaController();
        categoriaController.mostrarMenu();
        
        ProductosController productoController = new ProductosController();
        productoController.mostrarMenu();
        
        ProveedoresController proveedoresController = new ProveedoresController();
        proveedoresController.mostrarMenu();
        
        ClientesController clientesController = new ClientesController();
        clientesController.mostrarMenu();
    }
}
