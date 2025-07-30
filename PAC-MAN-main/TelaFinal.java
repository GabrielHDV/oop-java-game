import greenfoot.*;

public class TelaFinal extends World {

    public TelaFinal() {
        super(800, 600, 1); // Tamanho padrão do mundo
        prepare();
    }

    /**
     * Prepara o mundo com os elementos iniciais.
     */
    public void prepare() {
        redimensionarImagemDeFundo();
    }

    public void act() {
        if (Greenfoot.isKeyDown("escape")) {
            Greenfoot.setWorld(new StartScreen()); // Volta para a tela inicial
        }
    }

    /**
     * Redimensiona a imagem de fundo para o tamanho do mundo.
     */
    public void redimensionarImagemDeFundo() {
        GreenfootImage background = getBackground(); // Pega a imagem de fundo atual
        background.scale(getWidth(), getHeight());   // Redimensiona para o tamanho do mundo
        setBackground(background);                  // Define a nova imagem redimensionada como fundo
    }
}
