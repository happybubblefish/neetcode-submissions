class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length(), left = 0, right = 0, count = 0;

        while(right < len) {
            char ch = s.charAt(right++);

            if(!set.add(ch)) {
                char lc = s.charAt(left);
                
                while(lc != ch) {
                    set.remove(lc);
                    lc = s.charAt(++left);
                }

                left++;
            }

            count = Math.max(count, right - left);
        }

        return count;
    }
}
