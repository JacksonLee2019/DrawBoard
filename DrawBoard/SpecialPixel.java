/*
 * Programmer: Jackson Lee
 * Program: Special Pixel
 * Purpose: randomly generate a number of pixels that will turn either red, blue or green when clicked
 * Date: 2/12/16
*/
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
public class SpecialPixel extends Pixel {
    //constructor
    public SpecialPixel(int x, int y, int w, int h) {
        super(x, y, w, h);
    }
    //changes the pixel to a random color(red, green, or blue) when clicked, and back to black when clicked again
    public void mouseClicked(MouseEvent e) {
        int randomColor = (int)(Math.random() * 3);
        if(getBackground() == Color.black) {
            if(randomColor == 0) {
                setBackground(Color.red);
            } else if(randomColor == 1) {
                setBackground(Color.blue);
            } else {
                setBackground(Color.green);
            }
        } else {
            setBackground(Color.black);
        }
    }
}