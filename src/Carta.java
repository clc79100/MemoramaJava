import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Carta {
    private JButton button;
    private int posicion;
    private String imagen;

    public Carta(int posicion, String imagen){
        this.posicion = posicion;
        this.imagen = imagen;
    }

    public JButton getButton() {
        return button;
    }
    
    public int getPosicion() {
        return posicion;
    }

    public String getImagen() {
        return imagen;
    }

}
