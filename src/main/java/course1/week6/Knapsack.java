package course1.week6;

import java.util.Scanner;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int[][] D = new int[w.length + 1][W + 1];
        for (int j = 0; j < w.length + 1; j++) {
            for (int i = 0; i < W + 1; i++) {
                if (i == 0 || j == 0) {
                    D[j][i] = 0;
                } else {
                    if (w[j - 1] > i) {
                        D[j][i] = D[j - 1][i];
                    } else {
                        D[j][i] = Math.max(D[j - 1][i], D[j - 1][i - w[j - 1]] + w[j - 1]);
                    }
                }
            }
        }
        return D[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

