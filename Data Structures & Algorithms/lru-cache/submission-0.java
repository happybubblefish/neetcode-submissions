class LRUCache {

    class DoublyNode {
        int key;
        int val;
        DoublyNode prev;
        DoublyNode next;

        public DoublyNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    DoublyNode head;
    DoublyNode tail;
    Map<Integer, DoublyNode> map;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new DoublyNode(-1, 1);
        tail = new DoublyNode(-1, 1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public int get(int key) {
        DoublyNode node = map.get(key);

        if(node == null) {
            return -1;
        }

        moveToHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        DoublyNode node = map.get(key);

        if(node == null) {
            size++;
            node = new DoublyNode(key, value);
            map.put(key, node);
            addToHead(node);

            if(size > capacity) {
                removeLast();
                size--;
            }
        } else {
            node.val = value;
            map.put(key, node);
            moveToHead(node);
        }
    }

    private void moveToHead(DoublyNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }

    private void removeLast() {
        map.remove(tail.prev.key);
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }

    private void addToHead(DoublyNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
