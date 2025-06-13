//Java program to print unique permutation of string 
//using hash map.
import java.util.*;

class PermutationString {
    // Recursive function to generate permutations
     static void genPermutations(int n, StringBuilder curr, 
                          Map<Character, Integer> cnt, List<String> res) {
        
       // Base case: If the current permutation length equals 
       // to the input string length, add it to the result
        if (curr.length() == n) {
            res.add(curr.toString());
            return;
        }

        // Iterate through each character in the frequency map
        for (Map.Entry<Character, Integer> entry : cnt.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            // Skip characters with a count of 0
            if (count == 0) 
                continue;

            // Include the character in the current permutation
            curr.append(c);

            // Decrease its count in the frequency map
            cnt.put(c, count - 1);

            // Recur to build the next character in the permutation
            genPermutations(n, curr, cnt, res);

            // Backtrack: Remove the character and restore its count
            curr.deleteCharAt(curr.length() - 1);
            cnt.put(c, count);
        }
    }

     // Function to find all unique permutations of the input string
     static ArrayList<String> findPermutation(String s) {
        ArrayList<String> res = new ArrayList<>(); 
       
       	// Frequency map to count occurrences of each character
        Map<Character, Integer> cnt = new HashMap<>(); 

        // Populate the frequency map with the characters of the input string
        for (char c : s.toCharArray()) 
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);

        // To build permutations
        StringBuilder curr = new StringBuilder();
        genPermutations(s.length(), curr, cnt, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "ABC";
        List<String> res = findPermutation(s);

        for (String perm : res) 
            System.out.print(perm + " ");
    }
}