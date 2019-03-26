package course1.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxLootValue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] mass = reader.readLine().split(" ");
        int n = Integer.parseInt(mass[0]);
        int capacity = Integer.parseInt(mass[1]);
        Map<Double, Double> priceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mass = reader.readLine().split(" ");
            double value = Integer.parseInt(mass[0]);
            double weight = Integer.parseInt(mass[1]);
            double ratio = value / weight;
            if (priceMap.get(ratio) != null) {
                priceMap.replace(ratio, priceMap.get(ratio) + weight);
            } else {
                priceMap.put(ratio, weight);
            }
        }
        reader.close();
        System.out.println(maxLootValue(capacity, priceMap));
    }

    private static double maxLootValue(int capacity, Map<Double, Double> priceMap) {
        priceMap = priceMap.entrySet().stream()
                .sorted((o1, o2) -> {
                    if (o1.getKey() < o2.getKey()) {
                        return 1;
                    } else if (o1.getKey() > o2.getKey()) {
                        return -1;
                    } else {
                        return 0;
                    }
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        double sum = 0;
        for (Map.Entry<Double, Double> entry : priceMap.entrySet()) {
            if (entry.getValue() <= capacity) {
                capacity -= entry.getValue();
                sum += (entry.getKey() * entry.getValue());
            } else if (capacity != 0) {
                sum += (entry.getKey()) * capacity;
                capacity = 0;
            }
        }
        return sum;
    }

}
