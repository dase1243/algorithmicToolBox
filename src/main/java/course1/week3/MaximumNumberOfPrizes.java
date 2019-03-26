package course1.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumNumberOfPrizes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.close();

        List<Integer> list = maximumNumberOfPrizes(n);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    private static List<Integer> maximumNumberOfPrizes(int n) {
        int places = 0;
        List<Integer> candyList = new ArrayList<>();
        int i = 1;
        if (n == 1 || n == 2) {
            System.out.println(1);
            return Collections.singletonList(n);
        }
        while (n != 0) {
            if (n < i) {
                candyList.set(i - 2, candyList.get(i - 2) + n);
                System.out.println(places);
                return candyList;
            } else {
                candyList.add(i);
                n -= i;
                i++;
            }
            places++;
        }
        System.out.println(places);
        return candyList;
    }
}
