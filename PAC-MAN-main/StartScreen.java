import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classeque herda a classe World e serve como tela inicial do jogo.
 * 
 * @author (Gabriel, Gabriela, Vitor) 
 * @version (1.1)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 

        redimensionarImagemDeFundo();
    }
    
    /**
     * Método que controla as ações durante a execução do jogo na tela de menu.
     */
    public void act()
    {
        startPac();
        regularVolume();
        instrucoes();
    }

    /**
     * Método que cria o mundo "MeuMundo" e inicia o jogo ao pressionar a tecla "enter".
     * Também interrompe a música da tela de menu.
     */
    private void startPac(){
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new MundoFase1());
            Sons.pararMenuMusica();
        }
    }

    /**
     * Método que leva para as instruções ao pressionar a tecla "i".
     */
    private void instrucoes(){
        if (Greenfoot.isKeyDown("i")){
            Greenfoot.setWorld(new Instrucoes());
        }
    }

    /**
     * Método que ajusta o volume do som chamando um método da classe Som.
     */
    private void regularVolume()
    {
        Sons.regularVolume();
    }

    /**
     * Método que inicia a música da tela de menu chamando um método da classe Som.
     */
    public void started()
    {
        Sons som = new Sons();
        som.tocarMenuMusica();   
    }

    /**
     * Método que para a música chamando um método da classe Som.
     */
    public void stopped()
    {
        Sons.pararMenuMusica();
    }

    private void redimensionarImagemDeFundo() {
        GreenfootImage background = getBackground(); // Pega a imagem de fundo atual
        background.scale(getWidth(), getHeight());   // Redimensiona para o tamanho do mundo
        setBackground(background);                  // Define a nova imagem redimensionada como fundo
    }
}
