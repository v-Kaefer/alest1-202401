// Classe Pedido para representar cada pedido
public class Pedido {
    public int codigo;
    public String sabor;
    public int instante;
    public int preparo;

    public Pedido(int codigo, String sabor, int instante, int preparo) {
        this.codigo = codigo;
        this.sabor = sabor;
        this.instante = instante;
        this.preparo = preparo;
    }
}

// Classe NodoABP para representar cada no na Arvore Binaria de Pesquisa
class NodoABP {
    public Pedido pedido;
    public NodoABP esquerda;
    public NodoABP direita;

    public NodoABP(Pedido pedido) {
        this.pedido = pedido;
        this.esquerda = null;
        this.direita = null;
    }
}

// Classe ABP para gerenciar a Arvore Binaria de Pesquisa
class ABP {
    private NodoABP raiz;

    public ABP() {
        this.raiz = null;
    }

    public void inserir(Pedido pedido) {
        this.raiz = inserirRecursivo(this.raiz, pedido);
    }

    private NodoABP inserirRecursivo(NodoABP nodo, Pedido pedido) {
        if (nodo == null) {
            nodo = new NodoABP(pedido);
        } else if (pedido.codigo < nodo.pedido.codigo) {
            nodo.esquerda = inserirRecursivo(nodo.esquerda, pedido);
        } else {
            nodo.direita = inserirRecursivo(nodo.direita, pedido);
        }
        return nodo;
    }

    public void emOrdem() {
        emOrdemRecursivo(this.raiz);
    }

    private void emOrdemRecursivo(NodoABP nodo) {
        if (nodo != null) {
            emOrdemRecursivo(nodo.esquerda);
            System.out.print(nodo.pedido.codigo + " ");
            emOrdemRecursivo(nodo.direita);
        }
    }
}

// Classe FilaPedidos para gerenciar a fila de pedidos
class FilaPedidos {
    private NodoFila inicio;
    private NodoFila fim;
    private int tamanho;

    public FilaPedidos() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void enfileirar(Pedido pedido) {
        NodoFila novoNodo = new NodoFila(pedido);
        if (this.fim == null) {
            this.inicio = novoNodo;
        } else {
            this.fim.proximo = novoNodo;
        }
        this.fim = novoNodo;
        this.tamanho++;
    }

    public Pedido desenfileirar() {
        if (this.inicio == null) {
            return null;
        }
        Pedido pedido = this.inicio.pedido;
        this.inicio = this.inicio.proximo;
        if (this.inicio == null) {
            this.fim = null;
        }
        this.tamanho--;
        return pedido;
    }

    public boolean estaVazia() {
        return this.inicio == null;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public NodoFila getInicio() {
        return this.inicio;
    }

    public Pedido verProximo() {
        if (this.inicio == null) {
            return null;
        }
        return this.inicio.pedido;
    }
}

// Classe NodoFila para representar cada nodo na fila
class NodoFila {
    public Pedido pedido;
    public NodoFila proximo;

    public NodoFila(Pedido pedido) {
        this.pedido = pedido;
        this.proximo = null;
    }
}
