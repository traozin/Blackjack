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

/**
 *
 * @author Antonio Neto e Victor César
 */
public class Jogador {

    private String user;
    private String senha;
    private MaoDeCarta mao;
    private int qtdJogadas;
    private boolean jaParou;
    private boolean estourou;
    private int pontuacaoGeral;
    private int jogosVencidos;

    public Jogador() {
        this.user = null;
        this.senha = null;
        this.mao = new MaoDeCarta();
    }

    public Jogador(String user, String senha) {
        this.user = user;
        this.senha = senha;
        this.mao = new MaoDeCarta();
        this.qtdJogadas = 0;
        this.jogosVencidos = 0;
        this.pontuacaoGeral = 0;
        this.jaParou = false;
        this.estourou = false;
    }

    public Jogador(String user, String senha, int pontuacaoGeral, int jogosVencidos) {
        this.user = user;
        this.senha = senha;
        this.pontuacaoGeral = pontuacaoGeral;
        this.jogosVencidos = jogosVencidos;
        this.mao = new MaoDeCarta();
    }

    /**
     * Valor nominal de jogador
     * 
     * @return nome do jogador e seus atributos
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    @Override
    public String toString() {
        return user +", "+pontuacaoGeral+", "+jogosVencidos;
    }   
    

    public void setEstourou(boolean estourou) {
        this.estourou = estourou;
    }

    public boolean isEstourou() {
        return estourou;
    }

    public int getQtdJogadas() {
        return qtdJogadas;
    }

    public void setQtdJogadas(int qtdJogadas) {
        this.qtdJogadas = qtdJogadas;
    }

    public void setJaParou(boolean jaParou) {
        this.jaParou = jaParou;
    }

    public boolean isJaParou() {
        return jaParou;
    }

    public MaoDeCarta getMao() {
        return mao;
    }

    public String getUser() {
        return user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPontuacaoGeral() {
        return pontuacaoGeral;
    }

    public void setPontuacaoGeral(int pontuacaoGeral) {
        this.pontuacaoGeral += pontuacaoGeral;
    }

    public int getJogosVencidos() {
        return jogosVencidos;
    }

    public void setJogosVencidos(int jogosVencidos) {
        this.jogosVencidos += jogosVencidos;
    }
    
    /**
     * Acessa a mão de cartas e printa as cartas que o mesmo tem na mão
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public void mostrarMao() {

        for (int i = 0; i < mao.getContCartas(); i++) {
            System.out.println(mao.getMonte()[i].toString());
        }

    }

}
