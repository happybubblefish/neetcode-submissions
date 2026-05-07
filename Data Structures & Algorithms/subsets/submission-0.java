class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        dfs(res, nums, new ArrayList<>(), 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> temp, int start) {
        res.add(new ArrayList<>(temp));

        for(int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(res, nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
