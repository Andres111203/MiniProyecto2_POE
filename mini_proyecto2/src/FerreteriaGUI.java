import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class FerreteriaGUI {
    private JFrame frame;
    private JList<String> productList;
    private DefaultListModel<String> productModel;

    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel priceLabel;
    private JLabel stockLabel;
    private JLabel materialLabel;
    private JLabel useLabel;
    private JLabel toolLabel;

    // Estructura de datos para almacenar los detalles de los productos
    private String[][] productDetails = {
        {"Martillo", "Martillo de acero forjado", "$10", "50", "Acero", "Clavar clavos", "Martillo"},
        {"Destornillador", "Destornillador de cabeza plana", "$5", "30", "Acero", "Apriete de tornillos", "Destornillador"},
        {"Sierra", "Sierra de mano para madera", "$15", "20", "Acero, madera", "Cortar madera", "Sierra"},
        {"Llave inglesa", "Llave ajustable de acero", "$8", "40", "Acero", "Ajustar tuercas y tornillos", "Llave inglesa"}
    };

    public FerreteriaGUI() {
        frame = new JFrame("Inventario de la Ferretería");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // Panel de la lista de productos
        productModel = new DefaultListModel<>();
        productList = new JList<>(productModel);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane productScrollPane = new JScrollPane(productList);
        contentPane.add(productScrollPane, BorderLayout.CENTER);

        // Panel de detalles del producto
        JPanel detailsPanel = new JPanel(new GridLayout(7, 1));
        nameLabel = new JLabel();
        descriptionLabel = new JLabel();
        priceLabel = new JLabel();
        stockLabel = new JLabel();
        materialLabel = new JLabel();
        useLabel = new JLabel();
        toolLabel = new JLabel();
        detailsPanel.add(nameLabel);
        detailsPanel.add(descriptionLabel);
        detailsPanel.add(priceLabel);
        detailsPanel.add(stockLabel);
        detailsPanel.add(materialLabel);
        detailsPanel.add(useLabel);
        detailsPanel.add(toolLabel);
        contentPane.add(detailsPanel, BorderLayout.SOUTH);

        // Agregar productos a la lista
        for (String[] product : productDetails) {
            productModel.addElement(product[0]);
        }

        // Manejador de evento para cuando se selecciona un producto
        productList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = productList.getSelectedIndex();
                if (index != -1) {
                    // Obtener los detalles del producto seleccionado
                    String[] details = productDetails[index];
                    // Mostrar los detalles en las etiquetas del panel de detalles
                    nameLabel.setText("Nombre: " + details[0]);
                    descriptionLabel.setText("Descripción: " + details[1]);
                    priceLabel.setText("Precio: " + details[2]);
                    stockLabel.setText("Stock: " + details[3]);
                    materialLabel.setText("Material: " + details[4]);
                    useLabel.setText("Uso: " + details[5]);
                    toolLabel.setText("Herramienta necesaria: " + details[6]);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FerreteriaGUI();
            }
        });
    }
}