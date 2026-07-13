class Node{
    Node[] children = new Node[26];
    boolean isEnd = false;
}

class WordDictionary {

    public static Node root; 
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.children[index] == null){
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    public boolean dfs(String word, int pos, Node node){
        if(node == null) return false;

        if(pos == word.length()) return node.isEnd;

        char ch = word.charAt(pos);

        if(ch == '.'){
            for(Node child : node.children){
                if(child != null && dfs(word, pos+1, child)) return true;
                
            }
            return false;
            
        }
        int index = ch - 'a';
        return dfs(word, pos+1, node.children[index]);
    }
}
