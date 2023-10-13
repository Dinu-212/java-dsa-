import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        String exp=snr.next();
        System.out.println(isBalanced(exp));
        snr.close();
    }
    static boolean isBalanced(String exp)
    {
        Stack<Character> stk=new Stack<>();
        for(int idx=0;idx<exp.length();idx++)
        {
            Character reading_symbol=exp.charAt(idx);
            if("{([".contains(reading_symbol+""))
            {
                stk.push(reading_symbol);
            }
            if(reading_symbol=='}')
            {
                if(stk.isEmpty())
                {
                    return false;
                }
                if(stk.pop()!='{')
                {
                    return false;
                }
            }
            if(reading_symbol==']')
            {
                if(stk.isEmpty())
                {
                    return false;
                }
                if(stk.pop()!='[')
                {
                    return false;
                }
            }
            if(reading_symbol==')')
            {
                if(stk.isEmpty())
                {
                    return false;
                }
                if(stk.pop()!='(')
                {
                    return false;
                }
            }

        }
        return stk.isEmpty();
    }
}
