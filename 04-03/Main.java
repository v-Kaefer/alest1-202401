import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;
        System.out.println("Defina quantas ocorrências: ");
        n = input.nextInt();
        System.out.print(alg_01(n));
    }
    public static int alg_02(int n) {
        int operacoes = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                operacoes++;
        return operacoes;
    }
    public static int alg_01 (int n) {
        int operacoes = 0;
        for (int i = 0; i < n; i++) {
            operacoes++;
            System.out.print(operacoes + "\n");
        }
        operacoes = 3*operacoes+3;
        return operacoes;
    }
}