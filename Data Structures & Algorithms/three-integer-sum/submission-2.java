class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;

            while(left < right) {
                int sum = nums[left] + nums[right];

                if(nums[i] == -sum) {
                    List<Integer> temp = List.of(nums[i], nums[left++], nums[right--]);
                    if(!res.contains(temp)) {
                        res.add(temp);
                    }
                } else if(sum > -nums[i]) {
                    right--;
                    while(right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return res;
    }
}
