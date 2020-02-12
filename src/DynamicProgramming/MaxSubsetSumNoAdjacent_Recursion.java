package DynamicProgramming;

public class MaxSubsetSumNoAdjacent_Recursion {
    public static int maxSubsetSumNoAdjacent(int[] array) {
       return rec(array, 0);
    }

    //Time - O(n^2) | Space - O(n) where n is the size of the array
    public static int rec(int[] array, int left){
        if(left >= array.length) return 0;
        if(left == array.length-1) return array[left];
        return Math.max(array[left] + rec(array, left +  2), rec(array, left + 1));
    }
}