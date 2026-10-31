class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();
        int index = 1;

        backtrack(n, k, index, result, combinations);
        return result; 
    }

    public void backtrack(int n, int k, int index, List<List<Integer>> result, List<Integer> combinations){

        if(index > n){
            if(combinations.size() == k){
                result.add(new ArrayList<>(combinations));
            }
            return;
        }
        
        combinations.add(index);
        backtrack(n, k, index + 1, result, combinations);

        combinations.remove(combinations.size() - 1);
        backtrack(n, k, index + 1, result, combinations);
    }
}