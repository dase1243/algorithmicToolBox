package course1.week3;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CollectingSignatures {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Pair<Integer, Integer>> pairList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] mass = reader.readLine().split(" ");
            int value1 = Integer.parseInt(mass[0]);
            int value2 = Integer.parseInt(mass[1]);
            pairList.add(new Pair(value1, value2));
        }
        reader.close();
        System.out.println(collectingSignatures(pairList));
    }

    private static int collectingSignatures(List<Pair<Integer, Integer>> pairList) {
        List<Integer> points = new ArrayList<>();
        pairList.stream().sorted((o1, o2) -> {
            if (o1.getKey() > o2.getKey()) {
                return 1;
            } else if (o1.getKey() < o2.getKey()) {
                return -1;
            } else {
                return 0;
            }
        });
        int pointsNum = 0;
        for (int j = 0; j < pairList.size(); j++) {
            int currentPoint = 0;
            int left = pairList.get(j).getKey();
            int right = pairList.get(j).getKey();
//            for (int i = pairList.get(j).getKey(); i <= pairList.get(i).getValue(); i++) {
            for (int k = j + 1; k < pairList.size(); k++) {
                if (left <= pairList.get(k).getKey() && pairList.get(k).getKey() <= right) {
//                    currentPoint = k
                }
            }
//            }
        }
        return 0;
    }
}
