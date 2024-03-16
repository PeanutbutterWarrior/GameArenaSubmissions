import java.awt.Graphics2D;

public class Player implements Drawable{
    public static final int SPEED = 5;

    static final int FIRE_COOLDOWN = 25;
    static final int PLAYER_HEIGHT = 50;
    private int x;
    private int fireCooldown;
    Rectangle components[];
    public Player() {
        x = SpaceInvaders.WIDTH / 2;
        fireCooldown = 0;
        components = new Rectangle[3];
        components[0] = new Rectangle(x - 15, SpaceInvaders.HEIGHT - PLAYER_HEIGHT - 10, 30, 10, "WHITE");
        components[1] = new Rectangle(x - 12, SpaceInvaders.HEIGHT - PLAYER_HEIGHT - 12, 24, 2, "WHITE");
        components[2] = new Rectangle(x-3, SpaceInvaders.HEIGHT - PLAYER_HEIGHT - 16, 6, 4, "WHITE"); 
    }
    
    public void draw(Graphics2D window) {
        for (Rectangle rect: components){ 
            rect.draw(window);
        }

    }

    public void move(int dx) {
        x += dx;
        for (Rectangle rect: components) {
            rect.move(dx, 0);
        }
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
        return new Bullet(x, SpaceInvaders.HEIGHT - PLAYER_HEIGHT - 16);
    }
}
