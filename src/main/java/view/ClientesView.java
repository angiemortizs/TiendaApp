package view;

import modelo.Clientes;

import java.util.List;

public class ClientesView {
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void mostrarClientes(List<Clientes> clientes) {
        System.out.println("\n--- Lista de Clientes ---");
        for (Clientes cliente : clientes) {
            System.out.println("ID: " + cliente.getIdCliente() +
                               ", Nombre: " + cliente.getNomCliente() +
                               ", Contacto: " + cliente.getContactoCliente() +
                               ", Género: " + cliente.getGenero());
        }
    }
}
 