import greenfoot.*;

public class ContadorTiempo extends Actor {
    private int ciclos = 0;
    private int segundos = 0;

    public ContadorTiempo() {
        actualizarImagen();
    }

    public void act() {
        ciclos++;

        // Greenfoot corre a 60 FPS, así que cada 60 ciclos es 1 segundo
        if (ciclos >= 150) {
            segundos++;
            ciclos = 0;
            actualizarImagen();
        }
    }

    private void actualizarImagen() {
        setImage(new GreenfootImage("Tiempo: " + segundos + " s", 24, Color.YELLOW, new Color(0, 0, 0, 0)));
    }

    public int getTiempo() {
        return segundos;
    }
}
