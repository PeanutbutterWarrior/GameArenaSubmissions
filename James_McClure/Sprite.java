import java.awt.Graphics2D;
import java.util.ArrayList;

public class Sprite implements Drawable {
    private Rectangle boundingBox;
    private String colour;
    private int layer;
    private ArrayList<RelativeRect> components;

    public Sprite(Rectangle boundingBox, String defaultColour, int layer) {
        this.boundingBox = boundingBox;
        this.colour = defaultColour;
        this.layer = layer;
        components = new ArrayList<>();
    }

    public void addComponent(int x, int y, int w, int h ) {
        addComponent(x, y, w, h, colour);
    }

    public void addComponent(int x, int y, int w, int h, String colour) {
        RelativeRect r = new RelativeRect(
            x * SpaceInvaders.SCALE,
            y * SpaceInvaders.SCALE,
            w * SpaceInvaders.SCALE,
            h * SpaceInvaders.SCALE,
            colour,
            boundingBox
        );
        components.add(r);
    }

    public void draw(Graphics2D window) {
        for (RelativeRect r: components)
            r.draw(window);
    }

    public int getLayer() {
        return layer;
    }
}
