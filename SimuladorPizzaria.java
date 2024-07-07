import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimuladorPizzaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arquivo = "CasosDeTeste/pedidos_pizza_1000.csv"; // Substitua pelo caminho correto do arquivo
        FilaPedidos filaPedidos = new FilaPedidos();
        FilaPedidos filaEspera = new FilaPedidos();
        FilaPedidos filaProntos = new FilaPedidos();
        ABP abp = new ABP();

        // Processar a simulação
        String[] titulos = {"Instante de Tempo t", "Fila de pedidos", "Em produção", "Prontos"};
        StringBuilder csvData = new StringBuilder();

        // Carregar pedidos do arquivo CSV
        carregarPedidos(arquivo, filaPedidos);

        int tempoAtual = 0;
        int tempoTotal = 0;
        int pedidosProcessados = 0;
        Pedido pedidoEmProducao = null;
        int tempoRestante = 0;

        while (!filaPedidos.estaVazia() || pedidoEmProducao != null) {
            System.out.println("Instante de Tempo t=" + tempoAtual);
            String input = sc.nextLine();

            if (!filaPedidos.estaVazia()) {
                Pedido proximoPedido = filaPedidos.verProximo();
                if (proximoPedido.instante == tempoAtual) {
                    if (pedidoEmProducao == null) {
                        pedidoEmProducao = filaPedidos.desenfileirar();
                        tempoRestante = pedidoEmProducao.preparo;
                        System.out.println("Pedido em produção: " + pedidoEmProducao.codigo);
                    } else {
                        System.out.println("Pedido adicionado à fila de espera: " + proximoPedido.codigo);
                        filaEspera.enfileirar(proximoPedido);
                    }
                }
            }

            // Processa as ordens em produção ou espera baseado no instante
            if (pedidoEmProducao != null && tempoRestante > 0) {
                tempoRestante--;
                if (tempoRestante == 0) {
                    // Completa a ordem e atualiza o CSV
                    System.out.println("Pedido pronto: " + pedidoEmProducao.codigo);
                    abp.inserir(pedidoEmProducao);
                    pedidosProcessados++;
                    tempoTotal = tempoAtual;

                    // Atualiza o CSV
                    csvData.append(tempoAtual).append("|");
                    csvData.append(getIdsPizzas(filaPedidos)).append("|");
                    csvData.append(pedidoEmProducao.codigo).append("|");
                    csvData.append(getIdsPizzas(filaProntos)).append("\n");

                    // Move a próxima ordem da fila de espera para em produção, se disponível
                    if (!filaEspera.estaVazia()) {
                        pedidoEmProducao = filaEspera.desenfileirar();
                        tempoRestante = pedidoEmProducao.preparo;
                        System.out.println("Pedido em produção: " + pedidoEmProducao.codigo);
                    } else {
                        pedidoEmProducao = null;
                    }
                }
            }


            if (input.equalsIgnoreCase("C")) {
                while (!filaPedidos.estaVazia() || pedidoEmProducao != null) {
                    // Simulação contínua
                    if (pedidoEmProducao == null && !filaPedidos.estaVazia()) {
                        pedidoEmProducao = filaPedidos.desenfileirar();
                        tempoRestante = pedidoEmProducao.preparo;
                        System.out.println("Produzindo pedido: " + pedidoEmProducao.codigo);
                    }


                    if (!filaPedidos.estaVazia()) {
                        Pedido proximoPedido = filaPedidos.verProximo();
                        if (proximoPedido.instante == tempoAtual) {
                            if (pedidoEmProducao == null) {
                                pedidoEmProducao = filaPedidos.desenfileirar();
                                tempoRestante = pedidoEmProducao.preparo;
                                System.out.println("Pedido em produção: " + pedidoEmProducao.codigo);
                            } else {
                                System.out.println("Pedido adicionado à fila de espera: " + proximoPedido.codigo);
                                filaEspera.enfileirar(proximoPedido);
                            }
                        }
                    }

                    if (pedidoEmProducao != null) {
                        tempoRestante--;
                        if (tempoRestante == 0) {
                            System.out.println("Pedido pronto: " + pedidoEmProducao.codigo);
                            abp.inserir(pedidoEmProducao);
                            filaProntos.enfileirar(pedidoEmProducao);
                            pedidosProcessados++;
                            tempoTotal = tempoAtual;

                            // Move as ordens completas para "Prontos"
                            csvData.append(tempoAtual).append("|");
                            csvData.append(getIdsPizzas(filaPedidos)).append("|");
                            csvData.append(pedidoEmProducao.codigo).append("|");
                            csvData.append(getIdsPizzas(filaProntos)).append("\n");

                            // Verifica se a filaEspera está vazia
                            if (!filaEspera.estaVazia()) {
                                pedidoEmProducao = filaEspera.desenfileirar();
                                tempoRestante = pedidoEmProducao.preparo;
                                System.out.println("Pedido em produção: " + pedidoEmProducao.codigo);
                            } else {
                                pedidoEmProducao = null;
                            }
                        }
                    }
                    
                    if (pedidoEmProducao != null && tempoRestante == 0) {
                        filaProntos.enfileirar(pedidoEmProducao);
                    }

                    csvData.append(tempoAtual).append("|");
                    csvData.append(getIdsPizzas(filaPedidos)).append("|");
                    csvData.append(pedidoEmProducao != null ? pedidoEmProducao.codigo : 0).append("|");
                    csvData.append(getIdsPizzas(filaProntos)).append("\n");

                    tempoAtual++;
                }
            } else {
                // Passo a passo
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
                
                if (pedidoEmProducao != null && tempoRestante == 0) {
                    filaProntos.enfileirar(pedidoEmProducao);
                }
                csvData.append(tempoAtual).append("|");
                csvData.append(getIdsPizzas(filaPedidos)).append("|");
                csvData.append(pedidoEmProducao != null ? 1 : 0).append("|");
                csvData.append(getIdsPizzas(filaProntos)).append("\n");

                tempoAtual++;
            }
        }

        System.out.println("Total de pedidos processados: " + pedidosProcessados);
        System.out.println("Total de tempo executado: " + tempoTotal);
        System.out.print("Pedidos em ordem: ");
        abp.emOrdem();
        // Escreve o arquivo CSV
        escreverCSV("Simulação.csv", titulos, csvData.toString().split("\n"));
        
    }

    private static void carregarPedidos(String arquivo, FilaPedidos filaPedidos) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean pulaPrimeiraLinha = true;
            while ((linha = br.readLine()) != null) {
                // Pula a primeira linha
                if (pulaPrimeiraLinha) { 
                    pulaPrimeiraLinha = false;
                    continue; 
                }
                String[] dados = linha.split(";");
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

    private static void escreverCSV(String arquivo, String[] titulos, String[] dados) {
        try (FileWriter escritor = new FileWriter(arquivo)) {
            // Escrever os títulos
            for (String titulo : titulos) {
                escritor.append(titulo);
                escritor.append(" | ");
            }
            escritor.append("\n");

            // Escrever os dados
            for (String dado : dados) {
                escritor.append(dado.replace(";" , " | "));
                escritor.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getIdsPizzas (FilaPedidos fila) {
        StringBuilder ids = new StringBuilder();
        NodoFila atual = fila.getInicio();
        while (atual != null) {
            ids.append(atual.pedido.codigo).append(" ");
            atual = atual.proximo;
        }
        return ids.toString().trim();
    }

}