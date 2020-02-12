package DynamicProgramming;

import java.util.Arrays;

public class MaxSubsetSumNoAdjacent_Memoized {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        int[] dp = new int[array.length];
        Arrays.fill(dp, -1);
        return rec(array, 0, dp);
    }

    public static int rec(int[] array, int left, int[] dp){
        if(left >= array.length) return 0;
        if(dp[left] != -1) return dp[left];
        if(left == array.length-1) return array[left];
        dp[left] = Math.max(array[left] + rec(array, left +  2, dp), rec(array, left + 1, dp));
        return dp[left];
    }
}