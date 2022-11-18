package Minijuego3_Viborita;

import menu.MenuInicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaJuego extends JFrame {
    PanelJuego viborita = new PanelJuego();
    private JButton botonMenu = new JButton("Menú Principal");

    public VentanaJuego() {
        setSize(600, 650);
        this.setTitle("Viborita");
        this.add(viborita);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        viborita.agregarBoton(botonMenu);
        botonMenu.setFont(new Font("Thaoma", Font.BOLD,15));
        botonMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
                JFrame frame = new MenuInicio();
            }
        });
    }
}