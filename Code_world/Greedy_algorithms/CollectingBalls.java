package Greedy_algorithms;
import java.util.*;
public class CollectingBalls {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt(),m=snr.nextInt();
        int[] roadA=new int[n];
        int[] roadB=new int[m];
        Arrays.setAll(roadA,(i)->snr.nextInt());
        Arrays.setAll(roadB, (i)->snr.nextInt());
        System.out.println(solve(roadA,roadB));
        snr.close();
    }
    static int solve(int[] roadA,int[] roadB)
    {
        int aSum=0,bSum=0,ans=0,n=roadA.length,m=roadB.length;
        int i=0,j=0;
        while(i<n && j<m)
        {
            while(i+1<n && roadA[i]==roadA[i+1])
            {
                aSum+=roadA[i++];
            }
            while(j+1<m && roadB[j]==roadB[j+1])
            {
                bSum+=roadB[j++];
            }
            if(roadA[i]==roadB[j])
            {
                ans=ans+Math.max(aSum,bSum)+roadA[i];
                aSum=0;bSum=0;
                i++;j++;
            }
            else if(roadA[i]<roadB[j])// A element cannot be intersection point
            {
                aSum+=roadA[i++];
            }
            else{// B element cannot be the intersecion element
                bSum+=roadB[j++];
            }

        }
        while(i<n)//for rest of the elements
        {
            aSum+=roadA[i++];
        }
        while(j<n)
        {
            bSum+=roadB[j++];
        }
        ans+=Math.max(aSum,bSum);
        return ans;
    }
}
