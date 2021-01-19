package dami.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class Generate_Parentheses_22 {
	private static final String OPEN = "(";
	private static final String CLOSE = ")";

	private final List<String> result = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		StringBuilder sb = new StringBuilder();
		recursive(sb, 0, 0, n);
		return result;
	}

	private void recursive(StringBuilder prefix, int open, int close, int n) {
		if (n * 2 == prefix.length()) {
			result.add(prefix.toString());
			return;
		}

		if (open < n) {
			prefix.append(OPEN);
			recursive(prefix, open + 1, close, n);
			prefix.deleteCharAt(prefix.length() - 1);
		}

		if (close < open) {
			prefix.append(CLOSE);
			recursive(prefix, open, close + 1, n);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}
}

/*

// 나는 0부터 시작해서 n개 까지 진행
// 아래 코드는 n부터 시작해서 0까지 진행 => 매개변수 한 개(int n) 줄이기 가능

public List<String> generateParenthesis(int n) {
    List<String> result= new ArrayList<String>();
    dfs(n,n,result,"");
    return result;
}

public void dfs(int left, int right, List<String> result, String s) {
    if(left==0 && right==0) result.add(s);
    else
    {
       if(left>0) dfs(left-1, right, result, s+"(");
       if(right>left) dfs(left, right-1, result, s+")");
    }
}

*/
