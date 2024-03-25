import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManipulaDados {
    public static void main(String[] args) throws IOException {
        String arquivoCSV = "T1/Dados/transacoes_00020.csv"; // Local do arquivo a ser manipulado

        // Considerando: Id_Transacao,Mes,Loja,Valor

        // Declaração dos Arrays p/ manipulação dos dados
        String[] id_Transacao = new String[100]; // Alterar para L.L.E.
        String[] mes = new String[100];
        String[] loja = new String[100];
        int[] valor = new int[100];
        int contaTransacoes = 0; // Counter to keep track of the number of entries



                /*  Precisar ter uma verificação da ocorrência da filial, para puxar os Meses e valores.
            Para os valores, precisar ter uma comparação com todos os números dos meses, ou seja,
            precisa ter uma L.L. Encadeada para cada mês de determinada filial (mesmo que temp),
            então, separar os 3 maiores valores do ano e o mês com menor valor.
            
            # Três meses com mais vendas
            mesesMaisVendas [] = {Mes,Valor,Mes,Valor,Mes,Valor};
            
            # Mês com menor venda: (caso ocorrer empate mostrar o mês menos recente)
            mesMenosVendas [] = {Mes, Valor};
            
            # Média de vendas por transação
            mediaDeVendasPorTransacao = ArrayComSomaDosValores [] / counterTransacoes();

            verificaMaiorValor ()
            counterTransacoes ()
            verificaMenorValor ()
            mesMenosRecente ()
        */



        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            boolean pulaPrimeiraLinha = true;

            while ((linha = br.readLine()) != null) {

                if (pulaPrimeiraLinha) { // Pula a primeira linha
                    pulaPrimeiraLinha = false;
                    continue; 
                }

                // Separa os valores a partir de ","
                String[] fields = linha.split(",");

                // Separando na estrutura: "Id_Transacao, Mes, Loja, Valor"
                id_Transacao[contaTransacoes] = fields[0];
                mes[contaTransacoes] = fields[1];
                loja[contaTransacoes] = fields[2];
                valor[contaTransacoes] = Integer.parseInt(fields[3]);
                contaTransacoes++;
            }
        }

        // Print dos dados separados (debugger)
        for (int i = 0; i < contaTransacoes; i++) {
            System.out.println("ID: " + id_Transacao[i] + ", Month: " + mes[i] + ", Region: " + loja[i] + ", Value: " + valor[i]);
        }
    }
}
