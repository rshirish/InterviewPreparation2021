package com.shirish.trees;

import java.util.ArrayList;
import java.util.List;

public class RightSideView_24 {

     /*
                     1
                    /  \
                   2    3
                  / \   / \
                 4   5  7  8
                     /     / \
                    6     9   10
      */
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);

        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        List<Integer> preorder = rightSideView(root);
        System.out.println("Result : " + preorder);

    }

    private static List<Integer> rightSideView(Node root) {
        List<Integer> result  = new ArrayList<>();
        rightView(result, root, 0);
        return result;
    }

    private static void rightView(List<Integer> result, Node node, int currentDepth) {
        if(node == null)
            return;
        if(currentDepth == result.size())
            result.add(node.data);
        rightView(result, node.right, currentDepth+1);
        rightView(result, node.left, currentDepth+1);
    }
}
