class TimeMap {

    Map<String, List<String[]>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<String[]> values = map.getOrDefault(key, new ArrayList<>());
        values.add(new String[] { String.valueOf(timestamp), value });

        map.put(key, values);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }

        List<String[]> values = map.get(key);
        int left = 0, right = values.size(), mid = 0;

        while(left < right) {
            mid = left + (right - left) / 2;
            String[] mVal = values.get(mid);
            int t = Integer.parseInt(mVal[0]);

            if(t > timestamp) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left == 0 ? "" : values.get(left - 1)[1];
    }
}
