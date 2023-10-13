import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class arrays {
    
    public static void main(String args[])
    {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        no_of_triplets(arr,target);
        //int pos=sc.nextInt();
        //rotate_array(arr,pos);
        //largestNumber(arr);
        //MissingNumber(arr);
        /* 
        int target_sum=sc.nextInt();
        int subarray[]=subarray_target(arr,target_sum);
        for(int i:subarray)
        {
            System.out.print(i+" ");
        }
        */
        sc.close();
    }
    static int[] subarray_target(int arr[],int target)
    {
        int start=0,end=0;//first and last index of subarray
        int currentSum=arr[0];
        while(end<arr.length)
        {
            if(currentSum==target)
            {
                return new int[]{start,end};
            }
            else if(currentSum<target)
            {
                end++;
                currentSum+=arr[end];
            }
            else
            {
                currentSum-=arr[start];
                start++;
            }

        }
        return new int[]{-1,-1};

    }
    static void MissingNumber(int arr[])
    {
        int n=arr.length;
        int sum=(n+1)*(n+2)/2;
        for(int i:arr)
        {
            sum-=i;
        }
        System.out.println("The missing number is "+sum);
    }
    static void largestNumber(int arr[])
    {
        String nums[]=new String(arr.length);
        for(int i=0;i<arr.length;i++)
        {
            nums[i]=String.valueOf(i);
        }
        Comparator<String> comp=(a,b)->(b+a).compareTo(a+b);
        Arrays.sort(nums,comp);
        StringBuilder str=new StringBuilder();
        for(String s:nums)
        {
            str.append(s);
        }
        System.out.println(str);

    }/* 
    static void LargestNumber2(int arr[])
    {
        int max;
        for(int i:arr)
        {
            if(max<i)
            {
                max=i;
            }
        }
        int n=no_of_digits(max);
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<=arr.length;i++)
            {
                 
            }
        }
    }
    static int no_of_digits(int n)
    {
        int k=0;
        while(n>0)
        {
            n=n/10;
            k++;
        }
        return k;
    }*/
    static void rotate_array(int arr[],int pos)
    {
        rotatehelper(arr,0,pos-1);
        rotatehelper(arr,pos,arr.length-1);
        rotatehelper(arr,0,arr.length-1);
        for(int i:arr)
        {
            System.out.print(i);
        }

    }
    static void rotatehelper(int arr[],int start,int end)
    {
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    static void no_of_triplets(int arr[],int target)
    {
        int n=arr.length;
        int count=0;
        for(int i=0;i<n-2;i++)
        {
            int left=i+1;
            int right=n-1;
            while(left<right)
            {
                int sum=arr[i]+arr[left]+arr[right];
                if(sum<=target)
                {
                    right--;
                }
                else
                {
                    count+=(right-left);
                    left++;
                }
            }
        }
        System.out.println(count);
    }
}
