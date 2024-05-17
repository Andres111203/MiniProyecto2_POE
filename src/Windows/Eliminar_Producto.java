package Windows;


import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Eliminar_Producto {

    
    String nombre;
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

        eliminar_prod.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                Product producto_a_eliminar = null;
                while(true){

                    try{

                        nombre = nombre_prod_field.getText();
                        if(!nombre.matches("[a-zA-Z]+")){
                            throw new Excepcion_String("nombre invalido, solo letras");
                        }
                        for(Product producto : Product_Disp.arrayProducts){

                            if(nombre.equalsIgnoreCase(producto.getName())){

                                producto_a_eliminar = producto;
                            }
                        }
                        if(producto_a_eliminar != null){

                            Product_Disp.arrayProducts.remove(producto_a_eliminar);
                        }else{

                            JOptionPane.showMessageDialog(panel_eliminar, "El producto a eliminar no existe en el inventario");
                        }

                        nombre_prod_field.setText(" ");
                        break;

                        }catch(Excepcion_String ex){
                            JOptionPane.showMessageDialog(panel, ex.getMessage());
                        }
                    }
                }
            
        });

    

        
        panel.revalidate();
        panel.repaint();

    }
}