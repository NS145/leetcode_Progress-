class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result  = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();

        backtrack(n, k, result, combinations, 1);
        return result;
    }
    public void backtrack(int n, int k, List<List<Integer>> result, List<Integer> combinations, int index){

        if(index > n){
            if(combinations.size() == k){
                result.add(new ArrayList<>(combinations));
            }
            return;
        }

        combinations.add(index);
        backtrack(n, k, result, combinations, index + 1);

        combinations.remove(combinations.size() - 1);
        backtrack(n, k, result, combinations, index + 1);
    }
}