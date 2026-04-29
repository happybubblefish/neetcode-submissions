class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] cars = new int[len][2];

        for(int i = 0; i < len; i++) {
            cars[i] = new int[] { position[i], speed[i] };
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Deque<int[]> stack = new LinkedList<>();

        for(int[] car : cars) {
            if(stack.isEmpty()) {
                stack.push(car);
            } else {
                int[] prev = stack.peek();
                Double currTime = (double)(target - car[0]) / car[1];
                Double prevTime = (double)(target - prev[0]) / prev[1];

                if(currTime.compareTo(prevTime) > 0) {
                    stack.push(car);
                }
            }
        }

        return stack.size();
    }
}
