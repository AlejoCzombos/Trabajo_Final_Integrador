package Minijuego3_Viborita;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JPanel;

public class PanelJuego extends JPanel implements ActionListener {

    static final int ancho = 600;
    static final int largo = 625;
    static final int tamaño = 25;
    static final int juegoGen = (ancho*largo)/(tamaño*tamaño);
    static final int DELAY = 100;
    final int x[] = new int[juegoGen];
    final int y[] = new int[juegoGen];
    private int cuerpo = 6;
    private int comerManz;
    private int manzanaX;
    private int manzanaY;
    private char direccion = 'D';
    private boolean andar = false;
    private Timer timer;
    private Random random;
    private JButton botonRecargar = new JButton("Volver a Jugar");

    PanelJuego(){

        random = new Random();
        this.setPreferredSize(new Dimension(ancho, largo));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.DARK_GRAY);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        setearBoton();
        add(botonRecargar, BorderLayout.SOUTH);
        empezarJuego();

    }

    public void empezarJuego(){
        nuevaManzana();
        setearVariables();
        timer = new Timer(DELAY,this);
        timer.start();
        repaint();
    }

    public void setearVariables(){
        andar = true;
        direccion = 'D';
        cuerpo = 6;
        for (int i = 0; i < cuerpo; i++){
            x[i] = 0;
            y[i] = 0;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g){

        if(andar) {

            g.setColor(Color.red);
            g.fillOval(manzanaX, manzanaY, tamaño, tamaño);

            for (int i = 0; i < cuerpo; i++) {
                if (i == 0) {
                    g.setColor(new Color(238, 0, 255,250));
                    g.fillRect(x[i], y[i], tamaño, tamaño);
                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.setColor(new Color(200, 0, 213,250));
                    g.fillRect(x[i], y[i], tamaño, tamaño);
                }
            }
            g.setColor(Color.red);
            g.setFont(new Font("Thaoma", Font.BOLD,40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Puntaje: "+comerManz,(ancho - metrics.stringWidth("Puntaje: "+comerManz))/2,g.getFont().getSize());
        }else{
            juegoEnd(g);
            botonRecargar.setVisible(true);
        }
    }

    private void nuevaManzana(){
        manzanaX = random.nextInt((int)(ancho/tamaño))*tamaño;
        manzanaY = random.nextInt((int)(largo/tamaño))*tamaño;
    }

    private void mover(){

        for(int i = cuerpo; i > 0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch (direccion){
            case 'U':
                y[0] = y[0] - tamaño;
                break;
            case 'D':
                y[0] = y[0] + tamaño;
                break;
            case 'L':
                x[0] = x[0] - tamaño;
                break;
            case 'R':
                x[0] = x[0] + tamaño;
                break;
        }

    }

    private void verManzana(){

        if((x[0] == manzanaX) && (y[0] == manzanaY)){
            cuerpo++;
            comerManz++;
            nuevaManzana();
        }

    }

    private void verColision(){
        //controla si la cabeza choca con el cuerpo
        for(int i = cuerpo; i > 0; i--){
            if((x[0] == x[i])&& (y[0] == y[i])){
                andar = false;
            }
        }
        //controla si la cabeza toca un borde izquierdo
        if(x[0] < 0){
            andar = false;
        }
        //controla si la cabeza toca un borde derecho
        if(x[0] > ancho){
            andar = false;
        }
        //controla si la cabeza toca un borde de arriba
        if(y[0] < 0){
            andar = false;
        }
        //controla si la cabeza toca un borde de abajo
        if(y[0] > largo){
            andar = false;
        }
        if(!andar){
            timer.stop();
        }
    }

    private void juegoEnd(Graphics g){
        //texto cuando perdes
        g.setColor(Color.red);
        g.setFont(new Font("Thaoma", Font.BOLD,35));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Perdiste! Tu puntaje es: "+comerManz,(ancho - metrics.stringWidth("Perdiste!\nTu puntaje es: "+comerManz))/2,largo/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(andar){
            mover();
            verManzana();
            verColision();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direccion != 'R'){
                        direccion = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direccion != 'L'){
                        direccion = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direccion != 'D'){
                        direccion = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direccion != 'U'){
                        direccion = 'D';
                    }
                    break;
            }
        }
    }
    private void setearBoton(){
        botonRecargar.setBounds(ancho/2, largo/2, 100,40);
        botonRecargar.setVisible(false);
        botonRecargar.setFont(new Font("Thaoma", Font.BOLD,15));
        botonRecargar.setMargin(new Insets(10,10,10,20));
        botonRecargar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                botonRecargar.setVisible(false);
                andar = true;
                empezarJuego();
            }
        });

    }

}