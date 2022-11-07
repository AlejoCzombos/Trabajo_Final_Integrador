package Minijuego1_SimonDice;

import javax.swing.*;
import java.awt.*;

public class FrameAyuda extends JFrame{

    JPanel panel = new JPanel();

    public FrameAyuda(){
        setSize(250,300);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Ayuda");
        panel.add(new Label("El juego de forma aleatoria va iluminando los cuadrantes de colores, y a la vez que se ilumina cada cuadrante emite un sonido propio. Después de esperar, el usuario debe ir introduciendo la secuencia mostrada en el orden correcto, ayudándose de su memoria visual y sonora. Si lo consigue, este responderá con una secuencia más larga, y así sucesivamente. Si falla, el usuario debe volver a empezar. Los distintos niveles de dificultad van aumentando la velocidad de la secuencia a repetir."), BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }

}
