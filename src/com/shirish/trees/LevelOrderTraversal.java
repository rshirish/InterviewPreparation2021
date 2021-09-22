package com.shirish.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

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
        //Left  Right  Root
        levelOrderTraversal(root);

    }

    private static void levelOrderTraversal(Node root) {

        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<Node> queue = new LinkedList<Node>();
        if(root == null) return;
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i< levelNum; i++)
            {
                if(queue.peek().left!= null)
                    queue.add(queue.peek().left);
                if(queue.peek().right!= null)
                    queue.add(queue.peek().right);
                subList.add(queue.poll().data);
            }
            result.add(subList);
        }
        System.out.println(result);
    }
}
