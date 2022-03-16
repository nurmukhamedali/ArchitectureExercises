import java.util.Scanner;

class Color {
    String c, m, y, k;
}

public class Executer {
    static Color[][] memory;
    static String[] cache;
    static int n, m, k;
    static int hit = 0, miss = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        inputValue();

        cache = new String[k];
        memory = new Color[n][m];
        System.out.println(cache[0]);
        createMatrix();

        System.out.println("Choose algorithm(1 - 2)");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                f1();
                break;
            case 2:
                f2();
                break;
        }

        result();

        sc.close();
    }

    static void inputValue() {
        System.out.println("Enter N: ");
        n = sc.nextInt();
        System.out.println("Enter M: ");
        m = sc.nextInt();
        System.out.println("Enter K: ");
        k = sc.nextInt();
    }

    static void createMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memory[i][j] = new Color();
                memory[i][j].c = Integer.toString(i) + Integer.toString(j) + 'c';
                memory[i][j].m = Integer.toString(i) + Integer.toString(j) + 'm';
                memory[i][j].y = Integer.toString(i) + Integer.toString(j) + 'y';
                memory[i][j].k = Integer.toString(i) + Integer.toString(j) + 'k';
            }
        }
    }

    static void f1() {

        int index = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                for (int l = 0; l < 4; l++) {

                    if ((l == 0 && String.valueOf(cache[index]).equals(memory[i][j].c)) ||
                        (l == 1 && String.valueOf(cache[index]).equals(memory[i][j].m)) ||
                        (l == 2 && String.valueOf(cache[index]).equals(memory[i][j].y)) ||
                        (l == 3 && String.valueOf(cache[index]).equals(memory[i][j].k)))
                        hit++;
                    else {
                        miss++;
                        fillCache(index, i, j, l);
                    }

                    index++;
                    if (index == k) {
                        index = 0;
                    }
                }
            }
        }

    }

    static void f2() {

        int index = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                for (int l = 0; l < 4; l++) {

                    if ((l == 0 && String.valueOf(cache[index]).equals(memory[j][i].c)) ||
                            (l == 1 && String.valueOf(cache[index]).equals(memory[j][i].m)) ||
                            (l == 2 && String.valueOf(cache[index]).equals(memory[j][i].y)) ||
                            (l == 3 && String.valueOf(cache[index]).equals(memory[j][i].k)))
                        hit++;
                    else {
                        miss++;
                        fillCache(index, i, j, l);
                    }

                    index++;
                    if (index == k) {
                        index = 0;
                    }
                }
            }
        }

    }

    static void fillCache(int index, int posX, int posY, int posColor) {
        while (index < k) {
            switch (posColor) {
                case 0:
                    cache[index++] = memory[posX][posY].c;
                    posColor++;
                    break;
                case 1:
                    cache[index++] = memory[posX][posY].m;
                    posColor++;
                    break;
                case 2:
                    cache[index++] = memory[posX][posY].y;
                    posColor++;
                    break;
                case 3:
                    cache[index++] = memory[posX][posY].k;
                    posColor++;
                    break;
                case 4:
                    posColor = 0;
                    posY++;
                    break;
            }

            if (posY == m){
                posY = 0;
                posX++;
            }

            if (posX == n){
                posX = 0;
            }
        }
    }

    static void result() {
        System.out.println("The total number of accesses: " + (hit + miss));
        System.out.println("The number of hits: " + hit);
        System.out.println("The number of misses: " + miss);
        System.out.println("The hit rate "  + (double)(hit) / (double)(hit + miss));
        System.out.println("The miss rate " + (double)(miss) / (double)(hit + miss));
    }

    static void showMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(memory[i][j].c + " " + memory[i][j].m + " " + memory[i][j].y + " " + memory[i][j].k + " ");
            }
            System.out.println();
        }
    }
}