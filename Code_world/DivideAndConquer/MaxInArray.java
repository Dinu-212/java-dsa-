package DivideAndConquer;

import java.util.Arrays;
import java.util.Scanner;

public class MaxInArray {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt();
        int[] a=new int[n];
        Arrays.setAll(a,(i)->snr.nextInt());
        snr.close();
        divide(a);
    }
    static void divide(int[] arr)
    {
        if (arr==null || arr.length<1){
            return;
    }
    int mid=arr.length/2;
    int t1=divideHelper(0,mid,arr);
    int t2=divideHelper(mid+1,arr.length-1,arr);
    merge(t1,t2);
} 
    static int divideHelper(int start,int end,int[] arr)
    {
        int counter=Integer.MIN_VALUE;
        while(start<=end)
        {
            if(arr[start]>counter)
            {
                counter=arr[start];
            }
            start++;
        }
        return counter;
    }
    static void merge(int start,int end)
    {
        if(start<end)
        {
            System.out.println(end);
            return;
        }
        System.out.println(start);
        return;
    }
}
