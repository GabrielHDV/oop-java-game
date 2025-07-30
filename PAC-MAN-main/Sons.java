import greenfoot.*;
/**
 * Write a description of class Sons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sons  
{
    // Volume dos sons
    private static int volume;
    // Variável de controle para testar se o som está funcionando
    private static boolean teste;
    
    // Sons do jogo
    
    private static GreenfootSound menuMusica;
    private static GreenfootSound musicaDeFundo;
    private static GreenfootSound pacMorreu;
    private static GreenfootSound ComendoBolinha;
    /**
     * Constructor for objects of class Sons
     * pacman_start.wav
     */
    public Sons()
    {
        volume = 30;
        menuMusica = new GreenfootSound("pacman_start.wav");
        musicaDeFundo = new GreenfootSound("pacman_chomp.wav");
    }
    
    /**
     * Método que retorna o booleano que verifica se a música está tocando.
     */
    public static boolean TesteSom()
    {
        return teste;
    }
    
    /**
     * Método para tocar a música de fundo do jogo.
     */
    public static void tocarmusicaDeFundo()
    {   
        
            try {
            musicaDeFundo.playLoop();
            musicaDeFundo.setVolume(volume);
            teste = true;
        }
        catch (Exception e) 
        {
            System.out.println(" não foi possível tocar os sons do jogo");
            teste= false;
        }
    }
    
    /**
     * Método para tocar a música do menu do jogo.
     */
    public void tocarMenuMusica()
    {
        menuMusica = new GreenfootSound("pacman_start.wav");
            try {
            menuMusica.playLoop();
            menuMusica.setVolume(volume);
            teste = true;
        }
        catch (Exception e) 
        {
            System.out.println(" não foi possível tocar os sons do jogo");
            teste= false;
        }
    }
    
    /**
     * Método para parar de tocar a música tema do jogo.
     */
    public static void pararmusicaDeFundo()
    {
        musicaDeFundo.pause();
    }
    
    /**
     * Método para tocar o som de comer a bolinha.
     */
    public static void tocarComendoBolinha()
    {
        if (teste)
        {
            ComendoBolinha = new GreenfootSound("pacman_eatfruit.wav");
            ComendoBolinha.play();
            ComendoBolinha.setVolume(70);      
        }
    }
    
        /**
     * Método para tocar o som da morte do inimigo.
     */
    public static void tocarPacMorreu()
    {
        if (teste)
        {
            pacMorreu = new GreenfootSound("pacman_death.wav");
            pacMorreu.play();
            pacMorreu.setVolume(60);            
        }
    }
    
        /**
     * Método para parar de tocar a música do menu do jogo.
     */
    public static void pararMenuMusica()
    {
        menuMusica.stop();
        if (teste)
            menuMusica.setVolume(volume);
    }
    
    /**
     * Método que para aumentar ou diminuir o volume das músicas da StartScreen.
     */
    public static void regularVolume()
    {
        if (Greenfoot.isKeyDown("-")) 
            volume--;
        if (Greenfoot.isKeyDown("+")) 
            volume++;
        if (teste)
        {
            menuMusica.setVolume(volume);
            musicaDeFundo.setVolume(volume);
        }
    }
}
