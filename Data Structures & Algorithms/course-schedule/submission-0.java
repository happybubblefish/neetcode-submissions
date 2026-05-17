class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prep = pre[1];

            graph.get(prep).add(course);
            indegrees[course]++;
        }

        Deque<Integer> queue = new LinkedList<>();
        int finishes = 0;

        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            finishes++;

            for(int next : graph.get(curr)) {
                indegrees[next]--;

                if(indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return finishes == numCourses;
    }
}
