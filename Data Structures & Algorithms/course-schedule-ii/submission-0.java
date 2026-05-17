class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int index = 0;
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            int course = pre[0], prep = pre[1];

            graph.get(prep).add(course);
            indegrees[course]++;
        }

        Deque<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int finished = 0;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            finished++;
            res[index++] = curr;

            for(int next : graph.get(curr)) {
                indegrees[next]--;

                if(indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return finished == numCourses ? res : new int[0];
    }
}