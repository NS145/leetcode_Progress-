class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n < 2) return nums[0];
        int[] skipFirstHouse = new int[n-1];
        int[] skipLastHouse = new int[n-1];

        for(int i=0; i<n-1; i++){
            skipLastHouse[i] = nums[i];
            skipFirstHouse[i] = nums[i+1];
        }
        int lootSkippingLast = robHelp(skipLastHouse);
        int lootSkippingFirst = robHelp(skipFirstHouse);

        return Math.max(lootSkippingLast, lootSkippingFirst);
    }

    private int robHelp(int[] nums){
        int n = nums.length;
        if(n<2) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}