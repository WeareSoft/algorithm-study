package dami.programmers.level3;


// 참고 https://codedrive.tistory.com/49
public class 정수_삼각형 {
	private int[][] sums;

	public int solution(int[][] triangle) {
		int sum = triangle[0][0];
		if (triangle.length == 1) {
			return sum;
		}

		sums = triangle;
		findMaxSum(1, 0);

		int max = 0;
		for (int i = 0; i < sums[triangle.length - 1].length; i++) {
			max = Math.max(max, sums[triangle.length - 1][i]);
		}
		return max;
	}

	private void findMaxSum(int row, int col) {
		if (row == sums.length - 1 && col == sums[row].length - 1) {
			return;
		}

		if (col == 0) {
			sums[row][col] += sums[row - 1][col];
			findMaxSum(row, col + 1);
			return;
		}

		if (row == col) {
			sums[row][col] += sums[row - 1][col - 1];
			findMaxSum(row + 1, 0);
			return;
		}

		sums[row][col] += Math.max(sums[row - 1][col], sums[row - 1][col - 1]);
		findMaxSum(row, col + 1);
	}

}


/*  // 다른 풀이

	public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++)
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }

*/
