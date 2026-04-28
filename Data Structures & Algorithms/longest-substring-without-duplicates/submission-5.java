class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length(), left = 0, right = 0, count = 0;

        while(right < len) {
            char ch = s.charAt(right++);

            while(set.contains(ch)) {
                set.remove(s.charAt(left++));
            }

            set.add(ch);

            count = Math.max(count, right - left);
        }

        return count;
    }
}
