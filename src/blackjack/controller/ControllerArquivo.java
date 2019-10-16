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

package blackjack.controller;

import blackjack.model.Baralho;
import blackjack.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Antonio Neto e Victor César
 */
public class ControllerArquivo {

    private Arquivo arquivo;

    public Arquivo getArquivo() {
        return arquivo;
    }

    public ControllerArquivo() {
        this.arquivo = new Arquivo();
    }

    public void gravarListaArquivo(ListaEncadeada jogadores) throws IOException {
        arquivo.gravarListaArquivo(jogadores);
    }

    public ListaEncadeada carregarListaJogadores() throws FileNotFoundException {
        return arquivo.carregarListaJogadores();
    }

    public Baralho carregaUltimoBraralho() {
        return arquivo.carregaUltimoBraralho();
    }

    public void gravarBralho(Baralho baralho) throws IOException {
        arquivo.gravarBralho(baralho);
    }

    public void gravarPlacar(ListaEncadeada jogadores) throws IOException {
        arquivo.gravarPlacar(jogadores);
    }

    public void carregarPlacar() {
        arquivo.carregarPlacar();
    }

}
