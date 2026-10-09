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

        map.put(node, new Node(node.val));
        q.offer(node);

        while(!q.isEmpty()){
            Node first = q.poll();
            Node firstDupe = map.get(first);

            for(Node nei : first.neighbors){
                Node toConnect;
                if(map.containsKey(nei)){
                    toConnect = map.get(nei);
                }else{
                    toConnect = new Node(nei.val);
                    map.put(nei, toConnect);
                    q.offer(nei);
                }
                firstDupe.neighbors.add(toConnect);
            }
        }
        return map.get(node);
    }
}