class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26], freq2 = new int[26];

        int len1 = s1.length(), len2 = s2.length(), left = 0, right = 0;

        for(char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        while(right < len2) {
            char ch = s2.charAt(right++);
            int index = ch - 'a';
            
            if(freq1[ch - 'a'] == 0) {
                left = right;
                freq2 = new int[26];
                continue;
            }

            freq2[index]++;

            while(right - left > len1) {
                freq2[s2.charAt(left++) - 'a']-- ;
            }

            if(checkFreq(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }

    private boolean checkFreq(int[] freq1, int[] freq2) {
        for(int i = 0; i < 26; i++) {
            if(freq1[i] != 0 && freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}
