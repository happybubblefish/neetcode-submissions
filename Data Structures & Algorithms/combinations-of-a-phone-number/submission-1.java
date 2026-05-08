class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits == null || digits.length() == 0) {
            return res;
        }

        Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

        dfs(res, map, digits, new StringBuilder(), 0);

        return res;
    }

    private void dfs(List<String> res, Map<Character, String> map, String digits, StringBuilder sb, int start) {
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        char d = digits.charAt(start);
        String s = map.get(d);

        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(res, map, digits, sb, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
