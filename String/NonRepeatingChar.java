
import java.util.*;

class NonRepeatingChar {
    
    static final int MAX_CHAR = 256;
    static char nonRepeatingChar(String s) {
        // code here
        int[] visitedArray = new int [MAX_CHAR];
        Arrays.fill(visitedArray, -1);
        for(int i=0; i < s.length(); i++)
        {
            int index = s.charAt(i);
            
            if(visitedArray [index] == -1){
                //store the index when character is first seen
                visitedArray[index] = i;
                
            }
            else{
                //mark character as repeated
                visitedArray[index] = -2;
            }
        }
        int idx = Integer.MAX_VALUE;
        //find the smallest index of non- repeating characters
        for(int i=0; i < MAX_CHAR; i++){
            if(visitedArray[i] >= 0 && visitedArray[i] < idx){
                idx = visitedArray[i];            
            }
        }
        return (idx == Integer.MAX_VALUE || idx >= s.length()) ? '$' : s.charAt(idx);
        
    }
    public static void main(String []args){
        String s = "ssiibuu";
        System.out.println(nonRepeatingChar(s));
    }
}
