import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Difficulty - EASY*/
public class MoveElementToEnd {
    public static void main(String[] args){
        printList(moveElementToEnd(new ArrayList<>(Arrays.asList(3, 3, 3, 3, 3, 3, 3)), 3));
    }

    /*TimeComplexity - O(n) where n is the size of the list
      Space Complexity - O(1) */
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int right = array.size() - 1;
        int left = 0;

        while (right >= 0 && array.get(right) == toMove){
            right--;
        }

        while (right >= 0 && left < right) {
            if(array.get(left) == toMove){
                array.set(left, array.get(right));
                array.set(right, toMove);
                while (right >= 0 && array.get(right) == toMove){
                    right--;
                }
            }
            left++;
        }
        return array;
    }

    /**
     * method to print the list
     * @param list list to be printed
     */
    public static void printList(List<Integer> list){
        for(Integer i : list){
            System.out.print(i + " ");
        }
    }
}