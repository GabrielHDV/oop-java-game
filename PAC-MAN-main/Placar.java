import greenfoot.*;  

/**  
 * Classe Placar: Gerencia a pontuação, as vidas e o tempo de jogo.  
 */  
public class Placar extends Actor {  

    private int pontuacao;  
    private int tempoDecorrido; // Tempo em segundos  
    private int contagemFrames; // Contador de frames para conversão  

    public Placar() {  
        pontuacao = 0;   
        tempoDecorrido = 0;  
        contagemFrames = 0;  
        atualizarImagem();  
    }  

    /**  
     * Atualiza a imagem do placar exibida na tela.  
     */  
    private void atualizarImagem() { 
        
        GreenfootImage imagem = new GreenfootImage(1500, 60);  
         imagem.setColor(new Color(0, 0, 0, 0)); // Transparente
        imagem.fill(); // Preenche a imagem com transparência  

        imagem.setColor(Color.WHITE);  
        imagem.setFont(new Font("BOLD", true, false, 16));  

        // Exibe a pontuação, as vidas e o tempo de jogo  
        imagem.drawString("Pontuação: " + pontuacao, 700, 20);  
        imagem.drawString("Tempo: " + tempoDecorrido + "s", 1300, 20);  

        setImage(imagem);  
    }  

    /**  
     * Adiciona pontos ao placar.  
     */  
    public void adicionarPontos(int pontos) {  
        pontuacao += pontos;  
        atualizarImagem();  
    }  

    /**  
     * Atualiza o tempo de jogo.  
     */  
    public void act() {  
        contagemFrames++;  
        if (contagemFrames >= 60) { // Aproximadamente 1 segundo  
            tempoDecorrido++;  
            contagemFrames = 0;  
            atualizarImagem();  
        }  
    }  
}
