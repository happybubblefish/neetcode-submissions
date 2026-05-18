class Solution {
    int count = 0;

    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                count++;
            }
            
            dfs(i, graph, visited);
        }

        return count;
    }

    private void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if(visited.contains(node)) {
            return;
        }

        visited.add(node);

        for(int n : graph.get(node)) {
            dfs(n, graph, visited);
        }
    }
}
