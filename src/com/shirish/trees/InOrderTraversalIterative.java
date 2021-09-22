package com.shirish.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalIterative {

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

        List<Integer> inOrder = inOrderTraversal(root);
        System.out.println("Result : "+inOrder);

    }

    private static List<Integer> inOrderTraversal(Node root) {
        List<Integer> inOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(root == null)
            return inOrder;
       Node node = root;
        while(true)
        {
            if(node!= null) {
                stack.push(node);
                node = node.left;
            }
            else {
                if(stack.isEmpty())
                    break;
                node = stack.pop();
                inOrder.add(node.data);
                node= node.right;

            }
        }


        return inOrder;
    }

}
