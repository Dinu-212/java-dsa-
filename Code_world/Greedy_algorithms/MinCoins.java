package Greedy_algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MinCoins {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        Integer[] coins={10,5,2,1};
        int target=snr.nextInt();
        System.out.println("Total number of coins "+getMinCoins(coins,target));
        snr.close();
    }
    static int getMinCoins(Integer[] coins,int target)
    {
        Arrays.sort(coins,Collections.reverseOrder());
        int coinsCount=0;
        for(Integer currentCoin:coins)
        {
            if(target>=currentCoin)
            {
                coinsCount+=target/currentCoin;
                System.out.println(currentCoin+"->"+target/currentCoin);
                target=target%currentCoin;
            }
            if(target==0)
            {
                break;
            }
        }
        return coinsCount;
    }
}