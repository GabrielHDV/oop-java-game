import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MundoFase2 extends MundoBase  
{
    private PacJogador pacJogador;
    
    public MundoFase2() {
        super(800, 600); 

        pacJogador = new PacJogador();
        addObject(pacJogador, 69, 55);

        FantasmaAtirador fantasma = new FantasmaAtirador();
        addObject(fantasma, 50, getHeight() / 2);
        fantasma.fixarPosicao();

        criarLabirinto(330, 100, 8, 8, 90);
    }

    public void act() {
        verificarVitoria();
    }

    public void verificarVitoria() {
        if (getObjects(Bola.class).isEmpty()) {
            Greenfoot.setWorld(new TelaVitoria()); 
        }
    }

    public void fimDeJogo() {
        Greenfoot.setWorld(new TelaGameOver()); // Tela de game over
    }

}