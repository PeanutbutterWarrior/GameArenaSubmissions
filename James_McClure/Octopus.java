public class Octopus extends Enemy {
    private static final String COLOUR = "WHITE";
    private static final String EYE_COLOUR = "BLACK";
    private static final int ANIMATION_SPEED = 50;

    protected void populateSprite1() {
        // Body
        activeSprite.addComponent(4, 0, 4, 1);
        activeSprite.addComponent(1, 1, 10, 1);
        activeSprite.addComponent(0, 2, 12, 3);

        // Eyes
        activeSprite.addComponent(3, 3, 2, 1, EYE_COLOUR);
        activeSprite.addComponent(7, 3, 2, 1, EYE_COLOUR);

        // Mouth
        activeSprite.addComponent(5, 6, 2, 1);

        // Left tentacle
        activeSprite.addComponent(2, 5, 3, 1);
        activeSprite.addComponent(1, 6, 2, 1);
        activeSprite.addComponent(2, 7, 2, 1);

        // Right tentacle
        activeSprite.addComponent(7, 5, 3, 1);
        activeSprite.addComponent(9, 6, 2, 1);
        activeSprite.addComponent(8, 7, 2, 1);

    }

    protected void populateSprite2() {
        // Body
        inactiveSprite.addComponent(4, 0, 4, 1);
        inactiveSprite.addComponent(1, 1, 10, 1);
        inactiveSprite.addComponent(0, 2, 12, 3);

        // Eyes
        inactiveSprite.addComponent(3, 3, 2, 1, EYE_COLOUR);
        inactiveSprite.addComponent(7, 3, 2, 1, EYE_COLOUR);

        // Mouth
        inactiveSprite.addComponent(5, 6, 2, 1);

        // Left tentacle
        inactiveSprite.addComponent(3, 5, 2, 1);
        inactiveSprite.addComponent(2, 6, 2, 1);
        inactiveSprite.addComponent(0, 7, 2, 1);

        // Right tentacle
        inactiveSprite.addComponent(7, 5, 2, 1);
        inactiveSprite.addComponent(8, 6, 2, 1);
        inactiveSprite.addComponent(10, 7, 2, 1);
        
    }

    public Octopus(int x, int y) {
        super(x, y, 12, 8, 30, ANIMATION_SPEED, COLOUR);
    }
}