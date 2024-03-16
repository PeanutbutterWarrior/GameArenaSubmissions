import java.util.ArrayList;
import java.util.Iterator;

public class SpaceInvaders {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static void main(String[] args) {
        GameArena arena = new GameArena(500, 500);
        Player player = new Player();
        
        // Behaves mostly like a queue, a ringbuffer might be more efficient
        ArrayList<Bullet> bullets = new ArrayList<>();
        arena.addThing(player);

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
                player.move(-Player.SPEED);
            else if (arena.rightPressed())
                player.move(Player.SPEED);
            
            if (arena.upPressed() && player.canFire()) {
                Bullet newBullet = player.fire();
                bullets.add(newBullet);
                arena.addThing(newBullet);
            }

            arena.pause(); // Keep a consistent (ish) 50 fps
        }
    }
}
