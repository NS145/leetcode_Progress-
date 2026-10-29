class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        int index = 0;

        backtrack(nums, index, result, subSet);
        return result;
    }

    public void backtrack(int[] nums, int index, List<List<Integer>> result, List<Integer> subSet){
        if(index >= nums.length){
             if(!result.contains(subSet)){
                result.add(new ArrayList<>(subSet));
            }
            return;
        }
        subSet.add(nums[index]);

        backtrack(nums, index+1, result, subSet);

        subSet.remove(subSet.size() - 1);
        backtrack(nums, index+1, result, subSet);
    }
}