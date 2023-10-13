import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
public class strings {

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine().toUpperCase();
        System.out.println(string_encoding(str));
        //System.out.println(length_problem_sir(s));
        //special_letter(s);
        //KreetiMurti(s);
        //int n=sc.nextInt();
        //captiancy_test(s);
        //removeAllDuplicates(s);
        //longest_palindrome(s);
        //string_permutations(s,"");
        //System.out.println(super_ascii(s));
        //removeDuplicates(s);
        sc.close();
    }
    static String string_encoding(String str)
    {
        String res="";
        String alphabets_encoded="_zxywvutsrqponmlkjihgfedcba".toUpperCase();//_ is zero position
        for(int idx=0;idx<str.length();idx++)
        {
            char reading_character=str.charAt(idx);
            if(reading_character<65 || reading_character>90)
            {
                res=res+reading_character;
                continue;
            }
            int position=reading_character-64;
            res=res+alphabets_encoded.charAt(position);
        }
        return res;
    }
    static int length_problem_sir(String str)
    {
        str.toLowerCase();
        int n=str.length();
        char last=str.charAt(n-1);
        if(last>=97 && last<=122)
        {
            return (n>=10)?-1:n;
        }
        int idx=n-1;
        while(Character.isDigit(str.charAt(idx)))
        {
            idx--;
        }
        String stringPart=str.substring(0,idx+1);
        int numberPart=Integer.parseInt(str.substring(idx+1));
        int originalLength=stringPart.length();
        int ans=originalLength%10;
        if((numberPart*10+ans)==originalLength)
        {
            return ans;
        }
        return -1;
    }
    static void length_problem(String s)
    {
        int counter=0;
        String res="";
        for(char c:s.toCharArray())
        {
            if(!Character.isDigit(c))
            {
                counter++;
            }
            else{
                res=res+c;
            }
        }
        int temp=counter,no_of_digits=0;
        while(temp!=0)
        {
            temp=temp/10;
            no_of_digits++;
        }
        if(res.length()==0)
        {
            if(no_of_digits>=2)
            {
                System.out.println(-1);
                return;
            }
            else{
                System.out.println(counter);
                return;
            }
        }
        else{
        int tmp=Integer.parseInt(res);
        int no_res=0,res2=tmp;
        while(tmp!=0)
        {
            tmp=tmp/10;
            no_res++;
        }
        if(no_of_digits-no_res>2)
        {
            System.out.println(-1);
        }
        else{
            if(no_res!=0)
            System.out.println(counter-res2*(10*(no_of_digits-no_res)));
            else{
                System.out.println(counter);
            }
        }
    }
    }
    static int getFibonacciNumber(int n)
    {
        if(n<=2)
        {
            return 1;
        }
        else
        {
            return getFibonacciNumber(n-1)+getFibonacciNumber(n-2);

        }
    }
    static void special_letter(String s)
    {
        int counter=0;
        s.toLowerCase();
        for(char c:s.toCharArray())
        {
            counter+=getFibonacciNumber(c-96);
        }
        System.out.println(counter);
    }
    static void KreetiMurti(String s)
    {
        String[] s1=s.split("[.]");
        for(String value:s1)
        {
            if(value!="" && Integer.parseInt(value)>=0 && Integer.parseInt(value)<255)
            {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
    static int check_vowel_count(String s)
    {
        int count=0;
        for(char c:s.toCharArray())
        {
            if("aeiou".contains(""+c))
            {
                count++;
            }
        }
        return count;
    }
    static void captiancy_test(String s)
    {
        int n=s.length();
        n=n/2;
        String s1=s.substring(0, n);
        String s2=s.substring(n);
        int n1=check_vowel_count(s1);
        int n2=check_vowel_count(s2);
        if(n%2==0)
        {
            if(n1>=n2)
            {
                System.out.println("Virat");
            }
            else
            {
                System.out.println("Rohit");
            }
        }
        else{
            if(n1>n2)
            {
                System.out.println("Rohit");
            }
            else
            {
                System.out.println("Virat");
            }
        }
    }
    static void removeAllDuplicates(String str)
    {
        String ans="";
        int i=0,n=str.length();
        while(i<n)
        {
            if(i<n-1 && str.charAt(i)==str.charAt(i+1))
            {
                while(i<n-1 && str.charAt(i)==str.charAt(i+1))
                {
                    i++;
                }
            }
            else
            {
                ans+=str.charAt(i);
            }
            i++;
        }
        System.out.println(ans);
    }
    static void longest_palindrome(String str)
    {
        int ans=0;
        String answer="";
        for(int i=0;i<str.length();i++)
        {
            int left=i,right=i;
            int currentLength=0;
            while(left>=0 && right<str.length() && str.charAt(left)==str.charAt(right))
            {
                currentLength=right-left+1;
                if(currentLength>ans)
                {
                    ans=currentLength;
                    answer=str.substring(left, right+1);
                }
                left--;
                right++;
            }
            left=i;
            right=i+1;
            while(left>=0 && right<str.length() && str.charAt(left)==str.charAt(right))
            {
                currentLength=right-left+1;
                if(currentLength>ans)
                {
                    ans=currentLength;
                    answer=str.substring(left, right+1);
                }
                left--;
                right++;
            }
        }
        System.out.println(ans);
        System.out.println(answer);
    }
    static void string_permutations(String str,String ans)
    {
        if(str.isEmpty())
        {
            System.out.print(ans+" ");
            return;
        }
        for(int i=0;i<str.length();i++)
        {
            char ch_picked=str.charAt(i);
            String remaining=str.substring(0, i)+str.substring(i+1);
            string_permutations(remaining, ans+ch_picked);
        }
    }
    static boolean super_ascii_sir(String s)
    {
        HashMap<Character,Integer> frequency=new HashMap();
        for(int i=0;i<s.length();i++)
        {
            frequency.putIfAbsent(s.charAt(i),0);
            frequency.put(s.charAt(i),frequency.get(s.charAt(i))+1);
        }
        for(Character ch:frequency.keySet())
        {
            int count=s.charAt(ch);
            if(frequency.get(ch)!=count-96)
            {
                return false;
            }
        }
        return true;
    }
    static int freq_count(char c,String s)
    {
        int count=0;
        for(char cr:s.toCharArray())
        {
            if(c==cr)
            {
                count++;
            }
        }
        return count;
    }
    static boolean super_ascii(String s)
    {
        for(char c:s.toCharArray())
        {
            int tmp=c;
            tmp-=96;
            if(tmp!=freq_count(c,s))
            {
                return false;
            }
        }
        return true;
    }
    static void removeDuplicates(String s)
    {
        char arr[]=s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]!=arr[i+1])
            {
                sb.append(arr[i]);
            }
        }
        sb.append(arr[arr.length-1]);
        System.out.println(sb);
    }
}
