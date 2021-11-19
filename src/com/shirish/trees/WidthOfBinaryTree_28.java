package com.shirish.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WidthOfBinaryTree_28 {
    /*
                    1
                   /  \
                  3    7
                 /      \
                8         4
               /           \
              5             2
     */
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.left.left.left = new Node(5);
        root.right.right = new Node(4);
        root.right.right.right = new Node(2);


        Integer width = widthOfBinaryTree(root);
        System.out.println("Result : " + width);

    }

    private static Integer widthOfBinaryTree(Node root) {
        if(root == null) return 0;
        Integer ans = 0;
        Queue<TopView_22.Pair> q = new LinkedList<>();
        q.offer(new TopView_22.Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().line;    //to make the id starting from zero
            int first = 0,last = 0;
            for(int i=0; i<size; i++){
                int cur_id = q.peek().line-mmin;
                Node node = q.peek().node;
                q.poll();
                if(i==0) first = cur_id;
                if(i==size-1) last = cur_id;
                if(node.left != null)
                    q.offer(new TopView_22.Pair(node.left, cur_id*2+1));
                if(node.right != null)
                    q.offer(new TopView_22.Pair(node.right, cur_id*2+2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }

    }

