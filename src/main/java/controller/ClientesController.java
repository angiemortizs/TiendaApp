package controller;

import modelo.Clientes;
import modelo.ClientesDAO;
import view.ClientesView;

import java.util.List;
import java.util.Scanner;

public class ClientesController {
    private ClientesDAO clientesDAO;
    private Scanner scanner;

    public ClientesController() {
        clientesDAO = new ClientesDAO();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Clientes ---");
            System.out.println("1. Crear Clientes");
            System.out.println("2. Leer Clientes");
            System.out.println("3. Actualizar Clientes");
            System.out.println("4. Eliminar Clientes");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    crearClientes();
                    break;
                case 2:
                    leerClientes();
                    break;
                case 3:
                    actualizarClientes();
                    break;
                case 4:
                    eliminarClientes();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    private void crearClientes() {
        System.out.print("Ingrese el nombre de el cliente: ");
        String nomCliente = scanner.nextLine();
        System.out.print("Ingrese el numero de telefono del cliente: ");
        int contactoCliente = scanner.nextInt();
        
        Clientes clientes = new Clientes(0, nomCliente, 0, nomCliente);
        clientesDAO.crearClientes(clientes);
        ClientesView.mostrarMensaje("Cliente creado exitosamente.");
    }

    private void leerClientes() {
        List<Clientes> clientes = clientesDAO.leerClientes();
        ClientesView.mostrarClientes(clientes);
    }

    private void actualizarClientes() {
        leerClientes();
        System.out.print("\nIngrese el ID de el cliente que desea actualizar: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el nuevo nombre de el cliente: ");
        String nuevoNombreCliente = scanner.nextLine();
        System.out.print("Ingrese el nuevo telefono del cliente: ");
        String nuevoTelefono = scanner.nextLine();
        Clientes clientes = new Clientes(idCliente, nuevoNombreCliente, idCliente, nuevoTelefono);
        clientesDAO.actualizarCliente(clientes);
        ClientesView.mostrarMensaje("Categoría actualizada exitosamente.");
    }

    private void eliminarClientes() {
        leerClientes();
        System.out.print("\nIngrese el ID del cliente que desea eliminar: ");
        int idCliente = scanner.nextInt();
        clientesDAO.eliminarCliente(idCliente);
        ClientesView.mostrarMensaje("Cliente eliminado exitosamente.");
    }
}

