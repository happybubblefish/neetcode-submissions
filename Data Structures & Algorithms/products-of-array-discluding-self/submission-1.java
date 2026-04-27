class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] fwd = new int[len], rev = new int[len], res = new int[len];
        fwd[0] = nums[0];
        rev[len - 1] = nums[len - 1];

        for(int i = 1, j = len - 2; i < len && j >= 0; i++, j--) {
            fwd[i] = nums[i] * fwd[i - 1];
            rev[j] = nums[j] * rev[j + 1];
        }

        res[0] = rev[1];
        res[len - 1] = fwd[len - 2];

        for(int i = 1; i < len - 1; i++) {
            res[i] = fwd[i - 1] * rev[i + 1];
        }

        return res;
    }
}  
