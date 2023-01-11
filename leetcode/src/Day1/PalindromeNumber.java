package Day1;

import java.util.Stack;

public class PalindromeNumber {
	public static void main(String args[]) {
		System.out.println(isPalindrome(101101));
		System.out.println(isPalindromeOptimum(101101));
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
			else 
				return false;
		}
        return true;
    }
	public static boolean isPalindromeOptimum(int x) {
		 if(x < 0 || (x % 10 == 0 && x != 0)) {
	            return false;
	        }
	        int revertedNumber = 0;
	        while(x > revertedNumber) {
	            revertedNumber = revertedNumber * 10 + x % 10;
	            x /= 10;
	        }
	        return x == revertedNumber || x == revertedNumber/10;
	}
}
