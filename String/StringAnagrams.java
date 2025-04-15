class StringAnagrams {
    
    //input only lowercase, max char will be 26
    static final int MAX_CHAR = 26;
    
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {

        // Your code here
        //if(s1.length() != s2.length())
            //return false;
        
        int [] freq = new int[MAX_CHAR];
        
        //count frequency of each character of string s1
        for(int i=0; i < s1.length(); i++)
            freq[s1.charAt(i) - 'a']++;
            
            //count frequency of each character in string s2
            for(int i=0; i< s2.length(); i++)
                freq[s2.charAt(i) - 'a']--;
                
        //check if all freq are zero
        for(int count : freq){
            if(count != 0)
                return false;
        }
    return true;
         
    }
    public static void main(String []args){
        String s1= "geeks";
        String s2= "eekgs";
        System.out.println(areAnagrams(s1, s2));
    }
} 
