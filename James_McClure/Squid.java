public class Squid extends Enemy {
    private static final String COLOUR = "WHITE";
    private static final String EYE_COLOUR = "BLACK";
    private static final int ANIMATION_SPEED = 50;

    protected void populateSprite1() {
        // Body
        activeSprite.addComponent(3, 0, 2, 1);
        activeSprite.addComponent(2, 1, 4, 1);
        activeSprite.addComponent(1, 2, 6, 1);
        activeSprite.addComponent(0, 3, 8, 2);

        // Eyes
        activeSprite.addComponent(2, 3, 1, 1, EYE_COLOUR);
        activeSprite.addComponent(5, 3, 1, 1, EYE_COLOUR);

        // Left tentacle
        activeSprite.addComponent(1, 5, 1, 1);
        activeSprite.addComponent(0, 6, 1, 1);
        activeSprite.addComponent(1, 7, 1, 1);

        // Mouth
        activeSprite.addComponent(3, 5, 2, 1);

        // Right tentacle
        activeSprite.addComponent(6, 5, 1, 1);
        activeSprite.addComponent(7, 6, 1, 1);
        activeSprite.addComponent(6, 7, 1, 1);
    }

    protected void populateSprite2() {
        // Body
        inactiveSprite.addComponent(3, 0, 2, 1);
        inactiveSprite.addComponent(2, 1, 4, 1);
        inactiveSprite.addComponent(1, 2, 6, 1);
        inactiveSprite.addComponent(0, 3, 8, 2);

        // Eyes
        inactiveSprite.addComponent(2, 3, 1, 1, EYE_COLOUR);
        inactiveSprite.addComponent(5, 3, 1, 1, EYE_COLOUR);

        // Left tentacle
        inactiveSprite.addComponent(2, 5, 1, 1);
        inactiveSprite.addComponent(1, 6, 1, 1);
        inactiveSprite.addComponent(3, 6, 1, 1);
        inactiveSprite.addComponent(0, 7, 1, 1);
        inactiveSprite.addComponent(2, 7, 1, 1);

        // Right tentacle
        inactiveSprite.addComponent(5, 5, 1, 1);
        inactiveSprite.addComponent(4, 6, 1, 1);
        inactiveSprite.addComponent(6, 6, 1, 1);
        inactiveSprite.addComponent(5, 7, 1, 1);
        inactiveSprite.addComponent(7, 7, 1, 1);
    }


    public Squid(int x, int y) {
        super(x, y, 8, 8, 30, ANIMATION_SPEED, COLOUR);
    }
}

