package course1.week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<>();
        int[] mass = new int[n + 1];
        for (int i = 1; i < mass.length; i++) {
            mass[i] = mass[i - 1] + 1;
            if (i % 2 == 0)
                mass[i] = Math.min(1 + mass[i / 2], mass[i]);
            if (i % 3 == 0)
                mass[i] = Math.min(1 + mass[i / 3], mass[i]);
        }
        int i = n;
        while (i > 1) {
            sequence.add(i);
            if (mass[i - 1] == mass[i] - 1)
                i = i - 1;
            else if (i % 2 == 0 && (mass[i / 2] == mass[i] - 1))
                i = i / 2;
            else if (i % 3 == 0 && (mass[i / 3] == mass[i] - 1))
                i = i / 3;
        }
        sequence.add(1);
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

