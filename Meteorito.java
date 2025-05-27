import greenfoot.*;

public class Meteorito extends Actor {
    private int vx;
    private static GreenfootImage meteoritoImg = null;

    public Meteorito(int velocidad) {
        vx = -velocidad; // Movimiento de derecha a izquierda (negativo)

        if (meteoritoImg == null) {
            meteoritoImg = new GreenfootImage("meteorito.png");
            meteoritoImg.scale(50, 50); // Ajusta el tamaño como necesites
        }

        setImage(meteoritoImg);
    }

    public void act() {
        verificarColisionConNave(); // Primero verificar colisión
        mover(); // Luego mover
    }

    private void mover() {
        if (getWorld() == null) return; // Siempre verifica si sigue en el mundo
        setLocation(getX() + vx, getY());
        if (getX() <= 0) {
            getWorld().removeObject(this);
        }
    }

    private void verificarColisionConNave() {
        if (getWorld() == null) return; // Evita errores si ya fue eliminado
        Nave nave = (Nave) getOneIntersectingObject(Nave.class);
        if (nave != null) {
            nave.hit();
            getWorld().removeObject(this);
        }
    }
}
