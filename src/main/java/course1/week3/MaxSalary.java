package course1.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSalary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] massFee = reader.readLine().split(" ");
        List<Integer> numList = Arrays.stream(massFee).map(Integer::parseInt).collect(Collectors.toList());

        reader.close();

        System.out.println(maxSalary(numList));
    }

    private static String maxSalary(List<Integer> numList) {
        List<Integer> collect = numList.stream().sorted((o1, o2) -> {
            String[] o1Mass = String.valueOf(o1).split("");
            String[] o2Mass = String.valueOf(o2).split("");
            int length1 = o1Mass.length;
            int length2 = o2Mass.length;
            int o1i = 0;
            int o2i = 0;
            while (o1i != length1 || o2i != length2) {
                if (Integer.parseInt(o1Mass[o1i]) < Integer.parseInt(o2Mass[o2i])) {
                    return 1;
                } else if (Integer.parseInt(o1Mass[o1i]) > Integer.parseInt(o2Mass[o2i])) {
                    return -1;
                }
                o1i++;
                o2i++;
                if (o1i == length1 && o2i < length2) {
                    o1i = 0;
                } else if (o1i < length1 && o2i == length2) {
                    o2i = 0;
                }
            }
            return 0;
        }).collect(Collectors.toList());
        String concatination = "";
        for (Integer entry : collect) {
            concatination += entry.toString();
        }
        return concatination;
    }
}
