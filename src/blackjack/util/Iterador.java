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
public interface Iterador {
    
    /**
     * Testa se tem um proximo objeto na lista
     * 
     * @return true se for verdade, e false se o proximo objeto for nulo
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public boolean temProximo();

    /**
     * Retorna o proximo objeto e atualiza o cursor para um proximo teste
     * 
     * @return o "proximo" objeto
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public Object proximo();

}
