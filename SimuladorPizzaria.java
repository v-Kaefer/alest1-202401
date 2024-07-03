import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimuladorPizzaria {
    public static void main(String[] args) {
        String arquivo = "pedidos_pizza_15.csv"; // Substitua pelo caminho correto do arquivo
        FilaPedidos filaPedidos = new FilaPedidos();
        ABP abp = new ABP();

        // Carregar pedidos do arquivo CSV
        carregarPedidos(arquivo, filaPedidos);

        // Processar a simulação
        int tempoAtual = 0;
        int tempoTotal = 0;
        int pedidosProcessados = 0;
        Pedido pedidoEmProducao = null;
        int tempoRestante = 0;

        while (!filaPedidos.estaVazia() || pedidoEmProducao != null) {
            System.out.println("Instante de Tempo t=" + tempoAtual);

            if (pedidoEmProducao == null && !filaPedidos.estaVazia()) {
                pedidoEmProducao = filaPedidos.desenfileirar();
                tempoRestante = pedidoEmProducao.preparo;
                System.out.println("Produzindo pedido: " + pedidoEmProducao.codigo);
            }

            if (pedidoEmProducao != null) {
                tempoRestante--;
                if (tempoRestante == 0) {
                    System.out.println("Pedido pronto: " + pedidoEmProducao.codigo);
                    abp.inserir(pedidoEmProducao);
                    pedidosProcessados++;
                    tempoTotal = tempoAtual;
                    pedidoEmProducao = null;
                }
            }

            tempoAtual++;
        }

        System.out.println("Total de pedidos processados: " + pedidosProcessados);
        System.out.println("Total de tempo executado: " + tempoTotal);
        System.out.print("Pedidos em ordem: ");
        abp.emOrdem();
    }

    private static void carregarPedidos(String arquivo, FilaPedidos filaPedidos) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                int codigo = Integer.parseInt(dados[0]);
                String sabor = dados[1];
                int instante = Integer.parseInt(dados[2]);
                int preparo = Integer.parseInt(dados[3]);
                Pedido pedido = new Pedido(codigo, sabor, instante, preparo);
                filaPedidos.enfileirar(pedido);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
