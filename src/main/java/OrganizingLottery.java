import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//todo: not working
public class OrganizingLottery {
    private static Random random = new Random();

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int i = 0; i < points.length; i++) {
            int point = points[i];
            int l_count = 0;
            int r_count = 0;
            int left_point = starts[0];
            int right_point = ends[0];
            int li = 0;
            int ri = 0;
            while ((left_point < point || right_point < point) && li < starts.length) {
                left_point = starts[li];
                right_point = ends[ri];
                if (left_point <= point) {
                    l_count++;
                }
                if (right_point <= point) {
                    r_count++;
                }
                li++;
                ri++;
            }
            cnt[i] = l_count - r_count;
        }
        //write your code here
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }

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

}

