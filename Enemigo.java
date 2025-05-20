import greenfoot.*;

public class Enemigo extends Actor {
    private int vx;
    private int health = 3;
    private int shotDelay = 150;
    
    public Enemigo(int speed) {
        vx = speed;
        setImage("—Pngtree—3d ufo spacecraft illustration_5388987.png");
    }
    
    public void act() {
        move();
        shoot();
        checkHit();
    }
    
    private void move() {
        setLocation(getX() + vx, getY());
    }
    
    private void shoot() {
        if (shotDelay > 0) {
            shotDelay--;
        } else {
            getWorld().addObject(new EnemyLaser(), getX() - 40, getY());
            shotDelay = 180 + Greenfoot.getRandomNumber(120);
        }
    }
    
    private void checkHit() {
        Laser laser = (Laser)getOneIntersectingObject(Laser.class);
        if (laser != null) {
            health--;
            getWorld().removeObject(laser);
            
            if (health <= 0) {
                getWorld().removeObject(this);
            }
        }
    }
}