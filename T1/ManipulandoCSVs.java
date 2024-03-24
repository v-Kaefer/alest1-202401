import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManipulandoCSVs {
    public static void main(String[] args) {
        String csvFile = "example.csv"; // Replace with the path to your CSV file



        // Considerando: Id_Transacao,Mes,Loja,Valor

        // Manipulação de dados em Arrays. Alterar para Lista Linear Encadeada (Dinâmica)
        String[] id_transacoes = new String[100];
        String[] nomes = new String[100]; 
        String[] meses = new String[100]; 
        int[] valores = new int[100]; 
        int count = 0; // Counter to keep track of the number of entries


        /*  Precisar ter uma verificação da ocorrência da filial, para puxar os Meses e valores.
            Para os valores, precisar ter uma comparação com todos os números dos meses, ou seja,
            precisa ter uma L.L. Encadeada para cada mês de determinada filial (mesmo que temp),
            então, separar os 3 maiores valores do ano e o mês com menor valor.
            # Três meses com mais vendas
            Março 996
            Ago 704
            Fev 648
            # Mês com menor venda: (caso ocorrer empate mostrar o mês menos recente)
            Jan 0
            # Média de vendas por transação
            433,6
        */ 






        try (FileReader fileReader = new FileReader(csvFile);
             BufferedReader br = new BufferedReader(fileReader)) {

            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into fields based on the comma delimiter
                String[] fields = line.split(",");
                
                // Assuming the structure of each line is: "name;month;value"
                String name = fields[2];
                String month = fields[1];
                int value = Integer.parseInt(fields[3]);

                // Store the parsed data into arrays
                names[count] = name;
                months[count] = month;
                values[count] = value;
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the parsed data (just for demonstration)
        for (int i = 0; i < count; i++) {
            System.out.println("Name: " + names[i] + ", Month: " + months[i] + ", Value: " + values[i]);
        }
    }
}
