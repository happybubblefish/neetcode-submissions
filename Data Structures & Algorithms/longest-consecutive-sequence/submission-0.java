class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int currNum = 0;
        int count = 0;

        for(int num : nums) {
            set.add(num);
        }

        for(int num : nums) {
            if(!set.contains(num - 1)) {
                currNum = num;
                count = 1;
            }

            while(set.contains(currNum + 1)) {
                currNum += 1;
                count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
