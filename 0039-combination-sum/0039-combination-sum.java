class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        int index = 0;

        backtrack(nums, target, index, result, combination);
        return result;
    }

    public void backtrack(int[] nums, int target, int index, List<List<Integer>> result, List<Integer> combination){
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }
        
        if(index >= nums.length){
            return;
        }
        if(target < 0){
            return;
        }

        combination.add(nums[index]);

        backtrack(nums, target - nums[index], index, result, combination);

        combination.remove(combination.size() - 1);
        backtrack(nums, target, index + 1, result, combination);
    }
}
