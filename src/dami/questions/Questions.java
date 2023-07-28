package dami.questions;

public class Questions {
	public void solutions() {
		//new Task1().solution(6, 2, new char[] {'B', 'C'}, 2, new int[] {3, -2});
		//new Task1().solution(17, 5, new char[] {'B', 'D', 'I', 'M', 'P'}, 11, new int[] {3,-4,5,6,-7,-8,10,-12,-15,-20,23});

		//new Task2().solution(2, 6, new int[][] {{6, 2, 11, 0, 3, 5}, {6, 3, 0, 9, 0, 5}});
		//new Task2().solution(3, 10, new int[][] {{6, 12, 0, 2, 8, 4, 0, 7, 3, 6}, {6, 1,3,0,2,8,0,0,13,8}, {6,3,0,10,6,5,7,0,0,3}});

		//new Task3().solution(2, new String[] {"B2(RG)", "3(R2(GB))"});
		//new Task3().solution(3, new String[] {"3(BR2(R))", "B(RGB(RG))", "1B2R3G"});


		// 001100, 3 / 001100, 5
		//new Line3().solution("111011110011111011111100011111", 3);
		/*
		System.out.println(Arrays.toString(new Line6().solution(
				new String[]{"/", "/hello", "/hello/tmp", "/root", "/root/abcd", "/root/abcd/etc", "/root/abcd/hello"}
				, new String[]{"mkdir /root/tmp", "cp /hello /root/tmp", "rm /hello"}
		)));
		System.out.println(Arrays.toString(new Line6().solution(
				new String[]{"/"}
				, new String[]{"mkdir /a", "mkdir /a/b", "mkdir /a/b/c", "cp /a/b /", "rm /a/b/c"}
		)));
		*/

		//new Task6().solution("ZNMD");

		//new Task7().solution(17, 5, new char[] {'B', 'D', 'I', 'M', 'P'}, 11, new int[] {3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23});
		//new Task8().solution(2, 6, new int[][] {{6,2,11,0,3,5},{6,3,0,9,0,5}});
		//new Task8().solution(3, 10, new int[][] {{6,12,0,2,8,4,0,7,3,6},{6,1,3,0,2,8,0,0,13,8}, {6,3,0,10,6,5,7,0,0,3}});
		//new Task9().solution(2, new String[]{"B2(RG)", "3(R2(GB))"});
		new Task10().solution(6, new int[][]{{0,1,1,0,0,0},{0,1,1,0,1,1}, {0,0,0,0,1,1}, {0,0,0,0,1,1}, {1,1,0,0,1,0}, {1,1,1,0,0,0}});
		new Task10().solution(4, new int[][]{{1,0,0,0},{1,0,0,0}, {0,0,0,0}, {0,0,1,1}});
	}
}
