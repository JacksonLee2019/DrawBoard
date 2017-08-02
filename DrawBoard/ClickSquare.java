/**
 * This class creates a graphical square object that responds
 * to mouse clicks, passing information about them onwards.
 *
 * It is meant to be extended so that the methods for responding to the mouse
 * actions will actually do something.
 *
 * @author M. Allen
 */
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

@SuppressWarnings( "serial" )
public class ClickSquare extends JComponent implements MouseListener
{
    /*
     * pre: JFrame and LifeBoard objects must be initialized and passed
     * post: object created with ability to respond to mouse
     */
    public ClickSquare( int x, int y, int w, int h )
    {
        setBounds( x, y, w, h );
        setBackground( Color.black );
        addMouseListener( this );
    }
    
    /*
     * Following four methods exist only because required by MouseListener
     * interface; none of them do anything when events are received.
     *
     * They should be over-ridden in a descendant class, so that the object
     * actually responds to mouse activity.
     */
    public void mouseClicked( MouseEvent e )
    {
    }
    
    public void mouseEntered( MouseEvent arg0 )
    {
    }
    
    public void mouseExited( MouseEvent arg0 )
    {
    }
    
    public void mousePressed( MouseEvent arg0 )
    {
    }
    
    public void mouseReleased( MouseEvent arg0 )
    {
    }
    
    /**
     * post: this method draws a filled Rectangle
     * and the upper left corner is (getX(), getY())
     * and the rectangle's dimensions are getWidth() and getHeight()
     * and the rectangle's color is getBackground()
     */
    public void paint( Graphics g )
    {
        g.setColor( getBackground() );
        g.fillRect( 0, 0, getWidth() - 1, getHeight() - 1 );
        paintChildren( g );
    }
}
