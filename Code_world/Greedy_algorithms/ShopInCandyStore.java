package Greedy_algorithms;

import java.util.*;

public class ShopInCandyStore {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        Integer n=snr.nextInt();
        Integer k=snr.nextInt();
        Integer[] candies=new Integer[n];
        for(int idx=0;idx<n;idx++)
        {
            candies[idx]=snr.nextInt();
        }
        findMinCostToBuyAllCandies(candies,k);
        findMaxCostToBuyAllCandies(candies,k);
        snr.close();
    }
    static void findMinCostToBuyAllCandies(Integer[] candies,int k)
    {
        int minCost=0;
        Arrays.sort(candies);
        int n=candies.length;
        for(int i=0;i<n;i++)
        {
            minCost+=candies[i];
            n-=k;
        }
        System.out.println(minCost);
    }
    static void findMaxCostToBuyAllCandies(Integer[] candies,int k)
    {
        int maxCost=0;
        Arrays.sort(candies,Collections.reverseOrder());
        int n=candies.length;
        for(int i=0;i<n;i++)
        {
            maxCost+=candies[i];
            n-=k;
        }
        System.out.println(maxCost);
    }
}
