package DivideAndConquer;

public class MaxInArraySir {
    public static void main(String[] args) {
        int arr[]={1,-2,4,-1,8,3,11,4,-7};
        System.out.println(findMyMaxElement(arr,0,arr.length-1));
        System.out.println(findMyMinElement(arr, 0, arr.length-1));
    }
    static int findMyMaxElement(int[] arr,int start,int end)
    {
        if(start==end)
        {
            return arr[start];
        }
        int mid=(start+end)/2;
        int firstP=findMyMaxElement(arr, start, mid);
        int secondP=findMyMaxElement(arr,mid+1,end);
        return Math.max(firstP,secondP);
    }
    static int findMyMinElement(int[] arr,int start,int end)
    {
        if(start==end)
        {
            return arr[start];
        }
        else if(end-start==1)
        {
            return Math.min(arr[start],arr[end]);
        }
        else{
        int firstH=start+(end-start)/3;
        int secondH=start+2*(end-start)/3;
        int fP=findMyMinElement(arr, start,firstH);
        int sP=findMyMinElement(arr, firstH+1,secondH);
        int tP=findMyMinElement(arr,secondH+1,end);
        int resTwo=Math.min(fP,sP);
        return Math.min(tP,resTwo);
        }

    }
}
