import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe mostra as instruçoes do jogo  
 * se a tecla "backspace" foi clicada e seleciona a classe startScreen
 * @author (Vitor, Gabriel, Gabriela) 
 * @version (1.1)
 */
public class Instrucoes extends World
{

    /**
     * Construtor do objeto da classe Instrucoes.
     * 
     */
    public Instrucoes()
    {    
        super(800, 600, 1); 
        redimensionarImagemDeFundo();
    }
    
    public void act()
    {
        voltarMenu();
    }
    
    private void voltarMenu(){
        //Verifica se a tecla "backspace" esta pressionada e seleciona o mundo da startScreen
        if (Greenfoot.isKeyDown("backspace")){
            Greenfoot.setWorld(new StartScreen());
        }
    }
    
    private void redimensionarImagemDeFundo() {
        GreenfootImage background = getBackground(); // Pega a imagem de fundo atual
        background.scale(getWidth(), getHeight());   // Redimensiona para o tamanho do mundo
        setBackground(background);                  // Define a nova imagem redimensionada como fundo
    }
}
