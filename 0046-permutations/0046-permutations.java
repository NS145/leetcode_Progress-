class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();

        backtrack(nums, result, permutation);
        return result;
    }
    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> permutation){
        
        if(permutation.size() == nums.length){
            result.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(permutation.contains(nums[i])){
                continue;
            }
            permutation.add(nums[i]);
            backtrack(nums, result, permutation);

            permutation.remove(permutation.size() - 1);            
        }
    }
}