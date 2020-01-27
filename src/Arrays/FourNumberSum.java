package Arrays;

import java.util.*;

/*Difficulty - Medium*/
public class FourNumberSum {
    public static void main(String[] args){
        printList(Objects.requireNonNull(fourNumberSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 10)));
    }

    /*TimeComplexity - O(n^2) where n is the size of the list | Worst case O(n^3)
      Space Complexity - O(n^2) */
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> res = new ArrayList<>();
        Map<Integer, List<Integer[]>> sums = new HashMap<>();

        for(int i = 1; i < array.length; i++){
            for (int j = i+1; j < array.length; j++){
                int add = array[i] + array[j];
                int diff = targetSum - add;
                if(sums.containsKey(diff)){
                    for(int k = 0; k < sums.get(diff).size(); k++){
                        Integer[] subArray = sums.get(diff).get(k);
                        res.add(new Integer[]{subArray[0], subArray[1], array[i], array[j]});
                    }
                }
            }

            for(int k = 0; k < i; k++){
                int add = array[i] + array[k];
                if(sums.containsKey(add)){
                    sums.get(add).add(new Integer[]{array[i], array[k]});
                } else
                    sums.put(add, new ArrayList<Integer[]>(Collections.singleton(new Integer[]{array[i], array[k]})));
            }
        }


        return res;
    }

    /**
     * method to print the 2D list
     * @param list list to be printed
     */
    public static void printList(List<Integer[]> list){
        for(Integer[] i : list){
            System.out.println(i[0] + " " + i[1] + " " + i[2] + " " + i[3]);
        }
    }
}