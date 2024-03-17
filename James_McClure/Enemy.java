import java.awt.Graphics2D;

public abstract class Enemy implements Drawable {
    private int animationSpeed;
    private int x;
    private int y;
    private int speed;
    private int animationTimer;
    private boolean isDead;

    public Rectangle boundingBox;
    protected Sprite activeSprite;
    protected Sprite inactiveSprite;

    protected abstract void populateSprite1();

    protected abstract void populateSprite2();

    private void swapSprites() {
        Sprite temp = activeSprite;
        activeSprite = inactiveSprite;
        inactiveSprite = temp;
    }

    public Enemy(int x, int y, int w, int h, int speed, int animationSpeed, String defaultColor) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.animationSpeed = animationSpeed;
        animationTimer = animationSpeed;
        isDead = false;

        boundingBox = new Rectangle(x, y, w * SpaceInvaders.SCALE, h * SpaceInvaders.SCALE, "WHITE");

        activeSprite = new Sprite(boundingBox, defaultColor, 0);
        inactiveSprite = new Sprite(boundingBox, defaultColor, 0);

        populateSprite1();
        populateSprite2();
    }

    public void update() {
        animationTimer--;
        if (animationTimer == 0) {
            animationTimer = animationSpeed;
            swapSprites();
        }
    }

    public void draw(Graphics2D window) {
        activeSprite.draw(window);
    }

    public int getLayer() {
        return activeSprite.getLayer();
    }

    public boolean isHit(Bullet b) {
        return b.getBoundingBox().collides(boundingBox);
    }

    public void markDead() {
        isDead = true;
    }

    public boolean isDead() {
        return isDead;
    }
}
