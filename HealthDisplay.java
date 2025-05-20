import greenfoot.*;

public class HealthDisplay extends Actor {
    public HealthDisplay() {
        setImage(new GreenfootImage(20, 20));
        getImage().setColor(Color.GREEN);
        getImage().fillOval(0, 0, 20, 20);
    }
}