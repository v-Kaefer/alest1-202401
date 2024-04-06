public class Main {
    public static void main(String[] args) {

        // Tem que implementar um loop para a matrizVendas, receber os valores finais de cada mês

        // Matriz de vendas
        int[][] matrizVendas = {
                {0, 448, 0, 0, 0, 0, 0, 0, 0, 188, 0, 0},
                {0, 0, 996, 0, 0, 0, 0, 704, 0, 0, 0, 563},
                {0, 200, 0, 0, 0, 0, 0, 0, 0, 0, 407, 0},
                {0, 0, 0, 0, 0, 0, 5570, 0, 300, 0, 0, 0}
        };

        // Nome dos meses
        String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};

        // Nome das filiais [Nordeste tem que ficar abreviado pra manter o espaçamento certo]
        String[] filiais = {"Matriz", "Filial Sul", "Filial Norte", "F. Nordeste"};

        // Imprimi os cabeçalhos dos meses
        System.out.print("\t    ");
        for (String mes : meses) {
            System.out.printf("%4s ", mes);
        }
        System.out.println();

        // Encontrar o maior valor da matriz
        int maiorValor = Integer.MIN_VALUE;
        for (int[] linha : matrizVendas) {
            for (int valor : linha) {
                if (valor > maiorValor) {
                    maiorValor = valor;
                }
            }
        }
        int tamanhoMaximo = String.valueOf(maiorValor).length();

        // Imprimir dados da matriz de vendas
        for (int i = 0; i < matrizVendas.length; i++) {
            System.out.printf("%-12s", filiais[i]);
            for (int j = 0; j < matrizVendas[i].length; j++) {
                System.out.printf("%" + tamanhoMaximo + "d ", matrizVendas[i][j]);
            }
            System.out.println();
        }
    }
}
