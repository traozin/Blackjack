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

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Antonio Neto e Victor César
 */
public class ListaEncadeada implements IList, Serializable {

    private Node first;//referência para o primeiro elemento
    private Node last;//referência para o ultimo elemento
    private int cont;//contador da lista

    public ListaEncadeada() {
        this.first = null;//inicializado com null (lista está vazia)
        this.last = null;//inicializado com null(lista está vazia)
        this.cont = 0;//incializado com 0, não existe nenhum elemento
    }

    @Override
    public boolean estaVazia() {//testa se a lista tá vazia
        return (this.first == null);
    }

    @Override
    public int tamanho() {//retorna o tamanho da lista, que é inicializado com zero e incrementado e decrementado de acordo com as adições e remoções
        return cont;
    }

    @Override
    public void insereInicio(Object o) {//método de inserir no inicio
        Node novoNode = new Node(o);//novo nó

        if (this.estaVazia()) {//testa se está vazia
            this.last = novoNode;//se estiver vazia, o ultimo no também vai ser o primeiro
        }
        novoNode.setProx(this.first);//adiciona o nó no inicio
        this.first = novoNode;
        this.cont++;//incrementa o contador
    }

    @Override
    public void insereFinal(Object o) {//método de inserir no final
        Node novoNode = new Node(o);//novo nó

        if (this.estaVazia()) {//se a lista está vazia, o primeiro nó também vai ser o ultimo
            this.first = novoNode;
        } else {
            this.last.setProx(novoNode);//se tiver elementos, o ultimo nó aponta para o novo
        }
        this.last = novoNode;//e logo em seguida, se torna o ultimo
        this.cont++;// incrementa o contador
    }

    @Override
    public Object removeInicio() {
        Node aux = this.first;//nó que vai ser removido

        if (estaVazia()) {
            return null;//se estiver vazia, não tem nada para remover
        } else {
            if (this.cont == 1) {
                this.first = this.last = null;//se tiver apenas 1 elemento, o vai apagar o ultimo e o primeiro
            } else {
                this.first = this.first.getProx();//se tiver mais de um, só vai perder a referência do primeiro
            }
        }

        this.cont--;//decrementa o contador
        return aux.dados;//retorna os dados do mesmo
    }

    @Override
    public Object removeUltimo() {
        Node aux = this.first;//variável que vai ser usada para percorrer até chegar ao penúltimo
        Node removido = this.last;//o nó que vai ser removido

        if (estaVazia()) {
            return null;//se estiver vazia, não tem nada pra remover
        } else {
            if (this.cont == 1) {
                this.first = this.last = null;//se tiver apenas um elemento, o primeiro e o ultimo(mesmo node) serão apagados
            } else {
                while (aux.prox != this.last) {//percorrendo a lista até chegar no penúltimo
                    aux = aux.getProx();
                }
                this.last = aux;//dizendo que o penúltimo agora é o último
                this.last.setProx(null);//perdendo a referência do antigo último
            }
        }
        this.cont--;//decrementando contador
        return removido.dados;// devolvendo os dados do antigo último
    }

    @Override
    public Object recupera(int index) {
        Node atual = this.first;//variável que será usada para percorrer a lista

        if (estaVazia()) {
            return null;//se estiver vazia, não tem nada para recuperar
        } else {
            if (index == 0) {
                return this.first.dados;//se o indice for 0, significa que o usuário quer a primeira posição da lista
            } else {
                for (int i = 0; i < index; i++) {
                    atual = atual.getProx();//vai percorrer a lista "n" vezes até achar o node que está no indice passado como parâmetro
                }
            }
        }

        return atual.dados;//retorna os dados de atual, no lugar onde parou

    }

    @Override
    public Iterador iterador() {
        return new IteradorLista(this.first);//só retorna um iterador do tipo IteradorLista(classe aninhada da lista)
    }
    

    public class Node {//classe aninhada de lista

        private Object dados;//dados do node
        private Node prox;//referência para o proximo node

        public Node(Object dados) {
            this.dados = dados;//obriga à ter os dados na hora de criar o node
            this.prox = null;//e seta o proximo do node, para null, pois ele não está sendo inserido na lista, nesse momento
        }

        public Object getDados() {
            return dados;
        }

        public void setDados(Object dados) {
            this.dados = dados;
        }

        public Node getProx() {
            return prox;
        }

        public void setProx(Node prox) {
            this.prox = prox;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Node other = (Node) obj;
            if (!Objects.equals(this.dados, other.dados)) {
                return false;
            }
            return true;
        }

    }

    public class IteradorLista implements Iterador {

        private Node cur;

        public IteradorLista(Node cabeca) {
            this.cur = cabeca;
        }

        @Override
        public boolean temProximo() {
            return cur != null;//verifica se tem o proximo, se o cursor não é null
        }

        @Override
        public Object proximo() {
            Node aux = cur;//se o cursor não é null, passa o conteudo que está no cursor
            cur = cur.getProx();//avança o cursor
            return aux.dados;//e depois passa os dados do cursor
        }

    }

}
