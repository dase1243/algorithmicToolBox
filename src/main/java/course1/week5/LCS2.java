package course1.week5;

import java.util.Scanner;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int m = a.length;
        int n = b.length;
        int[][] D = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    D[i][j] = 0;
                } else if (a[i - 1] == b[j - 1]) {
                    D[i][j] = 1 + D[i - 1][j - 1];
                } else {
                    D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
                }
            }
        }

        return D[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

