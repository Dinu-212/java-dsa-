package Greedy_algorithms;

import java.util.*;

public class CoinPiles {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt();
        int k=snr.nextInt();
        int[] coin_piles=new int[n];
        for(int i=0;i<n;i++)
        {
            coin_piles[i]=snr.nextInt();
        }
        System.out.println(solve(coin_piles,k));
        snr.close();
    }
    static int solve(int[] arr,int k)
    {
        int minValue=getMin(arr);
        int ans=0;
        for(int i=0;i<arr.length;i++){
            int diff=arr[i]-minValue;
            if(diff>k)
            {
                int howMany=diff-k;
                ans+=howMany;
            }
        }
        return ans;
    }
    static int getMin(int[] arr)
    {
        int minValue=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(minValue>arr[i])
            {
                minValue=arr[i];
            }
        }
        return minValue;
    }
}
