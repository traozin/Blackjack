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

package blackjack.util;

import blackjack.model.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 *
 * @author Antonio Neto e Victor César
 */
public class Arquivo {

    /**
     * Escreve a lista encadeada em um arquivo de texto
     *
     * @param jogadores lista encadeada de jogadores
     * @throws IOException
     *
     * @author Antonio Neto
     * @author Victor César
     */
    public void gravarListaArquivo(ListaEncadeada jogadores) throws IOException {
        File t = new File("Jogo\\jogadores.players");
        t.createNewFile();

        try {
            FileOutputStream arq = new FileOutputStream(t, true);
            PrintWriter writer = new PrintWriter(t);

            Iterador it = jogadores.iterador();

            while (it.temProximo()) {
                Jogador aux = (Jogador) it.proximo();

                writer.print(aux.getUser() + ":");
                writer.print(aux.getSenha() + ":");
                writer.print(aux.getJogosVencidos() + ":");
                writer.println(aux.getPontuacaoGeral());

            }

            writer.close();
        } catch (IOException exc) {
            System.out.println("Erro");
        }

    }

    /**
     * Faz um cache da lista encadeada de jogadores se existir o arquivo de
     * saída
     *
     * @return se existir um arquivo, retorna uma a lista encadeada gravada no
     * arquivo, se não, retorna uma nova lista
     *
     * @throws FileNotFoundException
     * 
     * @author Antonio Neto
     * @author Victor César
     *
     */
    public ListaEncadeada carregarListaJogadores() throws FileNotFoundException {
        try {
            ListaEncadeada jogadores = new ListaEncadeada();

            Path path = Paths.get(new File("Jogo\\jogadores.players").getPath());

            Stream<String> lines = Files.lines(path);

            lines.forEach(line -> {
                StringTokenizer token = new StringTokenizer(line, ":");
                while (token.hasMoreTokens()) {
                    String nome = token.nextToken();
                    String senha = token.nextToken();
                    String jogosVencidos = token.nextToken();
                    String pontuacaoGeral = token.nextToken();

                    Jogador aux = new Jogador(nome, senha, Integer.parseInt(jogosVencidos), Integer.parseInt(pontuacaoGeral));
                    jogadores.insereFinal(aux);

                }
            });
            return jogadores;
        } catch (IOException exc) {
            return new ListaEncadeada();

        }
    }

    /**
     * Grava o baralho em um arquivo de texto
     * 
     * @param baralho baralho que vai ser gravado
     * @throws IOException
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public void gravarBralho(Baralho baralho) throws IOException {
        File t = new File("Jogo\\baralho.pack");
        t.createNewFile();

        try {
            FileOutputStream arq = new FileOutputStream(t, true);
            PrintWriter writer = new PrintWriter(t);

            Carta monte[] = baralho.getMonte();

            for (int i = 0; i < baralho.getTamanho(); i++) {
                writer.print(monte[i].getFace() + ":");
                writer.print(monte[i].getNipe() + ":");
                writer.print(monte[i].getId() + ":");
                writer.println(baralho.getContJogadas());
            }

            writer.close();
        } catch (IOException exc) {
            System.out.println("Erro");
        }
    }
    
    /**
     * Faz um cache de um baralho gravado no arquivo de texto
     * @return se existir um arquivo de texto, ele retorna o baralho naquele arquivo, senão, ele retorna null
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public Baralho carregaUltimoBraralho() {

        Baralho baralho = new Baralho();
        Carta[] cartas = new Carta[52];
        int index[] = new int[1];
        index[0] = 0;

        try {
            Path path = Paths.get(new File("Jogo\\baralho.pack").getPath());

            Stream<String> lines = Files.lines(path);

            lines.forEach(line -> {
                StringTokenizer token = new StringTokenizer(line, ":");

                while (token.hasMoreTokens()) {

                    String face = token.nextToken();
                    String nipe = token.nextToken();
                    String id = token.nextToken();
                    String cont = token.nextToken();

                    cartas[index[0]++] = new Carta(face, nipe.charAt(0), Integer.parseInt(id));
                    baralho.setContJogadas(Integer.parseInt(cont));

                }

            });

            baralho.setMonte(cartas);
            return baralho;
        } catch (IOException exc) {
            return null;
        }
    }

    /**
     * Escreve o placar em um arquivo de texto, ordenado pela maior pontuação
     * 
     * @param jogadores jogadores que serão escritos no placar
     * @throws IOException 
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public void gravarPlacar(ListaEncadeada jogadores) throws IOException {
        File t = new File("Jogo\\placar.score");
        t.createNewFile();
        int maiorPontuacao = 0;
        Jogador jogadorAux[] = new Jogador[10];
        int cont = 0;

        try {
            FileOutputStream arq = new FileOutputStream(t, true);
            PrintWriter writer = new PrintWriter(t);

            Iterador it = jogadores.iterador();

            while (it.temProximo()) {
                Jogador aux = (Jogador) it.proximo();

                if (cont == jogadorAux.length) {
                    Jogador novo[] = new Jogador[cont * 2];
                    for (int i = 0; i < cont; i++) {
                        novo[i] = jogadorAux[i];
                    }

                    jogadorAux = novo;
                }

                jogadorAux[cont++] = aux;

            }

            for (int i = 0; i < cont; i++) {
                int posicaoMaior = i;
                for (int j = (i + 1); j < cont; j++) {
                    if (jogadorAux[j].getPontuacaoGeral() > jogadorAux[posicaoMaior].getPontuacaoGeral()) {
                        posicaoMaior = j;
                    }

                }
                if (jogadorAux[i].getPontuacaoGeral() != jogadorAux[posicaoMaior].getPontuacaoGeral()) {
                    Jogador temp = jogadorAux[i];
                    jogadorAux[i] = jogadorAux[posicaoMaior];
                    jogadorAux[maiorPontuacao] = temp;
                }
            }

            for (int i = 0; i < cont; i++) {
                writer.println(jogadorAux[i].toString());
            }

            writer.close();
        } catch (IOException exc) {
            System.out.println("Erro");
        }

    }
    
    /**
     * Carrega o placar que está gravado em um arquivo de texto e printa, se não existir o arquivo, ele informa que não tem jogos cadastrados
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public void carregarPlacar() {

        try {
            Path path = Paths.get(new File("Jogo\\placar.score").getPath());

            Stream<String> lines = Files.lines(path);

            lines.forEach(line -> {
                StringTokenizer token = new StringTokenizer(line, "\n");

                while (token.hasMoreTokens()) {
                    System.out.println(token.nextToken());
                }

            });

        } catch (IOException exc) {
            System.out.println("Não existem jogos cadastrados!");
        }

    }
}
