import java.util.ArrayList;
import java.util.Iterator;

public class SpaceInvaders {
    public static final int SCALE = 2;
    public static final int WIDTH = 250 * SCALE;
    public static final int HEIGHT = 250 * SCALE;

    public static void main(String[] args) {
        GameArena arena = new GameArena(WIDTH, HEIGHT);
        Player player = new Player(250, 450);
        Crab crab = new Crab(50, 50);
        
        // Behaves mostly like a queue, a ringbuffer might be more efficient
        ArrayList<Bullet> bullets = new ArrayList<>();
        
        arena.addThing(player);
        arena.addThing(crab);

        while (true) {
            player.update();

            // Use iterator to allow for simultaneous iteration and removal
            Iterator<Bullet> iter = bullets.iterator();
            Bullet b;
            while (iter.hasNext()) {
                b = iter.next();
                b.update();
                if (b.isDead()) {
                    iter.remove();
                    arena.removeObject(b);
                }
            }

            if (arena.leftPressed())
                player.move(-1);
            else if (arena.rightPressed())
                player.move(1);
            
            if (arena.upPressed() && player.canFire()) {
                Bullet newBullet = player.fire();
                bullets.add(newBullet);
                arena.addThing(newBullet);
            }

            arena.pause(); // Keep a consistent (ish) 50 fps
        }
    }
}
