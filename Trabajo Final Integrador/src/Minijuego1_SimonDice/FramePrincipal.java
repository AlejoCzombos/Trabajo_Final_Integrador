package Minijuego1_SimonDice;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FramePrincipal extends JFrame implements ChangeListener, MouseListener {

    //Paneles utilizados
    private Panel_Grid layoutBotones = new Panel_Grid(1,2,30,30);
    private JPanel panelFlow = new JPanel();
    private PanelSimonDice panelSimonDice = new PanelSimonDice();
    private JPanel panelMenu = new JPanel();
    private JPanel panelPrincipal = new JPanel();

    //Botones y labels
    private JButton botonJugar = new JButton("Jugar");
    public JButton botonAtras = new JButton("Atras");
    private JRadioButton radioButtonLento = new JRadioButton("Lento");
    private JRadioButton radioButtonMedio = new JRadioButton("Medio");
    private JRadioButton radioButtonRapido = new JRadioButton("Rapido");
    private ButtonGroup grupoBotones = new ButtonGroup();
    private JLabel labelSimonDice = new JLabel("Simon Dice!", JLabel.CENTER);

    public FramePrincipal(){
        //Se definen los parametros iniciales de la ventana
        setSize(600,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Menú");
        setVisible(true);

        //Se agregan los paneles de juego y menu al panel principal
        panelPrincipal.add(panelMenu);
        panelPrincipal.add(panelSimonDice);
        add(panelPrincipal);

        //Se hace visible el menu y el juego no
        panelSimonDice.setVisible(false);
        panelMenu.setVisible(true);

        //Se llama al metodo que configura el panel del Menu
        inicializarPanelMenu();
    }
    public void inicializarPanelMenu(){
        //setea las dimensiones y layout
        panelMenu.setPreferredSize( new Dimension(600,600));
        panelMenu.setLayout(new BorderLayout(20,20));

        //setea los botones de opcion de velocidad
        setearCheckbox(radioButtonLento);
        setearCheckbox(radioButtonMedio);
        setearCheckbox(radioButtonRapido);

        //se le agregan los botones de opcion de velocidad al subpanel inferior y se le agrega un layout
        panelFlow.add(radioButtonLento);
        panelFlow.add(radioButtonMedio);
        panelFlow.add(radioButtonRapido);
        layoutBotones.add(panelFlow);
        panelMenu.add(layoutBotones, BorderLayout.SOUTH);

        //setea el boton jugar, se le agrega el listener que hace visible el juego e invisible el menu y se lo agrega al subpanel inferior
        layoutBotones.add(botonJugar);
        botonJugar.setFont(new Font("Thaoma", Font.BOLD,15));
        layoutBotones.setBorder(new EmptyBorder(20,80,20,80));
        botonJugar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                panelMenu.setVisible(false);
                panelSimonDice.setVisible(true);
                panelSimonDice.iniciarJuego();
            }
        });


        //agrega el nombre del juego al menu (Jlabel) y se lo configura
        panelMenu.add(labelSimonDice, BorderLayout.NORTH);
        labelSimonDice.setFont(new Font("Cooper Black", Font.BOLD,80));
        labelSimonDice.setAlignmentX(0);
        labelSimonDice.setForeground(new Color(0, 10, 218, 255));

        //se agrega un listener al boton atras del panel juego y se lo setea
        botonAtras.addMouseListener(this);
        panelSimonDice.setearBotones(botonAtras);
        panelSimonDice.agregarBoton(botonAtras);
    }

    //se agrega el listener, se agrega a un grupo de JRadioButton y se le cambia la fuente
    public void setearCheckbox(JRadioButton boton) {
        boton.addChangeListener(this);
        grupoBotones.add(boton);
        boton.setFont(new Font("Thaoma", Font.BOLD,15));
    }
    //Listener de boton atras que vuelve invisible el juego y visible el menu
    @Override
    public void mouseClicked(MouseEvent e) {
        panelSimonDice.setVisible(false);
        panelMenu.setVisible(true);
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    //Cada una de las opciones de dificultad setea el Delay del timer
    @Override
    public void stateChanged(ChangeEvent e) {
        if (radioButtonLento.isSelected()){
            panelSimonDice.setDelay(20);
        }
        if(radioButtonMedio.isSelected()){
            panelSimonDice.setDelay(15);
        }
        if(radioButtonRapido.isSelected()){
            panelSimonDice.setDelay(10);
        }
    }
}

