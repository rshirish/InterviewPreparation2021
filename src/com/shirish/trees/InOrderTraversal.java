package com.shirish.trees;

public class InOrderTraversal {

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
        //Left Root Right
        inOrderTraversal(root);

    }

    private static void inOrderTraversal(Node node) {
        if(node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(node.data + " ,");
        inOrderTraversal(node.right);
    }
}
