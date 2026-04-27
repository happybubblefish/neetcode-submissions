class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(int key : map.keySet()) {
            queue.offer(key);

            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[] res = new int[queue.size()];

        for(int i = 0; i < res.length; i++) {
            res[i] = queue.poll();
        }

        return res;
    }
}
