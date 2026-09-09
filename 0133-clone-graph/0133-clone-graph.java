/*
// Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node, new Node(node.val));
        while(!q.isEmpty()){
            Node first = q.remove();
            Node firstClone = map.get(first);
            for(Node curr : first.neighbors){
                Node currClone;
                if(map.containsKey(curr)){
                    currClone = map.get(curr);
                }else{
                    q.add(curr);
                    currClone = new Node(curr.val);
                    map.put(curr, currClone);
                }
                firstClone.neighbors.add(currClone);
            }
        }
        return map.get(node);
    }
}