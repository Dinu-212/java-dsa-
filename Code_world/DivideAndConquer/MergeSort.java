package DivideAndConquer;

public class MergeSort {
    public static void main(String[] args) {
        int arr[]={4,3,2,1,9,5,6};
        mergeSort(arr,0,arr.length-1);
        for(int i:arr)
        {
            System.out.print(i+" ");
        }
    }
    static void mergeSort(int[] arr,int start,int end)
    {
        if(start<end)
        {
        int mid=(start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr,start,mid,end);
        }
    }
    //merge sort code in java?
    static void merge(int[] arr,int start,int mid,int end)
    {
        int left=mid-start+1;
        int right=end-mid;
        int leftArr[]=new int[left];
        int rightArr[]=new int[right];
        for(int i=0;i<left;i++)
        {
            leftArr[i]=arr[start+i];
        }
        for(int i=0;i<right;i++)
        {
            rightArr[i]=arr[(mid+1)+i];
        }
        int first=0,second=0,k=start;
        while(first<left && second<right)
        {
            //for ascending give < , for descending give > below
            if(leftArr[first]<=rightArr[second])
            {
                //swap the elements in array
                arr[k]=leftArr[first];
                first++;
            }
            else
            {
                arr[k]=rightArr[second];
                second++;
            }
            k++;
        }
        //remaining elements in my left
        while(first<left)
        {
            arr[k]=leftArr[first];
            first++;
            k++;
        }
        while(second<right)
        {
            arr[k]=rightArr[second];
            second++;
            k++;
        }
    }
}
