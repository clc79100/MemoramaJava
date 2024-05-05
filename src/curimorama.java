import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class curimorama {
    public static void main(String[] args) {
        JFrame ventanaw = new JFrame("Memorama");
        ventanaw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaw.setLayout(new GridLayout(4, 4));

        ArrayList<String> listaImagenes = new ArrayList<>();
        listaImagenes.add("amigosdelclaudio.jpeg");
        listaImagenes.add("blueypana.jpeg");
        listaImagenes.add("freefiremax.jpeg");
        listaImagenes.add("losestadestruyendo.jpeg");
        listaImagenes.add("desmadre.jpg");
        listaImagenes.add("papiar.jpeg");
        listaImagenes.add("perrooperra.jpeg");
        listaImagenes.add("samuel.jpeg");        

        ArrayList<String> listaDuplicada = new ArrayList<>(listaImagenes);
        listaImagenes.addAll(listaDuplicada);

        Collections.shuffle(listaImagenes);

        Icon icono = null;

        for (String nombreImagen : listaImagenes) {
            icono = new ImageIcon(curimorama.class.getResource(nombreImagen));
            JButton button = new JButton(icono);
            ventanaw.add(button);
        }

        ventanaw.setSize(666, 666);
        ventanaw.setLocationRelativeTo(null);
        ventanaw.setVisible(true);
    }
}