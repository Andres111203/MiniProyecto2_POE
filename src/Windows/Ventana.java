package Windows;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener
{
    Container contenedor;
    private JPanel panel1, panel2, panel3;
    private Product_Disp product_disp;
    JButton boton1, boton2, boton3, boton4;
    
    //Se crea color con rgb
    Color miColor = new Color(216, 225, 230);
    Color mi_Otro_Color = new Color(110, 135, 146);

    public Ventana()
    {
        setTitle("Titulo generico");
        setSize(700, 400);
        //Necesario para parar el programa cerrando la ventana.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Centra la ventana, al correrle se queda en la mitad de la pantalla
        setLocationRelativeTo(null);
        //Contenedor principal o panel principal
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());

        //Se crean paneles para cada funcion.
        panel1 = new JPanel();
        panel1.setBackground(miColor);

        panel2 = new JPanel();
        panel2.setBackground(miColor);

        panel3 = new JPanel();
        panel3.setBackground(miColor);

        contenedor.add(panel1);


        //Se crea el panel lateral para cambiar de panel. 
        JPanel sidePanel = new JPanel();
        //ImagenIcon img = new ImagenIcon("")
        
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        boton1 = new JButton("Productos disponibles");
        boton2 = new JButton("Agregar Producto");
        boton3 = new JButton("Eliminar Producto");
        boton4 = new JButton("Actualizar Inventario");
        

        sidePanel.setBackground(mi_Otro_Color);
        //Se añaden los botones al panel lateral
        sidePanel.add(boton1);
        sidePanel.add(boton2);
        sidePanel.add(boton3);
        sidePanel.add(boton4);
        
        //Se crea un tamaño igual para los botones
        Dimension buttonSize = new Dimension(160, 75);
        boton1.setPreferredSize(buttonSize);
        boton2.setPreferredSize(buttonSize);
        boton3.setPreferredSize(buttonSize);
        boton4.setPreferredSize(buttonSize);
        

        contenedor.add(sidePanel, BorderLayout.WEST);

        boton1.addActionListener(new ActionListener()
        {
                @Override
            public void actionPerformed(ActionEvent e) {
                // Llama al método para mostrar los productos
                product_disp.Productos_disponibles(panel1);
            }
        });
            
            product_disp = new Product_Disp();
            Agregar_Producto agregar = new Agregar_Producto();
            Eliminar_Producto eliminar = new Eliminar_Producto();
            Actualizar_Inventario actualizar = new Actualizar_Inventario();

        boton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                agregar.agregando_Producto(panel1);
            }



        });

        boton3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                eliminar.eliminando_Producto(panel1);
            }
            
        });

        boton4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                actualizar.actualizar_Inventario(panel1);
            }
            
        });

            


    
    
        }
    
    
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
}
