class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result  = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();

        backtrack(n, k, result, combinations, 1);
        return result;
    }
    public void backtrack(int n, int k, List<List<Integer>> result, List<Integer> combinations, int index){
            
        if(combinations.size() == k){
            result.add(new ArrayList<>(combinations));
            return;
        }

        for(int i = index; i <= n; i++) {
            combinations.add(i);
            backtrack(n, k, result, combinations, i + 1);
            combinations.remove(combinations.size() - 1);
        }

    }
}