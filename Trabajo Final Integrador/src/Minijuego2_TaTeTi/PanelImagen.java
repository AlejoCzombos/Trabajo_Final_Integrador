package Minijuego2_TaTeTi;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PanelImagen extends JPanel {

    private Image imagen;

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        File archivo = new File("C:/Users/Win10/Desktop/x/x.png");

        try{
            imagen = ImageIO.read(archivo);
        } catch (IOException e){
            e.printStackTrace();
        }

        Graphics2D g2 = (Graphics2D)g;

        g2.drawImage(imagen, 20, 20, null);

    }

}
