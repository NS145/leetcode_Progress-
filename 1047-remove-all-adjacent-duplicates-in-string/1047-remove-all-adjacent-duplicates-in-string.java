class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> charStack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(!charStack.isEmpty() && charStack.peek() == ch){
                charStack.pop();
            }else{
                charStack.push(ch);
            }            
        }
        StringBuilder result = new StringBuilder();
        while(!charStack.isEmpty()){
            result.append(charStack.pop());
        }
        return result.reverse().toString();
    }
}