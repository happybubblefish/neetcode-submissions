class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length, left = 0, right = len, mid = 0;

        while(left < right) {
            mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return -1;
    }
}
