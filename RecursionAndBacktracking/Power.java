// Java program to calculate pow(b, e)
public class Power {

    // Recursive function to calculate pow(b, e)
    static double power(double b, int e) {
        
        // Base Case: pow(b, 0) = 1
        if (e == 0)
            return 1;

        if (e < 0)
            return 1 / power(b, -e);

        double temp = power(b, e / 2);

        if (e % 2 == 0)
            return temp * temp;
        else
            return b * temp * temp;
    }

    public static void main(String[] args) {
        double b = 3.0;
        int e = 5;
        double res = power(b, e);
        System.out.println(res);
    }
}