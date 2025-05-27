import greenfoot.*;

public class Nave extends Actor {
    private int shotDelay = 0;
    private int lives = 3;
    private int invincibilityTimer = 0;
    
    public Nave() {
        setImage("rocket.png");
    }
    
    public void act() {
        handleInvincibility();
        followMouse();
        shoot();
    }
    
    private void handleInvincibility() {
        if (invincibilityTimer > 0) {
            invincibilityTimer--;
            if (invincibilityTimer % 10 == 0) {
                getImage().setTransparency(getImage().getTransparency() == 150 ? 255 : 150);
            }
        } else {
            getImage().setTransparency(255);
        }
    }
    
    private void followMouse() {
        if (Greenfoot.mouseMoved(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) {
                setLocation(mouse.getX(), mouse.getY());
            }
        }
    }
    
    private void shoot() {
        if (shotDelay > 0) {
            shotDelay--;
        } else {
            getWorld().addObject(new Laser(), getX() + 50, getY());
            GreenfootSound laserSound = new GreenfootSound("laser.mp3");
            laserSound.setVolume(30);
            laserSound.play();
            shotDelay = 60;
        }
    }
    
    public void hit() {
        if (invincibilityTimer <= 0) {
            lives--;
            invincibilityTimer = 60;
            
            if (lives <= 0) {
                ((Espacio1)getWorld()).gameOver();
            }
        }
    }
}


