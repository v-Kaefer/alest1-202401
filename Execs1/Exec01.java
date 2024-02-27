import java.util.Scanner;
public class Exec01 { //1. Receba um inteiro n e retorne um String com todos os inteiros de 0 até n;
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        int var01;
        System.out.println("Digite um número inteiro: ");
        var01 = input.nextInt();

        for (int controle=0; controle<var01 ; controle++) {
            System.out.print(controle+",");
        }

        System.out.println(var01+".\nFinalizado");
    }
}