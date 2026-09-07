class Solution {
    public void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int pidx = partition(arr,low,high);
            quickSort(arr,low,pidx-1);
            quickSort(arr,pidx+1,high);
        }
        
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        
        int i = low-1;
        
        for(int j = low ; j<high ;j++ ){
            if (arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        
        i++;
        int temp = arr[high];
        arr[high] = arr[i];
        arr[i] = temp;
        
        return i;
        
    }
}