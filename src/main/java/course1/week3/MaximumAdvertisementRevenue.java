package course1.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumAdvertisementRevenue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] massFee = reader.readLine().split(" ");
        List<Integer> feeList = Arrays.stream(massFee).map(Integer::parseInt).collect(Collectors.toList());

        String[] massClicks = reader.readLine().split(" ");
        List<Integer> clickList = Arrays.stream(massClicks).map(Integer::parseInt).collect(Collectors.toList());

        reader.close();

        System.out.println(maximumAdvertisementRevenue(feeList, clickList));
    }

    private static int maximumAdvertisementRevenue(List<Integer> feeList, List<Integer> clickList) {
        feeList.sort(Integer::compareTo);
        clickList.sort(Integer::compareTo);
        int total = 0;
        for (int i = 0; i < feeList.size(); i++) {
            total += feeList.get(i) * clickList.get(i);
        }
        return total;
    }
}
