/*
 * Programmer: Jackson Lee
 * Program: Pixel
 * Purpose: create a pixel that changes from black to yellow when clicked
 * Date: 2/12/16
 */
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
public class Pixel extends ClickSquare {
    //Constructor
    public Pixel(int x, int y, int w, int h) {
        super(x, y, w, h);
    }
    //when a pixel is clicked, depending on its color, it will change to black or yellow
    public void mouseClicked(MouseEvent e) {
        if(getBackground() == Color.black) {
            setBackground(Color.yellow);
        } else {
            setBackground(Color.black);
        }
    }
}