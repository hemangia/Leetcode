package prog_704_binarySearch;

public class Solution {
    public int search(int[] nums, int target) {
        return binary(nums, target, 0, nums.length);
    }
    int binary(int[] nums, int target, int start, int end){
        int mid = start + (end - start) / 2 ;
        if(start>end){
            return -1 ;
        }
        if(target == nums[mid]){
            return mid ;
        }
        if(target > nums[mid]){
            return binary(nums, target, mid+1 , end);
        }
        if(target< nums[mid]){
            return binary(nums, target, start, mid-1);
        }
        return -1;
    }
}

//Solution 2
/*
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0 , nums.length-1);
    }
    int binarySearch(int arr[], int target, int start, int end){

        while(start<=end){
            int mid = start + end - start / 2 ;
            if(target == arr[mid]){
                return mid ;
            }
            if(target> arr[mid]){
                start = mid +1 ;
            }
            if(target< arr[mid]){
                end = mid - 1 ;
            }
        }
        return -1 ;
    }
}
*/