class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int len1 = s1.length(), len2 = s2.length(), left = 0, right = 0, count = len1;

        for(char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        while(right < len2) {
            char ch = s2.charAt(right++);

            if(freq[ch - 'a'] > 0) {
                count--;
            }

            freq[ch - 'a']--;

            while(right - left > len1) {
                char lc = s2.charAt(left++);

                if(freq[lc - 'a'] >= 0) {
                    count++;
                }

                freq[lc - 'a']++;
            }

            if(count == 0) {
                return true;
            }
        }

        return false;
    }
}
