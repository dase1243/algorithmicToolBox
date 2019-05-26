package course1.week5;

import java.util.Scanner;

class EditDistance {

    public static int EditDistance(String s, String t) {
        //write your code here
        if ("".equals(s)) {
            return t.length();
        }
        if ("".equals(t)) {
            return s.length();
        }

        int t_length = t.length();
        int s_length = s.length();
        int[][] D = new int[s_length + 1][t_length + 1];

        for (int i = 0; i < s_length + 1; i++) {
            for (int j = 0; j < t_length + 1; j++) {
                if (i == 0 || j == 0) {
                    D[i][j] = i + j;
                } else {
                    int insert = D[i - 1][j] + 1;
                    int delete = D[i][j - 1] + 1;
                    int match = D[i - 1][j - 1];
                    int mismatch = D[i - 1][j - 1] + 1;
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        D[i][j] = Math.min(insert, Math.min(delete, match));
                    } else {
                        D[i][j] = Math.min(insert, Math.min(delete, mismatch));
                    }
                }
            }
        }
        return D[s_length][t_length];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }

}
