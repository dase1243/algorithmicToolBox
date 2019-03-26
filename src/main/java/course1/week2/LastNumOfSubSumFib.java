package course1.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastNumOfSubSumFib {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] mass = reader.readLine().split(" ");
        long n = Long.parseLong(mass[0]);
        long m = Long.parseLong(mass[1]);
        reader.close();

        System.out.println(lastNumOfSubSumFib(n, m));
    }

    private static long lastNumOfSubSumFib(long n, long m) {
        int mod = 60;
        int sumOfLastNums = 0;
        for (long i = n % mod; i <= m % mod; i++) {
            sumOfLastNums += anyModuloOfFibNum(i, 10);
        }
        return sumOfLastNums % 10;
    }

    @SuppressWarnings("Duplicates")
    private static long anyModuloOfFibNum(long n, long mod) {
        long remainder = n % getPisanoPeriod(mod);

        long first = 0;
        long second = 1;

        long res = remainder;

        for (int i = 1; i < remainder; i++) {
            res = (first + second) % mod;
            first = second;
            second = res;
        }

        return res % mod;
    }

    private static long getPisanoPeriod(long m) {
        long a = 0;
        long b = 1;
        long c;
        for (int i = 0; i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1) return i + 1;
        }
        return 0;
    }
}
