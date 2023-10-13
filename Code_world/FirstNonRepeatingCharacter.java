import java.util.*;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        String str=snr.next();
        System.out.println(solve(str));
        snr.close();
    }
    static String solve(String str)
    {
        String result="";
        Map<Character,Integer> frequency=new HashMap<>();
        Queue<Character> queue=new ArrayDeque<>();
        for(int idx=0;idx<str.length();idx++)
        {
            char current_letter=str.charAt(idx);
            queue.add(current_letter);
            frequency.put(current_letter,frequency.getOrDefault(current_letter, 0)+1);
            while(!queue.isEmpty())
            {
                if(frequency.get(queue.peek())>1)
                {
                    queue.poll();
                }
                else
                {
                    result=result+queue.peek();
                    break;
                }
            }
            if(queue.isEmpty())
            {
                result=result+"-1";
            }
        }
        return result;
    }
}
