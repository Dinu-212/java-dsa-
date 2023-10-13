package DivideAndConquer;

public class SumInArray {
    public static void main(String[] args) {
        int[] arr={4,11,12,13,14,3};
        System.out.println(divide(arr,0,arr.length-1));
    }
    static int divide(int[] arr,int start,int end)
    {
        if (start==end){
            return arr[start];
        }
        int mid=(start+end)/2;
        int s1=divide(arr,start,mid);
        int s2=divide(arr,mid+1,end);
        return s1+s2;

    }
}
