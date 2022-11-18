package Minijuego3_Viborita;

import javax.swing.*;
public class VentanaJuego extends JFrame {
    PanelJuego viborita = new PanelJuego();

    //------------------------Prueba-----------------------
    public static void main(String[] args) {
        new VentanaJuego();
    }

    //------------------------Prueba-----------------------
    VentanaJuego() {
        setSize(600, 650);
        this.setTitle("Viborita");
        this.add(viborita);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}