package hee.codility.lesson;

public class PrefixSums_MinAvgTwoSlice {
    // [TIP] 2개 또는 3개(음수 포함)의 인자의 평균 값이 최소. O(N)
    public int solution(int[] A) {
        int idx = 0;
        float result = Float.MAX_VALUE;

        for(int i = 0 ; i < A.length ; i++){
            if(i+1 < A.length){
                if( result > (A[i] + A[i+1])/2f){
                    result = (A[i] + A[i+1])/2f ;
                    idx = i;
                }
            }

            if(i+2 < A.length){
                if( result > (A[i] + A[i+1] + A[i+2])/3f){
                    result = (A[i] + A[i+1] + A[i+2])/3f ;
                    idx = i;
                }
            }
        }
        return idx;
    }
}
