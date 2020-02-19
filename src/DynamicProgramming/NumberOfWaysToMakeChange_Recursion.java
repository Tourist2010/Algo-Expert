package DynamicProgramming;

public class NumberOfWaysToMakeChange_Recursion {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        return rec(denoms, denoms.length-1, n);
    }

    //Time - O(n^2) | Space O(n) where n is the number of denominations
    public static int rec(int[] denoms, int currentIndex, int target){
        if (target == 0) return 1;
        if(target < 0 || currentIndex < 0) return 0;

        return  rec(denoms, currentIndex, target-denoms[currentIndex]) + rec(denoms, currentIndex-1, target);
    }
}