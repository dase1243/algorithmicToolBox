package course1.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sum {
    private static void findMaxMultiplication(List<Long> list) {
        long max = Integer.MIN_VALUE;
        int maxIndex = 0;
        long secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            long elem = list.get(i);
            if (elem > max) {
                secondMax = max;
                max = elem;
                maxIndex = i;
            }
            if (elem > secondMax && maxIndex != i) {
                secondMax = elem;
            }
        }
        System.out.println(max * secondMax);
    }

    private static void findMaxMultiplicationBySort(List<Long> list) {
        list.sort(Long::compareTo);
        System.out.println(list.get(list.size() - 1) * list.get(list.size() - 2));
    }


    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add((long) scanner.nextInt());
        }
        findMaxMultiplicationBySort(list);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
