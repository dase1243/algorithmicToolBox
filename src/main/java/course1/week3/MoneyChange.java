package course1.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoneyChange {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] mass = reader.readLine().split(" ");
        int n = Integer.parseInt(mass[0]);
        reader.close();
        System.out.println(moneyChange(n));
    }

    private static int moneyChange(int n) {
        int count = 0;
        while (n != 0) {
            if (n >= 10) {
                n -= 10;
                count++;
            } else if (n >= 5) {
                n -= 5;
                count++;
            } else {
                n -= 1;
                count++;
            }
        }
        return count;
    }
}
