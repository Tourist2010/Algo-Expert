package DynamicProgramming;

import java.util.Arrays;

public class NumberOfWaysToMakeChange_DP {
    public static void main(String[] args){
        System.out.println(numberOfWaysToMakeChange(5, new int[]{1, 2, 3}));
    }

    //Time - O(nd) | space O(nd) where n is the target and d is the denominations
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        if (n == 0) return 1;
        if(denoms.length == 0) return 0;
        int[][] dp = new int[n+1][denoms.length];
        Arrays.fill(dp[0], 1);

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(j == 0){
                    if(i-denoms[j] < 0) dp[i][j] = 0;
                    else dp[i][j] = dp[i-denoms[j]][j];
                } else {
                    if(i-denoms[j] < 0) dp[i][j] = dp[i][j - 1];
                    else dp[i][j] = dp[i][j - 1] + dp[i - denoms[j]][j];
                }
            }
        }
        return dp[n][denoms.length-1];
    }
}