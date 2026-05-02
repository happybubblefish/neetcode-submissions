/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummyHead = new Node(-100), curr = dummyHead, ch = head;
        dummyHead.next = head;
        Map<Node, Node> map = new HashMap<>();

        while(ch != null) {
            Node node = new Node(ch.val);
            map.put(ch, node);
            curr.next = node;
            curr = curr.next;
            ch = ch.next;
        }

        curr = dummyHead.next;
        ch = head;

        while(ch != null) {
            curr.random = map.get(ch.random);
            curr = curr.next;
            ch = ch.next;
        }

        return dummyHead.next;
    }
}
