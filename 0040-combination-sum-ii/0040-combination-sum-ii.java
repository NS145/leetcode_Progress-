class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        int index = 0;

        backtrack(candidates, target, index, result, combination);
        return result;
    }

    public void backtrack(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> combination){
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }
        
        if(index >= candidates.length){
            return;
        }
        if(target < 0){
            return;
        }

        combination.add(candidates[index]);

        backtrack(candidates, target - candidates[index], index + 1, result, combination);

        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]){
            index++;
        }

        combination.remove(combination.size() - 1);
        backtrack(candidates, target, index + 1, result, combination);
    }
}
