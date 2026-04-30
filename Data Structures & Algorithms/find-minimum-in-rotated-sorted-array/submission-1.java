class Solution {
    public int findMin(int[] nums) {
        int len = nums.length, left = 0, right = len, mid = 0;

        while(left < right) {
            mid = left + (right - left) / 2;

            if(nums[mid] > nums[len - 1]) {
                left = mid + 1;
            } else if(nums[mid] <= nums[len - 1]) {
                right = mid;
            }
        }

        return nums[left];
    }
}
