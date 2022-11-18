package menu;

import Minijuego1_SimonDice.FramePrincipal;
import Minijuego2_TaTeTi.Ventana;
import Minijuego3_Viborita.VentanaJuego;
import Minijuego4_Dados.Dados;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.File;

public class MenuInicio extends JFrame {


    private JPanel general;
    private JButton alejo;
    private JButton gasu;
    private JButton campa;
    private JPanel panelTitulo;
    private JButton rodri;


    public MenuInicio() {


        add(general);

        setSize(600, 640); //tamaño de la ventana
        setLocationRelativeTo(null);

        setTitle("Minijuegos T.U.P.");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //que hacer cuando se pulsa "x" en la ventana (al salir)
        setResizable(false);


        Toolkit mipantalla = Toolkit.getDefaultToolkit();  //abrir nuestra ventana nativa
        Image miIcono = mipantalla.getImage("Trabajo Final Integrador\\src\\logoIcono.png"); //cambiar icono de ventana
        setIconImage(miIcono);


        alejo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                setVisible(false);
                FramePrincipal f = new FramePrincipal();

            }
        });
        campa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                setVisible(false);
                Ventana v = new Ventana();
            }
        });
        gasu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
                VentanaJuego v = new VentanaJuego();
            }
        });


        rodri.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
                Dados d = new Dados();
            }
        });
    }




    private class Titulo extends JPanel {

        Image imagen;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            try {
                imagen = ImageIO.read(new File("D:\\Archivos\\Desktop\\Trabajo_Final_Integrador-main\\Trabajo Final Integrador\\src\\menu\\Imagenes\\bienvenido.gif"));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("no se encontro la imagen ");
            }

            int alturaImagenTitulo = imagen.getHeight(this);
            int anchoImagenTitulo = imagen.getWidth(this);
            g.drawImage(imagen, 20, 20, null);

        }

    }
}
