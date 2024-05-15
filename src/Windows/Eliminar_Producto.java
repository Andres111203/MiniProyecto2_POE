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

public class Eliminar_Producto {

    

    protected void eliminando_Producto(JPanel panel){

        panel.removeAll();
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        
        JLabel titulo = new JLabel("Eliminando Productos", SwingConstants.CENTER);
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
       

        
        //creando el boton para eliminar el producto
        
        JPanel panel_eliminar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton eliminar_prod = new JButton("Eliminar");
        eliminar_prod.setFont(new Font("serif", Font.PLAIN, 14));
        eliminar_prod.setBackground(Color.RED);
        eliminar_prod.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_eliminar.setPreferredSize(new Dimension(42, 30));
        panel_eliminar.add(eliminar_prod);
        panel.add(panel_eliminar);

    

        
        panel.revalidate();
        panel.repaint();

    }
}