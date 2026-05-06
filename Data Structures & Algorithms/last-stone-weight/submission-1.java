class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for(int s : stones) {
            queue.offer(s);
        }

        while(queue.size() >= 2) {
            int s1 = queue.poll();
            int s2 = queue.poll();

            if(s1 != s2) {
                queue.offer(Math.abs(s1 - s2));
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
