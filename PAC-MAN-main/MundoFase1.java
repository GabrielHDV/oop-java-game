import greenfoot.*;

public class MundoFase1 extends MundoBase {

    public MundoFase1() {
        super(800, 600); 
        configurarFundo(); 

        prepare(); 
        criarLabirinto(50, 50, 8, 8, 90); 
    }

    private void configurarFundo() {

        redimensionarImagemDeFundo(); 
    }
    
    public void act() {
        verificarVitoria();  
    }
    
    private void prepare() {
       
        PacJogador pacJogador = new PacJogador();
        addObject(pacJogador,69,55);
        Fantasma fantasma = new Fantasma(pacJogador);
        addObject(fantasma,100,300);
        
        Fantasma fantasma2 = new Fantasma(pacJogador);
        addObject(fantasma2,430,300);
        
        Fantasma fantasma3 = new Fantasma(pacJogador);
        addObject(fantasma3,670,300);
        Sons.tocarmusicaDeFundo();   
    }

    public void verificarVitoria() {
        if (getObjects(Bola.class).isEmpty()) {
            Greenfoot.setWorld(new MundoFase2()); // Vai para a nova fase
        }
    }

    public void fimDeJogo() {
        Greenfoot.setWorld(new TelaGameOver()); // Tela de game over
    }
    
}
