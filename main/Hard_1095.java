package main;

class MountainArray {
    int[] arr;

    public MountainArray(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        return arr[index];
    }

    public int length() {
        return arr.length;
    }
}

class Hard_1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int ans = -1;
        int peakIdx = getPeak(mountainArr);
        if (mountainArr.get(peakIdx) == target) {
            ans = peakIdx;
        }
        System.out.println(ans);
        // look for 0 to peak-1
        if (ans == -1) {
            ans = _binarySearch(mountainArr, target, peakIdx - 1, true);
        }
        System.out.println(ans);
        // look for peak+1 to right
        if (ans == -1) {
            ans = _binarySearch(mountainArr, target, peakIdx + 1, false);
        }
        System.out.println(ans);
        return ans;
    }

    private static int getPeak(MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int _binarySearch(MountainArray mountainArr, int target, int centerIdx, boolean isAsc) {

        if (isAsc) {
            int left = 0;
            int right = centerIdx;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mountainArr.get(mid) == target) {
                    return mid;
                } else if (mountainArr.get(mid) > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        } else {
            int left = centerIdx;
            int right = mountainArr.length() - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mountainArr.get(mid) == target) {
                    return mid;
                } else if (mountainArr.get(mid) > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return -1;

    }

}