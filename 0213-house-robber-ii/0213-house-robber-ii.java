class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];
        int[] robLastHouse = new int[n-1];
        int[] robFirstHouse = new int[n-1];

        for(int i=0; i<n-1; i++){
            robFirstHouse[i] = nums[i];
            robLastHouse[i] = nums[i+1]; 
        }

        int robbingFirstHouse = robHelp(robFirstHouse);
        int robbingLastHouse = robHelp(robLastHouse);

        return Math.max(robbingFirstHouse, robbingLastHouse);
    }
    private int robHelp(int[] houseToRob){
        int n = houseToRob.length;
        if(n==1) return houseToRob[0];

        int[] dp = new int[n];
        dp[0] = houseToRob[0];
        dp[1] = Math.max(houseToRob[0], houseToRob[1]);

        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+houseToRob[i]);
        }
        return dp[n-1];
    }
}
