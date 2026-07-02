class Solution {
    public int findMin(int[] nums) {
        //divide and conquer, binary search
        //if the mid element > right element then the minimum element required will probably be in the mid to right range.
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] > nums[right]){
                left = mid+1;
            }else{
                right = mid;
            }

        }
        return nums[left];
    }
}