package course1.week6;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PlacingParentheses {
    static private long[][] m;
    static private long[][] M;

    private static long getMaximValue(String exp) {
        //write your code here
        if (exp.length() == 1) {
            return Long.parseLong(exp);
        }

        int[] numbers = IntStream.range(0, exp.length()).filter(i -> i % 2 == 0).map(exp::charAt).map(Character::getNumericValue).toArray();
        char[] ops = new char[(exp.length() - 1) / 2];

        int j = 0;
        for (int i = 1; i < exp.length(); i += 2) {
            ops[j] = exp.charAt(i);
            j++;
        }
        m = new long[numbers.length][numbers.length];
        M = new long[numbers.length][numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            m[i][i] = numbers[i];
            M[i][i] = numbers[i];
        }
        for (int i = 1; i < numbers.length; i++) {
            j = i;
            int k = 0;
            while (j != numbers.length) {
                long[] minMax = minMax(k, j, ops);
                m[k][j] = minMax[0];
                M[k][j] = minMax[1];
                j++;
                k++;
            }
        }
        return M[0][numbers.length - 1];
    }

    private static long[] minMax(int i, int j, char[] ops) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int k = i; k < j; k++) {
            long a = eval(M[i][k], M[k + 1][j], ops[k]);
            long b = eval(M[i][k], m[k + 1][j], ops[k]);
            long c = eval(m[i][k], M[k + 1][j], ops[k]);
            long d = eval(m[i][k], m[k + 1][j], ops[k]);

            min = Math.min(Math.min(a, b), Math.min(c, Math.min(d, min)));
            max = Math.max(Math.max(a, b), Math.max(c, Math.max(d, max)));
        }
        return new long[]{min, max};
    }

    private static long eval(long a, long b, long op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

