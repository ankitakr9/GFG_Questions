public class CharMin{
    public static int minChar(String s) {
        // Write your code here
        //int  n= s.length();
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        int[] lps = new int[combined.length()];
        
        for(int i=1; i < combined.length(); i++){
            int len = lps[i-1];
            while(len > 0 && combined.charAt(i) != combined.charAt(len)){
                len = lps[len-1];
            }
            if(combined.charAt(i) == combined.charAt(len)){
                len++;
            }
            lps[i] = len;
        }
        return s.length() - lps[lps.length - 1];
        
        
    }
    public static void main(String args[]){
        String s= "abc";
        System.out.println(minChar(s));
    }
}



