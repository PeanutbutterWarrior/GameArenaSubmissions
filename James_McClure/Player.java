import java.awt.Graphics2D;

public class Player implements Drawable{
    private static final int FIRE_COOLDOWN = 20;
    private static final String COLOUR = "WHITE";
    private static final int SPEED = 5;

    private int x;
    private int y;
    private int fireCooldown;

    private Rectangle boundingBox;
    private Sprite sprite;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.fireCooldown = 0;

        boundingBox = new Rectangle(
            x,
            y,
            13 * SpaceInvaders.SCALE, 
            7 * SpaceInvaders.SCALE,
            COLOUR
        );

        sprite = new Sprite(boundingBox, COLOUR, 0);

        sprite.addComponent(0, 4, 13, 4);
        sprite.addComponent(1, 3, 11, 1);
        sprite.addComponent(5, 1, 3, 2);
        sprite.addComponent(6, 0, 1, 1);

    }
    
    public void draw(Graphics2D window) {
        sprite.draw(window);
    }

    public void move(int dx) {
        x += dx * SPEED;
        boundingBox.move(dx * SPEED, 0);
    }

    public int getLayer() {
        return sprite.getLayer();
    }

    public void update() {
        fireCooldown--;
    }

    boolean canFire() {
        return fireCooldown <= 0;
    }

    Bullet fire() {
        fireCooldown = FIRE_COOLDOWN;
        return new Bullet(x + 6 * SpaceInvaders.SCALE, y);
    }
}
