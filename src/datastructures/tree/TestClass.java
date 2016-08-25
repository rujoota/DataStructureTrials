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
public class TestClass {
    public static void main(String[] args) {
        BST bst=new BST();
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(25);
        bst.insert(12);
        bst.insert(17);
        bst.display(bst.root);
        bst.search(13);
        System.out.println("inorder:");
        bst.inOrder(bst.root);
        System.out.println("preorder:");
        bst.preOrder(bst.root);
        System.out.println("postorder:");
        bst.postOrder(bst.root);
        bst.deleteTreeNode(bst.root, 12);
        System.out.println("inorder after deletion:");
        bst.inOrder(bst.root);
        System.out.println("root:"+bst.root.data);
    }
}
