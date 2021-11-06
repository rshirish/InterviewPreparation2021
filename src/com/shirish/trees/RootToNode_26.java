package com.shirish.trees;

import java.util.ArrayList;
import java.util.List;

public class RootToNode_26 {

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

        List<Integer> result = rootToNode(root, 9);
        System.out.println("Result : " + result);

    }

    private static List<Integer> rootToNode(Node root, int target) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        getPath(result, target, root);
        return result;
    }

    private static boolean getPath(List<Integer> result, int target, Node node) {
        if (node == null)
            return false;
        result.add(node.data);
        if (node.data == target)
            return true;
        if (getPath(result, target, node.left) || getPath(result, target, node.right))
            return true;
        result.remove(result.size() - 1);
        return false;
    }
}
