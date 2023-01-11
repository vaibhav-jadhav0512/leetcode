package Day1;

public class RomanToInt {
	public static void main(String args[]) {
		System.out.println(romanToInt("MCMXCVI"));
		System.out.println(romanToIntOptimum("MCMXCVI"));
	}

	public static int romanToInt(String str) {
		int sum = 0;
		for (int j = 0; j < str.length(); j++) {
			switch (str.charAt(j)) {
			case 'I':
				if (j < str.length() - 1 && str.charAt(j + 1) == 'V') {
					sum += 4;
					j = j + 1;
					break;
				} else if (j < str.length() - 1 && str.charAt(j + 1) == 'X') {
					sum += 9;
					j = j + 1;
					break;
				}
				sum += 1;
				break;
			case 'V':
				sum += 5;
				break;
			case 'X':
				if (j < str.length() - 1 && str.charAt(j + 1) == 'L') {
					sum += 40;
					j = j + 1;
					break;
				} else if (j < str.length() - 1 && str.charAt(j + 1) == 'C') {
					sum += 90;
					j = j + 1;
					break;
				}
				sum += 10;
				break;
			case 'L':
				sum += 50;
				break;
			case 'C':
				if (j < str.length() - 1 && str.charAt(j + 1) == 'D') {
					sum += 400;
					j = j + 1;
					break;
				} else if (j < str.length() - 1 && str.charAt(j + 1) == 'M') {
					sum += 900;
					j = j + 1;
					break;
				}
				sum += 100;
				break;
			case 'D':
				sum += 500;
				break;
			case 'M':
				sum += 1000;
				break;
			}
		}
		return sum;
	}
	
	public static int romanToIntOptimum(String s) {
		int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
	}
}
