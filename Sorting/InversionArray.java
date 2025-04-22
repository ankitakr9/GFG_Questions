
import java.io.*;
import java.util.*;

public class InversionArray {
    static int countAndMerge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 =r-m;
        
        int[] left = new int[n1];
        int[] right = new int[n2];
        
        for(int i=0; i<n1; i++)
            left[i] = arr[i+l];
        for(int j=0; j<n2; j++)
            right[j] =arr[m+1+j];
            
            int res=0;
            int i=0,j=0,k=l;
            while(i<n1 && j<n2){
                if(left[i] <= right[j]){
                    arr[k++] = left[i++];
                }
                else{
                    arr[k++] = right[j++];
                    res +=(n1-i);
                }
            }
            while(i<n1)
                arr[k++] = left[i++];
            while(j<n2)
                arr[k++] = right[j++];
        return res;
    }
    static int countInv(int[] arr, int l, int r){
        int res=0;
        if(l<r){
            int m= (r+l)/2;
            res += countInv(arr, l, m);
            res += countInv(arr, m+1, r);
            
            res += countAndMerge(arr,l,m,r);
            
            
        }
        return res;
    }
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        return countInv(arr, 0, arr.length-1);
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println(inversionCount(arr));
    }
}
