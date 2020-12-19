package dami.leetcode.medium;

// https://leetcode.com/problems/container-with-most-water/

// 1. 가장자리 인덱스부터 시작
// 2. 왼쪽 인덱스와 오른쪽 인덱스가 다를 때까지 34 반복
// 3. (뒷 인덱스 - 앞 인덱스) * min(앞 값, 뒷 값)
// 4. 둘 중 작은값을 가지는 인덱스를 안쪽으로 이동(-> <-)
//	- 작은값보다 큰값이 나올 때까지 && 큰값인덱스랑 같기 전까지
// 5. 34 반복 하면서 가장 큰 2번값 찾아서 반환
public class Container_With_Most_Water_11 {
	public int maxArea(int[] height) {
		int max = 0;
		int left = 0;
		int right = height.length - 1;
		int minIndex;
		while (left != right) {
			max = Math.max(max, (right - left) * Math.min(height[left], height[right]));

			if (height[left] < height[right]) {
				minIndex = left;
				while (height[minIndex] >= height[left] && left < right) {
					left++;
				}
			} else {
				minIndex = right;
				while (height[minIndex] >= height[right] && left < right) {
					right--;
				}
			}
		}

		return max;
	}
}

/*
// 아래 풀이는 모든 인덱스마다 넓이 계산해서 비교해줬고
// 나는 현재 비교한 인덱스의 값보다 작은 값의 넓이는 계산하지 않음

// 아래 풀이는 최소값 비교를 한 번만 해줌
// 나는 while문 들어가자마자 Math.min하고 그 아래 if문에서 또 min 비교

public int maxArea(int[] height) {
        int ans= 0 ;
        int low=0;
        int high = height.length-1;
        while(low<high){
            if(height[low]<height[high]){
                ans=Math.max(ans,(high-low) * height[low]);
                low++;
            }
            else{
                ans=Math.max(ans,(high-low) * height[high]);
                high--;
            }
        }
        return ans;
    }

*/
