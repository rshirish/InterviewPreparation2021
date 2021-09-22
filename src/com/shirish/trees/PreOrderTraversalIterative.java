package com.shirish.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalIterative {

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

        List<Integer> preorder = preOrderTraversal(root);
        System.out.println("Result : "+preorder);

    }

    private static List<Integer> preOrderTraversal(Node root) {
       Stack<Node> stack = new Stack<Node>();
       List<Integer> preorder = new ArrayList<>();
        if(root == null) return preorder;
        stack.push(root);

        while(!stack.isEmpty())
        {
            Node node = stack.pop();
            preorder.add(node.data);
            if(node.right != null)
                stack.add(node.right);
            if(node.left != null)
                stack.add(node.left);
        }

        return preorder;
    }
}
