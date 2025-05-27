import greenfoot.*;

public class Espacio1 extends World {
    private int spawnDelay = 0;
    private ContadorEnemigos contadorEnemigos;
    private ContadorTiempo contadorTiempo;

    private void prepare() { 
        contadorEnemigos = new ContadorEnemigos();
        addObject(contadorEnemigos, 100, 50); // Puedes ajustar la posición

        contadorTiempo = new ContadorTiempo();
        addObject(contadorTiempo, 700, 50);

        addObject(new Nave(), 100, getHeight() / 2);
        setBackground(new GreenfootImage("space1.jpg"));  
    }
    private GreenfootSound music = new GreenfootSound("musica rial rial rial.wav");
    public void started()
    {
        music.playLoop();
    }
    
    public ContadorEnemigos getContadorEnemigos() {
        return contadorEnemigos;
    }

    public ContadorTiempo getContadorTiempo() {
        return contadorTiempo;
    }

    public Espacio1() {
        super(800, 600, 1); // Tamaño aumentado para mejor juego
        prepare();
    }

    public void act() {
        spawnEnemies();
        spawnMeteoritos();
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

    private void spawnMeteoritos() {
        if (Greenfoot.getRandomNumber(200) < 2) { // Controla la frecuencia de aparición del meteorito
            int spawnY = Greenfoot.getRandomNumber(getHeight() - 100) + 50;
            addObject(new Meteorito(2), getWidth() + 50, spawnY);
            spawnDelay = 120;
        }
    }

    private void removeOffscreenObjects() {
        // Eliminar láseres que salgan de pantalla
        removeObjects(getObjectsAt(getWidth(), getHeight() / 2, Laser.class));
        removeObjects(getObjectsAt(0, getHeight() / 2, EnemyLaser.class));

        // Eliminar enemigos que salgan por izquierda
        for (Enemigo enemigo : getObjects(Enemigo.class)) {
            if (enemigo.getX() < -50) {
                removeObject(enemigo);
            }
        }

        // Eliminar meteoritos que salgan de la pantalla
        for (Meteorito meteorito : getObjects(Meteorito.class)) {
            if (meteorito.getX() < -50) {
                removeObject(meteorito);
            }
        }
    }

    public void gameOver() {
        showText("GAME OVER", getWidth() / 2, getHeight() / 2);
        music.stop();
        Greenfoot.stop();
    }
}
