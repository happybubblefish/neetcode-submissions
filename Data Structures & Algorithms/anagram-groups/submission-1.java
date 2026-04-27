class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            int[] arr = new int[26];

            for(char c : s.toCharArray()) {
                arr[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(arr[i]);
            }

            String str = sb.toString();

            if(!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }

            map.get(str).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
