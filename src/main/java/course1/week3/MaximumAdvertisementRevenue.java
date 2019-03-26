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

        long n = Long.parseLong(reader.readLine());

        String[] massFee = reader.readLine().split(" ");
        List<Long> feeList = Arrays.stream(massFee).map(Long::parseLong).collect(Collectors.toList());

        String[] massClicks = reader.readLine().split(" ");
        List<Long> clickList = Arrays.stream(massClicks).map(Long::parseLong).collect(Collectors.toList());

        reader.close();

        System.out.println(maximumAdvertisementRevenue(feeList, clickList));
    }

    private static long maximumAdvertisementRevenue(List<Long> feeList, List<Long> clickList) {
        feeList.sort(Long::compareTo);
        clickList.sort(Long::compareTo);
        long total = 0;
        for (int i = 0; i < feeList.size(); i++) {
            total += feeList.get(i) * clickList.get(i);
        }
        return total;
    }
}
