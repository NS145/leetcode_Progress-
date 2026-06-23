class LRUCache {
    class node{
        int key;
        int value;
        node next;
        node prev;

        node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    public node head = new node(-1, -1);
    public node tail = new node(-1, -1);

    int cap;
    HashMap<Integer, node> map;

    public LRUCache(int capacity) {
        map =  new HashMap(capacity);
        head.next = tail;
        tail.prev = head;
        cap = capacity;
    }
    void addNode(node newNode){
       node temp = head.next;
       newNode.next = temp;
       head.next = newNode;
       newNode.prev = head;
       temp.prev = newNode;
    }
    void deleteNode(node nodeToRemove){
        node nextNode = nodeToRemove.next;
        node prevNode = nodeToRemove.prev;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            node resultNode = map.get(key);
            int result = resultNode.value;

            map.remove(key);

            deleteNode(resultNode);
            addNode(resultNode);

            map.put(key, head.next);
            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            node existingNode = map.get(key);
            map.remove(key);
            deleteNode(existingNode);
        }
        if(map.size() == cap){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new node(key, value));
        map.put(key, head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */