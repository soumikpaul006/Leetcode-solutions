class LRUCache 
{
    class Node
    {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key,int val)
        {
            this.key=key;
            this.val=val;
        }
    }

    int capacity;
    HashMap<Integer,Node> map;
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);


    public LRUCache(int capacity) {
        
        this.capacity=capacity;
        map=new HashMap<>(capacity);

        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {

        if(map.containsKey(key))
        {
            Node node=map.get(key);

            deleteNode(node);
            map.remove(node);

            addNode(node);
            map.put(key,head.next);

            return node.val;
        }

        return -1;
    
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key))
        {
            Node node=map.get(key);
            deleteNode(node);
            map.remove(node.key);
        }

        if(map.size()==capacity)
        {
            Node node=tail.prev;

            deleteNode(node);
            map.remove(node.key);
        }

        addNode(new Node(key,value));
        map.put(key,head.next);
    }

    public void addNode(Node node)
    {
        Node next_node=head.next;

        node.next=next_node;
        next_node.prev=node;

        head.next=node;
        node.prev=head;
    }

    public void deleteNode(Node node)
    {
        Node next_node=node.next;
        Node prev_node=node.prev;

        prev_node.next=next_node;
        next_node.prev=prev_node;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */