/*******************************************************************************
Autores: Antonio Carlos Mendes Neto e Victor César da Rocha Bastos
Componente Curricular: MI - Programação
Concluido em: 28/05/2018
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/


package blackjack.model;

import java.util.Random;

/**
 *
 * @author Antonio Neto e Victor César
 */
public final class Baralho{

    private Carta[] monte;
    private int tamanho;
    private int qtdNipes;
    private int qtdFaces;
    private int contJogadas;

    public Baralho() {
        this.tamanho = 0;
        this.qtdNipes = 0;
        this.qtdFaces = 0;
        this.contJogadas = 0;
        this.monte = iniciaBaralho();
    }

    public Carta[] getMonte() {
        return monte;
    }

    public void setMonte(Carta[] monte) {
        this.monte = monte;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getContJogadas() {
        return contJogadas;
    }

    public void setContJogadas(int contJogadas) {
        this.contJogadas = contJogadas;
    }
    
    /**
     * Inicia o baralho com uma certa quantidade de cartas por face
     * 
     * @return um baralho ordenado
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public Carta[] iniciaBaralho() {
        
        Carta[] novo = new Carta[52];
        
        String[] face = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        char[] nipe = {'♠', '♥', '♣', '♦'};

        qtdFaces = face.length;
        qtdNipes = nipe.length;
        for (char nipeAux : nipe) {
            for (String faceAux : face) {
                novo[tamanho] = new Carta(faceAux, nipeAux, tamanho);
                tamanho++;
            }
        }
        
        return novo;
    }
    
    /**
     * Mostra o baralho de acordo com a quantidade de jogadas registradas
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public void mostrarBaralho() {

        for (int i = contJogadas; i < tamanho; i++) {
            System.out.println(monte[i].toString());                           
        }
    
    }

    /**
     * Embaralha um array de cartas utilizando-se de uma variável "randômica" 
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public void embaralha() {

        int num = this.tamanho - 1;

        Random embaralhador = new Random();

        for (int i = 0; i < tamanho - 1; i++) {
            int b = embaralhador.nextInt(num);
            Carta aux = monte[i];
            monte[i] = monte[b];
            monte[b] = aux;
            num--;
        }
    }

    /**
     * Ordena o array de cartas pelo número de id de cada carta, de acordo com a quantidade de jogadas registradas
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public void ordenaBaralho() {
        for (int i = contJogadas; i < tamanho; i++) {
            int posicaoMenor = i;
            for (int j = (i + 1); j < tamanho; j++) {
                if (monte[j].getId() < monte[posicaoMenor].getId()) {
                    posicaoMenor = j;
                }

            }
            if (monte[i].getId() != monte[posicaoMenor].getId()) {
                Carta temp = monte[i];
                monte[i] = monte[posicaoMenor];
                monte[posicaoMenor] = temp;
            }
        }

    }

    /**
     * Retira a carta de um indice específico do array de cartas
     * 
     * @param index indice da carta que vai ser retirada
     * @return carta retirada
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public Carta retiraCarta(int index) {
        return monte[index];
    }
    
    /**
     * Retira cartas do inicio do array, e incrementa a variável de jogadas(funciona como uma pilha)
     * 
     * @return carta retirada
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public Carta pegarCarta(){
        return monte[contJogadas++];
    }
    
    /**
     * Percorre um baralho até achar uma carta diferente
     * @param entrada array que vai ser comparado
     * @return se achar carta diferente, o array é diferente e retorna false, se não, o array é igual e retorna true
     * 
     * @author Antonio Neto 
     * @author Victor César
     */
    public boolean equals(Baralho entrada) {
        for (int i = 0; i < entrada.tamanho; i++) {
            if (!entrada.retiraCarta(i).equals(retiraCarta(i))) {
                return false;
            }
        }
        return true;
    }

}
