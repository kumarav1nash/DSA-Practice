package main;

public class SplitArray {

    private static int findMaxAfterMSplit(int[] arr, int m) {

        int minValue = findMax(arr);
        int maxValue = findSum(arr);

        // so the idea is to find the max value of the array after m splits
        // so we can do binary search on this
        while (minValue < maxValue) {
            int mid = minValue + (maxValue - minValue) / 2;
            if (canSplit(arr, m, mid)) {
                maxValue = mid;
            } else {
                minValue = mid + 1;
            }
        }
        return maxValue;

    }

    private static boolean canSplit(int[] arr, int m, int mid) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > mid) {
                sum = arr[i];
                count++;
            }
        }
        return count <= m;
    }

    private static int findSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}
