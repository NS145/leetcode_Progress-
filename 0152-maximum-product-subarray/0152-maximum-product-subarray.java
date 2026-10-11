class Solution {
    public int maxProduct(int[] nums) {
        int maxm = nums[0];
        int minm = nums[0];
        int result = nums[0];

        for(int i=1; i<nums.length; i++){
            int curr = nums[i];

            if(curr < 0){
                int temp = maxm;
                maxm = minm;
                minm = temp;
            }

            maxm = Math.max(curr, maxm * curr);
            minm = Math.min(curr, minm * curr);

            result = Math.max(result, maxm);
        }
        return result;
    }
}