package Minijuego4_Dados;
import menu.MenuInicio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Dados extends JFrame {

    private JPanel dadosPanel1;
    private JButton button1;
    private JLabel dadoPrimero;
    private JLabel dadoSegundo;
    private JLabel total;
    private JButton menuPrincipal;

    public Dados(){
        add(dadosPanel1);

        setSize(600, 640); //tamaño de la ventana
        setLocationRelativeTo(null);

        setTitle("DADOS T.U.P.");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //que hacer cuando se pulsa "x" en la ventana (al salir)
        setResizable(false);

        Toolkit mipantalla = Toolkit.getDefaultToolkit();  //abrir nuestra ventana nativa
        Image miIcono = mipantalla.getImage("Trabajo Final Integrador\\src\\logoIcono.png"); //cambiar icono de ventana
        setIconImage(miIcono);

        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                Random r = new Random();
                int dado1 = 0;
                dado1 = ((int)(r.nextDouble()*6));
                int dado2 = 0;
                dado2 = ((int)(r.nextDouble()*6));

               if(dado1==0){dadoPrimero.setIcon(new ImageIcon((getClass().getResource("dado1.jpg"))));
                }else if(dado1==1){dadoPrimero.setIcon(new ImageIcon((getClass().getResource("dado2.jpg"))));
                }else if(dado1==2){dadoPrimero.setIcon(new ImageIcon((getClass().getResource("dado3.jpg"))));
                }else if(dado1==3){dadoPrimero.setIcon(new ImageIcon((getClass().getResource("dado4.jpg"))));
                }else if(dado1==4){dadoPrimero.setIcon(new ImageIcon((getClass().getResource("dado5.jpg"))));
                }else if(dado1==5){dadoPrimero.setIcon(new ImageIcon((getClass().getResource("dado6.jpg"))));}

               if(dado2==0){dadoSegundo.setIcon(new ImageIcon((getClass().getResource("dado1.jpg"))));
                }else if(dado2==1){dadoSegundo.setIcon(new ImageIcon((getClass().getResource("dado2.jpg"))));
                }else if(dado2==2){dadoSegundo.setIcon(new ImageIcon((getClass().getResource("dado3.jpg"))));
                }else if(dado2==3){dadoSegundo.setIcon(new ImageIcon((getClass().getResource("dado4.jpg"))));
                }else if(dado2==4){dadoSegundo.setIcon(new ImageIcon((getClass().getResource("dado5.jpg"))));
                }else if(dado2==5){dadoSegundo.setIcon(new ImageIcon((getClass().getResource("dado6.jpg"))));}

                int resultado1 = dado1 +1;
                int resultado2 = dado2 +1;
                int totalx = resultado1 + resultado2;
                total.setText("TOTAL: "+totalx);
            }
        });
        menuPrincipal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
                JFrame frame = new MenuInicio();
            }
        });
    }
}
