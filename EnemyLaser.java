import greenfoot.*;

public class EnemyLaser extends Actor {
    private int speed = -3;
    
    public EnemyLaser() {
        // Láser rojo más grueso
        GreenfootImage image = new GreenfootImage(70, 6);
        image.setColor(Color.RED); // Cambiado a rojo para mejor contraste
        image.fill();
        setImage(image);
    }
    
    public void act() {
        // Movimiento horizontal inverso
        setLocation(getX() + speed, getY());
        
        // Eliminación a prueba de fallos
        World world = getWorld();
        if (world != null) {
            // Detección precisa de bordes
            boolean atLeftEdge = getX() <= 1;
            boolean atRightEdge = getX() >= world.getWidth() - 1;
            boolean atVerticalEdge = getY() <= 1 || getY() >= world.getHeight() - 1;
            
            if (atLeftEdge || atRightEdge || atVerticalEdge) {
                world.removeObject(this);
                return;
            }
            
            // Colisión con la nave
            Nave nave = (Nave)getOneIntersectingObject(Nave.class);
            if (nave != null) {
                nave.hit();
                world.removeObject(this);
            }
        }
    }
}