class Solution {
    public int maxArea(int[] heights) {
        int len = heights.length, max = 0, left = 0, right = len - 1;

        while(left < right) {
            int lh = heights[left], rh = heights[right];

            max = Math.max(max, (right - left) * Math.min(lh, rh));

            if(lh <= rh) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
