import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {

        char[][] tabuleiro = new char[3][3];
        int vez = 1;
        char jogador = 'X';

        inicializarTabuleiro(tabuleiro);

        while (true) {

            exibirTabuleiro(tabuleiro);

            System.out.println("Jogador " + jogador + " é sua vez.");

            int linha = obterLinha();
            int coluna = obterColuna();

            if (jogadaValida(tabuleiro, linha, coluna)) {
                realizarJogada(tabuleiro, linha, coluna, jogador);
                if (verificarVencedor(tabuleiro, jogador)) {
                    exibirTabuleiro(tabuleiro);
                    System.out.println("Jogador " + jogador + " venceu!");
                    break;
                }
                if (verificarEmpate(tabuleiro)) {
                    exibirTabuleiro(tabuleiro);
                    System.out.println("O jogo terminou em empate.");
                    break;
                }
                vez++;
                jogador = vez % 2 == 0 ? 'O' : 'X';
            } else {
                System.out.println("Jogada inválida, tente novamente.");
            }
        }
    }

    public static void inicializarTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public static void exibirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print("|" + tabuleiro[i][j]);
            }
            System.out.println("|");
            System.out.println("-------");
        }
    }

    public static int obterLinha() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a linha da jogada (1, 2 ou 3): ");
        int linha = scanner.nextInt();
        return linha - 1;
    }

    public static int obterColuna() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a coluna da jogada (1, 2 ou 3): ");
        int coluna = scanner.nextInt();
        return coluna - 1;
    }

    public static boolean jogadaValida(char[][] tabuleiro, int linha, int coluna) {
        if (linha >= 0 && linha < tabuleiro.length && coluna >= 0 && coluna < tabuleiro[linha].length) {
            if (tabuleiro[linha][coluna] == ' ') {
                return true;
            }
        }
        return false;
    }

    public static void realizarJogada(char[][] tabuleiro, int linha, int coluna, char jogador) {
        tabuleiro[linha][coluna] = jogador;
    }

    public static boolean verificarVencedor(char[][] tabuleiro, char jogador) {
        // Verificar linhas
        for (int i = 0; i < tabuleiro.length; i++) {
            if (        tabuleiro[i][0] == jogador &&
            tabuleiro[i][1] == jogador &&
            tabuleiro[i][2] == jogador) {
        return true;
        }
    }

    // Verificar colunas
    for (int j = 0; j < tabuleiro[0].length; j++) {
        if (tabuleiro[0][j] == jogador &&
                tabuleiro[1][j] == jogador &&
                tabuleiro[2][j] == jogador) {
            return true;
        }
    }

    // Verificar diagonais
    if (tabuleiro[0][0] == jogador &&
            tabuleiro[1][1] == jogador &&
            tabuleiro[2][2] == jogador) {
        return true;
    }
    if (tabuleiro[0][2] == jogador &&
            tabuleiro[1][1] == jogador &&
            tabuleiro[2][0] == jogador) {
        return true;
    }

    return false;
    }

    public static boolean verificarEmpate(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == ' ') {
                return false;
                }
            }
        }
    return true;
    }
}

