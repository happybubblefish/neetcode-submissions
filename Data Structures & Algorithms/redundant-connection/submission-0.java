class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            if(hasPath(a, b, graph, new HashSet<>())) {
                return edge;
            }

            graph.get(a).add(b);
            graph.get(b).add(a);
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
