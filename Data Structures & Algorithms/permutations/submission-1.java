class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, nums, new ArrayList<>());

        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> temp) {
        if(nums.length == temp.size()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])) continue;

            temp.add(nums[i]);
            dfs(res, nums, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
