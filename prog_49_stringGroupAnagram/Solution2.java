package prog_49_stringGroupAnagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
    /*
    Approach 2:
    Instead of sorting every string we are assigning a prime number to every character, and then we will be taking the multiplication of that all numbers in string and we will be assigning the product as a key and put the respective word in the list. Also we will be using double and not an Integer coz the product would be very long for the longer strings.
We will start with 2 and not 1 becoz the 1 multiply by 1 would be same number.

Time Complexity : O(N * K)
where N is the number of elements and K is the length of string.

This solution is optimized than the approach 1(sorting every string)
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Double, List<String>> storage = new HashMap<>();

        for(String s: strs){ // O(n)
            double prod = calculate(s); // O(k)
            if(storage.containsKey(prod)){
                List ls = storage.get(prod);
                ls.add(s);
                storage.put(prod, ls);

            }
            else{
                storage.put(prod, new ArrayList<>());
                List ls = storage.get(prod);
                ls.add(s);
                storage.put(prod, ls);
                //storage.get(prod).add(s); // we can write it in a single line as well.
            }
        }
        List<List<String>> result = new ArrayList<>(storage.values());
        return result ;
    }
    public double calculate(String st){
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        double result = 1d ;
        for(int i = 0; i < st.length(); i++){ // O(k)
            char c = st.charAt(i);
            int index = c - 'a' ; // This will give the difference in Ascii values and the respective index of prime array
            //For eg. if char is 'c' which is 99 and a is 97 then difference is 2 and 'c' is at index 2 in prime array
            result = result * prime[index];
        }


        return result ;

    }
}