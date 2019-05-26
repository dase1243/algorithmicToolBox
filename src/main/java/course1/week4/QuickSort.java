package course1.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class QuickSort {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
        //write your code here
        int[] left = new int[r - l + 1];
        int[] right = new int[r - l + 1];
        int[] center = new int[r - l + 1];
        int pivot = a[l];
        int l_count = 0;
        int r_count = 0;
        int c_count = 1;
        center[0] = pivot;
        int i = l + 1;
        while (i <= r) {
            if (pivot > a[i]) {
                left[l_count] = a[i];
                l_count++;
            } else if (pivot < a[i]) {
                right[r_count] = a[i];
                r_count++;
            } else {
                center[c_count] = a[i];
                c_count++;
            }
            i++;
        }
        int j = 0;
        while (l_count > j || c_count > j || r_count > j) {
            if (l_count > j) {
                a[l + j] = left[j];
            }
            if (c_count > j) {
                a[l + j + l_count] = center[j];
            }
            if (r_count > j) {
                a[l + j + l_count + c_count] = right[j];
            }
            j++;
        }

        int m1 = l + l_count - 1;
        int m2 = l + l_count + c_count;
        int[] m = {m1, m2};
        return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0]);
        randomizedQuickSort(a, m[1], r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
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

