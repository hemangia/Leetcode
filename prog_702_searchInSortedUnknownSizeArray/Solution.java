package prog_702_searchInSortedUnknownSizeArray;
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }

 class Solution {
 public int search(ArrayReader reader, int target) {
 int start = 0;
 int end = 1;
 while(target > reader.get(end)){ // here we will be increasing the window by multiplying by 2.
 start = end ; // when target is less than the end then we wil stop incrementing the window.
 end = end * 2;
 }
 return binary(reader, target, start, end);
 }
 int binary(ArrayReader reader, int target, int start, int end){
 while(start<=end){
 int mid = start + (end - start) / 2 ;
 if(reader.get(mid) == target){
 return mid ;
 }
 if(reader.get(mid) < target){
 start = mid +1 ;
 }
 if(reader.get(mid) > target){
 end = mid - 1 ;
 }
 }
 return -1 ;
 }
 }
*/