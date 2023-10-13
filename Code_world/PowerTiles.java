import java.util.*;
public class PowerTiles {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int n=snr.nextInt();
        int[] tiles=new int[n];
        Arrays.setAll(tiles, (i)->snr.nextInt());
        getPowerJumps(tiles);
    }
    static void getPowerJumps(int[] tiles)
    {
        int n=tiles.length-1;
        int idx=0;
        int k=tiles[idx];
        while(true)
        {
            if(idx==n)
            {
                System.out.println(true);
                return;
            }
            if(idx>n || k==0)
            {
                System.out.println(false);
                return;
            }
            idx=tiles[k]+idx;
            k=tiles[idx];
        }
    }
}
