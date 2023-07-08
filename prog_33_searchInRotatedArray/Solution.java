package prog_33_searchInRotatedArray;

public class Solution {
    // In this program we will be having sorted array in both the sides or we will be having sorted array in atleast one side
//We will check if left side is sorted and if it is sorted we will check if element lies between sorted side
// If element is not lying in left sorted side, we will move to right side.
//If our right side is sorted then we will check if element lies between right side, if not we will skip whole right side. and continue search in left side.
    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1 ;
        while(start <= end){
            int mid = start + (end - start) / 2 ;
            if (arr[mid] == target){
                return mid ;
            }
            if(arr[start] <= arr[mid]){ // This means if left side is sorted
                if(arr[start]<= target && target <= arr[mid]){ // if item lies between left side
                    end = mid - 1; // then skip right side
                }
                else{// if item is not lying in left side
                    start = mid + 1 ; // then skip left side and jump to right side
                }

            }
            else{ // this means right side is sorted
                if(arr[mid] <= target && target<= arr[end]){// if item lies in right side
                    start = mid + 1 ; // then skip left side
                }
                else{ // if item is not lying in right side
                    end = mid - 1 ; // then skip right side and jump to left side.
                }
            }
        }
        return -1 ;
    }
}
