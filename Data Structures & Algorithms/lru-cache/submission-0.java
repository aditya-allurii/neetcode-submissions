class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private Map<Integer,Node> cache;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    private void addLast(Node node){
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        //skipp
        prev.next = next;
        next.prev = prev;
    }
    private void moveToEnd(Node node){
        remove(node);
        addLast(node);
    }
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        moveToEnd(node);
        return node.value;
    }
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
            Node node = cache.get(key);
            node.value = value;
            moveToEnd(node);
            return;
        }
        if(cache.size() == capacity){
            Node lru = head.next;
            remove(lru);
            cache.remove(lru.key);
        }
        Node newNode = new Node(key,value);
        addLast(newNode);
        cache.put(key,newNode);
    }
}
