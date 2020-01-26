import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args){
        int[] ans = smallestDifference(new int[]{-1, 5, 10, 20, 3}, new int[]{26, 134, 135, 15, 17});
        System.out.println(ans[0] + ", " + ans[1]);
    }

    /*TimeComplexity - O(mLog(m)) + O(nLog(n))
      Space Complexity - O(1) */
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        int diff;
        Arrays.sort(arrayOne); //O(mLog(m)) where m = arrayOne size
        Arrays.sort(arrayTwo); //O(nLog(n)) where n = arrayTwo size

        //O(m + n)
        for(int i = 0, j = 0; i < arrayOne.length && j < arrayTwo.length; ){
            if(arrayOne[i] == arrayTwo[j]) {
                return new int[]{arrayOne[i], arrayTwo[j]};
            } else if(arrayOne[i] < arrayTwo[j]){
                diff = arrayTwo[j] - arrayOne[i];
                if(diff < min){
                    res = new int[]{arrayOne[i], arrayTwo[j]};
                    min = diff;
                }
                i++;
            } else {
                diff = arrayOne[i] - arrayTwo[j];
                if(diff < min){
                    res = new int[]{arrayOne[i], arrayTwo[j]};
                    min = diff;
                }
                j++;
            }
        }
        return res;
    }
}