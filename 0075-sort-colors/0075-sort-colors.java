class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n-1 ; i++){
            int min_ind=i;
            for(int j = i+1 ; j < n; j++){
                if(nums[j]<nums[min_ind]){
                    min_ind = j;               
                }
            }
            int temp = nums[min_ind];
            nums[min_ind] = nums[i];
            nums[i]= temp;
        }    
    }
}