class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums,0,(nums.length)-1);
        return nums;      
    }

    public static void quicksort(int[] nums, int low, int high){
        if(low<high){
            int pidx = partition(nums, low , high);
            quicksort(nums,low,pidx-1);
            quicksort(nums,pidx+1,high);
        }
    }

    public static int partition(int[] nums, int low , int high){
    
        int randomIndex = low + (int)(Math.random() * (high - low + 1));
        
        int temp = nums[randomIndex];
        nums[randomIndex] = nums[high];
        nums[high] = temp;

        int pivot = nums[high];
        int i = low-1;

        for(int j = low; j<high ; j++){
            if(nums[j]<pivot){
                i++;
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        i++;
        temp = nums[high];
        nums[high] = nums[i];
        nums[i] = temp;

        return i;
    }
}