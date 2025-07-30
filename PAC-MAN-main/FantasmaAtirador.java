import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FantasmaAtirador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class FantasmaAtirador extends Actor
{
    private int tempoParaAtirar = 100; // Intervalo entre os tiros
    private int contadorTiro = 0;
    private int posX;
    private int posY;

    public FantasmaAtirador() {
        GreenfootImage image = getImage();
        image.scale(400, 400); 
        setImage(image);
    }

    public void fixarPosicao() {
        posX = getX(); // Salva a posição inicial X
        posY = getY(); // Salva a posição inicial Y
    }

    public void act() 
    {
        setLocation(posX, posY); 
        // Contador para determinar quando atirar
        contadorTiro++;
        if (contadorTiro >= tempoParaAtirar) {
            atirarMiniFantasma();
            contadorTiro = 0;  // Reinicia o contador após o tiro
        }
    }

    private void atirarMiniFantasma() {
        // Cria três mini fantasmas com direções diferentes
        Projetil miniProjetil1 = new Projetil();
        Projetil miniProjetil2 = new Projetil();
        Projetil miniProjetil3 = new Projetil();

        // Adiciona os projeteis na posição do fantasma atirador
        getWorld().addObject(miniProjetil1, getX(), getY());
        getWorld().addObject(miniProjetil2, getX(), getY());
        getWorld().addObject(miniProjetil3, getX(), getY());

        miniProjetil1.setRotation(360);  // Direção direita
        miniProjetil2.setRotation(330);  // Levemente para a esquerda
        miniProjetil3.setRotation(390);  // Levemente para a direita
    }

}
