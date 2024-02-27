import java.util.Scanner;
public class Exec03 {//3. Receba um número e retorne true se este número for primo, false caso contrário;
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        int var01;
        System.out.println("Digite um número inteiro: ");
        var01 = input.nextInt();

        System.out.println("O número "+var01+" é primo? " + isPrimo(var01));
    }

    public static boolean isPrimo (double num) {
        if (num < 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) { // Enquanto a raiz quadrada do número for menor ou igual a i
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
