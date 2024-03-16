import java.awt.Graphics2D;

public class Bullet implements Drawable {
    static final int SPEED = 10;
    private static final String COLOUR = "WHITE";
    private Rectangle rect;
    private int x;
    private int y;
    private boolean dead;
    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        dead = false;
        rect = new Rectangle(x, y, 1 * SpaceInvaders.SCALE, 5 * SpaceInvaders.SCALE, COLOUR);
    }

    public void update() {
        y -= SPEED * SpaceInvaders.SCALE;
        rect.move(0, -SPEED * SpaceInvaders.SCALE);
        if (y < -5) // Offscreen
            dead = true;
    }

    public boolean isDead() {
        return dead;
    }

    public void draw(Graphics2D window) {
        rect.draw(window);
    }

    public int getLayer() {
        return 1;
    }
}
