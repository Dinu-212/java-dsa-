package Heap;

public class MinHeap {
    public static void main(String[] args) {
        int arr[]={12,6,2,7,1,8,9,3};
        //create heap form n/2-1 to 0
        for(int i=arr.length/2-1;i>=0;i--)
        {
            heapify(arr,arr.length,i);
        }
        for(int i:arr)
        {
            System.out.print(i+" ");
        }
        System.out.println();
        heapSort(arr);
        
    }
    static void heapSort(int[] arr)
    {
        int size=arr.length;
        for(int i=size-1;i>=0;i--)
        {
        int temp=arr[0];
        arr[0]=arr[i];
        arr[i]=temp;
        heapify(arr, i, 0);
        System.out.print(temp+" ");
        }

    }
    static void heapify(int[] arr,int size,int index)
    {
        int smallest=index;
        int left=left(index);
        int right=right(index);
        //to check for heap smallest element
        if(left<size && arr[left]<arr[smallest])
        {
            smallest=left;
        }
        if(right<size && arr[right]<arr[smallest])
        {
            smallest=right;
        }
        //if index is not smallest value
        if(smallest!=index)
        {
            //swap smallest value with parent
            int temp=arr[index];
            arr[index]=arr[smallest];
            arr[smallest]=temp;
            heapify(arr, size, smallest);
        }
    }
    static int parent(int index)
    {
        return (index%2==0)?(index/2-1):(index/2);
    }
    static int left(int index)
    {
        return (index*2)+1;
    }
    static int right(int index)
    {
        return (index*2)+2;
    }
}
