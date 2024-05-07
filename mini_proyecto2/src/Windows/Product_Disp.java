package Windows;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;


public class Product_Disp {

    protected void Productos_disponibles(JPanel panel) {
        // Elimina cualquier componente que ya esté en el panel
        panel.removeAll();

        // Panel de productos
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.setBorder(BorderFactory.createTitledBorder("Productos"));
        panel.add(productPanel, BorderLayout.CENTER);

        // Panel de lista de productos
        DefaultListModel<String> productModel = new DefaultListModel<>();
        JList<String> productList = new JList<>(productModel);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane productScrollPane = new JScrollPane(productList);
        productScrollPane.setPreferredSize(new Dimension(200, 200));
        productPanel.add(productScrollPane, BorderLayout.CENTER);

        // Panel de detalles del producto
        JPanel detailsPanel = new JPanel(new GridLayout(7, 2));
        productPanel.add(detailsPanel, BorderLayout.SOUTH);

        // Establecer un tamaño preferido para el panel de detalles del producto
        detailsPanel.setPreferredSize(new Dimension(510, 195));

        // Crear y configurar las etiquetas de detalle
        String[] detailLabelsText = {"Nombre:", "Descripción:", "Precio:", "Stock:", "Material:", "Uso:", "Herramienta necesaria:"};
        JLabel[] detailLabels = new JLabel[detailLabelsText.length];
        for (int i = 0; i < detailLabelsText.length; i++) {
            detailLabels[i] = createDetailLabel(detailLabelsText[i]);
            detailsPanel.add(detailLabels[i]);
            // Se agrega un espacio en blanco después de la etiqueta para la información
            detailsPanel.add(new JLabel());
        }

        // Estructura de datos para almacenar los detalles de los productos
        String[][] productDetails = {
            {"Martillo", "Martillo de acero forjado", "$10", "50", "Acero", "Clavar clavos", "Martillo"},
            {"Destornillador", "Destornillador de cabeza plana", "$5", "30", "Acero", "Apriete de tornillos", "Destornillador"},
            {"Sierra", "Sierra de mano para madera", "$15", "20", "Acero, madera", "Cortar madera", "Sierra"},
            {"Llave inglesa", "Llave ajustable de acero", "$8", "40", "Acero", "Ajustar tuercas y tornillos", "Llave inglesa"}
        };

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
                    for (int i = 0; i < details.length; i++) {
                        detailLabels[i].setText(detailLabelsText[i] + " " + details[i]);
                    }
                }
            }
        });
        
        // Actualiza la interfaz
        panel.revalidate();
        panel.repaint();
    }

    // Método para crear y configurar automáticamente una etiqueta de detalle
    private static JLabel createDetailLabel(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }
}