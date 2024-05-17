package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana extends JFrame implements ActionListener {
    Container contenedor;
    private JPanel panel1, panel2, panel3;
    private Product_Disp product_disp;
    /* */
    
    JButton boton1, boton2, boton3, boton4, boton5;

    // Se crea color con rgb
    Color miColor = new Color(216, 225, 230);
    Color mi_Otro_Color = new Color(110, 135, 146);

    public Ventana() {
        setTitle("FERRETODO");
        setSize(700, 680);
        // Necesario para parar el programa cerrando la ventana.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Centra la ventana, al correrle se queda en la mitad de la pantalla.
        setLocationRelativeTo(null);
        // Contenedor principal o panel principal.
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());

        /* */

        // Se crean paneles para cada función.
        panel1 = new JPanel();
        panel1.setBackground(miColor);

        panel2 = new JPanel();
        panel2.setBackground(miColor);

        panel3 = new JPanel();
        panel3.setBackground(miColor);

        contenedor.add(panel1);

        // Se crea el panel lateral para cambiar de panel.
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));

        boton1 = new JButton("Productos disponibles");
        boton2 = new JButton("Agregar Producto");
        boton3 = new JButton("Eliminar Producto");
        boton4 = new JButton("Actualizar Inventario");
        boton5 = new JButton("Tendencias del Inventario");
        

        sidePanel.setBackground(mi_Otro_Color);
        // Se añaden los botones al panel lateral.
        sidePanel.add(boton1);
        sidePanel.add(boton2);
        sidePanel.add(boton3);
        sidePanel.add(boton4);
        sidePanel.add(boton5);
     

        // Se crea un tamaño igual para los botones.
        Dimension buttonSize = new Dimension(160, 75);
        boton1.setPreferredSize(buttonSize);
        boton2.setPreferredSize(buttonSize);
        boton3.setPreferredSize(buttonSize);
        boton4.setPreferredSize(buttonSize);
        boton5.setPreferredSize(buttonSize);
       

        contenedor.add(sidePanel, BorderLayout.WEST);

        product_disp = new Product_Disp();
        Agregar_Producto agregar = new Agregar_Producto();
        Eliminar_Producto eliminar = new Eliminar_Producto();
        Actualizar_Inventario actualizar = new Actualizar_Inventario();

        // Añadir los ActionListeners a los botones.
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llama al método para mostrar los productos.
                product_disp.Productos_disponibles(panel1);
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llama al método para agregar productos.
                agregar.agregando_Producto(panel1);
                
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llama al método para eliminar productos.
                eliminar.eliminando_Producto(panel1);
            }
        });

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llama al método para actualizar inventario.
                actualizar.actualizar_Inventario(panel1);
            }
        });

        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel Panel = new JPanel();
                Panel.setLayout(new GridLayout(4, 1)); 
                Panel.setBackground(miColor);

                ArrayList<Product> products = Product_Disp.arrayProducts;
                double totalPrice = Tendencias_inv.getTotalPrice(products);
                ArrayList<Product> mostAndLeastStocked = Tendencias_inv.getMostAndLeastStockedProducts(products);
                ArrayList<String> mostUsedTools = Tendencias_inv.getMostUsedTools(products);

                JLabel totalPriceLabel = new JLabel("Precio total: " + totalPrice);
                Panel.add(totalPriceLabel);

                JLabel mostStockedLabel = new JLabel("Producto con más stock: " + mostAndLeastStocked.get(0).getName());
                Panel.add(mostStockedLabel);
                JLabel leastStockedLabel = new JLabel("Producto con menos stock: " + mostAndLeastStocked.get(1).getName());
                Panel.add(leastStockedLabel);

                JLabel mostUsedToolsLabel = new JLabel("Herramientas más usadas: " + mostUsedTools.get(0) + ", " + mostUsedTools.get(1));
                Panel.add(mostUsedToolsLabel);

                panel1.removeAll();
                panel1.setLayout(new BorderLayout());
                panel1.add(Panel, BorderLayout.CENTER);
                panel1.revalidate();
                panel1.repaint();
            }
        });;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implementa la lógica necesaria aquí.
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}