package Windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Agregar_Producto {

    String nombreP, descripcionP, precioP, cantidadP, materialP, usosP, herramienta_nesc;
    DefaultListModel<String> productModel;

    protected void agregando_Producto(JPanel panel) {
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // creando el panel para el titulo
        JLabel titulo = new JLabel("Agregando Productos", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 16));
        JPanel panel_titulo = new JPanel();
        panel_titulo.setBackground(Color.ORANGE);
        panel_titulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel_titulo.add(titulo);
        panel.add(panel_titulo);

        // creando el panel y el campo para el nombre del producto
        JPanel panel_nombre = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel nombre_prod = new JLabel("Ingrese el nombre del producto", SwingConstants.CENTER);
        panel_nombre.setBackground(Color.LIGHT_GRAY);
        panel_nombre.setMaximumSize(new Dimension(600, 150));
        panel_nombre.add(nombre_prod);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(panel_nombre);

        JTextField nombre_prod_field = new JTextField(30);
        JPanel panel_field_nombre = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nombre_prod_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_field_nombre.add(nombre_prod_field);
        panel.add(panel_field_nombre);
        panel.add(Box.createRigidArea(new Dimension(0, 7)));

        // creando los paneles y campo para la descripcion del producto
        JPanel panel_descripcion = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label_descripcion = new JLabel("Ingrese la descripcion del producto", SwingConstants.CENTER);
        panel_descripcion.setBackground(Color.LIGHT_GRAY);
        panel_descripcion.setMaximumSize(new Dimension(600, 30));
        panel_descripcion.add(label_descripcion);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(panel_descripcion);

        JTextArea descrip_prod_field = new JTextArea();
        descrip_prod_field.setPreferredSize(new Dimension(300, 25));
        JPanel panel_field_descrip = new JPanel(new FlowLayout(FlowLayout.CENTER));
        descrip_prod_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_field_descrip.setBackground(Color.WHITE);
        panel_field_descrip.add(descrip_prod_field);
        panel.add(panel_field_descrip);

        // creando los paneles y campo para el precio del producto
        JPanel panel_precio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label_precio = new JLabel("Ingrese el precio del producto", SwingConstants.CENTER);
        panel_precio.setBackground(Color.LIGHT_GRAY);
        panel_precio.setPreferredSize(new Dimension(600, 25));
        panel_precio.add(label_precio);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(panel_precio);

        JTextField precio_prod_field = new JTextField(30);
        JPanel panel_field_precio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        precio_prod_field.setPreferredSize(new Dimension(300, 20));
        precio_prod_field.setMaximumSize(new Dimension(300, 20));
        precio_prod_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_field_precio.add(precio_prod_field);
        panel.add(panel_field_precio);

        // agregando los paneles y campos para la cantidad
        JPanel panel_cantidad = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label_cantidad = new JLabel("Ingrese la cantidad del producto", SwingConstants.CENTER);
        panel_cantidad.setBackground(Color.LIGHT_GRAY);
        panel_cantidad.setPreferredSize(new Dimension(600, 35));
        panel_cantidad.add(label_cantidad);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(panel_cantidad);

        JTextField cantidad_prod_field = new JTextField(35);
        JPanel panel_field_cantidad = new JPanel(new FlowLayout(FlowLayout.CENTER));
        cantidad_prod_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_field_cantidad.setPreferredSize(new Dimension(600, 25));
        panel_field_cantidad.add(cantidad_prod_field);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(panel_field_cantidad);

        // agregando panel y campo para material
        JPanel panel_material = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label_material = new JLabel("Ingrese el material del producto", SwingConstants.CENTER);
        panel_material.setBackground(Color.LIGHT_GRAY);
        panel_material.setPreferredSize(new Dimension(600, 25));
        panel_material.add(label_material);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(panel_material);

        JTextField material_prod_field = new JTextField(35);
        JPanel panel_field_material = new JPanel(new FlowLayout(FlowLayout.CENTER));
        material_prod_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_field_material.add(material_prod_field);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(panel_field_material);


        // agregando panel y campo para usos
        JPanel panel_usos = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label_usos = new JLabel("Ingrese usos del producto", SwingConstants.CENTER);
        panel_usos.setBackground(Color.LIGHT_GRAY);
        panel_usos.setPreferredSize(new Dimension(600, 25));
        panel_usos.add(label_usos);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(panel_usos);

        JTextField usos_prod_field = new JTextField(35);
        JPanel panel_field_usos = new JPanel(new FlowLayout(FlowLayout.CENTER));
        usos_prod_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_field_usos.add(usos_prod_field);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(panel_field_usos);


        // agregando panel y campo para herramienta necesaria
        JPanel panel_herramienta = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label_herramienta = new JLabel("Ingrese el tipo herramienta", SwingConstants.CENTER);
        panel_herramienta.setBackground(Color.LIGHT_GRAY);
        panel_herramienta.setPreferredSize(new Dimension(600, 25));
        panel_herramienta.add(label_herramienta);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(panel_herramienta);

        
        JComboBox herramientaBox = new JComboBox<>();
        herramientaBox.addItem("ELECTRICA");
        herramientaBox.addItem("CORTE");
        herramientaBox.addItem("MANUAL");
        herramientaBox.addItem("MEDICION");
        JPanel panel_field_herramienta = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_field_herramienta.add(herramientaBox);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(panel_field_herramienta);


        // creando el boton para agregar el producto
        JPanel panel_agregar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton agregar_prod = new JButton("Agregar");
        agregar_prod.setFont(new Font("serif", Font.PLAIN, 14));
        agregar_prod.setBackground(Color.GREEN);
        agregar_prod.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_agregar.setPreferredSize(new Dimension(42, 30));
        panel_agregar.add(agregar_prod);
        panel.add(panel_agregar);
        

        agregar_prod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            boolean continuar = true;
             while(continuar){    
                try {
                    
                    nombreP = nombre_prod_field.getText();
                    descripcionP = descrip_prod_field.getText();

                    if (!nombreP.matches("[a-zA-Z ]+")) {
                        throw new Excepcion_String("Nombre incorrecto, solo letras y espacios permitidos.");
                        
                    }

                    precioP = precio_prod_field.getText();

                    if (!precioP.matches("[0-9]+")) {
                        throw new Excepcion_String_Dig("Precio inválido, debe ser un número.");
                    }

                    cantidadP = cantidad_prod_field.getText();

                    if (!cantidadP.matches("[0-9]+")) {
                        throw new Excepcion_String_Dig("Cantidad inválida, solo dígitos permitidos.");
                    }

                    materialP = material_prod_field.getText();
                    if (!materialP.matches("[a-zA-Z ]+")) {
                        throw new Excepcion_String("Material incorrecto, solo letras y espacios permitidos.");
                    } 
                    usosP = usos_prod_field.getText();
                    if (!usosP.matches("[a-zA-Z ]+")) {
                        throw new Excepcion_String("Material incorrecto, solo letras y espacios permitidos.");
                    } 
                    
                    Object herramienta = herramientaBox.getSelectedItem();
                    herramienta_nesc = herramienta.toString();
                    if (nombreP.isEmpty() || descripcionP.isEmpty() || precioP.isEmpty() || cantidadP.isEmpty() || materialP.isEmpty() || usosP.isEmpty() || herramienta_nesc.isEmpty()) {
                        JOptionPane.showMessageDialog(panel, "debes llenar todos los campos");
                    }
                    // Añadir el nuevo producto al ArrayList
                    Product newProduct = new Product(nombreP, descripcionP, precioP, cantidadP, materialP, usosP, herramienta_nesc);
                    Product_Disp.arrayProducts.add(newProduct);

                    JOptionPane.showMessageDialog(panel, "Producto agregado exitosamente");
                    break;

                
                } catch (Excepcion_String_Dig ex) {
                    JOptionPane.showMessageDialog(panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    continuar = false;
                    
                    

                }catch(Excepcion_String ex){
                    JOptionPane.showMessageDialog(panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    continuar = false;
                    

                }

                }
                nombre_prod_field.setText("");
                descrip_prod_field.setText("");
                precio_prod_field.setText("");
                cantidad_prod_field.setText("");
                material_prod_field.setText("");
                usos_prod_field.setText("");
                
            }
        });

        panel.revalidate();
        panel.repaint();
    }
}