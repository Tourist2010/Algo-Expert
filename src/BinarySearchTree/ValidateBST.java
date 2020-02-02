package BinarySearchTree;

public class ValidateBST {
    public static boolean validateBst(BST tree) {
        return validBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //O(n) time | O(d) space, where d is the depth of the tree
    public static boolean validBst(BST tree, int min, int max) {
        if(tree == null) return false;
        if(tree.left == null && tree.right == null)
            return (tree.value >= min && tree.value < max);
        if(tree.left != null && tree.right == null)
            return ((tree.value > tree.left.value) && (tree.value >= min && tree.value < max)
                    && validBst(tree.left, min, tree.value));
        if(tree.left == null && tree.right != null)
            return ((tree.value <= tree.right.value) && (tree.value >= min && tree.value < max) &&
                    validBst(tree.right, tree.value, max));
        return (tree.value > tree.left.value && tree.value <= tree.right.value) && (tree.value >= min && tree.value < max) &&
                validBst(tree.left, min, tree.value) && validBst(tree.right, tree.value, max);
    }

    //Binary Search Tree class
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
