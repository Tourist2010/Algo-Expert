package BinarySearchTree;


/*Difficulty - Medium*/
public class FindClosestValueInBST {
    public static int findClosestValueInBst(BST tree, int target) {
        int min = Integer.MAX_VALUE;
        return findClosestValue(tree, target, min, target);
    }

    /*TimeComplexity - O(log(n)) where n is the size of the list
      Space Complexity - O(1) */
    public static int findClosestValue(BST tree, int target, int min, int ans){
        if(tree == null) return ans;
        int diff = Math.abs(tree.value - target);
        if(diff < min){
            min = diff;
            ans = tree.value;
        }
        if(tree.value < target){
            ans = findClosestValue(tree.right, target, min, ans);
        } else if(tree.value > target){
            ans = findClosestValue(tree.left, target, min, ans);
        }
        return ans;
    }

    //Binary Search Tree
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }


}