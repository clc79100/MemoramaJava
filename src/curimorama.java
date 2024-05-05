import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class curimorama {
    private static int caso = 0;
    private static int cartaSeleccionada = 0;
    public static void main(String[] args) {
        JFrame ventanaw = new JFrame("Memorama");
        ventanaw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaw.setLayout(new GridLayout(4, 4));

        ArrayList<String> listaImagenes = new ArrayList<>();
        ArrayList<JButton> listaBotones = new ArrayList<>();
        ArrayList<Carta> Encontradas = new ArrayList<>();

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
        Iniciarjuego(listaBotones,listaImagenes,Encontradas,ventanaw);
        ventanaw.setSize(800, 800);
        ventanaw.setLocationRelativeTo(null);
        ventanaw.setVisible(true);
    }
    public static void Iniciarjuego(ArrayList<JButton> listaBotones,ArrayList<String> listaImagenes,ArrayList<Carta> Encontradas,JFrame ventanaw){
        for (int i = 0; i < listaImagenes.size(); i++) {
            JButton button = new JButton(new ImageIcon(curimorama.class.getResource("/esocarlos.jpg")));
            Carta carta = new Carta(i, listaImagenes.get(i));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    button.setIcon(new ImageIcon(curimorama.class.getResource(carta.getImagen())));
                    switch (caso) {
                        case 0:
                            caso = 1;
                            cartaSeleccionada = carta.getPosicion();
                            button.setEnabled(false);
                            break;

                        case 1:
                            if(!listaImagenes.get(carta.getPosicion()).equals(listaImagenes.get(cartaSeleccionada))){
                                JOptionPane.showMessageDialog(null, "Las cartas NO coinciden", "Alerta", JOptionPane.WARNING_MESSAGE);
                                listaBotones.get(cartaSeleccionada).setEnabled(true);
                                listaBotones.get(carta.getPosicion()).setIcon(new ImageIcon(curimorama.class.getResource("/esocarlos.jpg")));
                                listaBotones.get(cartaSeleccionada).setIcon(new ImageIcon(curimorama.class.getResource("/esocarlos.jpg")));

                            } else{
                                JOptionPane.showMessageDialog(null, "Las cartas SI coinciden", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                                listaBotones.get(carta.getPosicion()).setEnabled(false);
                                listaBotones.get(cartaSeleccionada).setEnabled(false);
                                Encontradas.add(carta);
                            }

                            caso = 0;
                            cartaSeleccionada = 0;
                            break;
                    
                        default:
                            break;
                    }
                    if(Encontradas.size()==8){
                        int respuesta = JOptionPane.showOptionDialog(
                            null,
                            "Reiniciarjuego?",
                            "Felicidades pibe",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            new String[]{"Simon Bv","nel perrin"},
                            "Simon Bv"
                        );
                        if(respuesta==JOptionPane.YES_OPTION){
                            reiniciarJuego(listaBotones, listaImagenes, Encontradas, ventanaw);
                        }else if(respuesta==JOptionPane.NO_OPTION){
                            ventanaw.dispose();
                        }
                    }
                }
            });
            ventanaw.add(button);
            listaBotones.add(button);
        }
    }
    public static void reiniciarJuego(ArrayList<JButton> listaBotones, ArrayList<String> listaImagenes, ArrayList<Carta> Encontradas, JFrame ventana) {
        ventana.getContentPane().removeAll();
    
        listaBotones.clear();
        listaImagenes.clear();
        Encontradas.clear();
    
        ArrayList<String> imagenes = new ArrayList<>();
        imagenes.add("amigosdelclaudio.jpeg");
        imagenes.add("blueypana.jpeg");
        imagenes.add("freefiremax.jpeg");
        imagenes.add("losestadestruyendo.jpeg");
        imagenes.add("desmadre.jpg");
        imagenes.add("papiar.jpeg");
        imagenes.add("perrooperra.jpeg");
        imagenes.add("samuel.jpeg");
    
        ArrayList<String> listaDuplicada = new ArrayList<>(imagenes);
        imagenes.addAll(listaDuplicada);
        Collections.shuffle(imagenes);
    
        Iniciarjuego(listaBotones, imagenes, Encontradas, ventana);
    
        ventana.revalidate();
        ventana.repaint();
    }
    
}
