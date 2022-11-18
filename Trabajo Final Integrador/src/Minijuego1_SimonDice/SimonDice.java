package Minijuego1_SimonDice;

import menu.MenuInicio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class SimonDice extends JPanel implements ActionListener, MouseListener {
    private ArrayList<Integer> secuencia;
    private Panel_Grid panelPuntuacion = new Panel_Grid(2,1,0,20);
    private Panel_Grid panelBotonesInferiores = new Panel_Grid(2,1,70,50);
    public JButton botonSalir = new JButton("Salir");
    public JButton botonAyuda = new JButton("Ayuda");
    public Label puntuacion = new Label("Puntos: 0");
    public Label mejorPuntuacion = new Label("Mejor puntuacion: 0");
    private Timer timer;
    private int eleccionColor, indiceSecuenciaActual;
    private int contadorTicks, tiempoIluminacion;
    private int puntajeActual, mejorPuntaje = 0;
    private boolean creandoPatron = true, gameOver = false;

    public SimonDice(){
        this.setPreferredSize( new Dimension(600,600));
        timer = new Timer(20,this);

        //Seteo el layout
        setLayout(new BorderLayout(10,10));

        //Agrego a los subpaneles los labels y botones correspondientes
        panelPuntuacion.add(puntuacion);
        panelPuntuacion.add(mejorPuntuacion);
        panelBotonesInferiores.add(botonSalir);
        panelBotonesInferiores.add(botonAyuda);
        panelBotonesInferiores.setBorder(new EmptyBorder(20,50,10,50));

        //Agrego el mouse listener al panel y a los botones
        addMouseListener(this);

        //Agrego los subpaneles al panel principal y le doy una ubicacion
        add(panelPuntuacion, BorderLayout.NORTH);
        add(panelBotonesInferiores, BorderLayout.SOUTH);

        //Uso los metodos de clase para setear botones y textos
        setearLabels(puntuacion);
        setearLabels(mejorPuntuacion);
        setearBotones(botonAyuda);
        setearBotones(botonSalir);

        iniciarJuego();
    }

    public void iniciarJuego(){
        //inicializo la lista de secuencia y las variables
        secuencia = new ArrayList<>();
        indiceSecuenciaActual = 0;
        tiempoIluminacion = 3;
        eleccionColor = 0;
        contadorTicks = 0;
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        dibujar(g);
    }

    public void dibujar(Graphics g) {
        //Si la eleccion de color es de un numero determinado se pinta (ilumina) sino, queda "apagado"
        if (eleccionColor == 1) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.GREEN.darker());
        }
        g.fillRect(40, 50, 240, 240);
        if (eleccionColor == 2) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.RED.darker());
        }
        g.fillRect(310, 50, 240, 240);
        if (eleccionColor == 3) {
            g.setColor(Color.ORANGE);
        }else {
            g.setColor(Color.ORANGE.darker());
        }
        g.fillRect(40, 320, 240, 240);
        if (eleccionColor == 4) {
            g.setColor(Color.BLUE);
        } else {
            g.setColor(Color.BLUE.darker());
        }
        g.fillRect(310, 320, 240, 240);
        if (gameOver){
            g.setColor(new Color(255, 0, 0, 147));
        }else {
            g.setColor(new Color(0x0000000, true));
        }
        g.fillRect(0,0,600,600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        contadorTicks++;

        //Cuando el contador de ticks modulo 20 es igual a 0 se pone a 0 eleccionColor y se reduce a tiempoIluminacion
        if (contadorTicks % 20 == 0){
            eleccionColor = 0;
            if(tiempoIluminacion >= 0){
                tiempoIluminacion--;
            }
        }

        //Si se esta crenado el patron y el tiempo de iluminacion es menor a 0 y el indice de secuencia es mayor a
        //al tamaño de la lista de secuencia se le agrega un nuevo color. Sino, se establece que el numero de color es igual al
        //color del indice de secuencia actual y se incrementa este.
        if(creandoPatron){
            if(tiempoIluminacion <= 0) {
                if (indiceSecuenciaActual >= secuencia.size()) {
                    eleccionColor = colorAleatorio();
                    secuencia.add(eleccionColor);
                    indiceSecuenciaActual = 0;
                    creandoPatron = false;
                } else {
                    eleccionColor = secuencia.get(indiceSecuenciaActual);
                    indiceSecuenciaActual++;
                }
                tiempoIluminacion = 2;
            }
            //Sino se esta creando una secuencia y el indice de secuencia actual es igual al tamaño de la secuencia
            //se tiene que crear una nueva secuencia y se pone a 0 el indice.
        }else if (indiceSecuenciaActual == secuencia.size()){
            creandoPatron = true;
            indiceSecuenciaActual = 0;
            tiempoIluminacion = 2;
        }

        //Creo las variables de puntaje, mejorpuntaje y actualizo los labels
        puntajeActual = secuencia.size();
        puntuacion.setText("Puntuacion: " + puntajeActual);
        repaint();
    }

    //Eventos de Mouse
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        //Si no se esta creando el patron y se hace click en cada zona de color, hace que la variable de eleccion color se establezca en el numero de cada color
        if(!creandoPatron && !gameOver){
            if(x > 40 && x < 280 && y > 50 && y < 290){
                eleccionColor = 1;
            }
            else if(x > 310 && x < 550 && y > 50 && y < 290){
                eleccionColor = 2;
            }
            else if(x > 40 && x < 280 && y > 320 && y < 560){
                eleccionColor = 3;
            }
            else if(x > 310 && x < 550 && y > 320 && y < 560){
                eleccionColor = 4;
            }

            //Si eligio algun color y no es igual al color del indice de la secuencia actual entonces el jugador perdio
            if(eleccionColor != 0){
                if(secuencia.get(indiceSecuenciaActual) == eleccionColor){
                    indiceSecuenciaActual++;
                }else{
                    gameOver = true;
                }
            }
            //Si el jugador perdio se establece el puntaje maximo si es true y se actualiza el label, y se reinicia el juego
        }else if (gameOver){
            if (puntajeActual > mejorPuntaje){
                mejorPuntaje = puntajeActual;
                mejorPuntuacion.setText("Mejor puntuacion: " + mejorPuntaje);
            }
            iniciarJuego();
            gameOver = false;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void setearBotones(JButton boton){
        boton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(boton == botonAyuda){

                }else if(boton == botonSalir){                    //NO SE CIERRAN LAS VENTANAS
                    FramePrincipal f = new FramePrincipal();     //CUANDO SE VUELVE AL MENU PRINCIPAL.
                    f.setVisible(false);

                    Panel_Grid p = new Panel_Grid();
                    p.setVisible(false);

                    setVisible(false);

                    JFrame frame = new MenuInicio();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    private static void setearLabels(Label label){
        label.setAlignment(1);
        label.setFont(new Font("Thaoma", Font.BOLD,15));
    }
    public static int colorAleatorio(){
        Random random = new Random();
        return random.nextInt(4)+1;
    }
}
