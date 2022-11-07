package Minijuego1_SimonDice;

import javax.swing.*;

public class FramePrincipal extends JFrame {

    SimonDice simonDice = new SimonDice();

    public FramePrincipal(){
        setSize(600,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Simon Dice");
        setVisible(true);
        add(simonDice);
    }

    public static void main(String[] args){
        FramePrincipal framePrincipal = new FramePrincipal();
    }

}
