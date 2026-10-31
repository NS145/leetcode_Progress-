class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int count = 0;
        int index = 0;

        backtrack(result, combination, nums, k, n, count, index);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> combination, int[] nums, int limit, int target, int count, int index){
        if(count > limit){
            return;
        }

        if(count == limit && target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }

        if(index >= nums.length){
            return;
        }

        combination.add(nums[index]);
        backtrack(result, combination, nums, limit, target - nums[index], count + 1, index + 1);

        combination.remove(combination.size() - 1);
        backtrack(result, combination, nums, limit, target, count, index + 1);
    }
}