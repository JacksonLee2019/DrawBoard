/**
 * This class initiates the drawing program, creating the window in which
 * graphics are displayed. It also contains methods for manipulating a grid
 * of objects graphical Pixel objects.
 *
 * @author M. Allen
 * @author Jackson Lee
 * Date: 2/12/16
 * Purpose: Make a drawing board that the user can create images on by clicking "pixels" inside the board
 */
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class DrawBoard implements KeyListener
{
    private JFrame window;
    private final int windowSize = 600;
    private Pixel[][] pixels = new Pixel[50][50];
    /**
     * Simple initiating main() method to start program.
     *
     * @param args Not used.
     */
    public static void main( String[] args )
    {
        DrawBoard db = new DrawBoard();
        db.makeBoard();
    }
    
    /**
     * Creates the graphical window.
     */
    private void makeBoard()
    {
        window = new JFrame( "Pictograph" );
        window.setVisible( true );
        window.setResizable( false );
        window.setLayout( null );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.getContentPane().setBackground( Color.white );
        window.setLocation( 20, 20 );
        window.setSize( windowSize + window.getInsets().left + window.getInsets().right,
                       windowSize + window.getInsets().top + window.getInsets().bottom );
        window.addKeyListener( this );
        
        int x = 0;
        int y  = 0;
        int randomPixel = 0;
        for(int i = 0; i < pixels.length; i++) {
            for(int j = 0; j < pixels[i].length; j++) {
                randomPixel = (int)((Math.random() * 10) + 1);
                if(randomPixel == 1) {
                    SpecialPixel p = new SpecialPixel(x, y, 12, 12);
                    pixels[i][j] = p;
                    window.add(p);
                    y = y + 12;
                } else {
                    Pixel p = new Pixel(x, y, 12, 12);
                    pixels[i][j] = p;
                    window.add(p);
                    y = y + 12;
                }
            }
            y = 0;
            x = x + 12;
            window.repaint();
        }
    }
    
    /**
     * Method called when a keyboard key is pressed.
     *
     * @param e The event that is caused by pressing a key.
     *            We can find out which key was pressed based upon this code.
     */
    @Override
    public void keyPressed( KeyEvent e )
    {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_SPACE) {
           resetBoard();
        } else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_DOWN) {
            flipVertical();
        } else if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT) {
            flipHorizontal();
        } else if(code == KeyEvent.VK_R) {
            rotate();
        } else if(code == KeyEvent.VK_S) {
            findSpecialPixels();
        } else {
            
        }
        
        window.repaint();
    }
    //Resets all pixels on the board back to black
    private void resetBoard() {
        for(int i = 0; i < pixels.length; i++) {
            for(int j = 0; j < pixels[i].length; j++) {
                pixels[i][j].setBackground(Color.black);
            }
        }
    }
    //Flip pixels vertically
    private void flipVertical() {
        for(int i = 0; i < pixels.length; i++) {
            for(int j = 0; j < .5 * pixels[i].length; j++) {
                Color color1 = pixels[i][j].getBackground();
                Color color2 = pixels[i][49 - j].getBackground();
                pixels[i][j].setBackground(color2);
                pixels[i][49 - j].setBackground(color1);
            }
        }
    }
    //Flip pixels horiztonally
    private void flipHorizontal() {
        for(int i = 0; i < .5 * pixels.length; i++) {
            for(int j = 0; j < pixels[i].length; j++) {
                Color color1 = pixels[i][j].getBackground();
                Color color2 = pixels[49 - i][j].getBackground();
                pixels[i][j].setBackground(color2);
                pixels[49 - i][j].setBackground(color1);
            }
        }
    }
    //Rotate pixels 90 degrees
    private void rotate() {
        Color[][] colorArray = new Color[50][50];
        for(int i = 0; i < pixels.length; i++) {
            for(int j = 0; j < pixels[i].length; j++) {
                colorArray[49-j][i] = pixels[i][j].getBackground();
            }
        }
        for(int i = 0; i < pixels.length; i++) {
            for(int j = 0; j < pixels[i].length; j++) {
                pixels[i][j].setBackground(colorArray[i][j]);
            }
        }
    }
    //shows all special pixels
    private void findSpecialPixels() {
        for(int i = 0; i < pixels.length; i++) {
            for(int j = 0; j < pixels[i].length; j++) {
                if(pixels[i][j] instanceof SpecialPixel) {
                    if(pixels[i][j].getBackground() == Color.black) {
                        int randomColor = (int)((Math.random() * 3) + 1);
                        if(randomColor == 1) {
                            pixels[i][j].setBackground(Color.red);
                        } else if(randomColor == 2) {
                            pixels[i][j].setBackground(Color.blue);
                        } else {
                            pixels[i][j].setBackground(Color.green);
                        }
                    } else {
                        pixels[i][j].setBackground(Color.black);
                    }
                }
            }
        }
    }
    /*
     * THE FOLLOWING METHODS ARE NOT ACTUALLY USED; THEY ARE MERELY PRESENT TO
     * SATISFY THE KEYLISTENER INTERFACE SPECIFICATION.
     *
     * DO NOT ADD CODE TO THEM FOR THIS ASSIGNMENT.
     */
    
    /*
     * (non-Javadoc)
     *
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped( KeyEvent e )
    {
    }
    
    /*
     * (non-Javadoc)
     *
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased( KeyEvent e )
    {
    }
}
