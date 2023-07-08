package prog_49_stringGroupAnagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
/*
This is the string pattern matching problem.
We have to find list of string with the same anagram, Anagram means same group of characters but different arrangment.
Here there are 2 approaches
1) Sorting every String
In this approach we are sorting a string into anagram and we will maintain a hashmap where key is sorted string as anagram and value is list of string which has same sorted anagram.
For eg. word "eat" we will convert it to "aet" we will check in hashmap if it exist, if yes then we will append it to the
corresponding list of key "aet" If not then we will create a new entry of string "aet" and put "eat" in corresponding list.
Time complexity : O(N * klogk) where N is the number of strings and k is the length of every string
We are sorting every string, thats why N * klogk

2) Prime number product approach
We can assign each alphabet to a prime number and then we can take the product of all the number.
For eg. product of "tea" and "ate" will be same. So we will be storing that under the same key and same list.

Time complexity : Here we are not sorting every string, we are just iterating through every character of string so,
it will be O(N * k) where K is the length of the every string.
*/
//Approach 1:

        public List<List<String>> groupAnagrams(String[] strs) {


                HashMap<String, List<String>> storage = new HashMap<>();
                for(String s: strs){
                        char c[] = s.toCharArray();
                        Arrays.sort(c) ;
                        String checkStr = String.valueOf(c);
                        if(storage.containsKey(checkStr)){
                                List ls = storage.get(checkStr);
                                ls.add(s);
                                storage.put(checkStr, ls);
                        }else{
                                storage.put(checkStr, new ArrayList<>());
                                List ls = storage.get(checkStr);
                                ls.add(s);
                                storage.put(checkStr, ls);
                        }

                }
                List<List<String>> result = new ArrayList<>(storage.values());
                return result ;
        }
}