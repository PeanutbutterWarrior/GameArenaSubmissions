import java.awt.Graphics2D;
/**
 * Allows a class to be rendered in the GameArena
 */
public interface Drawable {
    /**
     * Draw the object to the window
     * 
     * @param window The window to be drawn to
     */
    void draw(Graphics2D window);

    /**
     * Get the layer of the object
     * 
     * @return Layer
     */
    int getLayer();
}