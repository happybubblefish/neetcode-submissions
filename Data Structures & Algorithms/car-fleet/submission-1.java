class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] cars = new int[len][2];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Deque<int[]> stack = new LinkedList<>();

        for(int i = 0; i < position.length; i++) {
            cars[i] = new int[] { position[i], speed[i] };
            queue.offer(cars[i]);
        }

        while(!queue.isEmpty()) {
            int[] car = queue.poll();

            if(stack.isEmpty()) {
                stack.push(car);
            } else {
                int[] prev = stack.peek();

                Double currTime = 1.0 * (target - car[0]) / car[1];
                Double prevTime = 1.0 * (target - prev[0]) / prev[1];

                if(currTime.compareTo(prevTime) > 0) {
                    stack.push(car);
                }
            }
        }

        return stack.size();
    }
}
