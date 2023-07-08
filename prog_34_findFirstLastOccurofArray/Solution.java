package prog_34_findFirstLastOccurofArray;

public class Solution {

    /*
    In this program we will be doing two binary search, one for first occurance and 2nd for last occurance.
  1) Now suppose in first search if we found the mid which is equal to target and if my mid - 1 is same as target
    then I will continue my binary search by reducing end = mid -1
    if mid - 1 is not equal to target then we simply return the mid which will be our 1st occurance.

    2) Now we will do second binary search, but this time we know the first occurance
    then we will simply start from that occurance rather than starting from zero and find mid element.
    If my mid = target and mid + 1 = target then we wil continue binary search by start = mid+1
    If mid + 1 != target then we simply  return the mid as a second occurance.

    Rest conditions are same as a binary search

    Time Complexity :

    Since here we are performing 2 binary searches
    for 1 BS it will b log(n) and another it will b log(n)
    log(n) + log(n) = 2 log(n) and we dnt consider constants
    so Time Complexity  = log(n)

    */
    public int[] searchRange(int[] arr, int target) {
        if(arr.length == 0){
            return new int[]{-1, -1} ;
        }
        int firstIndex = firstBinary(arr, target, 0, arr.length -1 );
        int secondIndex = -1;
        if(firstIndex!=-1){
            secondIndex  = secondBinary(arr, target,firstIndex, arr.length - 1 );
        }

        return new int[]{firstIndex, secondIndex} ;
    }

    public int firstBinary(int[] arr, int target, int start, int end){
        if(arr.length > 0 && arr[0]== target)
            return 0 ;
        while(start<=end){
            int mid = start + (end - start) / 2 ;
            if(arr[mid] == target){
                if(mid!=0 && arr[mid] == arr[mid -1]){
                    end = mid -1 ;
                }
                else{
                    return mid ;
                }
            }
            if(arr[mid] > target){
                end = mid - 1;
            }
            if(arr[mid] < target){
                start = mid + 1;
            }
        }
        return -1 ;
    }

    public int secondBinary(int[] arr, int target, int start, int end){
        if(arr[arr.length -1 ] == target)
            return arr.length -1 ;

        while(start<=end){
            int mid = start + (end - start) / 2 ;
            if(arr[mid] == target){

                if(mid!= arr.length-1 && arr[mid]== arr[mid+1]){
                    start = mid + 1;
                }
                else{
                    return mid ;
                }
            }
            if(arr[mid]>target){
                end = mid -1 ;
            }
            if(arr[mid]<target){
                start = mid + 1 ;
            }
        }
        return -1 ;
    }
}

