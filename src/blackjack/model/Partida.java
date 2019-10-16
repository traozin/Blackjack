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

import blackjack.util.Iterador;
import blackjack.util.ListaEncadeada;
import java.util.Scanner;

/**
 *
 * @author Antonio Neto e Victor César
 */
public class Partida {
    
    private Baralho baralho;
    private ListaEncadeada jogadores;
    private Croupier bot;
    private int qtdJogadores;
    private boolean tem21;

    public Partida() {
        this.baralho = new Baralho();
        this.jogadores = new ListaEncadeada();
        this.bot = new Croupier();
        this.qtdJogadores = 0;
        this.tem21 = false;
    }

    public ListaEncadeada getJogadores() {
        return jogadores;
    }

    public void setQtdJogadores(int qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }

    public Croupier getBot() {
        return bot;
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public boolean isTem21() {
        return tem21;
    }

    /**
     * Adiciona o jogador na lista criada dentro da partida
     * 
     * @param user usuario do jogador
     * @param senha senha do jogador
     * @return só retorna false se o jogador já for cadastrado
     * 
     * @author Antonio Neto 
     * @author Victor César
     * 
     */
    public boolean cadastrarJogadorEmPartida(String user, String senha) {//função de cadastrar jogador em partida
        Jogador novo = new Jogador(user, senha);//jogador que vai ser adicionado, se não for repetido

        Iterador it = jogadores.iterador();//iterador usado para percorrer a lista de jogadores, testando se ele já existe

        while (it.temProximo()) {
            Jogador aux = (Jogador) it.proximo();

            if (aux.getUser().equals(novo.getUser())) {
                return false;//se o jogador exisir
            }
        }

        jogadores.insereFinal(novo);//adiciona o jogador na lista
        return true;//se o jogador não existir, depois de ser adicionado
    }

    /**
     * É a funcionalidade da partida, tirando o croupier
     * 
     * @return só tem retorno quando algum jogador chega em 21
     * 
     * @author Antonio Neto 
     * @author Victor César
     */
    public Jogador jogada() {
        Scanner input = new Scanner(System.in);
        Carta retirada;
        int todosPararam = 0;

        while (todosPararam < qtdJogadores) {
            Iterador it = jogadores.iterador();
            todosPararam = 0;
            
            while (it.temProximo()) {

                Jogador aux = (Jogador) it.proximo();
                System.out.println("\nVez de " + aux.getUser());
                
                if(!(aux.getMao().valorDaMao() == 0)){
                    System.out.println("Valor da mão: "+aux.getMao().valorDaMao());
                }

                if (aux.getQtdJogadas() == 0 && !aux.isJaParou()) {

                    retirada = baralho.pegarCarta();
                    System.out.println("\nVocê pegou um(a) " + retirada.toString());
                    aux.getMao().addCarta(retirada);

                    retirada = baralho.pegarCarta();
                    System.out.println("Você pegou um(a) " + retirada.toString());
                    aux.getMao().addCarta(retirada);

                    System.out.println("Valor da mão: " + aux.getMao().valorDaMao());
                    aux.setQtdJogadas(+1);
                    
                    if(aux.getMao().valorDaMao() == 21){
                        return aux;                        
                    }

                } else if (!aux.isJaParou() && !aux.isEstourou()) {

                    System.out.print("\nVocê deseja parar?\n\n1 - Sim\n2 - Não\n\nOpção: ");
                    switch (input.nextInt()) {
                        case 1:
                            todosPararam++;
                            aux.setJaParou(true);
                            break;
                        case 2:
                            
                            retirada = baralho.pegarCarta();
                            System.out.println("Você pegou um(a) " + retirada.toString());
                            aux.getMao().addCarta(retirada);

                            System.out.println("Valor da mão: " + aux.getMao().valorDaMao());
                            aux.setQtdJogadas(+1);
                            
                            if(aux.getMao().valorDaMao() > 21){
                                System.out.println("\nEstourou!\n");
                                aux.setEstourou(true);
                            }

                            if (aux.getMao().valorDaMao() == 21) {
                                tem21 = true;
                                return aux;
                            }
                            break;
                        default:
                            System.out.println("Opção inválida!\n\n");
                    }
                } else {
                    todosPararam++;
                    System.out.println("Este jogador já parou de jogar, proximo!");
                }
            }
        }

        return null;
    }    
}
