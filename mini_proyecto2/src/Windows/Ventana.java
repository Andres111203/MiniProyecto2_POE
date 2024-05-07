package Windows;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener
{
    Container contenedor;
    private JPanel panel1, panel2, panel3;
    private Product_Disp product_disp;
    JButton boton1, boton2, boton3;
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
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        boton1 = new JButton("Productos disponibles");
        boton2 = new JButton("parte 2");
        boton3 = new JButton("parte 3");

        sidePanel.setBackground(mi_Otro_Color);
        //Se añaden los botones al panel lateral
        sidePanel.add(boton1);
        sidePanel.add(boton2);
        sidePanel.add(boton3);
        //Se crea un tamaño igual para los botones
        Dimension buttonSize = new Dimension(160, 75);
        boton1.setPreferredSize(buttonSize);
        boton2.setPreferredSize(buttonSize);
        boton3.setPreferredSize(buttonSize);

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
    
    
        }
    
    
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
}
