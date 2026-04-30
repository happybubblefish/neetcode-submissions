class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length, left = 0, right = len, mid = 0;

        while(left < right) {
            mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > nums[len - 1]) {
                if(nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return -1;
    }
}
