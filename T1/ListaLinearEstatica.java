public class ListaLinearEstatica {
    private int capacidade;
    private int tamanho;
    private String[] itens;

    public ListaLinearEstatica() {
        tamanho = 0; // dos objetos no array
        capacidade = 5; // do array
        itens = new String[capacidade];
    }

    public void adicionar(String item) {
        if (tamanho == capacidade) {
            dobraCapacidadeDaLista();
        }
        itens[tamanho] = item;
        tamanho++;
    }

    private void dobraCapacidadeDaLista() {
        int novaCapacidade = capacidade * 2;
        String[] aumentaLista = new String[novaCapacidade];

        for (int i = 0; i < tamanho; i++) { // Copia os elementos da lista antiga para a nova 
            aumentaLista[i] = itens[i];
        }

        itens = aumentaLista; // Atualiza a referência da lista antiga para apontar para a nova lista 
        capacidade = novaCapacidade; 
    }

    public void imprimir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(i + " - " + itens[i]);
        }
    }

    public static void main(String[] args) {
        ListaLinearEstatica lista = new ListaLinearEstatica();
        lista.adicionar("A");
        lista.adicionar("B");
        lista.adicionar("C");
        lista.adicionar("D");
        lista.adicionar("E");
        lista.adicionar("F"); // Dobrará a capacidade antes de adicionar "F"
        lista.adicionar("teste");
        lista.imprimir();
    }
}
