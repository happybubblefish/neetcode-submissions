class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            if(hasPath(u, v, graph, new HashSet<>())) {
                return edge;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[0];
    }

    private boolean hasPath(int src, int target, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if(src == target) {
            return true;
        }

        visited.add(src);

        for(int n : graph.get(src)) {
            if(visited.contains(n)) {
                continue;
            }

            if(hasPath(n, target, graph, visited)) {
                return true;
            }
        }

        return false;
    }
}
