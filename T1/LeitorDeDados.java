import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorDeDados {
    

    static String[] headerMeses = {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ\n"};


    public static void getMeses () { // Print do "Header" com os meses
        for (String mes : headerMeses) {
            System.out.print("\t" + mes);
        }
    }



    public static void main(String[] args) {

        getMeses();
        ReadFile();
        
        
    }


    public static void ReadFile () {
    try {
      File myObj = new File("T1/Dados/transacoes_00020.csv");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println("\t"+data);
      }
      myReader.close();
        } catch (FileNotFoundException e) {
      System.out.println("Erro, arquivo não encontrado.");
      e.printStackTrace();
      }
    }


}

