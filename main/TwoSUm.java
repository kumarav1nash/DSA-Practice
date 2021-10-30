package main;

import java.util.HashMap;

class TwoSUm {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        // create a hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        // loop through the array
        for (int i = 0; i < nums.length; i++) {
            // if the target - nums[i] is in the map
            if (map.containsKey(target - nums[i])) {
                // return the index of the nums[i] and the index of the target - nums[i]
                return new int[] { map.get(target - nums[i]), i };
            }
            // if not, put the nums[i] and the index in the map
            map.put(nums[i], i);
        }
        // return null if not found
        return null;

    }

}