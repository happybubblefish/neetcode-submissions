/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        Deque <Node> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, new Node(node.val));

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            for(Node child : n.neighbors) {
                if(map.containsKey(child)) {
                    map.get(n).neighbors.add(map.get(child));
                } else {
                    map.put(child, new Node(child.val));
                    map.get(n).neighbors.add(map.get(child));
                    queue.offer(child);
                }
            }
        }

        return map.get(node);
    }
}