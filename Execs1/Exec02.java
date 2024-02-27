public class Exec02 { //2. Receba um inteiro n e retorne um array com todos os inteiros de 0 até n;
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        int var01, controleArray = 0;
        System.out.println("Digite um número inteiro: ");
        var01 = input.nextInt();
        int [] arrayInts = new int[var01+1];

        for (int controle=0; controle<=var01; controle++) {
            arrayInts[controle] = controle;
            System.out.println(arrayInts[controle]);
        }
        System.out.println("Fim");
    }
}