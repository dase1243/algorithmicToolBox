package course1.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreatestCommonDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] mass = reader.readLine().split(" ");
        reader.close();

        long a = Long.parseLong(mass[0]);
        long b = Long.parseLong(mass[1]);

//        System.out.println(euclidGCD(a, b));
        System.out.println(LCD(a, b));

    }

    private static long euclidGCD(long a, long b) {
        if (b > a) {
            long c = a;
            a = b;
            b = c;
        }
        while (a % b != 0) {
            long c = b;
            b = a % b;
            a = c;
        }
        return b;
    }

    private static long LCD(long a, long b) {
        long c = euclidGCD(a, b);
        return a * b / c;
    }

}
