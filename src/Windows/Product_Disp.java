package Windows;
//productos disponibles
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
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;


public class Product_Disp {
    
    public static ArrayList<Product> arrayProducts =  new ArrayList<>();
    public static DefaultListModel<String> productModel;
    public static JScrollPane productScrollPane;
    public static JList<String> productList;
    protected void Productos_disponibles(JPanel panel) {
        // Elimina cualquier componente que ya esté en el panel
        panel.removeAll();

        // Panel de productos
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.setBorder(BorderFactory.createTitledBorder("Productos"));
        panel.add(productPanel, BorderLayout.CENTER);

        // Panel de lista de productos
        productModel = new DefaultListModel<>();
        
        productList = new JList<>(productModel);
        
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productScrollPane = new JScrollPane(productList);
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
        
        Product product1 = new Product ("Martillo", "Martillo de acero forjado", "$10", "50", "Acero", "Clavar clavos", "Martillo");
        Product product2 = new Product ("Destornillador", "Destornillador de cabeza plana", "$5", "30", "Acero", "Apriete de tornillos", "Destornillador");
        Product product3 = new Product ("Sierra", "Sierra de mano para madera", "$15", "20", "Acero, madera", "Cortar madera", "Sierra");
        Product product4 = new Product ("Llave inglesa", "Llave ajustable de acero", "$8", "40", "Acero", "Ajustar tuercas y tornillos", "Llave inglesa");
        /* 
        arrayProducts.add(product1);
        arrayProducts.add(product2);
        arrayProducts.add(product3);
        arrayProducts.add(product4);*/
        // Agregar productos a la lista de la vista
        for (Product product : arrayProducts) {
            productModel.addElement(product.getName()); 
            
        }
        

        // Manejador de evento para cuando se selecciona un producto
        productList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = productList.getSelectedIndex();
                if (index != -1) {
                    ArrayList<String> detailsList = new ArrayList<>();
                    // Obtener los detalles del producto seleccionado
                    Product details = arrayProducts.get(index);

                    detailsList.add(details.getName());
                    detailsList.add(details.getDescription());
                    detailsList.add(details.getPrice());
                    detailsList.add(details.getQuantity());
                    detailsList.add(details.getMaterial());
                    detailsList.add(details.getUse());
                    detailsList.add(details.getCategory());
                    

                    for (int i = 0; i < detailsList.size(); i++) {
                        detailLabels[i].setText(detailLabelsText[i] + " " + detailsList.get(i));
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
    /* 
    public DefaultListModel<String> getProductModel() {
        return productModel;
    }*/

    

    
}