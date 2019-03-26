package course1.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFueling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int destination = Integer.parseInt(reader.readLine());
        int maxRange = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        String[] mass = reader.readLine().split(" ");
        List<Integer> stopList = new ArrayList<>();
        stopList.add(0);
        stopList.addAll(Arrays.stream(mass).map(Integer::parseInt).collect(Collectors.toList()));
        reader.close();

        System.out.println(carFueling(destination, maxRange, stopList));
    }

    private static int carFueling(int destination, int maxRange, List<Integer> stopList) {
        int stops = 0;
        int n = stopList.size();
        for (int i = 0; i < n;) {
            int currentPosition = stopList.get(i);
            if(currentPosition + maxRange >= destination) {
                return stops;
            }
            int range = currentPosition + maxRange;
            while(i + 1 < n && stopList.get(i + 1) <= range) {
                i++;
            }
            if(stopList.get(i) == currentPosition) {
                return -1;
            }
            else {
                stops ++;
            }

        }
        return 0;
    }
}
