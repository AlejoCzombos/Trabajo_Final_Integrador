package Minijuego1_SimonDice;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Panel_Grid extends JPanel {

    public Panel_Grid(){

    }

    public Panel_Grid(int columnas, int filas,int hgap,int vgap){
        setLayout(new GridLayout(filas,columnas,hgap,vgap));
        setAlignmentX(1);
        setBorder(new EmptyBorder(10,10,10,10));
    }

}
