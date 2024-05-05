import javax.swing.JFrame;
import java.awt.Container;

public class App extends JFrame
{
    Container contenedor;
    public App()
    {
        setTitle("Ferreteria");
        setSize(500, 300);
        setVisible(true);



    }
    
    
    public static void main(String[] args) throws Exception
    {
        App app = new App();
        System.out.println(app);
    }
}
