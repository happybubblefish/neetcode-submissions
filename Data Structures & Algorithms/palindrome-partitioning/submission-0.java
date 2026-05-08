class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        dfs(res, s, new ArrayList<>(), 0);

        return res;
    }

    private void dfs(List<List<String>> res, String s, List<String> temp, int start) {
        if(start == s.length()) {
            res.add(new ArrayList<>(temp));
        }

        for(int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);

            if(isValid(sub)) {
                temp.add(sub);
                dfs(res, s, temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
