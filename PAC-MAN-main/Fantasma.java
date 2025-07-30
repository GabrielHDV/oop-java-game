import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo) 

/**
 * Classe Fantasma - Representa um fantasma inimigo no jogo.
 * 
 * @author (Vitor Firmino, Gabriel Henrique, Gabriela)
 * @version (1.1 - 20/12/2024 - Versão inicial oficial.)
 */
public class Fantasma extends Actor {   
    private static int velocidade = 1;
    private boolean estaVivoF; // Indica se o fantasma está vivo
    private PacJogador pacJogador;
    private int tempoAlternancia = 0; // Contador de tempo
    private boolean perseguindo = true; // Alterna entre perseguir e mover aleatoriamente

    /**
     * Construtor do Fantasma
     * @param pacJogador Referência ao jogador
     */
    public Fantasma(PacJogador pacJogador) {
        this.pacJogador = pacJogador;
        this.estaVivoF = true; // Define como vivo inicialmente

        GreenfootImage imagem = new GreenfootImage("fantasma-azul.png");
        imagem.scale(27, 34);
        setImage(imagem);
    }

    /**
     * Método principal de ação do fantasma.
     */
    public void act() {
        if (estaVivoF) { // O fantasma só age se estiver vivo
            movimentar();
            comer();
            tempoAlternancia++;
        // A cada 3 segundos (aprox. 180 frames), alternamos o comportamento
        if (tempoAlternancia >= 180) {
            perseguindo = !perseguindo;
            tempoAlternancia = 0; // Reinicia o contador
            }
        }
    }

    /**
     * Método responsável por mover o fantasma.
     * 10% das vezes o fantasma gira aleatoriamente entre -60 e 60 graus.
     */
    public void movimentar() {
        move(velocidade);

        // Se atingir a borda do mundo, muda de direção
        if (isAtEdge()) {
            turn(180);
        }

         if (perseguindo) {
            // Persegue o PacJogador
            if (pacJogador.estaVivo() && !isTouching(PacJogador.class)) {
                turnTowards(pacJogador.getX(), pacJogador.getY());
            }
        } else {
            // Movimento aleatório
            if (Greenfoot.getRandomNumber(100) < 10) {
                int angulo = Greenfoot.getRandomNumber(90) - 60;
                turn(angulo);
            }
        }
    }

    /**
     * Método que verifica se o fantasma colidiu com o jogador.
     * Se houver colisão, o jogador é removido do mundo.
     */
    public void comer() {
        PacJogador  pac = (PacJogador) getOneIntersectingObject(PacJogador.class);
        if (pac != null) {
            pac.fantasmizado();
            getWorld().removeObject(pacJogador); // Remover o PacJogador detectado
             // Chamar o método que trata a morte do PacJogador
        }
    }

    /**
     * Método que define o fantasma como morto.
     */
    public void morreu() {
        if (estaVivoF){
        estaVivoF= false;
        setImage(new GreenfootImage(1, 1)); // Torna o fantasma invisível
        }
    }
}
