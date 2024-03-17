import java.awt.Graphics2D;

public class Crab implements Drawable{
    private static final String COLOUR = "WHITE";
    private static final String EYE_COLOUR = "BLACK";

    private int x;
    private int y;
    private int speed;

    private Rectangle boundingBox;
    private RelativeRect[] components;

    public Crab(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = 30;

        boundingBox = new Rectangle(
            x,
            y,
            11 * SpaceInvaders.SCALE,
            8 * SpaceInvaders.SCALE,
            COLOUR
        );
        
        components = new RelativeRect[14];

        // Left antenna
        components[0] = new RelativeRect(
            2 * SpaceInvaders.SCALE,
            0,
            1 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );
        components[2] = new RelativeRect(
            3 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );

        // Right antenna
        components[1] = new RelativeRect(
            8 * SpaceInvaders.SCALE,
            0,
            1 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );
        components[3] = new RelativeRect(
            7 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );

        // Body
        components[4] = new RelativeRect(
            2 * SpaceInvaders.SCALE,
            2 * SpaceInvaders.SCALE,
            7 * SpaceInvaders.SCALE,
            4 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );
        components[5] = new RelativeRect(
            1 * SpaceInvaders.SCALE,
            3 * SpaceInvaders.SCALE,
            9 * SpaceInvaders.SCALE,
            2 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );

        // Eyes
        components[12] = new RelativeRect(
            3 * SpaceInvaders.SCALE,
            3 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            EYE_COLOUR,
            1,
            boundingBox
        );
        components[13] = new RelativeRect(
            7 * SpaceInvaders.SCALE,
            3 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            EYE_COLOUR,
            boundingBox
        );

        // Left arm
        components[6] = new RelativeRect(
            0 * SpaceInvaders.SCALE,
            4 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            3 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );

        // Right arm
        components[7] = new RelativeRect(
            10 * SpaceInvaders.SCALE,
            4 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            3 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );
        
        // Left mandible
        components[8] = new RelativeRect(
            2 * SpaceInvaders.SCALE,
            6 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );

        components[9] = new RelativeRect(
            3 * SpaceInvaders.SCALE,
            7 * SpaceInvaders.SCALE,
            2 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );

        // Right mandible
        components[10] = new RelativeRect(
            8 * SpaceInvaders.SCALE,
            6 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );

        components[11] = new RelativeRect(
            6 * SpaceInvaders.SCALE,
            7 * SpaceInvaders.SCALE,
            2 * SpaceInvaders.SCALE,
            1 * SpaceInvaders.SCALE,
            COLOUR,
            boundingBox
        );

    
    }

    public void draw(Graphics2D window) {
        for (RelativeRect r: components) {
            r.draw(window);
        }
    }

    public int getLayer() {
        return 0;
    }
}
