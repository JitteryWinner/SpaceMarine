import greenfoot.*;

public class Espacio1 extends World {
    private int spawnDelay = 0;
    
    public Espacio1() {    
        super(800, 600, 1); // Tamaño aumentado para mejor juego
        prepare();
    }
    
    private void prepare() {
        addObject(new Nave(), 100, getHeight()/2);
        setBackground(new GreenfootImage("space1.jpg"));
    }
    
    public void act() {
        spawnEnemies();
        removeOffscreenObjects(); // Limpieza de objetos fuera de pantalla
    }
    
    private void spawnEnemies() {
        if (spawnDelay > 0) {
            spawnDelay--;
        } else {
            int spawnY = Greenfoot.getRandomNumber(getHeight() - 100) + 50;
            addObject(new Enemigo(-2), getWidth() + 50, spawnY);
            spawnDelay = 120;
        }
    }
    
    private void removeOffscreenObjects() {
        // Eliminar láseres que salgan de pantalla
        removeObjects(getObjectsAt(getWidth(), getHeight()/2, Laser.class));
        removeObjects(getObjectsAt(0, getHeight()/2, EnemyLaser.class));
        
        // Eliminar enemigos que salgan por izquierda
        for (Enemigo enemigo : getObjects(Enemigo.class)) {
            if (enemigo.getX() < -50) {
                removeObject(enemigo);
            }
        }
    }
    
    public void gameOver() {
        showText("GAME OVER", getWidth()/2, getHeight()/2);
        Greenfoot.stop();
    }
}