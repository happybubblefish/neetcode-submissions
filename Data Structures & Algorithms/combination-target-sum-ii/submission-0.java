class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        dfs(res, candidates, new ArrayList<>(), 0, target);

        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, List<Integer> temp, int start, int target) {
        if(target == 0 && !res.contains(temp)) {
            res.add(new ArrayList<>(temp));
        }

        if(target < 0) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) continue;

            temp.add(candidates[i]);
            dfs(res, candidates, temp, i + 1, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
