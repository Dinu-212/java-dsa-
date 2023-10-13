package DP_algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class NthFibo {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        long n=snr.nextInt();
        long[] buffer=new long[(int)n+1];
        Arrays.fill(buffer,-1);
        System.out.println(getNthFibo(n,buffer));
        snr.close();
    }
    static long getNthFibo(long n,long[] buffer)
    {
        if(n<=1)
        {
            return n;
        }
        if(buffer[(int)n]!=-1)
        {
            return buffer[(int) n];
        }
        buffer[(int)n]=getNthFibo(n-1,buffer)+getNthFibo(n-2,buffer);
        return buffer[(int)n];
    }
}
