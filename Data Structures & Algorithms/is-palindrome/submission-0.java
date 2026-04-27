class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length(), left = 0, right = len - 1;

        while(left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if(Character.isLetterOrDigit(l) && Character.isLetterOrDigit(r)) {
                if(Character.toLowerCase(l) == Character.toLowerCase(r)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            } else if(!Character.isLetterOrDigit(l)) {
                left++;
            } else {
                right--;
            }
        }

        return true;
    }
}
