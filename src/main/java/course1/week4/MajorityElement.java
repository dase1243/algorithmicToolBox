package course1.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        List<Integer> searchList = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        reader.close();

        System.out.println(majorityElement(searchList));
    }

    private static int majorityElement(List<Integer> searchList) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int integer: searchList) {
            if(map.containsKey(integer)) {
                map.replace(integer, map.get(integer) + 1);
            } else {
                map.put(integer, 1);
            }
        }
        for (Integer integer: map.values()) {
            if(integer > searchList.size() / 2) {
                return 1;
            }
        }
        return 0;
    }

}
