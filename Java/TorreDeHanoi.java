import java.util.Scanner;

public class TorreDeHanoi {

    public static void imprime(int[][] tab, int fil, int col, int ultNum) {

        for (int c = col - 1; c >= 0; c--) {

            for (int f = 0; f < fil; f++) {

                int esp = (ultNum - tab[f][c]) / 2;

                // Espaço à esquerda

                for (int i = 0; i < esp; i++) {

                    System.out.print(" ");

                }

                for (int i = 0; i < tab[f][c]; i++) {

                    System.out.print("8");

                }

                // Espaço à direita

                for (int i = 0; i < esp; i++) {

                    System.out.print(" ");

                }

                System.out.print("\t");

            }

            System.out.println();

        }

    }

    public static void moveDisco(int[][] tab, int fil, int col, int ultNum, int filOrig, int filDest) {

        int cO = col - 1;

        int cD = col - 1;

        while (cO >= 0 && tab[filOrig][cO] == 0) {

            cO--;

        }

        if (cO < 0) {

            cO = 0;

        }

        while (cD >= 0 && tab[filDest][cD] == 0) {

            cD--;

        }

        tab[filDest][cD + 1] = tab[filOrig][cO];

        tab[filOrig][cO] = 0;

        imprime(tab, fil, col, ultNum);

    }

    public static void hanoi(int[][] tab, int fil, int col, int disc, int ultNum, int O, int A, int D) {

        if (disc == 1) {

            clearScreen();

            moveDisco(tab, fil, col, ultNum, O, D);

            sleep(600);

        } else {

            hanoi(tab, fil, col, disc - 1, ultNum, O, D, A);

            clearScreen();

            moveDisco(tab, fil, col, ultNum, O, D);

            sleep(600);

            hanoi(tab, fil, col, disc - 1, ultNum, A, O, D);

        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fil = 3;

        int col;

        int[][] tabuleiro;

        int disc = 1;

        int ultNum;

        System.out.println("Torre de Hanoi - Pericles Borges");

        System.out.print("Indique o número de discos: ");

        col = scanner.nextInt();

        tabuleiro = new int[fil][col];

        for (int f = 0; f < fil; f++) {

            for (int c = col - 1; c >= 0; c--) {

                if (f == 0) {

                    tabuleiro[f][c] = disc;

                    disc += 2;

                } else {

                    tabuleiro[f][c] = 0;

                }

            }

        }

        ultNum = disc;

        clearScreen();

        imprime(tabuleiro, fil, col, ultNum);

        sleep(600);

        hanoi(tabuleiro, fil, col, col, ultNum, 0, 1, 2);

    }

    

    public static void clearScreen() {

        // Limpa a tela do console

        System.out.print("\033[H\033[2J");

        System.out.flush();

    }

    public static void sleep(int milliseconds) {

        // Aguarda um determinado tempo em milissegundos

        try {

            Thread.sleep(milliseconds);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

}

