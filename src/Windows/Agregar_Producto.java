package Windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Agregar_Producto {

    

    protected void agregando_Producto(JPanel panel){

        panel.removeAll();
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //creando el panel para el titulo

        JLabel titulo = new JLabel("Agregando Productos", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 16));
        JPanel panel_titulo = new JPanel();
        panel_titulo.setBackground(Color.ORANGE);
        panel_titulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel_titulo.add(titulo);

        panel.add(panel_titulo);
        
         
        //creando el panel y el campo para el nombre del producto
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
       
        //creando los paneles y campo para la descripcion del producto
        JPanel panel_descripcion = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label_descripcion = new JLabel("Ingrese la descripcion del producto", SwingConstants.CENTER);
        panel_descripcion.setBackground(Color.LIGHT_GRAY);
        panel_descripcion.setMaximumSize(new Dimension(600, 30));
        panel_descripcion.add(label_descripcion);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(panel_descripcion);
        
        JTextArea descrip_prod_field = new JTextArea();
        descrip_prod_field.setPreferredSize(new Dimension(300,50));
        JPanel panel_field_descrip = new JPanel(new FlowLayout(FlowLayout.CENTER));
        descrip_prod_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_field_descrip.setBackground(Color.WHITE);
        panel_field_descrip.add(descrip_prod_field);
        panel.add(panel_field_descrip);

        

        //creando los paneles y campom para el precio del producto
        JPanel panel_precio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label_precio = new JLabel("Ingrese el precio del producto", SwingConstants.CENTER);
        panel_precio.setBackground(Color.LIGHT_GRAY);
        panel_precio.setPreferredSize(new Dimension(600,25));
        panel_precio.add(label_precio);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(panel_precio);

        JTextField precio_prod_field = new JTextField(30);
        JPanel panel_field_precio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        precio_prod_field.setPreferredSize(new Dimension(300, 20));
        precio_prod_field.setMaximumSize(new Dimension(300,20));
        precio_prod_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_field_precio.add(precio_prod_field);
        panel.add(panel_field_precio);

        //agregando los paneles y campos para la cantidad

        JPanel panel_cantidad = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label_cantidad = new JLabel("Ingrese la cantidad del producto", SwingConstants.CENTER);
        panel_cantidad.setBackground(Color.LIGHT_GRAY);
        panel_cantidad.setPreferredSize(new Dimension(600,25));
        panel_cantidad.add(label_cantidad);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(panel_cantidad);

        JTextField cantidad_prod_field = new JTextField(10);
        JPanel panel_field_cantidad = new JPanel(new FlowLayout(FlowLayout.CENTER));
        cantidad_prod_field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_field_cantidad.add(cantidad_prod_field);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(panel_field_cantidad);

        
        //creando el boton para agregar el producto

        JPanel panel_agregar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton agregar_prod = new JButton("Agregar");
        agregar_prod.setFont(new Font("serif", Font.PLAIN, 14));
        agregar_prod.setBackground(Color.GREEN);
        agregar_prod.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_agregar.setPreferredSize(new Dimension(42, 30));
        panel_agregar.add(agregar_prod);
        panel.add(panel_agregar);

        
        panel.revalidate();
        panel.repaint();

    }

    

}
