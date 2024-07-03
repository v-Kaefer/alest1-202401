import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManipulaDados {
    public static void main(String[] args) throws IOException {
        String pedidosCSV = "alest1-202401/CasosDeTeste/pedidos_pizza_15.csv"; // Local do arquivo a ser manipulado

        // Considerando: Id_Transacao,saborDaPizza,Loja,tempoDePreparo
        

        // Declaração dos Arrays p/ manipulação dos dados
        String[] id = new String[100]; // Alterar para L.L.E.
        String[] saborDaPizza = new String[100];
        String[] instantePedido = new String[100];
        int[] tempoDePreparo = new int[100];
        int contaTransacoes = 0; // Counter to keep track of the number of entries

        try (BufferedReader br = new BufferedReader(new FileReader(pedidosCSV))) {
            String linha;
            boolean pulaPrimeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                // Pula a primeira linha
                if (pulaPrimeiraLinha) { 
                    pulaPrimeiraLinha = false;
                    continue; 
                }

                // Separa os tempoDePreparoes a partir de ","
                String[] fields = linha.split(",");

                // Separando na estrutura: "Id, SaborDaPizza, InstantePedido, TempoDePreparo"
                id[contaTransacoes] = fields[0];
                saborDaPizza[contaTransacoes] = fields[1];
                instantePedido[contaTransacoes] = fields[2];
                tempoDePreparo[contaTransacoes] = Integer.parseInt(fields[3]);
                contaTransacoes++;
            }
        }

        // Print dos dados separados (debugger)
        for (int i = 0; i < contaTransacoes; i++) {
            System.out.println("ID: " + id[i] + ", Month: " + saborDaPizza[i] + ", Region: " + instantePedido[i] + ", Value: " + tempoDePreparo[i]);
        }
    }
}