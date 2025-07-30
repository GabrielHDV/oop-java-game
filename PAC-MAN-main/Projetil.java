import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Projetil extends Actor
{
    public Projetil() {
        GreenfootImage image = getImage();
        image.scale(35, 35); 
        setImage(image);
    }

    public void act() 
    {
        move(5); 

        // Remove o projetil se ele sair da tela
        if (isAtEdge()) {
            if (getWorld() != null) { 
                getWorld().removeObject(this);
            }
            return; // 
        }

        // Verifica se o ator ainda está no mundo antes de verificar colisão
        if (getWorld() != null && isTouching(PacJogador.class)) {
            Greenfoot.setWorld(new TelaGameOver());
            Greenfoot.stop(); // Para o jogo 
        }
    }

}