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

import blackjack.model.Jogador;
import blackjack.util.Iterador;
import blackjack.util.ListaEncadeada;

/**
 *
 * @author Antonio Neto e Victor César
 */
public class ControllerJogador {

    private ListaEncadeada jogadores;

    public ControllerJogador() {
        jogadores = new ListaEncadeada();
    }

    public ListaEncadeada getJogadores() {
        return jogadores;
    }

    public void setJogadores(ListaEncadeada jogadores) {
        this.jogadores = jogadores;
    }
    
    /**
     * Cadastra um jogador na lista de jogadores, se ele não existir
     * 
     * @param user usuario do jogador
     * @param senha senha do jogador
     * @return true se conseguiu cadastrar, false se o jogador já foi cadastrado
     * 
     * @author Antonio Neto 
     * @author Victor César
     */
    public boolean cadastrarJogador(String user, String senha) {//função de cadastrar jogador
        Jogador novo = new Jogador(user, senha);//jogador que vai ser adicionado, se não for repetido

        if(verifica(user)){
            return false;
        }
        
        jogadores.insereFinal(novo);//adiciona o jogador na lista
        return true;//se o jogador não existir, depois de ser adicionado
    }
    
    /**
     * Itera a lista de jogadores, validando login e senha
     * 
     * @param user usuario do jogador
     * @param senha senha do jogador
     * 
     * @return só retorna false se não encontrar um jogador com usuário e senhas iguais aos digitados
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public boolean login(String user, String senha){
        
        Iterador it = jogadores.iterador();
        
        while(it.temProximo()){
            Jogador aux = (Jogador) it.proximo();

            if (aux.getUser().equals(user) && aux.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;  
        
    }
    
    /**
     * Itera a lista de jogadores, para testar se o jogador existe
     * 
     * @param user usuario do jogador
     * @return true se o jogador existe, false se não
     * 
     * @author Antonio Neto 
     * @author Victor César
     */
    public boolean verifica(String user){
        Iterador it = jogadores.iterador();
        
        while(it.temProximo()){
            Jogador aux = (Jogador) it.proximo();

            if (aux.getUser().equals(user)) {
                return true;
            }
        }
        return false;
    }

}
