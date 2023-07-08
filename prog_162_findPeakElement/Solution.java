package prog_162_findPeakElement;

public class Solution {
    /*
    Peak element is the element which is greater than its left and right neighbor
    In this solution we have to find any peak element, an array may contain multiple peak elements and we can return any.
    we will start with mid
    1) if my mid is greater than its left and right element and left or right is not first or last
    element, in this case we will return mid as result.
    2) If right side of mid is greater than than mid then we will continue our search on right side.
    3) If left side of mid is greater then continue left side.
    4) In this case we have to either move left or right and we can not simply return -1 even if i have 1 element in
    the array we need to return that element, that's why here we use else at the end, instead of if (arr[mid+1] > arr
    [mid])
    Time Complexity : Since we are skiping one part of array so Complexity will be
    O(log N)

    */
public int findPeakElement(int[] arr) {
        int start = 0 ;
        int end = arr.length -1 ;
        while(start<=end){
        int mid = start + (end - start) / 2 ;

        if((mid == 0 || arr[mid-1] < arr[mid]) &&
        (mid == arr.length-1 || arr[mid] > arr[mid +1])){
        return mid ;
        }
        if(mid > 0 && arr[mid -1] > arr[mid]){
        end = mid - 1 ;
        }
        else{
        start = mid +1 ;
        }


        }
        return -1 ;
        }
        }