// Java program to find minimum Platforms Required 
// for Given Arrival and Departure Times

import java.util.Arrays;

class MinPlateform {

    // Function to find the minimum 
    // number of platforms required
    static int minPlatform(int[] arr, int[] dep) {
        int n = arr.length;
        int res = 0;

        // Find the max Departure time 
        int maxDep = dep[0];
        for (int i = 1; i < n; i++) {
            maxDep = Math.max(maxDep, dep[i]);
        }

        // Create an array to store the count of trains at each
        // time
        int[] v = new int[maxDep + 2];
        
        // Increment the count at the arrival time and decrement
        // at the departure time
        for (int i = 0; i < n; i++) {
            v[arr[i]]++;
            v[dep[i] + 1]--;
        }
        
        int count = 0;

        // Iterate over the array and keep track of the maximum
        // sum seen so far
        for (int i = 0; i <= maxDep + 1; i++) {
            count += v[i];
            res = Math.max(res, count);
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(minPlatform(arr, dep));
    }
}