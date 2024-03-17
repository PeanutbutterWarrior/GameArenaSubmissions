public class Crab extends Enemy {
    private static final String COLOUR = "WHITE";
    private static final String EYE_COLOUR = "BLACK";
    private static final int ANIMATION_SPEED = 50;

    protected void populateSprite1() {
        // Left antenna
        activeSprite.addComponent(2, 0, 1, 1);
        activeSprite.addComponent(3, 1, 1, 1);

        // Right antenna
        activeSprite.addComponent(8, 0, 1, 1);
        activeSprite.addComponent(7, 1, 1, 1);

        // Body
        activeSprite.addComponent(2, 2, 7, 4);
        activeSprite.addComponent(1, 3, 9, 2);

        // Eyes
        activeSprite.addComponent(3, 3, 1, 1, EYE_COLOUR);
        activeSprite.addComponent(7, 3, 1, 1, EYE_COLOUR);

        // Left arm
        activeSprite.addComponent(0, 4, 1, 3);

        // Right arm
        activeSprite.addComponent(10, 4, 1, 3);
        
        // Left mandible
        activeSprite.addComponent(2, 6, 1, 1);
        activeSprite.addComponent(3, 7, 2, 1);

        // Right mandible
        activeSprite.addComponent(8, 6, 1, 1);
        activeSprite.addComponent(6, 7, 2, 1);
    }

    protected void populateSprite2() {
        // Left antenna
        inactiveSprite.addComponent(2, 0, 1, 1);
        inactiveSprite.addComponent(3, 1, 1, 1);

        // Right antenna
        inactiveSprite.addComponent(8, 0, 1, 1);
        inactiveSprite.addComponent(7, 1, 1, 1);

        // Body
        inactiveSprite.addComponent(2, 2, 7, 4);
        inactiveSprite.addComponent(1, 3, 9, 3);

        // Eyes
        inactiveSprite.addComponent(3, 3, 1, 1, EYE_COLOUR);
        inactiveSprite.addComponent(7, 3, 1, 1, EYE_COLOUR);

        // Left arm
        inactiveSprite.addComponent(0, 1, 1, 4);

        // Right arm
        inactiveSprite.addComponent(10, 1, 1, 4);

        // Left mandible
        inactiveSprite.addComponent(2, 6, 1, 1);
        inactiveSprite.addComponent(1, 7, 1, 1);

        // Right mandible
        inactiveSprite.addComponent(8, 6, 1, 1);
        inactiveSprite.addComponent(9, 7, 1, 1);
    }

    public Crab(int x, int y) {
        super(x, y, 11, 8, 30, ANIMATION_SPEED, COLOUR);
    }
}
