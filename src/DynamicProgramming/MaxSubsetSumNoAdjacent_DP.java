package DynamicProgramming;

public class MaxSubsetSumNoAdjacent_DP {

    //Time - O(n) | Space - O(n) where n is the size of the array
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if(array.length == 0) return 0;
        int[] dp = new int[array.length+1];
        dp[array.length] = 0;
        dp[array.length-1] = array[array.length-1];

        for(int i = array.length-2; i >= 0; i--){
            dp[i] = Math.max(array[i] + dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}