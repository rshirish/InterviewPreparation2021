package com.shirish.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalSingleStack {

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
        List<Integer> postOrder = new ArrayList<>();
        if(root == null) return postOrder;
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while( current != null || !stack.isEmpty() )
        {
            if(current != null) {
                stack.push(current);
                current = current.left;

            } else {
                Node temp   = stack.peek().right;
                if(temp == null )
                {
                    temp =
                    stack.pop();
                    postOrder.add(temp.data);
                    while(!stack.isEmpty() && temp == stack.peek().right)
                    {
                        temp =
                        stack.pop();
                        postOrder.add(temp.data);
                    }


                } else {
                    current = temp;
                }
            }

        }
        return postOrder;

    }


}
