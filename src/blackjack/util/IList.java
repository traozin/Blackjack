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

/**
 *
 * @author Antonio Neto e Victor César
 */
public interface IList {
    
    /**
     * Testa se a lista está vazia 
     * 
     * @return true se está vazia, false se não estiver
     * @author Antonio Neto
     * @author Victor César
     */
    public boolean estaVazia();

    /**
     * Mostra o tamanho da lista
     * 
     * @return o tamanho da lista
     * @author Antonio Neto
     * @author Victor César
     */
    public int tamanho();
    
    /**
     * Insere no inicio da Lista Encadeada
     * 
     * @param o
     * @author Antonio Neto
     * @author Victor César
     */
    public void insereInicio(Object o);
    
    /**
     * Insere no final da Lista Encadeada
     * 
     * @param o 
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public void insereFinal(Object o);
    
    /**
     * Remove um objeto do inicio da Lista Encadeada
     * 
     * @return o objeto removido
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public Object removeInicio();

    /**
     * Remove um objeto do final da Lista Encadeada
     * 
     * @return o objeto removido
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public Object removeUltimo();

    /**
     * Recupera um objeto no indice passado como parâmetro
     * 
     * @param index do objeto na lista encadeada
     * @return o objeto no indice especificado
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public Object recupera(int index);
    
    /**
     * Cria um iterador para essa Lista Encadeada
     * 
     * @return um novo iterador, apontando para o início da lista
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public Iterador iterador();
}
