package prog_153_searchMinInRotatedSortedArray;

public class Solution {
    /*
    Always remember in rotated array, minimum element which is pivot where rotation happened
    always lies in unsorted section. so we will simply skip the sorted side.
    1) Here we will be checking first if our array is rotated or not
        If not rotated then we will simply return 0th element.
        else we will continue calculating mid element
    2) if my mid is less than mid -1 and less than mid + 1
        it means we found minimum element and we will return our mid

    3) if our left side is sorted then we will skip that side and
        and continue our search in right side
    4) if our right side is sorted then we will skip that side
        and continue our search in left side.

    Time Complexity : log(N)

     */
public int findMin(int[] arr) {
        int start = 0 ;
        int end = arr.length - 1 ;

        while(start<= end){
        if(arr[start] <= arr[end]){
        return arr[start] ;

        }
        int mid = start + (end - start) / 2 ;

        if((mid == 0 || arr[mid-1] > arr[mid]) &&  arr[mid] < arr[mid+1] ){ // here we will add edge case as well
        return arr[mid]; // that our mid should'nt be first or last element but it can work with first element //
        //as well, no need to use last element edge case. We can add last element case, no harm.
        }
        if(arr[start] <= arr[mid]){ //it means left side is sorted
        start = mid +1 ;
        }
        if(arr[mid] <= arr[end]){ //it means right side is sorted
        end = mid - 1;
        }
        }
        return -1 ;
        }
        }
