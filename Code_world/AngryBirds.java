import java.util.Arrays;
import java.util.Scanner;

public class AngryBirds {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt();
        int[] nests=new int[n];
        Arrays.setAll(nests,(i)->snr.nextInt());
        int birds=snr.nextInt();
        largest_minimum_distance(nests,birds);
        snr.close(); 
    }
    static void largest_minimum_distance(int[] nests,int birds)
    {
        int start=0,end=nests[nests.length-1]-nests[0],mid=(start+end)/2,ans=0;
        while(start<=end)
        {
            mid=(start+end)/2;
            if(canPlace(nests,birds,mid))
            {
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        System.out.println(ans);

    }
    static boolean canPlace(int[] nests,int birds,int distance)
    {
        int birdsPlaced=1;
        int previous=nests[0];
        for(int idx=1;idx<nests.length;idx++)
        {
            int current=nests[idx];
            if(current-previous>=distance)
            {
                birdsPlaced++;
                previous=current;
                if(birdsPlaced==birds)
                {
                    return true;
                }
            }
        }
        return false;

    } 
}
