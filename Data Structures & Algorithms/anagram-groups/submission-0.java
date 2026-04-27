class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String str = new String(chs);
            List<String> temp = new ArrayList<>();


            if(map.containsKey(str)) {
                temp = map.get(str);
            } else {
                map.put(str, temp);
            }

            temp.add(s);
        }

        return new ArrayList<>(map.values());
    }
}
