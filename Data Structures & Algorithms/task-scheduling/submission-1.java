class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;

        if(n == 0) {
            return len;
        }

        int[] counts = new int[26];

        for(char c : tasks) {
            counts[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int count : counts) {
            if(count > 0) {
                maxHeap.offer(count);
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if(!maxHeap.isEmpty()) {
                int count = maxHeap.poll() - 1;

                if(count > 0) {
                    queue.offer(new int[] { count, time + n });
                }
            }

            if(!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}
