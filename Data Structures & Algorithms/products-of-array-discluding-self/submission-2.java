class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] fwd = new int[len], rev = new int[len], res = new int[len];
        fwd[0] = 1;
        rev[len - 1] = 1;

        for(int i = 1; i < len; i++) {
            fwd[i] = fwd[i - 1] * nums[i - 1];
        }

        for(int j = len - 2; j >= 0; j--) {
            rev[j] = rev[j + 1] * nums[j + 1];
        }

        for(int i = 0; i < len; i++) {
            res[i] = fwd[i] * rev[i];
        }

        return res;
    }
}  
