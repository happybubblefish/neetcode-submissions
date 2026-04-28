class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int len = s.length(), left = 0, right = 0, maxFreq = 0, res = 0;

        while(right < len) {
            char ch = s.charAt(right++);
            freq[ch - 'A']++;

            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            while(right - left - maxFreq > k) {
                freq[s.charAt(left++) - 'A']--;
            }

            res = Math.max(res, right - left);
        }

        return res;
    }
}
