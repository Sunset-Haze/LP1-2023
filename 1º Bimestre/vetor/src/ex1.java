import java.util.Scanner;
public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nomes = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o nome" + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }

        exibirNomes(nomes);

        for (int i = 0; i < 4; i++) {
            System.out.print("Digite um número inteiro de 1 a 20: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            String nome = obterNome(opcao, nomes);
            System.out.println(nome);
        }

        double[][] contas = new double[4][4];
        for (int i = 0; i < 3; i++) {
            System.out.print("Digite um número" + (i + 1) + ": ");
            double numero = scanner.nextDouble();

            contas[0][i + 1] = numero;
            contas[i + 1][0] = numero;

            contas[i + 1][i + 1] = numero * numero;

            contas[i + 1][3] = numero - contas[0][3];
            contas[3][i + 1] = numero - contas[3][0];

            contas[1][i + 1] = numero - contas[0][i + 1];
            contas[i + 1][1] = numero * contas[i + 1][0];

            contas[2][i + 1] = numero * numero;
            contas[i + 1][2] = numero * numero;
        }

        exibirMatriz(contas);

        scanner.close();
    }

    public static void exibirNomes(String[] nomes){
        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);
        }
    }

    public static String obterNome(int opcao, String[] nomes){
        if (opcao == 1){
            return nomes[0];
        }
        else if (opcao >= 2 && opcao <= 10) {
            return nomes[1];

        }
        else if (opcao > 10) {
            return nomes[2];
        }
        else{
            return "Opção inválida!";
        }
    }

    public static void exibirMatriz(double[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
