import java.util.ArrayList;
import java.util.Iterator;

public class SpaceInvaders {
    public static final int SCALE = 4;
    public static final int WIDTH = 250 * SCALE;
    public static final int HEIGHT = 250 * SCALE;

    public static void main(String[] args) {
        GameArena arena = new GameArena(WIDTH, HEIGHT);
        Player player = new Player(250, 450);
        Crab crab = new Crab(50, 50);
        Squid squid = new Squid(100, 50);
        Octopus octopus = new Octopus(150, 50);
        
        // Behaves mostly like a queue, a ringbuffer might be more efficient
        ArrayList<Bullet> bullets = new ArrayList<>();
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(crab);
        enemies.add(squid);
        enemies.add(octopus);
        
        arena.addThing(player);
        arena.addThing(crab);
        arena.addThing(squid);
        arena.addThing(octopus);

        while (true) {
            player.update();
            crab.update();
            squid.update();
            octopus.update();

            // Use iterator to allow for simultaneous iteration and removal
            Iterator<Bullet> bulletIter = bullets.iterator();
            while (bulletIter.hasNext()) {
                Bullet b = bulletIter.next();
                for (Enemy e: enemies) {
                    if (e.isHit(b)) {
                        b.markDead();
                        e.markDead();
                    }
                }
                b.update();
            }

            bulletIter = bullets.iterator();
            while (bulletIter.hasNext()) {
                Bullet b = bulletIter.next();
                if (b.isDead()) {
                    bulletIter.remove();
                    arena.removeObject(b);
                }
            }

            Iterator<Enemy> enemyIter = enemies.iterator();
            while (enemyIter.hasNext()) {
                Enemy e = enemyIter.next();
                if (e.isDead()) {
                    enemyIter.remove();
                    arena.removeObject(e);
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
