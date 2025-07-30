import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PacJogador here.
 * 
 * @author (Vitor Firmino,Gabriel Henrique, Gabriela  ) 
 * @version (1.1 - 20/12/2024 - Versão inicial oficial.)
 */
public class PacJogador extends Actor
{   
    private int velocidade;
    private boolean estaVivo;
    private int bolasComidas;
    private GreenfootImage[] imagem;
    private GreenfootImage[] imagemParaCima;

    private int imagemAtual;

    private int refreshImagemAtual;

    private int contador;
    // para alterar a esquerda e direita
    private boolean viradoParaEsquerda;
    private boolean viradoParaBaixo;
    private boolean viradoParaCima;
    /**
     * Construtor que incializa o objeto Pac-Man 
     */
    public PacJogador() {
        velocidade = 4;
        inicializa();
        bolasComidas = 0;
        // para o movimento não ficar muito lento 
        refreshImagemAtual = 6;
        contador = 0;
        
        viradoParaEsquerda = false;
        viradoParaBaixo = false;
        viradoParaCima = false;
        
        
        // Vetor com 4 posições pois temos 4 imagens
        imagem = new GreenfootImage[4]; 
        imagemParaCima = new GreenfootImage[4];

        // Loop para carregar e redimensionar as imagens
        for (int i = 0; i < imagem.length; i++) {
            imagem[i] = new GreenfootImage("frame " + (i + 1) + ".png");
            imagem[i].scale(27, 34);
        }
        
        for (int i = 0; i < imagemParaCima.length; i++) {
            imagemParaCima[i] = new GreenfootImage("frameViradoParaCima " + (i + 1) + ".png");
            imagemParaCima[i].scale(27, 34);
        }
        
        imagemAtual = 0;
        setImage(imagem[imagemAtual]);
       
    }
    
    /**
     * Metodo para incializar o objeto na tela  
     */
    public void inicializa() {
        // Define a posição inicial do pac na tela
        setLocation(400, 200);
        estaVivo = true;
    }
    /**
     * Metodo boleano para dizer se o jogador esta vivo 
     */
    public boolean estaVivo() {
        return estaVivo;
    }
    
    /**
     * Metodo para controlar a velocidade da animação.
     */
    private void animacao() {
        contador++;
        if (contador == refreshImagemAtual) {
            imagemAtual++;
            if (imagemAtual >= imagem.length ) {
                imagemAtual = 0; 
            }
            atualizarImagem();
            
            contador = 0;
        }
    }
    
    /**
     * Metodo para que a imagem inverta para a esquerda 
     */
    private void atualizarImagem() {
        GreenfootImage imagemAtualizada = new GreenfootImage(imagem[imagemAtual]);
        if (viradoParaEsquerda) {
            imagemAtualizada.mirrorHorizontally();
        }
        setImage(imagemAtualizada);
    }
    
    /**
     * Metodo para que a imagem inverta para baixo
     */
    private void atualizarImagemBaixo() {
        GreenfootImage imagemAtualizada = new GreenfootImage(imagemParaCima[imagemAtual]);
        imagemAtualizada.rotate(180);
        setImage(imagemAtualizada);
    }
    
    private void atualizarImagemCima() {
        GreenfootImage imagemAtualizada = new GreenfootImage(imagemParaCima[imagemAtual]);
        setImage(imagemAtualizada);
    }
    
     /**
     * Método para movimentação do jogador
     * apertando as teclas(W,A,S,D) para os movimentos.
     */
    public void movimenta() {
        if (estaVivo) {
            if (Greenfoot.isKeyDown("W") || Greenfoot.isKeyDown("up")) {
                setLocation(getX(), getY() - velocidade);
                if(!viradoParaCima){
                    viradoParaEsquerda = false;
                    atualizarImagemCima();   
                }             
            }
            if (Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("left")) {
                setLocation(getX() - velocidade, getY());
                if (!viradoParaEsquerda) {
                    viradoParaEsquerda = true;
                    atualizarImagem();
                }
            }
            if (Greenfoot.isKeyDown("S") || Greenfoot.isKeyDown("down")) {
                setLocation(getX(), getY() + velocidade);
                if(!viradoParaBaixo){
                    viradoParaEsquerda = false;
                    atualizarImagemBaixo();
                }
            }
            if (Greenfoot.isKeyDown("D") || Greenfoot.isKeyDown("right")) {
                setLocation(getX() + velocidade, getY());
                if (viradoParaEsquerda) {
                    viradoParaEsquerda = false;
                    atualizarImagem();
                }
            }
        }
    }
    
         /**
         * come a bolinha 
         */
    public void comerBolinha() {
    Actor bola = getOneObjectAtOffset(0, 0, Bola.class);
    if (bola != null) {
        getWorld().removeObject(bola);

        // Verifica se o mundo atual é uma instância de MeuMundo
        if (getWorld() instanceof MundoFase1) {
            MundoFase1 mundo = (MundoFase1) getWorld();
            mundo.getPlacar().adicionarPontos(10);
            mundo.verificarVitoria();
        }
        // Verifica se o mundo atual é uma instância de MundoFase2
        else if (getWorld() instanceof MundoFase2) {
            MundoFase2 mundoFase2 = (MundoFase2) getWorld();
            mundoFase2.getPlacar().adicionarPontos(10);
            //mundoFase2.verificarVitoria();
        }

        bolasComidas++;
        Sons.tocarComendoBolinha();
        }
    }

    
    public int bolasComidas() {
        return bolasComidas;
    }
    
    /**
     * testa se o fantasma encostou no pac
     */
    public void fantasmizado() {
        if (estaVivo) {
              //virou geleca
            estaVivo = false;
            Sons.tocarPacMorreu();
            MundoFase1 labirinto = getWorldOfType(MundoFase1.class);
            labirinto.fimDeJogo();
            MundoFase2 lab = getWorldOfType(MundoFase2.class);
            lab.fimDeJogo();
        }
    }

    public void act() {
        movimenta(); 
        comerBolinha();
        animacao();
    } 
}
