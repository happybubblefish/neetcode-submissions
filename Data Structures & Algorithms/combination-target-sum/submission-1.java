class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        dfs(res, nums, new ArrayList<>(), 0, target);

        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> temp, int start, int target) {
        if(target == 0 && !res.contains(temp)) {
            res.add(new ArrayList<>(temp));
        }

        if(target < 0) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(res, nums, temp, i, target - nums[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
