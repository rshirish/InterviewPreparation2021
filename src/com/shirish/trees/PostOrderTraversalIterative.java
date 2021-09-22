package com.shirish.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalIterative {

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

        postOrderTraversal(root);
        List<Integer> postOrder = postOrderTraversal(root);
        System.out.println("Result : " + postOrder);

    }

    private static List<Integer> postOrderTraversal(Node root) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        List<Integer> pot = new ArrayList<>();
        if(root == null)
            return pot;
        stack1.add(root);
        while(!stack1.isEmpty())
        {
            Node node = stack1.pop();
            stack2.add(node);
            if(node.left!=null)
                stack1.add(node.left);
            if(node.right!=null)
                stack1.add(node.right);

        }
        while (!stack2.isEmpty())
            pot.add(stack2.pop().data);

        return pot;

    }
}
