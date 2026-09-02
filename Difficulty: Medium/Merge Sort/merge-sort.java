class Solution {
    public void mergeSort(int arr[], int l, int r) {
        if (l>=r){
            return;
        } 
        
        int mid = l + (r-l)/2;
        
        //divide left
        mergeSort(arr,l,mid);
        
        //right
        mergeSort(arr, mid+1, r);
        
        conquer(arr, l, mid,r);
    }
    public void conquer(int[] arr, int l , int mid, int r){
        int [] merged = new int [r-l+1];
        
        int idx1=l;
        int idx2=mid+1;
        int x=0;
        
        while(idx1<=mid && idx2<=r){
            if(arr[idx1]<arr[idx2]){
                merged[x++]=arr[idx1++];
            }else{
                merged[x++]=arr[idx2++];
            }
        }
        while(idx1<=mid){
            merged[x++]=arr[idx1++];
        }
        while(idx2<=r){
            merged[x++]=arr[idx2++];
        }
        for(int i = 0 , j = l; i<merged.length; i++, j++){
            arr[j]=merged[i];
        }
    }
    
}