import java.awt.Graphics2D;

public class Bullet implements Drawable {
    static final int SPEED = 10;
    private Rectangle rect;
    private int x;
    private int y;
    private boolean dead;
    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        dead = false;
        rect = new Rectangle(x, y, 2, 5, "WHITE");
    }

    public void update() {
        y -= SPEED;
        rect.move(0, -SPEED);
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
