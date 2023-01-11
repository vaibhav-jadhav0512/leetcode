package Day1;

import java.util.Stack;

public class PalindromeNumber {
	public static void main(String args[]) {
		System.out.println(isPalindrome(101101));
	}

	public static boolean isPalindrome(int x) {
		String str=String.valueOf(x);
		int []arr=new int[str.length()];
		Stack<Character> stk = new Stack<>();  
        for(int i=0;i<arr.length;i++) {
        	arr[i]=str.charAt(i);
        	stk.push(str.charAt(i));
        }
        for (int i = 0; i < arr.length; i++) {
			if(arr[i]==stk.pop())
				continue;
			else {
				return false;
			}
			
		}
        return true;
    }
}
