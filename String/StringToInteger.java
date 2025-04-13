

public class StringToInteger {
   
    static int myAtoi(String s) {
        // Your code here
        int sign=1;
        int result =0;
        int index=0;
        
        //For ignore whitespaces
        while(index < s.length() && s.charAt(index) == ' ')
        {
            index++;
        }
        //for store the sign
        if(index < s.length() && (s.charAt(index)== '-' || s.charAt(index) == '+')){
            if(s.charAt(index++) == '-' )
            {
                sign= -1;
            }
        }
        //for the number digit by digit
        while(index <s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
            
            //in the case of overflow/underflow
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && s.charAt(index) - '0' >7)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            //for convert string to decimal number of current digit
            
            result = 10 * result + (s.charAt(index++) - '0');
        }
        return result * sign;
    }
    public static void main(String []args){
        String s = " -123";
        
        System.out.println(myAtoi(s));
    }
}

