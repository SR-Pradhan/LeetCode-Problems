import java.util.HashMap;

class LRUCache {

    // Doubly linked-list node
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy nodes simplify insertion and deletion
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Remove node from its current position
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add node at MRU position, just before tail
    public void add(Node node) {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);

            // Accessing a node makes it most recently used
            remove(node);
            add(node);

            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        // Existing key: update and move it to MRU
        if(map.containsKey(key)) {
            Node node = map.get(key);

            node.val = value;

            remove(node);
            add(node);

            return;
        }

        // New key: create, store, and add to MRU
        Node node = new Node(key, value);

        map.put(key, node);
        add(node);

        // Remove LRU if capacity is exceeded
        if(map.size() > capacity) {
            Node lru = head.next;

            remove(lru);
            map.remove(lru.key);
        }
    }
}