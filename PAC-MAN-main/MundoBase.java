import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class MundoBase extends World  
{
    private PacJogador pacJogador;
    private Placar placar;
    
    /**
     * Construtor para objetos da classe MundoBase.
     */
    public MundoBase(int largura, int altura) {
        super(largura, altura, 1); 
        placar = new Placar();
        addObject(placar, 100, 20);  // Adiciona o placar na parte superior esquerda
    }

    /**
     * Método responsável por tocar a música tema do jogo.
     */
    public void started() {
        Sons.tocarmusicaDeFundo();   
    }
    
    /**
     * Método responsável por parar de tocar a música tema do jogo.
     */
    public void stopped() {
        Sons.pararmusicaDeFundo();
    }
    
    public Placar getPlacar() {
        return placar;
    }
    
    /**
     * Método para criar um labirinto de bolas.
     */
    public void criarLabirinto(int inicioX, int inicioY, int linhas, int colunas, int espacoEntreBolas) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if ((i % 2 == 0 || j % 3 != 0) && !(i == 5 && j > 5 && j < 10)) {
                    Bola bola = new Bola();
                    addObject(bola, inicioX + j * espacoEntreBolas, inicioY + i * espacoEntreBolas);
                }
            }
        }
    }
    
    public void redimensionarImagemDeFundo() {
        GreenfootImage background = getBackground(); 
        background.scale(getWidth(), getHeight());   
        setBackground(background);                  
    }
}
