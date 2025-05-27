import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ContadorEnemigos extends Actor {
    private int enemigosDestruidos = 0;

    public ContadorEnemigos() {
        actualizarImagen();
    }

    public void incrementar() {
        enemigosDestruidos++;
        actualizarImagen();
    }

    private void actualizarImagen() {
        setImage(new GreenfootImage("Enemigos: " + enemigosDestruidos, 24, Color.WHITE, new Color(0, 0, 0, 0)));
    }
}
