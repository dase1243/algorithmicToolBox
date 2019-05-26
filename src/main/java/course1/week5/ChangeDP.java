package course1.week5;

import java.util.Scanner;

public class ChangeDP {

    private static int getChange(int m) {
        //write your code here
        int[] mass = new int[m + 1];
        int i = 1;

        while (i <= m) {
            int ex1 = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                ex1 = mass[i - 1] + 1;
            }

            int ex3 = Integer.MAX_VALUE;
            if (i - 3 >= 0) {
                ex3 = mass[i - 3] + 1;
            }

            int ex4 = Integer.MAX_VALUE;
            if (i - 4 >= 0) {
                ex4 = mass[i - 4] + 1;
            }
            int min = Math.min(ex1, Math.min(ex3, ex4));

            if(mass[i] == 0 || min < mass[i]) {
                mass[i] = min;
            }
            i++;
        }
        return mass[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

