/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.tree;

/**
 *
 * @author rujuraj
 */
public class Diameter {

    public static class Node {

        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class Height {

        int h;
    }

    static Node root;

    /* define height =0 globally and  call diameterOpt(root,height)
       from main */
    static int diameterOpt(Node root, Height height) {
        /* lh --> Height of left subtree
           rh --> Height of right subtree */
        Height lh = new Height(), rh = new Height();

        if (root == null) {
            height.h = 0;
            return 0;
            /* diameter is also 0 */
        }

        /* ldiameter  --> diameter of left subtree
           rdiameter  --> Diameter of right subtree */
 /* Get the heights of left and right subtrees in lh and rh
         And store the returned values in ldiameter and ldiameter */
        int ldiameter = diameterOpt(root.left, lh);
        int rdiameter = diameterOpt(root.right, rh);

        /* Height of current node is max of heights of left and
         right subtrees plus 1*/
        height.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
    }

    /* A wrapper over diameter(Node root) */
    static int diameter() {
        Height height = new Height();
        return diameterOpt(root, height);
    }

    /*The function Compute the "height" of a tree. Height is the
      number f nodes along the longest path from the root node
      down to the farthest leaf node.*/
    static int height(Node node) {
        /* base case tree is empty */
        if (node == null) {
            return 0;
        }

        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (1 + Math.max(height(node.left), height(node.right)));
    }

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("The diameter of given binary tree is : "
                + diameter());
    }
}
