package main;

public class RotatedBinarySearch {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        if (pivot == -1) {
            return findTarget(nums, target, 0, nums.length - 1);

        } else {
            if (nums[pivot] == target) {
                return pivot;
            }
            int a = findTarget(nums, target, 0, pivot - 1);
            if (a == -1) {
                return findTarget(nums, target, pivot + 1, nums.length - 1);
            }
            return a;
        }

    }

    private static int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid < right && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > left && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            if (nums[mid] <= nums[left]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }

    private static int findTarget(int[] nums, int target, int left, int right) {

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
