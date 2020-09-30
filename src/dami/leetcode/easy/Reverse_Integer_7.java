package dami.leetcode.easy;

// Submission Detail : https://leetcode.com/submissions/detail/356536589/
public class Reverse_Integer_7 {

	public int reverse(int x) {
		try {
			long result = 0;
			int n = 0;
			while(x != 0) {
				n = x%10;
				result += n;
				x = (x-n)/10;

				if(x != 0) {
					if(result*10 <= Integer.MAX_VALUE && result*10 >= Integer.MIN_VALUE)
						result *= 10;
					else
						return 0;
				}
			}
			return (int) result;

		} catch(NumberFormatException e) {
			return 0;
		} catch(ArithmeticException e) {
			return 0;
		}
	}
}

/*
class Solution {
    public int reverse(int x) {

        int result = 0;

        while (x != 0) {

            int pop = x % 10;

            x = x / 10;

            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10) {
                return 0;
            }

            result = result * 10 + pop;
        }

        return result;
    }
}
 */
