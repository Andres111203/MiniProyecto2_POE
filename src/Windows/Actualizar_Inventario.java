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

public class Actualizar_Inventario {

    boolean productoExiste = false;
    String nombreProd, cantidadProd, precioProd;
    

    protected void actualizar_Inventario(JPanel panel){

        panel.removeAll();
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        
        JLabel titulo = new JLabel("Actualizando Inventario", SwingConstants.CENTER);
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

        //creando el boton para actualizar el inventario

        JPanel panel_actualizar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton actualizar = new JButton("Actualizar");
        actualizar.setFont(new Font("serif", Font.PLAIN, 14));
        actualizar.setBackground(Color.LIGHT_GRAY);
        actualizar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel_actualizar.setPreferredSize(new Dimension(42, 30));
        panel_actualizar.add(actualizar);
        panel.add(panel_actualizar);


        actualizar.addActionListener(new ActionListener() {

            
            @Override
            public void actionPerformed(ActionEvent e) {


                boolean continua = true;
                while(continua){

                    try{

                    nombreProd = nombre_prod_field.getText();
                    if(!nombreProd.matches("[a-zA-Z]+")){
                        throw new Excepcion_String("nombre invalido, solo letras");
                    }
                    cantidadProd = cantidad_prod_field.getText();

                    if(!nombreProd.matches("[0-9]+")){
                        throw new Excepcion_String_Dig("cantidad invalida, solo numeros");
                    }
                    precioProd = precio_prod_field.getText();
                    if(!nombreProd.matches("[0-9]+")){
                        throw new Excepcion_String_Dig("precio invalido, solo numeros");
                    }

                    Product producto_a_actualizar = null;

                    for(Product prods : Product_Disp.arrayProducts){

                        if(nombreProd.isEmpty()){

                            JOptionPane.showMessageDialog(panel, "Ingrese un  nombre");
                            break;
                        }

                        if(!(nombreProd.equalsIgnoreCase(prods.getName()))){

                            productoExiste = false;
                            JOptionPane.showMessageDialog(panel, "El producto ingresado no existe");
                            break;
                        }
                        
                        
                        else{

                            productoExiste = true;
                            producto_a_actualizar = prods;
                            
                        }
                    }

                    if(producto_a_actualizar != null){

                        producto_a_actualizar.setPrice(precioProd);
                        producto_a_actualizar.setQuantity(cantidadProd);
                        JOptionPane.showMessageDialog(panel, "se actualizó el inventario con éxito");
                    }else{

                        JOptionPane.showMessageDialog(panel, "el inventario está  vacío ");
                    }

                    

                    break;

                    }catch(Excepcion_String ex){
                        JOptionPane.showMessageDialog(panel, ex.getMessage());
                        continua = false;

                    }catch(Excepcion_String_Dig ex){
                        JOptionPane.showMessageDialog(panel, ex.getMessage());
                        continua = false;
                    }

                    
                }
                nombre_prod_field.setText(" ");
                precio_prod_field.setText(" ");
                cantidad_prod_field.setText(" ");
            }
            
        });
                
        
        
        panel.revalidate();
        panel.repaint();

    }

    

}

