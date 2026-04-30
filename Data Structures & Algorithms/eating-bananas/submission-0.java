class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int len = piles.length, left = 1, right = piles[len - 1], mid = 0;

        while(left < right) {
            mid = left + (right - left) / 2;

            if(helper(piles, mid) > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int helper(int[] piles, int num) {
        int res = 0;

        for(int p : piles) {
            res += Math.ceilDiv(p, num);
        }

        return res;
    }
}
