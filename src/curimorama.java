import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class curimorama {
    private static int caso = 0;
    private static int cartaSeleccionada = 0;
    public static void main(String[] args) {
        JFrame ventanaw = new JFrame("Memorama");
        ventanaw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaw.setLayout(new GridLayout(4, 4));

        ArrayList<String> listaImagenes = new ArrayList<>();
        ArrayList<JButton> listaBotones = new ArrayList<>();

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

        
        for (int i = 0; i < listaImagenes.size(); i++) {
            JButton button =  new JButton(new ImageIcon(curimorama.class.getResource("backCard.jpg")));
            Carta carta = new Carta(i, listaImagenes.get(i));
            button.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e){
                    int posicion = carta.getPosicion();
                    String imagen = carta.getImagen();
                    button.setIcon(new ImageIcon(curimorama.class.getResource(imagen)));

                    switch (caso) {
                        case 0:
                            caso = 1;
                            cartaSeleccionada = posicion;
                            button.setEnabled(false);
                            break;

                        case 1:
                            if(!listaImagenes.get(posicion).equals(listaImagenes.get(cartaSeleccionada))){
                                JOptionPane.showMessageDialog(null, "Las cartas NO coinciden", "Alerta", JOptionPane.WARNING_MESSAGE);
                                listaBotones.get(cartaSeleccionada).setEnabled(true);
                                listaBotones.get(posicion).setIcon(new ImageIcon(curimorama.class.getResource("backCard.jpg")));
                                listaBotones.get(cartaSeleccionada).setIcon(new ImageIcon(curimorama.class.getResource("backCard.jpg")));

                            } else{
                                JOptionPane.showMessageDialog(null, "Las cartas SI coinciden", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                                listaBotones.get(posicion).setEnabled(false);
                                listaBotones.get(cartaSeleccionada).setEnabled(false);
                            
                            }

                            caso = 0;
                            cartaSeleccionada = 0;
                            break;
                    
                        default:
                            break;
                    }
                 }
            });
            ventanaw.add(button);
            listaBotones.add(button);
        }

        ventanaw.setSize(666, 666);
        ventanaw.setLocationRelativeTo(null);
        ventanaw.setVisible(true);
    }
}