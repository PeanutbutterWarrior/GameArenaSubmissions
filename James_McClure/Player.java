import java.awt.Graphics2D;

public class Player implements Drawable{
    private static final int FIRE_COOLDOWN = 1;
    private static final String COLOUR = "WHITE";
    private static final int SPEED = 5;

    private int x;
    private int y;
    private int fireCooldown;

    private Rectangle boundingBox;
    private RelativeRect components[];

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

        components = new RelativeRect[4];
        components[0] = new RelativeRect(
            0,
            4 * SpaceInvaders.SCALE,
            13 * SpaceInvaders.SCALE,
            4 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );
        components[1] = new RelativeRect(
            1 * SpaceInvaders.SCALE,
            3 * SpaceInvaders.SCALE,
            11 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );
        components[2] = new RelativeRect(
            5 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            3 * SpaceInvaders.SCALE,
            2 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );
        components[3] = new RelativeRect(
            6 * SpaceInvaders.SCALE,
            0,
            1 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );

    }
    
    public void draw(Graphics2D window) {
        for (Rectangle rect: components){ 
            rect.draw(window);
        }

    }

    public void move(int dx) {
        x += dx * SPEED;
        boundingBox.move(dx * SPEED, 0);
    }

    public int getLayer() {
        return 0;
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
