package course1.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {
    //    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        List<Integer> searchList = Arrays.stream(reader.readLine().split(" ")).skip(1).map(Integer::parseInt).collect(Collectors.toList());
//        List<Integer> findList = Arrays.stream(reader.readLine().split(" ")).skip(1).map(Integer::parseInt).collect(Collectors.toList());
//
//        reader.close();
//
//        List<Integer> indexes = findList.stream().map(integer -> course1.week4.BinarySearch.findIndex(searchList, integer)).collect(Collectors.toList());
//
//        for (Integer e : indexes) {
//            System.out.print(e + " ");
//        }
//    }
//
//    private static int findIndex(List<Integer> searchList, int num) {
//        int l = 0;
//        int r = searchList.size() - 1;
//
//        while (l <= r) {
//            int index = (r + l) / 2;
//            int mid = searchList.get(index);
//            if (mid == num) {
//                return index;
//            } else if (mid > num) {
//                r = index - 1;
//            } else {
//                l = index + 1;
//            }
//        }
//        return -1;
//    }
    static int binarySearch(int[] a, int x) {
        int left = 0;
        int right = a.length;
        //write your code here
        while (left < right) {
            int index = (right + left) / 2;
            int mid = a[index];
            if (mid == x) {
                return index;
            } else if (mid > x) {
                right = index;
            } else {
                left = index + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
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
