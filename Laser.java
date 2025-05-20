import greenfoot.*;

public class Laser extends Actor {
    private int speed = 4;
    
    public Laser() {
        // Láser amarillo más grueso para mejor visibilidad
        GreenfootImage image = new GreenfootImage(80, 6);
        image.setColor(Color.YELLOW);
        image.fill();
        setImage(image);
    }
    
    public void act() {
        // Movimiento horizontal
        setLocation(getX() + speed, getY());
        
        // Eliminación INFALIBLE al tocar bordes
        World world = getWorld();
        if (world != null) {
            if (getX() >= world.getWidth() - 1 || getX() <= 0) {
                world.removeObject(this);
                return; // Salir inmediatamente
            }
            
            // Verificación adicional de posición
            if (getY() <= 0 || getY() >= world.getHeight() - 1) {
                world.removeObject(this);
            }
        }
    }
}