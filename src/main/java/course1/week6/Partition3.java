package course1.week6;

import java.util.Scanner;


public class Partition3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(canPartitionKSubsets(A, 3) ? 1 : 0);
    }

    private static boolean canPartitionKSubsets(int[] arr, int k) {

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }

        return canPartition(0, arr, new boolean[arr.length], k, 0, sum / k);
    }

    private static boolean canPartition(int iterationStart, int[] arr, boolean[] used, int k,
                                        int inProgressBucketSum, int target) {
        if (k == 1) {
            return true;
        }

        if (inProgressBucketSum == target) {
            return canPartition(0, arr, used, k - 1, 0, target);
        }
        for (int i = iterationStart; i < arr.length; i++) {
            if (!used[i] && inProgressBucketSum + arr[i] <= target) {
                used[i] = true;
                if (canPartition(i + 1, arr, used, k, inProgressBucketSum + arr[i], target)) {
                    return true;
                }
                used[i] = false;
            }
        }

        return false;
    }
}

