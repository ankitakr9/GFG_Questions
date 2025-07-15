// Java implementation to decode the given string without stack
import java.util.*;

class DecodeString {

    // Function to decode given encoded string
    static String decodedString(String s) {

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            // If the current character is not a closing
            // bracket, append it to the result string.
            if (s.charAt(i) != ']') {
                res.append(s.charAt(i));
            }

            // If the current character is a closing bracket
            else {

                // Create a temporary string to store
                // the substring within the corresponding
                // opening bracket.
                StringBuilder temp = new StringBuilder();
                while (res.length() > 0
                       && res.charAt(res.length() - 1)
                              != '[') {
                    temp.insert(
                        0, res.charAt(res.length() - 1));
                    res.deleteCharAt(res.length() - 1);
                }

                // Remove the opening bracket from the
                // result string.
                res.deleteCharAt(res.length() - 1);

                // Extract the preceding number and convert
                // it to an integer.
                StringBuilder num = new StringBuilder();
                while (res.length() > 0
                       && Character.isDigit(
                           res.charAt(res.length() - 1))) {
                    num.insert(
                        0, res.charAt(res.length() - 1));
                    res.deleteCharAt(res.length() - 1);
                }
                int p = Integer.parseInt(num.toString());

                // Append the substring to the result
                // string, repeat it to the required number
                // of times.
                for (int j = 0; j < p; j++) {
                    res.append(temp.toString());
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "3[b2[ca]]";
        System.out.println(decodedString(s));
    }
}