class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        int lenS = s.length(), lenT = t.length(), left = 0, right = 0, count = lenT, minLen = Integer.MAX_VALUE, start = 0;

        for(char c : t.toCharArray()) {
            freq[c]++;
        }

        while(right < lenS) {
            char ch = s.charAt(right++);

            if(freq[ch] > 0) {
                count--;
            }

            freq[ch]--;

            while(count == 0) {
                if(right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lc = s.charAt(left++);

                if(freq[lc] >= 0) {
                    count++;
                }

                freq[lc]++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
