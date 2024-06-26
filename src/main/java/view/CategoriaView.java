package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import modelo.Categoria;

public class CategoriaView extends JFrame {
    private JTextField txtNombreCategoria;
    private JTextField txtIdCategoria;
    private JTextField txtNuevoNombreCategoria;
    public JButton btnCrearCategoria;
    public JButton btnEliminarCategoria;
    public JButton btnMostrarCategoria;
    public JButton btnActualizarCategoria;
    private JTextArea txtAreaCategorias;

    public CategoriaView() {
        super("Categorías");
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(3, 2));

        JLabel lblNombreCategoria = new JLabel("Nombre de la categoría:");
        txtNombreCategoria = new JTextField(20);
        panelEntrada.add(lblNombreCategoria);
        panelEntrada.add(txtNombreCategoria);

        JLabel lblIdCategoria = new JLabel("ID de la categoría:");
        txtIdCategoria = new JTextField(20);
        panelEntrada.add(lblIdCategoria);
        panelEntrada.add(txtIdCategoria);

        JLabel lblNuevoNombreCategoria = new JLabel("Nuevo nombre de la categoría:");
        txtNuevoNombreCategoria = new JTextField(20);
        panelEntrada.add(lblNuevoNombreCategoria);
        panelEntrada.add(txtNuevoNombreCategoria);

        add(panelEntrada, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnCrearCategoria = new JButton("Crear categoría");
        btnEliminarCategoria = new JButton("Eliminar categoría");
        btnMostrarCategoria = new JButton("Mostrar categorías");
        btnActualizarCategoria = new JButton("Actualizar categoría");
        panelBotones.add(btnCrearCategoria);
        panelBotones.add(btnEliminarCategoria);
        panelBotones.add(btnMostrarCategoria);
        panelBotones.add(btnActualizarCategoria);

        add(panelBotones, BorderLayout.CENTER);

        // Panel de salida
        JPanel panelSalida = new JPanel();
        txtAreaCategorias = new JTextArea(10, 20);
        txtAreaCategorias.setEditable(false);
        panelSalida.add(new JScrollPane(txtAreaCategorias));

        add(panelSalida, BorderLayout.SOUTH);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public String getNombreCategoria() {
        return txtNombreCategoria.getText();
    }

    public int getIdCategoria() {
        try {
            return Integer.parseInt(txtIdCategoria.getText());
        } catch (NumberFormatException e) {
            return -1; // ID inválido
        }
    }

    public String getNuevoNombreCategoria() {
        return txtNuevoNombreCategoria.getText();
    }

    public void mostrarCategorias(List<Categoria> categorias) {
        txtAreaCategorias.setText("");
        for (Categoria categoria : categorias) {
            txtAreaCategorias.append("ID: " + categoria.getId() + ", Nombre: " + categoria.getNombre() + "\n");
        }
    }
}
