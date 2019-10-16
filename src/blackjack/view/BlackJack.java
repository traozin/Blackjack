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

package blackjack.view;

import blackjack.controller.*;
import blackjack.model.*;
import blackjack.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Antonio Neto e Victor César
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {

        Scanner input = new Scanner(System.in);

        ControllerJogador jogadores = new ControllerJogador();
        ControllerArquivo arquivos = new ControllerArquivo();

        jogadores.setJogadores(arquivos.carregarListaJogadores());

        boolean controle = true;

        while (controle) {
            Baralho ultimoBaralho = arquivos.carregaUltimoBraralho();
            System.out.println("\nBlackJack");

            System.out.println("1 - Partida");
            System.out.println("2 - Cadastrar");
            System.out.println("3 - Regras");
            System.out.println("4 - Placar");
            System.out.println("5 - Sair");

            System.out.print("\nOpção: ");

            switch (input.nextInt()) {
                case 1:

                    System.out.println("\nPartida");
                    System.out.println("1 - Iniciar partida");
                    System.out.println("2 - Baralho da última partida");

                    System.out.print("\nOpção: ");

                    switch (input.nextInt()) {
                        case 1:
                            boolean menu = true;
                            int cont = 0;
                            ControllerPartida partida = new ControllerPartida();
                            while (menu) {
                                System.out.println("\nRestam " + (5 - cont) + " vagas no jogo");
                                System.out.print("\n1 - Cadastrar jogador na Partida\n2 - Iniciar partida\n3 - Voltar para o menu\n\nOpção: ");
                                switch (input.nextInt()) {
                                    case 1:
                                        if (cont == 5) {
                                            System.out.println("\nChegou ao número máximo de cadastros por partida");
                                        } else {
                                            System.out.println("\nLogin Jogador");
                                            System.out.print("User: ");
                                            String user = input.next();
                                            if (!jogadores.verifica(user)) {
                                                System.out.println("\nJogador não encontrado!");
                                            } else {
                                                System.out.print("Senha: ");
                                                String senha = input.next();
                                                if (jogadores.login(user, senha)) {
                                                    partida.cadastrarJogadorEmPartida(user, senha);
                                                    cont++;
                                                } else {
                                                    System.out.println("Senha inválida!");
                                                }
                                            }
                                        }
                                        break;
                                    case 2:
                                        partida.getPartida().setQtdJogadores(cont);
                                        Croupier bot = partida.getPartida().getBot();

                                        Baralho baralho = partida.getPartida().getBaralho();
                                        baralho.embaralha();

                                        bot.getMao().addCarta(baralho.pegarCarta());
                                        Carta retirada = baralho.pegarCarta();
                                        System.out.println("\nUma das cartas que o croupier pegou foi um(a) " + retirada.toString());
                                        bot.getMao().addCarta(retirada);

                                        Jogador ganhador = partida.jogada();

                                        System.out.println("\nMão do croupier!");
                                        bot.mostrarMao();
                                        System.out.println("\nValor da mao do Croupier: " + bot.getMao().valorDaMao());

                                        if (bot.getMao().valorDaMao() < 17) {
                                            System.out.println("\nCroupier continua cavando enquanto estiver com a mão inferior à 17!\n");
                                        }

                                        boolean croupierGanhou = bot.ate17(partida.getPartida().getBaralho());

                                        if (bot.isEstourou() && !partida.getPartida().isTem21()) {
                                            int contador = 0;
                                            int valor_ganhador = 0;

                                            Iterador it = partida.getPartida().getJogadores().iterador();
                                            while (it.temProximo()) {
                                                Jogador teste = (Jogador) it.proximo();
                                                if (!teste.isEstourou()) {
                                                    if (teste.getMao().valorDaMao() > valor_ganhador) {
                                                        ganhador = teste;
                                                        valor_ganhador = teste.getMao().valorDaMao();
                                                        contador = 1;
                                                    } else if (teste.getMao().valorDaMao() == valor_ganhador) {
                                                        contador++;
                                                    }
                                                }
                                            }
                                            if (contador > 1) {
                                                ganhador = null;
                                                System.out.println("Empate, partida desconsiderada!");
                                            }
                                        } else if (!partida.getPartida().isTem21() && !bot.isPegou21()) {
                                            int contador = 0;
                                            int valor_ganhador = 0;

                                            Iterador it = partida.getPartida().getJogadores().iterador();
                                            while (it.temProximo()) {
                                                Jogador aux = (Jogador) it.proximo();
                                                if (!aux.isEstourou()) {
                                                    if (aux.getMao().valorDaMao() > bot.getMao().valorDaMao() && aux.getMao().valorDaMao() > valor_ganhador) {
                                                        ganhador = aux;
                                                        valor_ganhador = aux.getMao().valorDaMao();
                                                        contador = 1;
                                                    } else if (aux.getMao().valorDaMao() == valor_ganhador) {
                                                        contador++;
                                                    }
                                                }
                                            }
                                            if (contador > 1) {
                                                ganhador = null;
                                                System.out.println("Empate!");
                                                croupierGanhou = true;
                                            }
                                        } else if (partida.getPartida().isTem21() && bot.isPegou21()) {
                                            ganhador = null;
                                            croupierGanhou = true;
                                        }
                                        if (ganhador != null) {
                                            System.out.println("O jogador " + ganhador.getUser() + " ganhou com " + ganhador.getMao().valorDaMao() + " pontos!");

                                            Iterador it = jogadores.getJogadores().iterador();
                                            while (it.temProximo()) {
                                                Jogador aux = (Jogador) it.proximo();

                                                if (aux.getUser().equals(ganhador.getUser())) {
                                                    aux.setJogosVencidos(1);
                                                    aux.setPontuacaoGeral(ganhador.getMao().valorDaMao());
                                                }
                                            }
                                        } else if (croupierGanhou && ganhador == null) {
                                            System.out.println("Croupier ganhou com " + bot.getMao().valorDaMao() + " pontos!");
                                        } else {
                                            System.out.println("Não houveram ganhadores, partida desconsiderada!");
                                        }
                                        arquivos.gravarListaArquivo(jogadores.getJogadores());
                                        arquivos.gravarBralho(baralho);
                                        arquivos.gravarPlacar(jogadores.getJogadores());
                                        menu = false;
                                        break;
                                    case 3:
                                        menu = false;
                                        break;
                                    default:
                                        System.out.println("\nOpção inválida!");
                                }
                            }
                            break;
                        case 2:
                            if (ultimoBaralho != null) {
                                System.out.println("\nOrdem de saída:\n");
                                ultimoBaralho.mostrarBaralho();
                                ultimoBaralho.ordenaBaralho();
                                System.out.println("\nOrdenado:\n");
                                ultimoBaralho.mostrarBaralho();
                            } else {
                                System.out.println("Não existe nenhuma partida cadastrada!\n");
                            }
                            break;

                    }
                    break;
                case 2:
                    System.out.print("\nDigite seu usuário: ");
                    String user = input.next();
                    if (jogadores.verifica(user)) {
                        System.out.println("\nJogador já cadastrado!");
                    } else {
                        System.out.print("Digite sua senha: ");
                        String senha = input.next();
                        jogadores.cadastrarJogador(user, senha);
                        arquivos.gravarListaArquivo(jogadores.getJogadores());
                    }

                    break;
                case 3:
                    System.out.println("\nREGRAS!!");
                    System.out.println("1 - Quando um jogador faz 21(sendo BlackJack ou não) ele ganha a partida");
                    System.out.println("2 - Sempre que o croupier fizer 21 ele ganha");
                    System.out.println("3 - Será utilizado um único baralho para cada partida");
                    System.out.println("4 - O jogador só poderá pedir uma carta por rodada");
                    System.out.println("5 - O jogador irá pontuar de acordo com o valor das cartas da sua mão (apenas o ganhador pontua);");
                    System.out.println("6 - O croupier continua cavando enquanto tiver a mão menor que 17\n");
                    break;
                case 4:
                    arquivos.carregarPlacar();
                    break;
                case 5:
                    controle = false;
                    break;
                default:
                    System.out.println("Entrada inválida");
                    break;
            }

        }

    }

}
