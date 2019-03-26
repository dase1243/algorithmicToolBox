package course1.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectingSignatures {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] mass = reader.readLine().split(" ");
            int value1 = Integer.parseInt(mass[0]);
            int value2 = Integer.parseInt(mass[1]);
            pairList.add(new Pair(value1, value2));
        }
        reader.close();
        collectingSignatures(pairList);
    }

    private static void collectingSignatures(List<Pair> pairList) {
        pairList = pairList.stream().sorted((o1, o2) -> {
            if (o1.getRight() > o2.getRight()) {
                return 1;
            } else if (o1.getRight() < o2.getRight()) {
                return -1;
            } else {
                return 0;
            }
        }).collect(Collectors.toList());

        List<Integer> pointList = new ArrayList<>();

        while (pairList.size() != 0) {

            int minRight = pairList.get(0).getRight();
            pointList.add(minRight);
            int i = 0;
            while (i != pairList.size()) {
                int value = pairList.get(i).getRight();
                int key = pairList.get(i).getLeft();

                if (key <= minRight && minRight <= value) {
                    pairList.remove(i);
                    continue;
                }
                i++;
            }
        }

        System.out.println(pointList.size());
        for (Integer integer : pointList) {
            System.out.print(integer + " ");
        }
    }

    static class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }
    }
}
