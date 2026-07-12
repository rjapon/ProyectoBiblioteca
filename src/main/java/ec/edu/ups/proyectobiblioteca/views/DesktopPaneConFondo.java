package ec.edu.ups.proyectobiblioteca.views;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class DesktopPaneConFondo extends JDesktopPane {

    private Image imagen;

    public DesktopPaneConFondo() {
        imagen = new ImageIcon(getClass().getResource("/ec/edu/ups/proyectobiblioteca/images/FondoBiblioteca.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}