package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*Difficulty - Medium*/
public class LargestRange {
    public static void main(String[] args){
        printList(Objects.requireNonNull(largestRange(new int[]{4, 2, 1 ,3})));
    }

    /*TimeComplexity - O(n) where n is the size of the list
      Space Complexity - O(n) - Hashmap size */
    public static int[] largestRange(int[] array) {
        Map<Integer, Boolean> map = new HashMap<>();
        int li = 0, ri = 0;

        //O(n)
        for (int value : array) {
            map.put(value, false);
        }
        int max = Integer.MIN_VALUE;
        int mli = 0, mri = 0;

        //O(n)
        for (int curr : array) {
            if (!map.get(curr)) {
                map.replace(curr, true);
                int x = 1;
                while (map.containsKey(curr - x)) {
                    map.replace(curr - x, true);
                    x++;
                }
                li = curr - x + 1;
                x = 1;
                while (map.containsKey(curr + x)) {
                    map.replace(curr + x, true);
                    x++;
                }
                ri = curr + x - 1;

                if(ri - li > max){
                    max = ri - li;
                    mli = li; mri = ri;
                }
            }
        }
        return new int[]{mli, mri};
    }

    /**
     * method to print the 2D list
     * @param list list to be printed
     */
    public static void printList(int[] list){
        for(int i : list){
            System.out.print(i + " ");
        }
    }
}