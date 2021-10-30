package main;

class RotatedBinarySearch2 {
    public static void main(String[] args) {
        int[] rotated = { 4, 5, 0, 1, 2, 3 };
        int target = 1;
        System.out.println(rotatedBinarySearch(rotated, target));
    }

    // write a recursive function that takes a rotated sorted array and a target
    // value and returns the index of the target value
    // if the target value is not found, return -1
    public static int rotatedBinarySearch(int[] array, int target) {
        return rotatedBinarySearch(array, target, 0, array.length - 1);
    }

    private static int rotatedBinarySearch(int[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (array[start] <= array[mid]) {
            if (target >= array[start] && target < array[mid]) {
                return rotatedBinarySearch(array, target, start, mid - 1);
            } else {
                return rotatedBinarySearch(array, target, mid + 1, end);
            }
        } else {
            if (target > array[mid] && target <= array[end]) {
                return rotatedBinarySearch(array, target, mid + 1, end);
            } else {
                return rotatedBinarySearch(array, target, start, mid - 1);
            }
        }
    }

}