class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder currStr = new StringBuilder();
        int num = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }else if(ch == '['){
                numStack.push(num);
                strStack.push(currStr);

                num = 0;
                currStr = new StringBuilder();
            }else if(ch == ']'){
                int repeat = numStack.pop();
                StringBuilder prevChar = strStack.pop();

                while(repeat--> 0){
                    prevChar.append(currStr);
                }
                currStr = prevChar;
            }else{
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}