package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        //Time - O(n) | Space - O(n) where n is the size of the tree
        public List<String> depthFirstSearch(List<String> array) {
            Stack<Node> stack = new Stack<>();
            stack.add(this);
            while (!stack.isEmpty()){
                Node n = stack.pop();
                array.add(n.name);
                for(int i = n.children.size()-1; i >= 0; i--){
                    stack.add(n.children.get(i));
                }
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}