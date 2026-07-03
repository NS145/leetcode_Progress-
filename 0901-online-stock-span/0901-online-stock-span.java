class StockSpanner {
    private Stack<int[]> spanStack;
    public StockSpanner() {
        spanStack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        while(!spanStack.isEmpty() && spanStack.peek()[0] <= price){
            span += spanStack.pop()[1];
        }
        spanStack.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */