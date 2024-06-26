package view;

import modelo.Productos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;

public class ProductosView extends JFrame {
    private JTextField txtNombreProducto;
    private JTextField txtPrecioProducto;
    private JTextField txtCategoriaId;
    private JTextField txtIdProducto;
    public JButton btnCrearProducto;
    public JButton btnLeerProductos;
    public JButton btnActualizarProducto;
    public JButton btnEliminarProducto;
    private JTextArea txtAreaProductos;

    public ProductosView() {
        super("Productos");
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(4, 2));

        JLabel lblNombreProducto = new JLabel("Nombre del producto:");
        txtNombreProducto = new JTextField(20);
        panelEntrada.add(lblNombreProducto);
        panelEntrada.add(txtNombreProducto);

        JLabel lblPrecioProducto = new JLabel("Precio del producto:");
        txtPrecioProducto = new JTextField(20);
        panelEntrada.add(lblPrecioProducto);
        panelEntrada.add(txtPrecioProducto);

        JLabel lblCategoriaId = new JLabel("ID de la categoría:");
        txtCategoriaId = new JTextField(20);
        panelEntrada.add(lblCategoriaId);
        panelEntrada.add(txtCategoriaId);

        JLabel lblIdProducto = new JLabel("ID del producto:");
        txtIdProducto = new JTextField(20);
        panelEntrada.add(lblIdProducto);
        panelEntrada.add(txtIdProducto);

        add(panelEntrada, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnCrearProducto = new JButton("Crear producto");
        btnLeerProductos = new JButton("Leer productos");
        btnActualizarProducto = new JButton("Actualizar producto");
        btnEliminarProducto = new JButton("Eliminar producto");
        panelBotones.add(btnCrearProducto);
        panelBotones.add(btnLeerProductos);
        panelBotones.add(btnActualizarProducto);
        panelBotones.add(btnEliminarProducto);

        add(panelBotones, BorderLayout.CENTER);

        // Panel de salida
        JPanel panelSalida = new JPanel();
        txtAreaProductos = new JTextArea(10, 20);
        txtAreaProductos.setEditable(false);
        panelSalida.add(new JScrollPane(txtAreaProductos));

        add(panelSalida, BorderLayout.SOUTH);

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public String getNombreProducto() {
        return txtNombreProducto.getText();
    }

    public double getPrecioProducto() {
        return Double.parseDouble(txtPrecioProducto.getText());
    }

    public int getCategoriaId() {
        return Integer.parseInt(txtCategoriaId.getText());
    }

    public int getIdProducto() {
        return Integer.parseInt(txtIdProducto.getText());
    }

    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static void mostrarProductos(List<Productos> productos) {
        StringBuilder sb = new StringBuilder();
        for (Productos producto : productos) {
            sb.append("ID: ").append(producto.getId())
              .append(", Nombre: ").append(producto.getNombre())
              .append(", Precio: ").append(producto.getPrecio())
              .append(", ID Categoría: ").append(producto.getCategoriaId())
              .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Productos", JOptionPane.INFORMATION_MESSAGE);
    }
}
