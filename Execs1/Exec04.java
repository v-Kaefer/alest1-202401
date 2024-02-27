import java.util.Scanner;
public class Exec04 {//4. Receba dois inteiros e retorne um array com todos os primos entre estes números.
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        int var01, var02, controleRangeMin, controleRangeMax;
        System.out.println("Digite o primeiro número inteiro: ");
        var01 = input.nextInt();
        System.out.println("Digite o segundo número inteiro: ");
        var02 = input.nextInt();


        if (var01-var02 < var02-var01) {
            controleRangeMin = var02-var01; // Começo do Array 
            controleRangeMax = var02;      // Máximo do Array
        } else {
            controleRangeMin = var01 - var02;
            controleRangeMax = var01;
        }

        int [] arrayRestrito = new int[controleRangeMax+1];
        int controleArray = controleRangeMin;

        do {
            arrayRestrito[controleArray] = controleRange;
            System.out.println(arrayRestrito[controleArray]);
            controleArray = controleArray + 1;

        } while (controleRangeMin <= controleRangeMax);
        System.out.println("Fim");

    }

}