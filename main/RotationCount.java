package main;

class RotationCount {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 6, 7, 1, 2 };

        System.out.println(rotationCount(arr));
    }

    private static int rotationCount(int[] arr) {
        int pIdx = findPivot(arr);
        return pIdx + 1;
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

}