package programmers.skillcheck;

public class SkillCheck0202 {
    public static void main(String[] args) {
        System.out.println(new SkillCheck0202().solution(new int[]{1, 2, 3, 4}));
        System.out.println(new SkillCheck0202().solution(new int[]{1, 2, 7, 6, 4}));
    }

    public int solution(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    cnt += isPrime(nums[i] + nums[j] + nums[k]) ? 1 : 0;
                }
            }
        }
        return cnt;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
