package Minijuego2_TaTeTi;

import menu.MenuInicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Ventana extends JFrame {

    private JPanel panel1;
    private JPanel panelMenu;
    private JPanel panel2;
    private JLabel lModo;
    private JCheckBox vsPCCheckBox;
    private JCheckBox a2JugadoresCheckBox;
    private JButton jugarButton;
    private JPanel panelJuego;
    private JButton reiniciar;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    private JButton volverButton;
    private JButton volverMenu;
    private boolean IA = false;

    private String turno = "X";
    private final JLabel[] lbs = new JLabel[9];
    private boolean fin = false;
    private int movs = 0;

    private final int[][] ganadores = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9},
            {1, 5, 9},
            {3, 5, 7}
    };

    public Ventana(){

        panel2 = new PanelImagen();

        add(panel1);

        setSize(600,640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        lbs[0] = l1;
        lbs[1] = l2;
        lbs[2] = l3;
        lbs[3] = l4;
        lbs[4] = l5;
        lbs[5] = l6;
        lbs[6] = l7;
        lbs[7] = l8;
        lbs[8] = l9;

        ganador();

        l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                clickear(1);
                if(IA == true && !fin){
                    while (turno.equals("O")){
                        juegaIA();
                    }
                }
            }
        });

        l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                clickear(2);
                if(IA == true && !fin){
                    while (turno.equals("O")){
                        juegaIA();
                    }
                }
            }
        });

        l3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                clickear(3);
                if(IA == true && !fin){
                    while (turno.equals("O")){
                        juegaIA();
                    }
                }
            }
        });

        l4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                clickear(4);
                if(IA == true && !fin){
                    while (turno.equals("O")){
                        juegaIA();
                    }
                }
            }
        });

        l5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                clickear(5);
                if(IA == true && !fin){
                    while (turno.equals("O")){
                        juegaIA();
                    }
                }
            }
        });

        l6.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                clickear(6);
                if(IA == true && !fin){
                    while (turno.equals("O")){
                        juegaIA();
                    }
                }
            }
        });

        l7.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                clickear(7);
                if(IA == true && !fin){
                    while (turno.equals("O")){
                        juegaIA();
                    }
                }
            }
        });

        l8.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                clickear(8);
                if(IA == true && !fin){
                    while (turno.equals("O")){
                        juegaIA();
                    }
                }
            }
        });

        l9.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                clickear(9);
                if(IA == true && !fin){
                    while (turno.equals("O")){
                        juegaIA();
                    }
                }
            }
        });

        reiniciar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                reiniciarJuego();
            }
        });

        vsPCCheckBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                apretarCeckBox(vsPCCheckBox, a2JugadoresCheckBox);
            }
        });

        a2JugadoresCheckBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                apretarCeckBox(a2JugadoresCheckBox, vsPCCheckBox);

            }
        });

        jugarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                panelMenu.setVisible(false);
                panelJuego.setVisible(true);
                if(vsPCCheckBox.isSelected()){
                    IA = true;
                } else if(a2JugadoresCheckBox.isSelected()){
                    IA = false;
                }
            }
        });

        volverButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                reiniciarJuego();
                panelMenu.setVisible(true);
                panelJuego.setVisible(false);
            }
        });

        volverMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
                JFrame frame = new MenuInicio();
            }
        });
    }

    public void reiniciarJuego(){
        fin = false;
        movs = 0;
        int i = 0;
        while (i<lbs.length) {
            lbs[i].setText("");
            lbs[i].setBackground(Color.white);
            turno = "X";
            i++;
        }
    }

    public void clickear(int espacio){
        if(!fin){
            if(lbs[espacio-1].getText().equals("")){
                lbs[espacio-1].setText(turno);
                movs++;
                ganador();
                cambioTurno();
            }
        }
    }

    public void cambioTurno(){
        if(turno.equals("X")){
            turno = "O";
        } else {
            turno = "X";
        }
    }

    public void ganador(){
        for(int i = 0; i<ganadores.length; i++){
            if(lbs[ganadores[i][0] - 1].getText().equals("X") &&
                    lbs[ganadores[i][1] - 1].getText().equals("X") &&
                    lbs[ganadores[i][2] - 1].getText().equals("X")){
                lbs[ganadores[i][0]-1].setBackground(Color.green);
                lbs[ganadores[i][1]-1].setBackground(Color.green);
                lbs[ganadores[i][2]-1].setBackground(Color.green);
                fin = true;
            } else if(lbs[ganadores[i][0] - 1].getText().equals("O") &&
                    lbs[ganadores[i][1] - 1].getText().equals("O") &&
                    lbs[ganadores[i][2] - 1].getText().equals("O")){
                lbs[ganadores[i][0]-1].setBackground(Color.green);
                lbs[ganadores[i][1]-1].setBackground(Color.green);
                lbs[ganadores[i][2]-1].setBackground(Color.green);
                fin = true;
            }
        }
        if(movs == 9 && !fin){
            for(int i = 0; i<ganadores.length; i++){
                lbs[ganadores[i][0]-1].setBackground(Color.red);
                lbs[ganadores[i][1]-1].setBackground(Color.red);
                lbs[ganadores[i][2]-1].setBackground(Color.red);
            }
            fin = true;
        }
    }

    private void apretarCeckBox(JCheckBox a1, JCheckBox a2){
        if(!a1.isSelected()){
            a2.setSelected(false);
        } else {
            a2.setSelected(true);
        }
    }

    private void juegaIA(){
        Random rnd = new Random();
        int jugadas = 9;
        int random = rnd.nextInt(jugadas);
        if(turno.equals("O")){
            if(lbs[random].getText().equals("X") || lbs[random].getText().equals("O")){
                random = rnd.nextInt(jugadas);
                clickear(random+1);
            }
        }
    }

}
