class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while(i < str.length()) {
            int j = i;

            while(str.charAt(j) != '#') {
                j++;
            }

            Integer len = Integer.valueOf(str.substring(i, j));
            j++;
            String s = str.substring(j, j + len);
            res.add(s);
            i = j + len;
        }
        
        return res;
    }
}
