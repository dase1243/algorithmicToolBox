package course1.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LastDigitOfLargeFibonacciNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println(lastDigitOfLargeFibonacciNumber(n));
    }

    private static long lastDigitOfLargeFibonacciNumber(int n) {
        int mod = 60;

        List<Long> sequence = new ArrayList<>();
        sequence.add(0L);
        sequence.add(1L);

        for (int i = 2; i <= n % mod; i++) {
            sequence.add(sequence.get(i - 1) + sequence.get(i - 2));
        }
        return sequence.get(n % mod) % 10;
    }
}
